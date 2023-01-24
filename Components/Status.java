import java.util.ArrayList;

public class Status {
    private boolean isFeinted;
    private String currentStatus;

    public Status(Move move) {
        this.isFeinted = false;
    }

    public String applyStatus(Move move) {
        String currentStatus = "Normal";
        ArrayList<SpecialMoves> specMoves = new ArrayList<>();
        for(SpecialMoves i : specMoves) {
            if(i.getName().equals(move.getName())) {
                currentStatus = i.getStatus();
            }
        }
        return currentStatus;
    }

    public boolean ifPokemonFeinted(Pokemon p) {
        boolean flag = false;
        if(p.getHealth() == 0) {
            flag = true;
        }
        return flag;
    }

    public boolean isFeinted() {
        return isFeinted;
    }

    public void setFeinted(boolean isFeinted) {
        this.isFeinted = isFeinted;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    
}
