import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UIBattlePanel extends JPanel {
    private ImageIcon humanPlayerPokemonImg;
    private ImageIcon computerPlayerPokemonImg;
    public JLabel humanPlayerPokemonLabel;
    public JLabel computerPlayerPokemonLabel;
    public static UIHP humanPlayerHP;
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

    
    /** 
     * Create panel for humanplayer
     * @param humanPlayer
     */
    public void createPlayerPanel(HumanPlayer humanPlayer) {
        Path imgPath = Paths.get("Assets/back/",
                String.valueOf(humanPlayer.getCurrentPokemon().getNumber()) + ".png");
        String stringimgPath = imgPath.toString();
        // Create a panel for the human player's pokemon and hp
        JPanel humanPlayerPanel = new JPanel();
        humanPlayerPanel.setLayout(new BorderLayout());
        humanPlayerPokemonImg = new ImageIcon(
                stringimgPath);
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

    
    /** 
     * Create panel for computer
     * @param computerPlayer
     */
    public void createComputerPanel(Computer computerPlayer) {
        JPanel computerPlayerPanel = new JPanel();
        computerPlayerPanel.setLayout(new BorderLayout());
        computerPlayerPokemonImg = new ImageIcon(
                "Assets/front/"
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

    
    /** 
     * Updates computer pokemon
     * @param computerPlayer
     */
    public void updateComputerPokemon(Computer computerPlayer) {
        Path imgPath = Paths.get("Assets/front/", 
                String.valueOf(computerPlayer.getCurrentPokemon().getNumber()) + ".png");
        String stringimgPath = imgPath.toString();
        computerPlayerPokemonImg = new ImageIcon(
                stringimgPath);
        Image computerPlayerImage = computerPlayerPokemonImg.getImage();
        Image computerPlayerNewimg = computerPlayerImage.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
        computerPlayerPokemonImg = new ImageIcon(computerPlayerNewimg);
        computerPlayerPokemonLabel.setIcon(computerPlayerPokemonImg);
        computerPlayerHP.updateHP(computerPlayer.getCurrentPokemon());
        computerPlayerPokemonStatus.setText(computerPlayer.getCurrentPokemon().getStatus().getCurrentStatus());
    }

    
    /** 
     * @return ImageIcon
     */
    public ImageIcon getHumanPlayerPokemonImg() {
        return humanPlayerPokemonImg;
    }

    
    /** 
     * @param humanPlayerPokemonImg
     */
    public void setHumanPlayerPokemonImg(ImageIcon humanPlayerPokemonImg) {
        this.humanPlayerPokemonImg = humanPlayerPokemonImg;
    }

    
    /** 
     * @return ImageIcon
     */
    public ImageIcon getComputerPlayerPokemonImg() {
        return computerPlayerPokemonImg;
    }

    
    /** 
     * @param computerPlayerPokemonImg
     */
    public void setComputerPlayerPokemonImg(ImageIcon computerPlayerPokemonImg) {
        this.computerPlayerPokemonImg = computerPlayerPokemonImg;
    }

    
    /** 
     * @return JLabel
     */
    public JLabel getHumanPlayerPokemonLabel() {
        return humanPlayerPokemonLabel;
    }

    
    /** 
     * @param humanPlayerPokemonLabel
     */
    public void setHumanPlayerPokemonLabel(JLabel humanPlayerPokemonLabel) {
        this.humanPlayerPokemonLabel = humanPlayerPokemonLabel;
    }

    
    /** 
     * @return JLabel
     */
    public JLabel getComputerPlayerPokemonLabel() {
        return computerPlayerPokemonLabel;
    }

    
    /** 
     * @param computerPlayerPokemonLabel
     */
    public void setComputerPlayerPokemonLabel(JLabel computerPlayerPokemonLabel) {
        this.computerPlayerPokemonLabel = computerPlayerPokemonLabel;
    }

    
    /** 
     * @return UIHP
     */
    public static UIHP getHumanPlayerHP() {
        return humanPlayerHP;
    }

    
    /** 
     * @param humanPlayerHP
     */
    public void setHumanPlayerHP(UIHP humanPlayerHP) {
        this.humanPlayerHP = humanPlayerHP;
    }

    
    /** 
     * @return UIHP
     */
    public static UIHP getComputerPlayerHP() {
        return computerPlayerHP;
    }

    
    /** 
     * @param computerPlayerHP
     */
    public void setComputerPlayerHP(UIHP computerPlayerHP) {
        this.computerPlayerHP = computerPlayerHP;
    }

    
    /** 
     * @return JLabel
     */
    public JLabel getHumanPlayerPokemonStatus() {
        return humanPlayerPokemonStatus;
    }

    
    /** 
     * @param humanPlayerPokemonStatus
     */
    public void setHumanPlayerPokemonStatus(JLabel humanPlayerPokemonStatus) {
        this.humanPlayerPokemonStatus = humanPlayerPokemonStatus;
    }

    
    /** 
     * @return JLabel
     */
    public JLabel getComputerPlayerPokemonStatus() {
        return computerPlayerPokemonStatus;
    }

    
    /** 
     * @param computerPlayerPokemonStatus
     */
    public void setComputerPlayerPokemonStatus(JLabel computerPlayerPokemonStatus) {
        this.computerPlayerPokemonStatus = computerPlayerPokemonStatus;
    }
}