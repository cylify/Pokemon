import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;


public class UIPokemonPanel extends JPanel {
    protected JButton[] pokemons;

    public UIPokemonPanel(Player p) {
        pokemons = new JButton[p.pokemonBag.size()];
        UIBattlePanel battlePanel = new UIBattlePanel(p);
        add(battlePanel);
        JLabel imgLabel = new JLabel();
        for(int i = 0; i < pokemons.length; ++i) {
            pokemons[i] = new JButton(p.pokemonBag.get(i).getName());
            if(pokemons[i].getText().equals(p.pokemonBag.get(0).getName())) {
                continue;
            } else {
                final Integer innerI = i;
                pokemons[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Pokemon temp = p.pokemonBag.get(innerI);
                        p.pokemonBag.set(innerI, p.currentPokemon);
                        pokemons[innerI] = new JButton(p.currentPokemon.getName());
                        p.currentPokemon = temp;
                        ImageIcon icon = new ImageIcon(temp.getImg());
                        imgLabel.setIcon(icon);
                        battlePanel.repaint();
                        battlePanel.pokemonImg = new ImageIcon(
                            "C:/Users/mradi/Dropbox/Programming/Java/Grade 12 Computer Science/Unit 4/Pokemon/Assets/back/"
                            + String.valueOf(p.currentPokemon.getNumber()) + ".png");
                        Image image = battlePanel.pokemonImg.getImage();
                        Image newimg = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
                        battlePanel.pokemonImg = new ImageIcon(newimg);
                        battlePanel.label.setIcon(battlePanel.pokemonImg);
                        Main.c.show(Main.main, "battle");
                    }
                });
                add(pokemons[i]);
            }
        }

        


        ImageIcon backImg = new ImageIcon("C:/Users/mradi/Dropbox/Programming/Java/Grade 12 Computer Science/Unit 4/Pokemon/Assets/BackButton.jpg");
        Image image = backImg.getImage();
        Image newimg = image.getScaledInstance(75, 75,  java.awt.Image.SCALE_SMOOTH);
        backImg = new ImageIcon(newimg);
        JButton backButton = new JButton(backImg);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.c.show(Main.main, "battle");
            }
        });
        backButton.setPreferredSize(new Dimension(50,50));
        add(backButton);
    }

}
