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
    private UILoserPanel loserPanel;
    private UIWinnerPanel winnerPanel;

    public UIMovePanel(HumanPlayer hplayer, Computer comp, UIBattlePanel battlePanel, UILoserPanel loserPanel, UIWinnerPanel winnerPanel) {
        this.hplayer = hplayer;
        this.comp = comp;
        this.battlePanel = battlePanel;
        this.loserPanel = new UILoserPanel();
        this.winnerPanel = new UIWinnerPanel();
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
            Main.c.show(Main.main, "lost");
        } else if(comp.allPokemonFeinted()) {
            Main.c.show(Main.main, "won");
        }
    }

    /**
     * Create label for move panel
     */
    public void createMoveLabel() {
        Path textPath = Paths.get("Assets/", "pokemon-stadium-2.ttf");
        String textPathAsString = textPath.toString();
        JLabel exclaim = new JLabel("THESE ARE YOUR MOVES!");
        try {
            InputStream inputStream = new BufferedInputStream(new FileInputStream(
                    textPathAsString));
            Font font = Font.createFont(Font.TRUETYPE_FONT, inputStream);
            font = font.deriveFont(26f);
            exclaim.setFont(font);
        } catch (IOException | FontFormatException e) {
            exclaim.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
        }
        add(exclaim, BorderLayout.NORTH);
    }

    
    /** 
     * Create move buttons
     * @param moveButtonsPanel
     */
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

    /**
     * Create back button to go back to previous screen
     */
    private void createBackButton() {
        Path backButtonPath = Paths.get("Assets/", "BackButton.jpg");
        String stringbackButtonPath = backButtonPath.toString();
        backButtonIcon = new ImageIcon(
                stringbackButtonPath);
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

    /**
     * Update buttons for moves for current pokemon
     */
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

    
    /** 
     * @return HumanPlayer
     */
    public HumanPlayer gethplayer() {
        return hplayer;
    }

    
    /** 
     * @param hplayer
     */
    public void sethplayer(HumanPlayer hplayer) {
        this.hplayer = hplayer;
    }

    
    /** 
     * @return ArrayList<JButton>
     */
    public ArrayList<JButton> getMoveButtons() {
        return moveButtons;
    }

    
    /** 
     * @param moveButtons
     */
    public void setMoveButtons(ArrayList<JButton> moveButtons) {
        this.moveButtons = moveButtons;
    }

    
    /** 
     * @return JButton
     */
    public JButton getBackButton() {
        return backButton;
    }

    
    /** 
     * @param backButton
     */
    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    
    /** 
     * @return ImageIcon
     */
    public ImageIcon getBackButtonIcon() {
        return backButtonIcon;
    }

    
    /** 
     * @param backButtonIcon
     */
    public void setBackButtonIcon(ImageIcon backButtonIcon) {
        this.backButtonIcon = backButtonIcon;
    }

    
    /** 
     * @return HumanPlayer
     */
    public HumanPlayer getHplayer() {
        return hplayer;
    }

    
    /** 
     * @param hplayer
     */
    public void setHplayer(HumanPlayer hplayer) {
        this.hplayer = hplayer;
    }

    
    /** 
     * @return Computer
     */
    public Computer getComp() {
        return comp;
    }

    
    /** 
     * @param comp
     */
    public void setComp(Computer comp) {
        this.comp = comp;
    }

    
    /** 
     * @return UIBattlePanel
     */
    public UIBattlePanel getBattlePanel() {
        return battlePanel;
    }

    
    /** 
     * @param battlePanel
     */
    public void setBattlePanel(UIBattlePanel battlePanel) {
        this.battlePanel = battlePanel;
    }

    
    /** 
     * @return UILoserPanel
     */
    public UILoserPanel getLoserPanel() {
        return loserPanel;
    }

    
    /** 
     * @param loserPanel
     */
    public void setLoserPanel(UILoserPanel loserPanel) {
        this.loserPanel = loserPanel;
    }

    
    /** 
     * @return UIWinnerPanel
     */
    public UIWinnerPanel getWinnerPanel() {
        return winnerPanel;
    }

    
    /** 
     * @param winnerPanel
     */
    public void setWinnerPanel(UIWinnerPanel winnerPanel) {
        this.winnerPanel = winnerPanel;
    }
}