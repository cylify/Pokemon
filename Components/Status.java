public class Status {
    private String currentStatus;

    /**
     * Constructer
     */
    public Status(String currentStatus) {
        this.currentStatus = currentStatus;
    }


    /**
     * Constructer
     */
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

    
}
