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

public class UIBagPanel extends JPanel {
    GridBagConstraints c = new GridBagConstraints();
    private JButton[] potionButtons;
    public UIBagPanel() throws IOException, FontFormatException {
        // setLayout(new GridLayout());
        potionButtons = new JButton[4];
        Player player = new HumanPlayer();
        
        
        JLabel potionExclaim = new JLabel("THESE ARE YOUR POTIONS!");
        potionExclaim.setVerticalAlignment(JLabel.TOP);
        try {
            InputStream inputStream = new BufferedInputStream(new FileInputStream("C:/Users/mradi/Dropbox/Programming/Java/Grade 12 Computer Science/Unit 4/Pokemon/Assets/pokemon-stadium-2.ttf"));
            Font font = Font.createFont(Font.TRUETYPE_FONT, inputStream);
            font = font.deriveFont(26f);
            potionExclaim.setFont(font);
        } catch (IOException | FontFormatException e) {
            potionExclaim.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
        }
        add(potionExclaim);
        for(int i = 0; i < potionButtons.length; ++i) {
            potionButtons[i] = new JButton(player.potionBag.get(i).getName());
            add(potionButtons[i]);
        }

        ImageIcon backImg = new ImageIcon("C:/Users/mradi/Dropbox/Programming/Java/Grade 12 Computer Science/Unit 4/Pokemon/Assets/BackButton.jpg");
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
