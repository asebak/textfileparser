import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;

public class DownloaderTest {

    String urlPath = "https://www.gutenberg.org/files/2701/2701-0.txt";
    String fileName = "download.txt";

    @Test
    public void testDownloadFile() {
        Downloader downloader = new DownloaderImpl();
        downloader.downloadFile(urlPath, fileName);
        Assert.assertTrue(Files.exists(Path.of(fileName)));
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidDownloadFile() {
        Downloader downloader = new DownloaderImpl();
        downloader.downloadFile("http://", fileName);
    }



    @Test
    public void testDownloadFileContents() {
        Downloader downloader = new DownloaderImpl();
        String contents = downloader.downloadFileContents(urlPath);
        Assert.assertTrue(contents.contains("The Project Gutenberg eBook of Moby-Dick; or The Whale, by Herman Melville"));
    }
}
