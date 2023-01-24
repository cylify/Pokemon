import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.IOException;
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
        Player p = new HumanPlayer();
        UIStartScreen start = new UIStartScreen(c, main);
        main.add(start, "start");
        c.show(main, "start");
        main.add(new UIOptionPanel(), "option");
        main.add(new UIBagPanel(), "bag");
        // main.add(new UIOptionPanel(), "option");
        main.add(new UIPokemonPanel(), "pokemon");
        main.add(new UIMovePanel(), "fight");
        main.add(new UIBattlePanel(p), "battle");
        add(main);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

    public static void main(String[] args) throws IOException, FontFormatException {
        new Main();
    }
}
