package by.htp.task.task_4;

import java.io.IOException;
import java.util.List;

public class MainFTP {

    private static FTPAddress address = new FTPAddress("ftp.byfly.by",21, "anonymous", "anonymous");
    private static FTPClient ftpClient = new FTPClient();
    private static List catalogDir;

    public static void main(String[] args) throws IOException {
        ftpClient.connect(address);
        catalogDir = ftpClient.getCatalogDir();
        goToDirs();
        createDir();
        ftpClient.close();

    }

    private static void goToDirs() throws IOException {
        for (Object o : catalogDir) {
            ftpClient.goToDir(o.toString());
            ftpClient.goToDir("");
        }
    }

    private static void createDir () throws IOException {
        if (ftpClient.isCreateDir("forTest"))
            ftpClient.deleteDir("forTest");
    }
}
