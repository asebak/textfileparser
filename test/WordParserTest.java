import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordParserTest {

    @Test
    public void testparsingWordsFromFile(){
        String downloadedFileContents = "john deere food eating food john download";
        WordParser wordParser = new WordParser(downloadedFileContents);
        var words = wordParser.cleanParagraphToCollectWords().keySet();
        Assert.assertTrue(words.containsAll(new HashSet<>(Arrays.asList(downloadedFileContents.split(" ")))));
    }

    @Test
    public void testTop2WordsinFile(){
        WordParser wordParser = new WordParser("john deere food eating food john download");
        var words = wordParser.topWords(2);

        Assert.assertTrue(words.containsAll(List.of("john", "food")));

    }
}
