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

public class UIWinnerPanel extends JPanel {
    private JLabel winnerLabel;
    private JButton exit;

    public UIWinnerPanel() {
        Path imgPath = Paths.get("Assets/", "won.jpg");
        String stringimgPath = imgPath.toString();
        ImageIcon wonImg = new ImageIcon(
                stringimgPath);
        Image image = wonImg.getImage();
        Image newimg = image.getScaledInstance(400, 350, java.awt.Image.SCALE_SMOOTH);
        wonImg = new ImageIcon(newimg);
        this.winnerLabel = new JLabel(wonImg);
        add(winnerLabel);
        // setLayout(new BorderLayout());
        this.exit = new JButton("EXIT");
        exit.addActionListener(e -> System.exit(0));
        add(exit);
        setPreferredSize(new Dimension(700, 600));
        setVisible(true);
        setBackground(Color.WHITE);
    }

}
