import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class DownloaderImpl implements Downloader {

    public void downloadFile(String url, String fileName) {
        var path = Paths.get(fileName);
        try (InputStream in = URI.create(url).toURL().openStream()) {
            if(Files.exists(path)) {
                Files.delete(path);
            }
            Files.copy(in, path);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public String downloadFileContents(String url) {
        try (InputStream in = URI.create(url).toURL().openStream()) {
            return new Scanner(in).
                    useDelimiter("\\Z").next();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
