import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CoffeeShop extends JFrame {
    private static String[] items = { "Americano ", "Latte     ", "Cappuccino", "Espresso  ", "Arabica   ",
            "Mochaccino", "Tiramisu  ", "Robusta   ", "Liberica  ", "Excelso   ", "Affogato  " };
    private static int[] prices = { 21, 24, 29, 19, 23, 33, 33, 30, 66, 95, 34 };
    private static int[] orders = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    final private Font mainFont = new Font("Monospace", Font.PLAIN, 12);
    JTextField tfCount1;
    JButton bAdd1, bRM1, bPurchase, bReset;

    CoffeeShop() {
        // North Panel
        JLabel lInfo = new JLabel("(If your total purchase reach Rp. 100K, you will get a 15% discount!)");
        lInfo.setFont(mainFont);

        JPanel pNorth = new JPanel();
        pNorth.setLayout(new GridLayout(1, 1, 5, 5));
        pNorth.add(lInfo);

        // Center Panel
        tfCount1 = new JTextField();
        tfCount1.setFont(mainFont);

        JPanel pCenter = new JPanel();
        pCenter.setLayout(new GridLayout(1, 1, 5, 5));
        pCenter.add(tfCount1);

        // East Panel
        bAdd1 = new JButton("+");
        bRM1 = new JButton("-");

        // South Panel
        bPurchase = new JButton("Purchase");
        bPurchase.setFont(mainFont);
        bPurchase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO: Add Action Listener on Purchase Button
            }
        });
        bReset = new JButton("Reset");
        bReset.setFont(mainFont);

        JPanel pSouth = new JPanel();
        pSouth.setLayout(new GridLayout(1, 2, 5, 5));
        pSouth.add(bPurchase);
        pSouth.add(bReset);

        JPanel pEast = new JPanel();
        pEast.setLayout(new GridLayout(1, 2, 5, 5));
        pEast.add(bAdd1);
        pEast.add(bRM1);

        // Main Panel

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(26, 118, 168));
        mainPanel.add(pEast, BorderLayout.EAST);
        mainPanel.add(pCenter, BorderLayout.CENTER);
        mainPanel.add(pNorth, BorderLayout.NORTH);
        mainPanel.add(pSouth, BorderLayout.SOUTH);

        setTitle("Welcome to Volgion Coffee Shop!");
        setSize(500, 800);
        setMinimumSize(new Dimension(250, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CoffeeShop();
    }
}
