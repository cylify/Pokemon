import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Image;
import java.awt.GridLayout;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Font;
import java.awt.FontFormatException;
import javax.swing.JLabel;


public class UIPokemonPanel extends JPanel {
    private JButton[] pokemons;
    private HumanPlayer p;
    private UIBattlePanel battlePanel;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private ActionListener[] actionListeners;
    private UIMovePanel movePanel;

    public UIPokemonPanel(HumanPlayer p, UIBattlePanel battlePanel, CardLayout cardLayout, JPanel mainPanel, UIMovePanel movePanel) {
        this.p = p;
        this.battlePanel = battlePanel;
        this.movePanel = movePanel;
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        setLayout(new BorderLayout());
        JPanel pokePanel = new JPanel(new GridLayout(2,2));
        createPokemonLabel();
        createPokemonButtons(pokePanel);
        createBackButton();
    }

    public void createPokemonLabel() {
        JLabel potionExclaim = new JLabel("THESE ARE YOUR POK\u00C9MONS!");
        try {
            InputStream inputStream = new BufferedInputStream(new FileInputStream(
                    "C:/Users/mradi/Dropbox/Programming/Java/Grade 12 Computer Science/Unit 4/Pokemon/Assets/pokemon-stadium-2.ttf"));
            Font font = Font.createFont(Font.TRUETYPE_FONT, inputStream);
            font = font.deriveFont(26f);
            potionExclaim.setFont(font);
        } catch (IOException | FontFormatException e) {
            potionExclaim.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
        }
        add(potionExclaim, BorderLayout.NORTH);
    }

    public void createPokemonButtons(JPanel pokePanel) {
        pokemons = new JButton[p.getPokemonBag().size()];
        actionListeners = new ActionListener[pokemons.length];
        for (int i = 0; i < pokemons.length; ++i) {
            pokemons[i] = new JButton(p.getPokemonBag().get(i).getName());
            final int index = i;
            actionListeners[i] = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    changePokemon(index);
                    movePanel.updateMoveButtons();
                    UIHP.updateHP(p.getCurrentPokemon());
                }
            };
            pokemons[i].addActionListener(actionListeners[i]);
            if (p.getCurrentPokemon().getName().equals(pokemons[i].getText())) {
                pokemons[i].setEnabled(false);
            } else {
                pokemons[i].setEnabled(true);
            }
            pokePanel.add(pokemons[i]);
        }
        add(pokePanel, BorderLayout.CENTER);
    }

    public void changePokemon(int index) {
        int prevIndex = -1;
        for (int j = 0; j < pokemons.length; j++) {
            if (pokemons[j].getText().equals(p.getCurrentPokemon().getName())) {
                prevIndex = j;
                break;
            }
        }
        Pokemon temp = p.getPokemonBag().get(index);
        p.setCurrentPokemon(temp);
        ImageIcon icon = new ImageIcon(temp.getImg());
        Image image = icon.getImage();
        Image newimg = image.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        battlePanel.humanPlayerPokemonLabel.setIcon(icon);
        battlePanel.repaint();
        cardLayout.show(mainPanel, "battle");
        pokemons[index].setEnabled(false);
        if(prevIndex != -1 && prevIndex != index) {
            pokemons[prevIndex].setEnabled(true);
        }
    }

    public void createBackButton() {
        ImageIcon backImg = new ImageIcon(
                "C:/Users/mradi/Dropbox/Programming/Java/Grade 12 Computer Science/Unit 4/Pokemon/Assets/BackButton.jpg");
        Image image = backImg.getImage();
        Image newimg = image.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH);
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
       

// public class UIPokemonPanel extends JPanel {
//     protected JButton[] pokemons;

//     public UIPokemonPanel(Player p, UIBattlePanel battlePanel) {
//         pokemons = new JButton[p.pokemonBag.size()];
//         JLabel imgLabel = new JLabel();
//         for(int i = 0; i < pokemons.length; ++i) {
//             pokemons[i] = new JButton(p.pokemonBag.get(i).getName());
//             if(pokemons[i].getText().equals(p.currentPokemon.getName())) {
//                 continue;
//             } else {
//                 final Integer innerI = i;
//                 pokemons[i].addActionListener(new ActionListener() {
//                     @Override
//                     public void actionPerformed(ActionEvent e) {
//                         Pokemon temp = p.pokemonBag.get(innerI);
//                         pokemons[innerI].setText(p.currentPokemon.getName());
//                         p.currentPokemon = temp;
//                         ImageIcon icon = new ImageIcon(temp.getImg());
//                         imgLabel.setIcon(icon);
//                         battlePanel.pokemonImg = new ImageIcon(
//                             "C:/Users/mradi/Dropbox/Programming/Java/Grade 12 Computer Science/Unit 4/Pokemon/Assets/back/"
//                             + String.valueOf(p.currentPokemon.getNumber()) + ".png");
//                         Image image = battlePanel.pokemonImg.getImage();
//                         Image newimg = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
//                         battlePanel.pokemonImg = new ImageIcon(newimg);
//                         battlePanel.label.setIcon(battlePanel.pokemonImg);
//                         battlePanel.repaint();
//                         Main.c.show(Main.main, "battle");
//                     }
//                 });
//                 add(pokemons[i]);
//             }
//         }

        
//     }

// }
