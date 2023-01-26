public class Status {
    private String currentStatus;

    public Status(String currentStatus) {
        this.currentStatus = currentStatus;
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

    
}
