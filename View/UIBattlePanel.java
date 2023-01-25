import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Image;


public class UIBattlePanel extends JPanel {
    ImageIcon pokemonImg;
    JLabel label;

    public UIBattlePanel(Player p, UIHP hp) {
        pokemonImg = new ImageIcon(
                "C:/Users/mradi/Dropbox/Programming/Java/Grade 12 Computer Science/Unit 4/Pokemon/Assets/back/"
                        + String.valueOf(p.getCurrentPokemon().getNumber()) + ".png");
        Image image = pokemonImg.getImage();
        Image newimg = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        pokemonImg = new ImageIcon(newimg);
        label = new JLabel(pokemonImg);
        add(label);
        add(new UIOptionPanel(), "option");
        add(hp, "hp");
        setVisible(true);
        setBackground(Color.WHITE);
    }
}