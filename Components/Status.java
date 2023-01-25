public class Status {
    private String currentStatus;
    private int duration;

    public Status(String currentStatus) {
        this.currentStatus = currentStatus;
        this.duration  = 2;
    }


    public Status() {
        this("Normal");
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
