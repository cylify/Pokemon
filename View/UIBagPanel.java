import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UIBagPanel extends JPanel {
    private JButton[] potionButtons;

    public UIBagPanel(HumanPlayer player) throws IOException, FontFormatException {
        setLayout(new BorderLayout());

        Path textPath = Paths.get("Assets/", "pokemon-stadium-2.ttf");
        String textPathAsString = textPath.toString();
        JLabel potionExclaim = new JLabel("THESE ARE YOUR POTIONS!");
        try {
            InputStream inputStream = new BufferedInputStream(new FileInputStream(
                    textPathAsString));
            Font font = Font.createFont(Font.TRUETYPE_FONT, inputStream);
            font = font.deriveFont(26f);
            potionExclaim.setFont(font);
        } catch (IOException | FontFormatException e) {
            potionExclaim.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
        }
        add(potionExclaim, BorderLayout.NORTH);

        // Create a new panel with GridLayout to hold the potion buttons
        JPanel potionButtonPanel = new JPanel(new GridLayout(3, 2));
        potionButtons = new JButton[player.getPotionBag().size()];
        for (int i = 0; i < potionButtons.length; ++i) {
            potionButtons[i] = new JButton(player.getPotionBag().get(i).getName());
            if((!player.getCurrentPokemon().getStatus().getCurrentStatus().equals("Normal")) && player.getPotionBag().get(i).getHealing().equals("All")) {
                potionButtons[i].setEnabled(true);
            } else if(player.getCurrentPokemon().getStatus().getCurrentStatus().equals(player.getPotionBag().get(i).getHealing())) {
                potionButtons[i].setEnabled(true);
            } else {
                potionButtons[i].setEnabled(false);
            }
            final Integer innerI = i;
            potionButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    player.getCurrentPokemon().setStatus(new Status());
                    potionButtons[innerI].setEnabled(false);
                    Main.c.show(Main.main, "battle");
                }
            });
            potionButtonPanel.add(potionButtons[i]);
        }
        add(potionButtonPanel, BorderLayout.CENTER);
        createBackButton();
        setBackground(Color.WHITE);
    }
    
    
    public void createBackButton() {
        ImageIcon backImg = new ImageIcon(
                "C:/Users/mradi/Dropbox/Programming/Java/Grade 12 Computer Science/Unit 4/Pokemon/Assets/BackButton.jpg");
        Image image = backImg.getImage(); // transform it
        Image newimg = image.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        backImg = new ImageIcon(newimg);
        JButton backButton = new JButton(backImg);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.c.show(Main.main, "battle");
            }
        });
        backButton.setPreferredSize(new Dimension(50, 50));
        add(backButton, BorderLayout.SOUTH);
    }
}