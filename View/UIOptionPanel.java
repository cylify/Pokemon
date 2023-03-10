import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;

public class UIOptionPanel extends JPanel {
    public static JButton fight, bag, run, pokemon;

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
                System.exit(0);
            }
        });
        add(run);
    }

    
    /** 
     * @return JButton
     */
    public JButton getFight() {
        return fight;
    }

    
    /** 
     * @param fight
     */
    public void setFight(JButton fight) {
        this.fight = fight;
    }

    
    /** 
     * @return JButton
     */
    public JButton getBag() {
        return bag;
    }

    
    /** 
     * @param bag
     */
    public void setBag(JButton bag) {
        this.bag = bag;
    }

    
    /** 
     * @return JButton
     */
    public JButton getRun() {
        return run;
    }

    
    /** 
     * @param run
     */
    public void setRun(JButton run) {
        this.run = run;
    }

    
    /** 
     * @return JButton
     */
    public JButton getPokemon() {
        return pokemon;
    }

    
    /** 
     * @param pokemon
     */
    public void setPokemon(JButton pokemon) {
        this.pokemon = pokemon;
    }
}
