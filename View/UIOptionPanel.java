import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UIOptionPanel extends JPanel {
    JButton fight,bag,run,pokemon;
    GridBagConstraints c = new GridBagConstraints();

    public UIOptionPanel() {
        setLayout(new GridBagLayout());
        c.insets = new Insets(5,5,5,5);

        fight = new JButton("FIGHT");
        c.gridx = 5;
        c.gridy = 5;
        c.anchor = GridBagConstraints.SOUTH;
        fight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.c.show(Main.main, "fight");
            }
        });
        add(fight,c);

        bag = new JButton("BAG");
        c.gridy = 6;
        bag.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.c.show(Main.main, "bag");
            }
        });
        add(bag,c);
        
        pokemon = new JButton("POK\u00C9MON");
        c.gridy = 7;
        pokemon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.c.show(Main.main, "pokemon");
            }
        });
        add(pokemon,c);

        run = new JButton("RUN");
        c.gridy = 8;
        run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.c.show(Main.main, "start");
            }
        });
        add(run,c);
        setPreferredSize(new Dimension(700,400));
    }
}
