import by.htp.task.task_1_2_3.ui.page.UtilityImpl;
import by.htp.task.task_1_2_3.ui.page.task_2.bo.Account;
import by.htp.task.task_1_2_3.ui.page.task_3.bo.Combination;
import by.htp.task.task_1_2_3.ui.page.task_3.bo.Passenger;
import java.io.IOException;

class Property extends UtilityImpl{

    protected static String targetTutBy;
    protected static String indexURLTutBy;
    protected static String requestTutBy;

    protected static Account account;
    protected static String inboxURL;
    protected static String sentURL;
    protected static String spamURL;
    protected static String indexURLGmail;

    protected static  String indexURLDelta;
    protected static Combination combination;
    protected static Passenger passenger;

    protected static String driverType;

    protected static void initProperties() throws IOException {
        driverType = getObject("driverVersion");
        initTutBy();
        initGmail();
        initDelta();
    }

    private static void initTutBy () throws IOException {
        targetTutBy = getObject("targetTutBy");
        indexURLTutBy = getObject("indexURLTutBy");
        requestTutBy = getObject("requestTutBy");
    }

    private static void initGmail () throws IOException {
        account = new Account(getObject("accountEmail"), getObject("accountPassword"));
        inboxURL = getObject("inboxURL");
        sentURL = getObject("sentURL");
        spamURL = getObject("spamURL");
        indexURLGmail = getObject("indexURLGmail");
    }

    private static void initDelta () throws IOException {
        indexURLDelta = getObject("indexURLDelta");
        combination = new Combination(getObject("combinationFrom"), getObject("combinationTo"), getObject("combinationDepartDate"), getObject("combinationRetirnDate"));
        passenger = new Passenger(getObject("firstName"), getObject("lastName"), getObject("phone"), getObject("email"));

    }
}
