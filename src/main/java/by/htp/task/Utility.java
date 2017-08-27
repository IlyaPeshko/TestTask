package by.htp.task;

import org.apache.log4j.Logger;

/**
 * Created by user on 27.08.17.
 */
public class Utility {
    private static final Logger log = Logger.getLogger(Utility.class);

    public static void logger (Object message){
        log.info(message);
        System.out.println(message);
    }
}
