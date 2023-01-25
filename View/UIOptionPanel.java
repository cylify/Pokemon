import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;

public class UIOptionPanel extends JPanel {
    JButton fight,bag,run,pokemon;

    public UIOptionPanel() {
        setLayout(new GridLayout(1, 4, 5, 5));

        fight = new JButton("FIGHT");
        fight.setPreferredSize(new Dimension(150,50));
        fight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.c.show(Main.main, "fight");
            }
        });
        add(fight);

        bag = new JButton("BAG");
        bag.setPreferredSize(new Dimension(150,50));
        bag.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.c.show(Main.main, "bag");
            }
        });
        add(bag);
        
        pokemon = new JButton("POK\u00C9MON");
        pokemon.setPreferredSize(new Dimension(150,50));
        pokemon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.c.show(Main.main, "pokemon");
            }
        });
        add(pokemon);

        run = new JButton("RUN");
        run.setPreferredSize(new Dimension(150, 50));
        run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.c.show(Main.main, "start");
            }
        });
        add(run);
    }
}
