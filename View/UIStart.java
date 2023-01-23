import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import java.awt.Insets;

public class UIStart extends JPanel {
    CardLayout c;
    JPanel main;

    public UIStart(CardLayout c, JPanel main) { // You do not need to pass in cardlayout and main - however this makes the panel more reusable outside of the project
        super(new GridLayout()); 
        this.c = c;
        this.main = main;
        ImageIcon bg = new ImageIcon("C:/Users/mradi/Dropbox/Programming/Java/Grade 12 Computer Science/Unit 4/Pokemon/Assets/StartBackground.png");
        JButton BGbutton = new JButton();
        BGbutton.setMargin(new Insets(0,0,0,0));
        BGbutton.setBorderPainted(false);
        BGbutton.setIcon(bg);
        BGbutton.addActionListener(e -> showBattle());
        add(BGbutton);
        
    }
    
    public void showBattle() {
        UIBattle battle = new UIBattle(c, main);
        main.add(battle, "two");
        c.show(main, "two");
    }
}

