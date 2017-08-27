package by.htp.task.task_4;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by user on 15.08.17.
 */
public class MainFTP {

    //private static FTPAddress address = new FTPAddress("ftp.byfly.by",21, "anonymous", "anonymous");
    private static FTPAddress address = new FTPAddress("ftp.stat.duke.edu",21, "anonymous", "anonymous");

    public static void main(String[] args) {

        FTPClient ftpClient = new FTPClient(); //entity for fetch catalog dir
        FTPClient ftpClient2 = new FTPClient(); //entity for create and delete
        ArrayList list = new ArrayList();

        try {
            ftpClient.connect(address);
            list = ftpClient.list();
            ftpClient.close();
        } catch (IOException e) {}

        try {
            ftpClient2.connect(address);

            for (Object o :list) {

                ftpClient2.goToDir(o.toString().trim());
                ftpClient2.currentDir();
                System.out.println();

                if (ftpClient2.createDir("forTest"))
                    ftpClient2.deleteDir("forTest");
                ftpClient2.goToDir("/");
                ftpClient2.currentDir();
            }
            ftpClient2.close();
        } catch (IOException e) {}
    }
}
