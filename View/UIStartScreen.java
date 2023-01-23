import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UIStartScreen extends JPanel {
    CardLayout c;
    JPanel main;

    public UIStartScreen(CardLayout c, JPanel main) {
        this.c = c;
        this.main = main;

        ImageIcon bgImg = new ImageIcon("C:/Users/mradi/Dropbox/Programming/Java/Grade 12 Computer Science/Unit 4/Pokemon/Assets/StartBackground.png");
        JButton play = new JButton(bgImg);
        play.setMargin(new Insets(0,0,0,0));
        add(play);
        
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIMain.c.show(UIMain.main, "battle");
            }
        });
    }

    
}
