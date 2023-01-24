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
    public UIBattlePanel(Player p) {
        ImageIcon pokemonImg = new ImageIcon("C:/Users/mradi/Dropbox/Programming/Java/Grade 12 Computer Science/Unit 4/Pokemon/Assets/back/" + String.valueOf(p.pokemonBag.get(0).getNumber()) +".png");
        System.out.println(p.pokemonBag.get(0).getNumber());
        Image image = pokemonImg.getImage(); // transform it 
        Image newimg = image.getScaledInstance(75, 75,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        pokemonImg = new ImageIcon(newimg);
        JLabel label = new JLabel(pokemonImg);
        add(label);
        add(new UIOptionPanel(), "option");
    }
}