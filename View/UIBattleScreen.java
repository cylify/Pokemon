import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UIBattleScreen extends JPanel {
    JButton fight,bag,run,pokemon;
    GridBagConstraints c = new GridBagConstraints();

    public UIBattleScreen() {
        setLayout(new GridLayout());
        c.insets = new Insets(5,5,5,5);
        fight = new JButton("FIGHT");
        c.gridx = 0;
        c.gridy = 0;
        add(fight, c);

        bag = new JButton("BAG");
        c.gridx = 1;
        c.gridy = 1;
        add(bag, c);

        run = new JButton("RUN");
        c.gridx = 2;
        c.gridy = 2;
        run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIMain.c.show(UIMain.main, "start");
            }
        });
        add(run, c);
        pokemon = new JButton("POK\u00C9MON");
        c.gridx = 3;
        c.gridy = 3;
        add(pokemon, c);
    }
}
