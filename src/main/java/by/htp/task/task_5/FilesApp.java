package by.htp.task.task_5;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by user on 27.08.17.
 */
public class FilesApp {

    public static void main(String[] args) {
        //writer();
    }

    public static void writer (String row) {

        try(FileWriter writer = new FileWriter("src/main/resources/CNN results.txt", true))
        {

            writer.write(row);
            writer.append('\n');
            writer.flush();
            writer.close();

        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}