public class Battle {
    private int currentTurn;
    private Player player1;
    private Player player2;

    public Battle() {
        player1 = new HumanPlayer();
        player2 = new HumanPlayer();   
    }
}
