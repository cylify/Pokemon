import javax.swing.JProgressBar;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

public class UIHP extends JPanel {
    private JProgressBar hpBar;

    public UIHP(Player player) {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(150, 30));
        hpBar = new JProgressBar();
        hpBar.setMinimum(0);
        hpBar.setMaximum(player.getCurrentPokemon().getHealth());
        hpBar.setValue(player.getCurrentPokemon().getCurrentHp());
        hpBar.setStringPainted(true);
        hpBar.setString(String.valueOf(player.getCurrentPokemon().getCurrentHp()) + "/" + String.valueOf(
                player.getCurrentPokemon().getHealth()));
        add(hpBar, BorderLayout.CENTER);
        hpBar.setForeground(Color.BLUE);
        setBackground(Color.WHITE);
    }

    public void updateHP(Player player) {
        hpBar.setMaximum(player.getCurrentPokemon().getHealth());
        hpBar.setValue(player.getCurrentPokemon().getCurrentHp());
        hpBar.setString(String.valueOf(player.getCurrentPokemon().getCurrentHp()) + "/" + String.valueOf(
                player.getCurrentPokemon().getHealth()));
    }

}
