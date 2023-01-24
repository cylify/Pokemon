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

    public UIPokemonPanel() {
        pokemons = new JButton[4];
        Player p = new HumanPlayer();
        for(int i = 0; i < pokemons.length; ++i) {
            pokemons[i] = new JButton(p.pokemonBag.get(i).getName());
            add(pokemons[i]);
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
