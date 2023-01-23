import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.CardLayout;

public class UIStartScreen extends JFrame {

    static JPanel main;
    static CardLayout c;

    public UIStartScreen() {
        super("Pok\uEE09mon");
        c = new CardLayout();
        main = new JPanel(c);

        ImageIcon bgImg = new ImageIcon("C:/Users/mradi/Dropbox/Programming/Java/Grade 12 Computer Science/Unit 4/Pokemon/Assets/StartBackground.png");
        JButton play = new JButton(bgImg);
        play.setMargin(new Insets(0,0,0,0));
        main.add(play);
        add(main);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new UIStartScreen();
    }
}
