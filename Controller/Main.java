import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FontFormatException;

public class Main extends JFrame {
    static JPanel main;
    static CardLayout c;

    public Main() throws IOException, FontFormatException {
        super("Pok\u00E9mon");
        c = new CardLayout();
        main = new JPanel(c);
        Player p = new Player();
        UIStartScreen start = new UIStartScreen(c, main);
        UIHP hp = new UIHP(p);
        UIBattlePanel battlePanel = new UIBattlePanel(p, hp);
        UIMovePanel movePanel = new UIMovePanel(p);
        main.add(start, "start");
        c.show(main, "start");
        main.add(new UIOptionPanel(), "option");
        main.add(new UIBagPanel(p), "bag");
        main.add(new UIOptionPanel(), "option");
        main.add(new UIPokemonPanel(p, battlePanel, c, main, movePanel, hp), "pokemon");
        main.add(movePanel, "fight");
        main.add(battlePanel, "battle");
        add(main);
        setPreferredSize(new Dimension(900,550));
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static <V> void mix(ArrayList<V> arr) {
        Collections.shuffle(arr);
    }
    

    public static void main(String[] args) throws IOException, FontFormatException {
        new Main();
    }
}
