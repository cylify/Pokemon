import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.CardLayout;
import java.awt.Color;
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
    JLabel label;

    public UIBattlePanel(Player p) {
        pokemonImg = new ImageIcon(
                "C:/Users/mradi/Dropbox/Programming/Java/Grade 12 Computer Science/Unit 4/Pokemon/Assets/back/"
                        + String.valueOf(p.getCurrentPokemon().getNumber()) + ".png");
        Image image = pokemonImg.getImage();
        Image newimg = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        pokemonImg = new ImageIcon(newimg);
        label = new JLabel(pokemonImg);
        add(label);
        add(new UIOptionPanel(), "option");
        add(new UIHP(p.getCurrentPokemon()), "hp");
        setVisible(true);
        setBackground(Color.WHITE);
    }
}