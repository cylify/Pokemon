import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.CardLayout;

public class UIMain extends JFrame {
    static JPanel main;
    static CardLayout c;

    public UIMain() {
        super("Pok\u00E9mon");
        c = new CardLayout();
        main = new JPanel(c);
        UIStartScreen start = new UIStartScreen(c, main);
        main.add(start, "start");
        c.show(main, "start");
        add(main);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new UIMain();
    }
}
