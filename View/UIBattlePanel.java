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


public class UIBattlePanel extends JPanel {
    ImageIcon pokemonImg;
    JLabel label1;
    JLabel label2;

    public UIBattlePanel(Player p1, Player p2) {
        label1 = player1PokemonDisplay(p1);
        label2 = player2PokemonDisplay(p2);
        add(label1);
        add(label2);
        add(new UIOptionPanel(), "option");
        add(new UIHP(p1.pokemonBag.get(0)), "hp");
        add(new UIHP(p2.pokemonBag.get(0)), "hp");
        setVisible(true);
    }

    public JLabel player1PokemonDisplay(Player p1) {
        pokemonImg = new ImageIcon(
                "Pokemon/Assets/back/"
                        + String.valueOf(p1.currentPokemon.getNumber()) + ".png");
        Image image = pokemonImg.getImage();
        Image newimg = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        pokemonImg = new ImageIcon(newimg);
        JLabel label1 = new JLabel(pokemonImg);
        return label1;
    }

    public JLabel player2PokemonDisplay(Player p2) {
        pokemonImg = new ImageIcon(
                "Pokemon/Assets/back/"
                        + String.valueOf(p2.currentPokemon.getNumber()) + ".png");
        Image image = pokemonImg.getImage();
        Image newimg = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        pokemonImg = new ImageIcon(newimg);
        JLabel label2 = new JLabel(pokemonImg);
        return label2;
    }
}