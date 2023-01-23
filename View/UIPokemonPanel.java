import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.FontFormatException;

public class UIPokemonPanel extends JPanel {
    protected JButton[] pokemons;

    public UIPokemonPanel() {
        pokemons = new JButton[4];
        Player p = new HumanPlayer();
        for(int i = 0; i < pokemons.length; ++i) {
            pokemons[i] = new JButton(p.pokemonBag.get(i).getName());
            add(pokemons[i]);
        }
    }

}
