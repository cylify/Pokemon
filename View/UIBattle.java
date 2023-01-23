import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

import javax.swing.ImageIcon;

public class UIBattle extends JPanel {
	CardLayout c;
    JPanel main;
	public UIBattle(CardLayout c, JPanel main) {
        this.c = c;
        this.main = main;
        JButton fightButton = new JButton("FIGHT!");
        add(fightButton);
        fightButton.setSize(30,50);
        fightButton.addActionListener(e -> showMoves());
        // fightButton.setPreferredSize(new Dimension(30, 50));
        ImageIcon img = new ImageIcon("C:/Users/mradi/Dropbox/Programming/Java/Grade 12 Computer Science/Unit 4/Pokemon/Assets/BackButton.jpg");
        JButton backButton = new JButton(img);
        backButton.setSize(100,50);
        // backButton.setPreferredSize(new Dimension(100, 50));
        add(backButton);
        backButton.addActionListener(e -> showUIStart());
    }

    public void showMoves() {
        UIMoves moves = new UIMoves(c, main);
        main.add(moves, "three");
        c.show(main, "three");
    }
    public void showUIStart() {
        // Already made the panel so don't need to remake -> otherwise would initialize panels here
        //PanelOne panelOne = new PanelOne(c, main); 
        //main.add(panelOne, "One");
        c.show(main, "one");
	}
}