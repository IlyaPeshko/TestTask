package by.htp.task.task_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

abstract class FTP {

    protected Socket socket = null;
    protected BufferedReader buffReader = null;
    protected BufferedWriter buffWriter = null;
    protected InputStreamReader inputStreamReader;
    protected OutputStreamWriter outputStreamWriter;

    protected final String WELCOME_RESPONSE = "220";
    protected final String USER_OK_NEED_PASS_RESPONSE = "331";
    protected final String USER_IS_LOGED_RESPONSE = "230";
    protected final String CREATE_DIR_PERMISSION_DENIED_RESPONSE = "550 Permission denied.";
}
