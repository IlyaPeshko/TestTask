package by.htp.task.ui.page.task_3;

import org.apache.log4j.Logger;

/**
 * Created by user on 17.08.17.
 */
abstract class Page {
    private static final Logger log = Logger.getLogger(Page.class);

    public static void logger (Object message){
        log.info(message);
    }
}
