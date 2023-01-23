import java.awt.GridLayout;
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
        setSize(new Dimension(200, 100));
        setLayout(new GridLayout());
        c.insets = new Insets(5,5,5,5);
        fight = new JButton("FIGHT");
        fight.setSize(new Dimension(100, 100));
        add(fight);

        bag = new JButton("BAG");
        bag.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.c.show(Main.main, "bag");
            }
        });
        add(bag);

        run = new JButton("RUN");
        run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.c.show(Main.main, "start");
            }
        });
        add(run);

        pokemon = new JButton("POK\u00C9MON");
        pokemon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.c.show(Main.main, "pokemon");
            }
        });
        add(pokemon);
    }
}
