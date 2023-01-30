import javax.swing.JProgressBar;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

public class UIHP extends JPanel {
    private JProgressBar hpBar;

    public UIHP(Pokemon p) {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(150, 30));
        hpBar = new JProgressBar();
        hpBar.setMinimum(0);
        hpBar.setMaximum(p.getHealth());
        hpBar.setValue(p.getCurrentHp());
        hpBar.setStringPainted(true);
        hpBar.setString(String.valueOf(p.getCurrentHp()) + "/" + String.valueOf(p.getHealth()));
        add(hpBar, BorderLayout.CENTER);
        hpBar.setForeground(Color.BLUE);
        setBackground(Color.WHITE);
    }

    
    /** 
     * For pokemon update hp which is a JProgressBar
     * @param p
     */
    public void updateHP(Pokemon p) {
        hpBar.setMaximum(p.getHealth());
        if (p.getCurrentHp() > 0) {
            hpBar.setValue(p.getCurrentHp());
            hpBar.setString(String.valueOf(p.getCurrentHp()) + "/" + String.valueOf(p.getHealth()));
        } else {
            hpBar.setValue(0);
            hpBar.setString("0" + "/" + String.valueOf(p.getHealth()));
        }
    }
}