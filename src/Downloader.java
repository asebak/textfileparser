public interface Downloader {
    void downloadFile(String url, String fileName);

    String downloadFileContents(String url);

}
