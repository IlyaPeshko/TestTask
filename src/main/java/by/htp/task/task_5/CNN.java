package by.htp.task.task_5;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import static by.htp.task.Utility.logger;
import java.io.IOException;
import java.util.List;

public class CNN {

    private static int numberForConsole = 1;
    private static int count;
    private static int size = 100;
    private static int from = 0;
    private static final String xPathCount = ".//div[@class='cnn-search__results-count']";
    private static final String xPathTarget = ".//h3[@class='cnn-search__result-headline']/a";
    private static final String indexPageURL = "http://edition.cnn.com/search/?q=trump";
    private static final String searchPageURL = "http://edition.cnn.com/search/?q=";
    private static final String sizeForURL = "&size=";
    private static final String fromForURL = "&from=";

    public static void main(String[] args) throws IOException {
        logger("task 5");
        CNN cnnSearch = new CNN();
        WebClient webClient = cnnSearch.initWebClient();
        HtmlPage page = null;
        List <Object> preCatalog;
        String searchWord = "Trump";

        count = cnnSearch.count(webClient, page);
        logger("found " + count + " news with: " + searchWord);
        webClient.close();
        while (cnnSearch.getSize() <= count) {
            webClient = cnnSearch.initWebClient();
            preCatalog = cnnSearch.catalog(page, webClient, searchWord);
            System.out.println();
            for (Object o : preCatalog) {
                FilesApp.writer(o.toString());
                logger(numberForConsole++ + o.toString());
            }
            webClient.close();
        }
    }

    private WebClient initWebClient () throws IOException {
        logger("initWebClient");
        logger(indexPageURL);
        java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
        java.util.logging.Logger.getLogger("org.apache.http").setLevel(java.util.logging.Level.OFF);
        java.util.logging.Logger.getLogger("org.apache.log4j").setLevel(java.util.logging.Level.OFF);


        WebClient webClient = new WebClient(BrowserVersion.FIREFOX_52);
        webClient.getOptions().setUseInsecureSSL(true); //ignore ssl certificate
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);

        return webClient;
    }

    private static int count (WebClient webClient, HtmlPage page) throws IOException {
        page = webClient.getPage(indexPageURL);
        waitJS(webClient);

        System.out.println();
        HtmlDivision div = (HtmlDivision) page.getByXPath(xPathCount).get(0);
        int count = Integer.parseInt(div.getTextContent().substring(30,37).trim());

        return count;
    }

    private List<Object> catalog (HtmlPage page, WebClient webClient, String searchWord) throws IOException {
        page = webClient.getPage(searchPageURL+searchWord+sizeForURL+size+ fromForURL +from);
        waitJS(webClient);
        printPosition(page);

        List<Object> list = page.getByXPath(xPathTarget);
        logger("received from page" + list.size() + " news");
        size = size+100;
        from = from+100;
        return list;
    }

    private static void waitJS (WebClient webClient) {
        logger("wait JavaScript");
        webClient.waitForBackgroundJavaScriptStartingBefore(5000);
        webClient.waitForBackgroundJavaScript(1000);
    }

    private static void printPosition (HtmlPage page) {
        HtmlDivision div = (HtmlDivision) page.getByXPath(".//div[@class='cnn-search__results-count']").get(0);
        logger("receiving "+ div.getTextContent());
    }

    public int getSize() {
        return size;
    }


}