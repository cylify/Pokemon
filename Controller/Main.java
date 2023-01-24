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
        Player p1 = new HumanPlayer();
        Player p2 = new Computer();
        UIStartScreen start = new UIStartScreen(c, main);
        main.add(start, "start");
        c.show(main, "start");
        main.add(new UIOptionPanel(), "option");
        main.add(new UIBagPanel(), "bag");
        main.add(new UIOptionPanel(), "option");
        main.add(new UIPokemonPanel(p1), "pokemon");
        main.add(new UIMovePanel(), "fight");
        main.add(new UIBattlePanel(p1), "battle");
        add(main);
        setPreferredSize(new Dimension(900,550));
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

    public static void main(String[] args) throws IOException, FontFormatException {
        new Main();
    }
}
