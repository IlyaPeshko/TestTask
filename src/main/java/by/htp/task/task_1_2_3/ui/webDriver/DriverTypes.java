package by.htp.task.task_1_2_3.ui.webDriver;


public enum DriverTypes {
    FIREFOX ("firefox"), IE ("internet explorer"), GC ("google chrome"), GC_Win32 ("google chrome win32");

    private String driverName;

    DriverTypes(String driverName){
        this.driverName = driverName;
    }

    public String getDriverName() {
        return this.driverName;
    }
}
