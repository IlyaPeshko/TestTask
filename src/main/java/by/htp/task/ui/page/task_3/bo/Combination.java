package by.htp.task.ui.page.task_3.bo;

/**
 * Created by user on 09.08.17.
 */
public class Combination {

    private String from;
    private String to;
    private String departDate;
    private String returnDate;

    public Combination(String from, String to, String departDate, String returnDate) {
        this.from = from;
        this.to = to;
        this.departDate = departDate;
        this.returnDate = returnDate;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDepartDate() {
        return departDate;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Combination{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", departDate='" + departDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                '}';
    }
}
