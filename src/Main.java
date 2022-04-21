public class Main {

    private static final String URL = "https://www.gutenberg.org/files/2701/2701-0.txt";

    public static void main(String[] args) {

        var downloader = new DownloaderImpl();
        var contents = downloader.downloadFileContents(URL);
        var wordParser = new WordParser(contents,
                "the","of","to","and","a","in","is",
                "it","you","that","he","was","for","on","are","with","as","I","his",
                "they","be","at","one","have","this","from",
                "or","had","by","not","word","but","what","some","we","can","out",
                "other","were","all","there","when","up","use","your","how","said","an","each","she"
                );
        var topWords = wordParser.topWords(50);

        topWords.forEach(System.out::println);


    }
}
