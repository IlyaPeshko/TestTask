package by.htp.task.task_4;

/**
 * Created by user on 15.08.17.
 */
public class FTPAddress {
    private String frtAddress;
    private int port;
    private String user;
    private String password;

    public FTPAddress(String frtAddress, int port, String user, String password) {
        this.frtAddress = frtAddress;
        this.port = port;
        this.user = user;
        this.password = password;
    }

    public String getFrtAddress() {
        return frtAddress;
    }

    public void setFrtAddress(String frtAddress) {
        this.frtAddress = frtAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "FTPAddress{" +
                "frtAddress='" + frtAddress + '\'' +
                ", port=" + port +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
