import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import java.awt.Image;

public class UILoserPanel extends JPanel {
    private JLabel loserLabel;
    private JButton exit;

    public UILoserPanel() {
        createLoserPanel();
        setLayout(new BorderLayout());
        this.exit = new JButton("EXIT");
        exit.addActionListener(e -> System.exit(0));
        add(exit, BorderLayout.SOUTH);
        setPreferredSize(new Dimension(700, 600));
        setVisible(true);
        // setBackground(Color.WHITE);
    }

    public void createLoserPanel() {
        JPanel winnerPanel = new JPanel();
        winnerPanel.setLayout(new BorderLayout());
        Path imgPath = Paths.get("Assets/", "lost.png");
        String stringimgPath = imgPath.toString();
        ImageIcon wonImg = new ImageIcon(
                stringimgPath);
        Image image = wonImg.getImage();
        Image newimg = image.getScaledInstance(600, 550, java.awt.Image.SCALE_SMOOTH);
        wonImg = new ImageIcon(newimg);
        this.loserLabel = new JLabel(wonImg);
        winnerPanel.add(loserLabel, BorderLayout.CENTER);
        add(winnerPanel);
    }

}
