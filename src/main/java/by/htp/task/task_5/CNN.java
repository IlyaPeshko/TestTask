package by.htp.task.task_5;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.util.List;

import static by.htp.task.task_1_2_3.ui.page.Page.log;

public class CNN {
    private static final String indexPageURL = "http://edition.cnn.com/";
    private static int counter;

    public static void main(String[] args) throws IOException {
        CNN find = new CNN();
        WebClient webClient = find.initWebClient();
        HtmlPage page = webClient.getPage(indexPageURL);

        waitJS(webClient, 1000);

        List list = page.getByXPath("//*[contains(text(),'Trump')]/text()");
        for (Object e : list) {
            if (!e.toString().equals(""))
                if(e.toString().contains("Trump ") || e.toString().contains("Trump's")|| e.toString().contains("Trumps ")){
                    log.info(e);
                    counter++;
                }

        }
        log.info("founded: " + counter);
    }

    private WebClient initWebClient () throws IOException {
        log.info(indexPageURL);

        WebClient webClient = new WebClient(BrowserVersion.FIREFOX_52);
        webClient.getOptions().setUseInsecureSSL(true); //ignore ssl certificate
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);


        return webClient;
    }

    private static void waitJS (WebClient webClient, int waitTime) {
        log.info("");
        webClient.waitForBackgroundJavaScriptStartingBefore(waitTime);
        webClient.waitForBackgroundJavaScript(waitTime);
    }
}
