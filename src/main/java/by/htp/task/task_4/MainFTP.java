package by.htp.task.task_4;

import java.io.IOException;
import java.util.List;

public class MainFTP {

    private static FTPAddress address = new FTPAddress("ftp.des.tstu.ru",21, "anonymous", "anonymous");

    public static void main(String[] args) throws IOException {

        FTPClient ftpClient = new FTPClient();
        FTPClient ftpClient2 = new FTPClient();

        ftpClient.connect(address);
        List list = ftpClient.getCatalogDir();
        ftpClient.close();

        ftpClient2.connect(address);
        for (Object o : list) {
            ftpClient2.goToDir("/" + o.toString().trim());

            if (ftpClient2.createDir("forTest"))
                ftpClient2.deleteDir("forTest");

        }
        ftpClient2.close();

    }
}
