import by.htp.task.ui.page.task_4.FTPAddress;
import by.htp.task.ui.page.task_4.FTPClient;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by user on 19.08.17.
 */
public class task_4 {
    private static FTPAddress address = new FTPAddress("ftp.byfly.by",21, "anonymous", "anonymous");

    @Test
    public void ftp () {
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

                if (ftpClient2.createDir("forTest"))
                    ftpClient2.deleteDir("forTest");
                ftpClient2.goToDir("/");
                ftpClient2.currentDir();
            }
            ftpClient2.close();
        } catch (IOException e) {}
    }
}
