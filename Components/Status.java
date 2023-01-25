import java.util.ArrayList;

public class Status {
    private String currentStatus;
    private int duration;

    public Status(String currentStatus, int duration) {
        this.currentStatus = currentStatus;
        this.duration = duration;
    }


    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    
}
