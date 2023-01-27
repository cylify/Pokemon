import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
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
import javax.swing.JOptionPane;
import java.nio.file.Path;
import java.nio.file.Paths;


public class UIPokemonPanel extends JPanel {
    private JButton[] pokemons;
    private HumanPlayer p;
    private UIBattlePanel battlePanel;
    private ActionListener[] actionListeners;
    private UIMovePanel movePanel;
    private Computer comp;
    private UILoserPanel loserPanel;
    private UIWinnerPanel winnerPanel;

    public UIPokemonPanel(HumanPlayer p, UIBattlePanel battlePanel, UIMovePanel movePanel, Computer comp, 
            UILoserPanel loserPanel, UIWinnerPanel winnerPanel) {
        this.p = p;
        this.battlePanel = battlePanel;
        this.movePanel = movePanel;
        this.comp = comp;
        this.loserPanel = new UILoserPanel();
        this.winnerPanel = new UIWinnerPanel();
        setLayout(new BorderLayout());
        JPanel pokePanel = new JPanel(new GridLayout(2,2));
        createPokemonLabel();
        createPokemonButtons(pokePanel);
        createBackButton();
    }

    public void checkWin() {
        if(p.allPokemonFeinted()) {
            Main.c.show(Main.main, "lost");
        } else if(comp.allPokemonFeinted()) {
            Main.c.show(Main.main, "won");
        }
    }

    public void createPokemonLabel() {
        Path textPath = Paths.get("Assets/", "pokemon-stadium-2.ttf");
        String textPathAsString = textPath.toString();
        JLabel potionExclaim = new JLabel("THESE ARE YOUR POK\u00C9MONS!");
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

    
    /** 
     * @param pokePanel
     */
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
                    p.getCurrentPokemon().checkCurrenthp();
                    if(p.getCurrentPokemon().isFeinted()) {
                        JOptionPane.showMessageDialog(null,
                        "Your current Pokemon is fainted. You must switch Pokemon.");
                        checkWin();
                    }
                    Main.c.show(Main.main, "battle");
                    movePanel.updateMoveButtons();
                    UIBattlePanel.getHumanPlayerHP().updateHP(p.getCurrentPokemon());
                    comp.getCurrentPokemon().checkCurrenthp();
                    comp.playComp(p.getCurrentPokemon());
                    battlePanel.updateComputerPokemon(comp);
                    Main.c.show(Main.main, "battle");
                    checkWin();
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

    
    /** 
     * @param index
     */
        public void changePokemon(int index) {
        int prevIndex = -1;
        for (int j = 0; j < pokemons.length; j++) {
            if (pokemons[j].getText().equals(p.getCurrentPokemon().getName())) {
                prevIndex = j;
                break;
            }
        }
        Pokemon temp = p.getPokemonBag().get(index);
        if (temp.getHealth() <= 0) {
            JOptionPane.showMessageDialog(this, "This Pokemon is feinted and cannot be chosen");
            return;
        }
        p.setCurrentPokemon(temp);
        ImageIcon icon = new ImageIcon(temp.getBackimg());
        Image image = icon.getImage();
        Image newimg = image.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        battlePanel.humanPlayerPokemonLabel.setIcon(icon);
        battlePanel.humanPlayerHP.updateHP(p.getCurrentPokemon());
        battlePanel.repaint();
        Main.c.show(Main.main, "battle");
        pokemons[index].setEnabled(false);
        if(prevIndex != -1 && prevIndex != index) {
            pokemons[prevIndex].setEnabled(true);
        }
    }

    public void createBackButton() {
        Path backButtonPath = Paths.get("Assets/", "BackButton.jpg");
        String stringbackButtonPath = backButtonPath.toString();
        ImageIcon backImg = new ImageIcon(
                stringbackButtonPath);
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

    
    /** 
     * @return JButton[]
     */
    public JButton[] getPokemons() {
        return pokemons;
    }

    
    /** 
     * @param pokemons
     */
    public void setPokemons(JButton[] pokemons) {
        this.pokemons = pokemons;
    }

    
    /** 
     * @return HumanPlayer
     */
    public HumanPlayer getP() {
        return p;
    }

    
    /** 
     * @param p
     */
    public void setP(HumanPlayer p) {
        this.p = p;
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
     * @return ActionListener[]
     */
    public ActionListener[] getActionListeners() {
        return actionListeners;
    }

    
    /** 
     * @param actionListeners
     */
    public void setActionListeners(ActionListener[] actionListeners) {
        this.actionListeners = actionListeners;
    }

    
    /** 
     * @return UIMovePanel
     */
    public UIMovePanel getMovePanel() {
        return movePanel;
    }

    
    /** 
     * @param movePanel
     */
    public void setMovePanel(UIMovePanel movePanel) {
        this.movePanel = movePanel;
    }

    public Computer getComp() {
        return comp;
    }

    public void setComp(Computer comp) {
        this.comp = comp;
    }

    public UILoserPanel getLoserPanel() {
        return loserPanel;
    }

    public void setLoserPanel(UILoserPanel loserPanel) {
        this.loserPanel = loserPanel;
    }

    public UIWinnerPanel getWinnerPanel() {
        return winnerPanel;
    }

    public void setWinnerPanel(UIWinnerPanel winnerPanel) {
        this.winnerPanel = winnerPanel;
    }
}