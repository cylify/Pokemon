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

public class UIMovePanel extends JPanel {
    protected JButton[] pokemonMoves;
    public UIMovePanel() {
        pokemonMoves = new JButton[4];
        Player p = new HumanPlayer();
        for(int i = 0; i < pokemonMoves.length; ++i) {
            pokemonMoves[i] = new JButton(p.pokemonBag.get(0).getMoves()[i].getName());
            add(pokemonMoves[i]);
        }

        ImageIcon backImg = new ImageIcon("Pokemon/Assets/BackButton.jpg");
        Image image = backImg.getImage(); // transform it 
        Image newimg = image.getScaledInstance(75, 75,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
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