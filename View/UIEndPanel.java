import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.BorderLayout;

public class UIEndPanel extends JPanel {
    private JLabel winnerLabel;
    private JButton exit;
    public UIEndPanel() {
        setLayout(new BorderLayout());
        this.winnerLabel = new JLabel();

        this.exit = new JButton();
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            } 
        });
        setPreferredSize(new Dimension(700, 500));
        add(exit, BorderLayout.SOUTH);
        add(winnerLabel, BorderLayout.CENTER);
    }

    public void setWinner(String message) {
        this.winnerLabel.setText(message);
    }
}
