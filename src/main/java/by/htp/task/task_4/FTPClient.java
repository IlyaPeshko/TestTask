package by.htp.task.task_4;

import static by.htp.task.task_1_2_3.ui.page.Page.log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

public class FTPClient {

    private Socket socket = null;
    private BufferedReader buffReader = null;
    private BufferedWriter buffWriter = null;
    private InputStreamReader inputStreamReader;
    private OutputStreamWriter outputStreamWriter;

    private final String WELCOME_RESPONSE = "220";
    private final String USER_OK_NEED_PASS_RESPONSE = "331";
    private final String USER_IS_LOGED_RESPONSE = "230";
    private final String CREATE_DIR_PERMISSION_DENIED_RESPONSE = "550 Permission denied.";

    public synchronized void connect(FTPAddress address) throws IOException{
        log.info(address);
        if(socket!=null){
            throw new IOException("you are connected");
        }

        socket = new Socket(address.getFrtAddress(), address.getPort());
        inputStreamReader = new InputStreamReader(socket.getInputStream());
        buffReader = new BufferedReader(inputStreamReader);
        outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
        buffWriter = new BufferedWriter(outputStreamWriter);

        String message = buffReader.readLine();
        log.info(message);
        if(!isStartWithMSG(message, WELCOME_RESPONSE)){
            throw new IOException("try logIn exception");
        }

        sendLine("USER "+address.getUser());
        message = buffReader.readLine();
        log.info(message);
        if(!isStartWithMSG(message, USER_OK_NEED_PASS_RESPONSE)){
            throw new IOException("user exception: "+address.getUser());
        }

        sendLine("PASS "+address.getPassword());
        message = buffReader.readLine();
        log.info(message);

        if(!isStartWithMSG(message, USER_IS_LOGED_RESPONSE)){
            throw new IOException("User was not signed in");
        }

    }

    public synchronized ArrayList getCatalogDir() throws IOException{
        if(socket == null){
            throw new IOException("disconnected");
        }

        String[] date = getPASVPort();
        Socket listSocket = new Socket(date[0], Integer.parseInt(date[1]));

        sendLine("LIST");

        InputStreamReader pasvSocket = new InputStreamReader(listSocket.getInputStream());
        buffReader = new BufferedReader(pasvSocket);

        ArrayList results = new ArrayList();
        String line;
        while((line = buffReader.readLine()) != null) {
            if (!line.startsWith("-"))
                if (line.contains(">"))
                    results.add(line.toString().substring(56, line.indexOf("->", 56)).trim());
                    else results.add(line.toString().substring(56).trim()); {}
        }

        inputStreamReader = new InputStreamReader(socket.getInputStream());
        buffReader = new BufferedReader(inputStreamReader);
        outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
        buffWriter = new BufferedWriter(outputStreamWriter);

        log.debug(buffReader.readLine());
        log.debug(buffReader.readLine());
        log.info(results);

        return results;
    }

    public synchronized void goToDir(String dir) throws IOException {
        sendLine("CWD /" + dir);
        String message = buffReader.readLine();
        if (dir.equals(""))
            dir = "main page";
        log.info("'"+dir+"'"+ ": " + message);
    }

    public synchronized boolean isCreateDir(String nameOfDirectory) throws IOException {
        sendLine("MKD " + nameOfDirectory);
        String message = buffReader.readLine();
        log.info(message);
        if(message.equals(CREATE_DIR_PERMISSION_DENIED_RESPONSE)){
            return false;
        }

        return false;
    }

    public synchronized void deleteDir (String nameOfDirectory) throws IOException {
        sendLine("DELE " + nameOfDirectory);
        String message = buffReader.readLine();
        log.info(message);
    }

    public synchronized void close(){
        try {
            sendLine("QUIT");
            String message = buffReader.readLine();
            log.info(message);
        } catch (IOException e) {
            log.error(e);
        } finally {
            socket = null;
        }
    }

    private synchronized String[] getPASVPort() throws IOException{
        sendLine("PASV");

        String message = buffReader.readLine();
        log.info(message);

        int startIndex = message.indexOf("(");
        int endIndex = message.indexOf(")",startIndex+1);

        String value = (message.substring(startIndex+1, endIndex)).replace(" ", "");
        String[] link = value.split(",");
        String ip = link[0]+"."+link[1]+"."+link[2]+"."+link[3];

        int port = (Integer.parseInt(link[4])*256)+Integer.parseInt(link[5]);
        log.info("IP: "+ip+" Port: "+port);

        return new String[]{ip, ""+port};
    }

    private synchronized void sendLine(String line) throws IOException {
        if (socket == null) {
            throw new IOException("FTPClient is not connected.");
        }
        try {
            buffWriter.write(line + "\r\n");
            buffWriter.flush();

        } catch (IOException e) {
            socket = null;
        }
    }

    private static boolean isStartWithMSG(String message, String start){
        return message.startsWith(start+" ");
    }

}