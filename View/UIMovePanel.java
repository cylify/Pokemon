import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Font;
import java.awt.FontFormatException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UIMovePanel extends JPanel {
    private HumanPlayer hplayer;
    private Computer comp;
    private ArrayList<JButton> moveButtons;
    private UIBattlePanel battlePanel;
    private JButton backButton;
    private ImageIcon backButtonIcon;
    private UIEndPanel endPanel;

    public UIMovePanel(HumanPlayer hplayer, Computer comp, UIBattlePanel battlePanel, UIEndPanel endPanel) {
        this.hplayer = hplayer;
        this.comp = comp;
        this.battlePanel = battlePanel;
        this.endPanel = new UIEndPanel();
        moveButtons = new ArrayList<>();
        JPanel moveButtonsPanel = new JPanel(new GridLayout(2, 2));
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(300, 400));
        createMoveLabel();
        createMoveButtons(moveButtonsPanel);
        createBackButton();
        setBackground(Color.WHITE);
    }

    public void checkWin() {
        if(hplayer.allPokemonFeinted()) {
            endPanel.setWinner("The computer has won!");
            endPanel.setLoser("You have lost.");
            endPanel.repaint();
            endPanel.revalidate();
            Main.c.show(Main.main, "end");
        } else if(comp.allPokemonFeinted()) {
            endPanel.setWinner("You have won!");
            endPanel.setLoser("The computer has lost.");
            endPanel.repaint();
            endPanel.revalidate();
            Main.c.show(Main.main, "end");
        }
    }

    public void createMoveLabel() {
        Path textPath = Paths.get("Assets/", "pokemon-stadium-2.ttf");
        String textPathAsString = textPath.toString();
        JLabel potionExclaim = new JLabel("THESE ARE YOUR MOVES!");
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
    }

    private void createMoveButtons(JPanel moveButtonsPanel) {
        for (Move move : hplayer.getCurrentPokemon().getMoves()) {
            JButton moveButton = new JButton(move.getName());
            moveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Main.c.show(Main.main, "battle");
                    if(hplayer.getCurrentPokemon().isFeinted()) {
                        moveButton.setEnabled(false);
                        JOptionPane.showMessageDialog(null, "Switch pokemons, your current Pok\u00E9mon has fainted");
                        checkWin();
                    } else {
                        hplayer.attack(comp, move);
                        checkWin();
                    }
                    comp.getCurrentPokemon().checkCurrenthp();
                    comp.playComp(hplayer.getCurrentPokemon());
                    battlePanel.updateComputerPokemon(comp);
                    UIBattlePanel.getHumanPlayerHP().updateHP(hplayer.getCurrentPokemon());
                    hplayer.getCurrentPokemon().checkCurrenthp();
                    Main.c.show(Main.main, "battle");
                    checkWin();
                }
            });
            moveButtonsPanel.add(moveButton);
        }
        add(moveButtonsPanel, BorderLayout.CENTER);
    }

    private void createBackButton() {
        backButtonIcon = new ImageIcon(
                "C:/Users/mradi/Dropbox/Programming/Java/Grade 12 Computer Science/Unit 4/Pokemon/Assets/BackButton.jpg");
        Image image = backButtonIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(55, 55, java.awt.Image.SCALE_SMOOTH);
        // scale it the smooth way
        backButtonIcon = new ImageIcon(newimg);
        backButton = new JButton(backButtonIcon);
        backButton.setPreferredSize(new Dimension(50, 50));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.c.show(Main.main, "battle");
            }
        });
        add(backButton, BorderLayout.SOUTH);
    }

    public void updateMoveButtons() {
        moveButtons.clear();
        JPanel moveButtonsPanel = new JPanel(new GridLayout(2, 2));
        for (Move move : hplayer.getCurrentPokemon().getMoves()) {
            JButton moveButton = new JButton(move.getName());
            moveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Main.c.show(Main.main, "battle");
                    if(hplayer.getCurrentPokemon().isFeinted()) {
                        moveButton.setEnabled(false);
                        JOptionPane.showMessageDialog(null, "Switch pokemons, your current Pok\u00E9mon has fainted");
                        checkWin();
                    } else {
                        hplayer.attack(comp, move);
                        checkWin();
                    }
                    UIBattlePanel.getComputerPlayerHP().updateHP(comp.getCurrentPokemon());
                    comp.getCurrentPokemon().checkCurrenthp();
                    comp.playComp(hplayer.getCurrentPokemon());
                    battlePanel.updateComputerPokemon(comp);
                    UIBattlePanel.getHumanPlayerHP().updateHP(hplayer.getCurrentPokemon());
                    hplayer.getCurrentPokemon().checkCurrenthp();
                    Main.c.show(Main.main, "battle");
                    checkWin();
                }
            });
            moveButtonsPanel.add(moveButton);
        }
        removeAll();
        add(moveButtonsPanel, BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);
        revalidate();
        repaint();
    }

    public HumanPlayer gethplayer() {
        return hplayer;
    }

    public void sethplayer(HumanPlayer hplayer) {
        this.hplayer = hplayer;
    }

    public ArrayList<JButton> getMoveButtons() {
        return moveButtons;
    }

    public void setMoveButtons(ArrayList<JButton> moveButtons) {
        this.moveButtons = moveButtons;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    public ImageIcon getBackButtonIcon() {
        return backButtonIcon;
    }

    public void setBackButtonIcon(ImageIcon backButtonIcon) {
        this.backButtonIcon = backButtonIcon;
    }
}