import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class UIHP extends JPanel {
    public UIHP(Pokemon p) {
        JProgressBar hpBar = new JProgressBar();
        hpBar.setMinimum(0); // set minimum value
        hpBar.setMaximum(p.getHealth()); // set maximum value
        hpBar.setValue(p.getHealth()); // set current value
        hpBar.setForeground(Color.BLUE);
        hpBar.setBackground(Color.WHITE);
        JLabel hpLabel = new JLabel(String.valueOf(p.getHealth()) + "/" + String.valueOf(p.getHealth()));
        add(hpBar);
        add(hpLabel);

    }
}