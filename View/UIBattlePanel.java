import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

public class UIBattlePanel extends JPanel {
    private ImageIcon humanPlayerPokemonImg;
    private ImageIcon computerPlayerPokemonImg;
    public JLabel humanPlayerPokemonLabel;
    private JLabel computerPlayerPokemonLabel;
    public UIHP humanPlayerHP;
    public static UIHP computerPlayerHP;
    private JLabel humanPlayerPokemonStatus;
    private JLabel computerPlayerPokemonStatus;

    public UIBattlePanel(HumanPlayer humanPlayer, Computer computerPlayer) {
        createPlayerPanel(humanPlayer);
        createComputerPanel(computerPlayer);

        add(new UIOptionPanel(), BorderLayout.CENTER);
        setPreferredSize(new Dimension(700, 500));
        setVisible(true);
        setBackground(Color.WHITE);
    }   

    public void createPlayerPanel(HumanPlayer humanPlayer) {
        // Create a panel for the human player's pokemon and hp
        JPanel humanPlayerPanel = new JPanel();
        humanPlayerPanel.setLayout(new BorderLayout());
        humanPlayerPokemonImg = new ImageIcon(
                "C:/Users/mradi/Dropbox/Programming/Java/Grade 12 Computer Science/Unit 4/Pokemon/Assets/back/"
                        + String.valueOf(humanPlayer.getCurrentPokemon().getNumber()) + ".png");
        Image humanPlayerImage = humanPlayerPokemonImg.getImage();
        Image humanPlayerNewimg = humanPlayerImage.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
        humanPlayerPokemonImg = new ImageIcon(humanPlayerNewimg);
        humanPlayerPokemonLabel = new JLabel(humanPlayerPokemonImg);
        humanPlayerPanel.add(humanPlayerPokemonLabel, BorderLayout.NORTH);
        humanPlayerHP = new UIHP(humanPlayer.currentPokemon);
        humanPlayerPanel.add(humanPlayerHP, BorderLayout.WEST);
        humanPlayerPokemonStatus = new JLabel(humanPlayer.getCurrentPokemon().getStatus().getCurrentStatus());
        humanPlayerPokemonStatus.setBackground(Color.WHITE);
        humanPlayerPanel.add(humanPlayerPokemonStatus, BorderLayout.SOUTH);
        add(humanPlayerPanel, BorderLayout.WEST);
    }

    public void createComputerPanel(Computer computerPlayer) {
        JPanel computerPlayerPanel = new JPanel();
        computerPlayerPanel.setLayout(new BorderLayout());
        computerPlayerPokemonImg = new ImageIcon(
                "C:/Users/mradi/Dropbox/Programming/Java/Grade 12 Computer Science/Unit 4/Pokemon/Assets/front/"
                        + String.valueOf(computerPlayer.getCurrentPokemon().getNumber()) + ".png");
        Image computerPlayerImage = computerPlayerPokemonImg.getImage();
        Image computerPlayerNewimg = computerPlayerImage.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
        computerPlayerPokemonImg = new ImageIcon(computerPlayerNewimg);
        computerPlayerPokemonLabel = new JLabel(computerPlayerPokemonImg);
        computerPlayerPanel.add(computerPlayerPokemonLabel, BorderLayout.NORTH);
        computerPlayerHP = new UIHP(computerPlayer.getCurrentPokemon());
        computerPlayerPanel.add(computerPlayerHP, BorderLayout.CENTER);
        computerPlayerPokemonStatus = new JLabel(computerPlayer.getCurrentPokemon().getStatus().getCurrentStatus());
        computerPlayerPokemonStatus.setBackground(Color.WHITE);
        computerPlayerPanel.add(computerPlayerPokemonStatus, BorderLayout.SOUTH);
        add(computerPlayerPanel, BorderLayout.EAST);

    }

    public ImageIcon getHumanPlayerPokemonImg() {
        return humanPlayerPokemonImg;
    }

    public void setHumanPlayerPokemonImg(ImageIcon humanPlayerPokemonImg) {
        this.humanPlayerPokemonImg = humanPlayerPokemonImg;
    }

    public ImageIcon getComputerPlayerPokemonImg() {
        return computerPlayerPokemonImg;
    }

    public void setComputerPlayerPokemonImg(ImageIcon computerPlayerPokemonImg) {
        this.computerPlayerPokemonImg = computerPlayerPokemonImg;
    }

    public JLabel getHumanPlayerPokemonLabel() {
        return humanPlayerPokemonLabel;
    }

    public void setHumanPlayerPokemonLabel(JLabel humanPlayerPokemonLabel) {
        this.humanPlayerPokemonLabel = humanPlayerPokemonLabel;
    }

    public JLabel getComputerPlayerPokemonLabel() {
        return computerPlayerPokemonLabel;
    }

    public void setComputerPlayerPokemonLabel(JLabel computerPlayerPokemonLabel) {
        this.computerPlayerPokemonLabel = computerPlayerPokemonLabel;
    }

    public UIHP getHumanPlayerHP() {
        return humanPlayerHP;
    }

    public void setHumanPlayerHP(UIHP humanPlayerHP) {
        this.humanPlayerHP = humanPlayerHP;
    }

    public static UIHP getComputerPlayerHP() {
        return computerPlayerHP;
    }

    public void setComputerPlayerHP(UIHP computerPlayerHP) {
        this.computerPlayerHP = computerPlayerHP;
    }

    public JLabel getHumanPlayerPokemonStatus() {
        return humanPlayerPokemonStatus;
    }

    public void setHumanPlayerPokemonStatus(JLabel humanPlayerPokemonStatus) {
        this.humanPlayerPokemonStatus = humanPlayerPokemonStatus;
    }

    public JLabel getComputerPlayerPokemonStatus() {
        return computerPlayerPokemonStatus;
    }

    public void setComputerPlayerPokemonStatus(JLabel computerPlayerPokemonStatus) {
        this.computerPlayerPokemonStatus = computerPlayerPokemonStatus;
    }
}