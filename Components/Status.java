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

    
    /** 
     * @return String
     */
    public String getCurrentStatus() {
        return currentStatus;
    }

    
    /** 
     * @param currentStatus
     */
    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    
    /** 
     * @return int
     */
    public int getDuration() {
        return duration;
    }

    
    /** 
     * @param duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    
}
