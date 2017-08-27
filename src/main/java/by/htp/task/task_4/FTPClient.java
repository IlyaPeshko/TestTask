package by.htp.task.task_4;

import static by.htp.task.Utility.logger;

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
        logger("task 4");
        logger(address);
        if(socket!=null){
            throw new IOException("you are connected");
        }

        // connection
        socket = new Socket(address.getFrtAddress(), address.getPort());

        //initialize readers
        InputStreamReader isw = new InputStreamReader(socket.getInputStream());
        buffReader = new BufferedReader(isw);
        OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
        buffWriter = new BufferedWriter(osw);


        String message = buffReader.readLine();
        logger(message);
        if(!startWithMSG(message, WELCOME)){
            throw new IOException("try log in exception");
        }

        buffWriter.write("USER "+address.getUser()+ "\r\n");
        buffWriter.flush();

        message = buffReader.readLine();
        logger(message);
        if(!startWithMSG(message, USER_OK_NEED_PASS)){
            throw new IOException("user exception: "+address.getUser());
        }

        buffWriter.write("PASS "+address.getPassword()+ "\r\n");
        buffWriter.flush();

        message = buffReader.readLine();
        logger(message);
        if(!startWithMSG(message, USER_IS_LOGED)){
            throw new IOException("User was not signed in");
        }

    }

    public void close(){
        try {
            buffWriter.write("QUIT\r\n");
            buffWriter.flush(); 

            String message = buffReader.readLine();
            logger(message); }
        catch (IOException e) {}
        finally {socket = null; }
    }

    public ArrayList list() throws IOException{
        logger("fetch list");
        if(socket == null){
            throw new IOException("disconnected");
            //logger("disconnected");
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
        logger("catalog: " + results);
        return results;
    }

    private String[] setPASV() throws IOException{
        buffWriter.write("PASV\r\n");
        buffWriter.flush();

        String message = buffReader.readLine();
        logger(message);

        int startIndex = message.indexOf("(");
        int endIndex = message.indexOf(")",startIndex+1);

        String value = (message.substring(startIndex+1, endIndex)).replace(" ", "");
        String[] link = value.split(",");
        String ip = link[0]+"."+link[1]+"."+link[2]+"."+link[3];

        int port = (Integer.parseInt(link[4])*256)+Integer.parseInt(link[5]);
        logger("IP: "+ip+" Port: "+port);

        return new String[]{ip, ""+port};
    }

    public void goToDir(String dir) throws IOException {
        sendLine("CWD " + dir);
        buffWriter.flush();
        String message = buffReader.readLine();
        logger("current dir: "+message);
    }

    public synchronized String currentDir() throws IOException {
        sendLine("PWD");
        buffWriter.flush();
        String message = buffReader.readLine();
        logger(message);
        return message;
    }

    public boolean createDir (String nameOfDirectory) throws IOException {
        sendLine("MKD " + nameOfDirectory);
        buffWriter.flush();
        String message = buffReader.readLine();
        logger("create: "+message);
        if (message.equals("550 Permission denied."))
            return false;
        return true;
    }

    public synchronized void deleteDir (String nameOfDirectory) throws IOException {
        sendLine("DELE " + nameOfDirectory);
        buffWriter.flush();
        String message = buffReader.readLine();
        logger("delete dir" + message);
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