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

    private final String WELCOME  = "220";
    private final String USER_OK_NEED_PASS  = "331";
    private final String USER_IS_LOGED  = "230";

    public void connect(FTPAddress address) throws IOException{
        log.info(address);
        if(socket!=null){
            throw new IOException("you are connected");
        }

        socket = new Socket(address.getFrtAddress(), address.getPort());

        InputStreamReader isw = new InputStreamReader(socket.getInputStream());
        buffReader = new BufferedReader(isw);
        OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
        buffWriter = new BufferedWriter(osw);


        String message = buffReader.readLine();
        log.info(message);
        if(!startWithMSG(message, WELCOME)){
            throw new IOException("try logIn exception");
        }

        buffWriter.write("USER "+address.getUser()+ "\r\n");
        buffWriter.flush();

        message = buffReader.readLine();
        log.info(message);
        if(!startWithMSG(message, USER_OK_NEED_PASS)){
            throw new IOException("user exception: "+address.getUser());
        }

        buffWriter.write("PASS "+address.getPassword()+ "\r\n");
        buffWriter.flush();

        message = buffReader.readLine();
        log.info(message);
        if(!startWithMSG(message, USER_IS_LOGED)){
            throw new IOException("User was not signed in");
        }

    }

    public ArrayList getCatalogDir() throws IOException{
        if(socket == null){
            throw new IOException("disconnected");
        }

        String[] date = setPASV();
        Socket listSocket = new Socket(date[0], Integer.parseInt(date[1]));

        buffWriter.write("NLST\r\n");
        buffWriter.flush();

        InputStreamReader pasvSocet = new InputStreamReader(listSocket.getInputStream());
        buffReader = new BufferedReader(pasvSocet);

        ArrayList results = new ArrayList();
        String line;
        while((line = buffReader.readLine()) != null) {
            results.add(line.toString());

        }
        log.info(results);
        return results;
    }

    public void goToDir(String dir) throws IOException {
        sendLine("CWD " + dir);
        buffWriter.flush();
        String message = buffReader.readLine();
        log.info("'"+dir+"' "+ " : " + message);
    }

    public boolean createDir (String nameOfDirectory) throws IOException {
        sendLine("MKD " + nameOfDirectory);
        buffWriter.flush();
        String message = buffReader.readLine();
        log.info(message);
        if (message.equals("550 Permission denied."))
            return false;
        return true;
    }

    public synchronized void deleteDir (String nameOfDirectory) throws IOException {
        sendLine("DELE " + nameOfDirectory);
        buffWriter.flush();
        String message = buffReader.readLine();
        log.info(message);
    }

    public void close(){
        try {
            buffWriter.write("QUIT\r\n");
            buffWriter.flush();

            String message = buffReader.readLine();
            log.info(message); }
        catch (IOException e) {}
        finally {socket = null; }
    }

    private String[] setPASV() throws IOException{
        buffWriter.write("PASV\r\n");
        buffWriter.flush();

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

    private boolean startWithMSG(String message, String start){
        return message.startsWith(start+" ");
    }

}