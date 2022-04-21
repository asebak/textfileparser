
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordParser {

    private final Set<String> excludedWords;
    private final String paragraph;

    public WordParser(String paragraph, String... excludedWords){
        this.paragraph = paragraph;
        this.excludedWords = Stream.of(excludedWords).collect(Collectors.toSet());
        this.excludedWords.add("");
    }
    public HashMap<String, Integer> cleanParagraphToCollectWords() {

        String[] lines = paragraph.split("\\r?\\n"); //split lines
        HashMap<String, Integer> wordsMap = new HashMap<>();


        for (String line : lines) {
            var words = List.of(line.toLowerCase().replaceAll("[^\\p{Alnum}]+", " ").split(" "));

            words.forEach(word -> {
                if (!excludedWords.contains(word) && !word.equals("s")) { //check not excluded and a special case with an apostrophy s which gets included
                    wordsMap.merge(word, 1, Integer::sum);
                }
            });

        }

        return wordsMap;
    }

    public List<String> topWords(int total) {
        HashMap<String, Integer> wordsMap = cleanParagraphToCollectWords();
       return wordsMap.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) //sort
                        .limit(total) //limit
                        .map(Map.Entry::getKey)//convert object
                        .collect(Collectors.toList());

    }
}
