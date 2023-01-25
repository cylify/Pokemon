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

public class UIMovePanel extends JPanel {
    private Player player;
    private ArrayList<JButton> moveButtons;
    private JButton backButton;
    private ImageIcon backButtonIcon;

    public UIMovePanel(Player player) {
        this.player = player;
        moveButtons = new ArrayList<>();
        JPanel moveButtonsPanel = new JPanel(new GridLayout(2, 2));
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(300, 400));
        createMoveButtons(moveButtonsPanel);
        createBackButton();
        setBackground(Color.WHITE);
    }

    private void createMoveButtons(JPanel moveButtonsPanel) {
        for (Move move : player.getCurrentPokemon().getMoves()) {
            JButton moveButton = new JButton(move.getName());
            moveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    player.getCurrentPokemon().attack(move, player.getCurrentPokemon(), player.getDefendingPokemon());
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
        for (Move move : player.getCurrentPokemon().getMoves()) {
            JButton moveButton = new JButton(move.getName());
            moveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    player.getCurrentPokemon().attack(move, player.getCurrentPokemon(), player.getDefendingPokemon());
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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
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