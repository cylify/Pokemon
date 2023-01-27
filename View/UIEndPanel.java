import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;

public class UIEndPanel extends JPanel {
    private JLabel winnerLabel;
    private JLabel loserLabel;
    private JButton exit;

    public UIEndPanel() {
        setLayout(new BorderLayout());
        this.winnerLabel = new JLabel();
        this.loserLabel = new JLabel();
        this.winnerLabel.setPreferredSize(new Dimension(200, 50));
        this.loserLabel.setPreferredSize(new Dimension(200, 50));
        winnerLabel.setForeground(Color.black);
        loserLabel.setForeground(Color.black);
        winnerLabel.setHorizontalAlignment(JLabel.CENTER);
        loserLabel.setHorizontalAlignment(JLabel.CENTER);
        this.winnerLabel.setVisible(true);
        this.loserLabel.setVisible(true);
        this.exit = new JButton("EXIT");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exit, BorderLayout.SOUTH);
        add(winnerLabel, BorderLayout.NORTH);
        add(loserLabel, BorderLayout.CENTER);
        // setBackground(Color.WHITE);
    }

    public void setWinner(String message) {
        this.winnerLabel.setText(message);
        this.winnerLabel.repaint();
    }

    public void setLoser(String message) {
        this.loserLabel.setText(message);
        this.loserLabel.repaint();
    }
}
