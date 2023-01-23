import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class UIMain extends JFrame {
	static JPanel main;
    static CardLayout c;

    public UIMain() {
        super("Pok\u00E9mon");

        c = new CardLayout();
        main = new JPanel(c);

        UIStart start = new UIStart(c, main);
        main.add(start, "one");
        c.show(main, "one");

        add(main);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

	public static void main(String[] args) {
        new UIMain();
	}

}
