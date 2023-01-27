import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FontFormatException;

public class Main extends JFrame {
    public static HumanPlayer player;
    public static Computer comp;
    static JPanel main;
    static CardLayout c;

    public Main() throws IOException, FontFormatException {
        super("Pok\u00E9mon");
        c = new CardLayout();
        main = new JPanel(c);
        player = new HumanPlayer();
        comp = new Computer();
        UIStartScreen start = new UIStartScreen(c, main);
        UILoserPanel loserPanel = new UILoserPanel();
        UIWinnerPanel winnerPanel = new UIWinnerPanel();
        UIBattlePanel battlePanel = new UIBattlePanel(player, comp);
        UIMovePanel movePanel = new UIMovePanel(player, comp, battlePanel, loserPanel, winnerPanel);
        UIOptionPanel optionPanel = new UIOptionPanel();
        main.add(start, "start");
        c.show(main, "start");
        main.add(loserPanel, "lost");
        main.add(winnerPanel, "won");
        main.add(new UIOptionPanel(), "option");
        main.add(new UIBagPanel(player), "bag");
        main.add(optionPanel, "option");
        main.add(new UIPokemonPanel(player, battlePanel, movePanel, comp, loserPanel, winnerPanel), "pokemon");
        main.add(movePanel, "fight");
        main.add(battlePanel, "battle");
        add(main);
        setResizable(false);
        setPreferredSize(new Dimension(900,550));
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void checkWinner() {
        if(player.allPokemonFeinted()) {
            UILoserPanel lost = new UILoserPanel();
            Main.main.add(lost);
        } else if(comp.allPokemonFeinted()) {
            UIWinnerPanel won = new UIWinnerPanel();
            Main.main.add(won);
        }
    }
    
    /** 
     * @param arr
     */
    public static <V> void mix(ArrayList<V> arr) {
        Collections.shuffle(arr);
    }
    

    
    /** 
     * @param args
     * @throws IOException
     * @throws FontFormatException
     */
    public static void main(String[] args) throws IOException, FontFormatException {
        new Main();
    }
}
