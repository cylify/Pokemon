public class Status {
	private String currentStatus;
	protected boolean isDebuff;
	private boolean isFeinted;

	public Status(String currentStatus) {
		this.currentStatus = currentStatus;
		this.isFeinted = false;
		this.isDebuff = false;
	}
	
	public boolean hasStatus() {
		if(!this.currentStatus.isEmpty()) {
			return true;
		}
		return false;
	}
}