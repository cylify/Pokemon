public class Battle {
    private int currentTurn;
    private Computer player1;
    private Player player2;

    public Battle() {
        player1 = new Computer();
        player2 = new Player();   
    }
}
