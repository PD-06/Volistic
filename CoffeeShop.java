import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CoffeeShop extends JFrame {
    private static String[] items = { "Americano ", "Latte     ", "Cappuccino", "Espresso  ", "Arabica   ",
            "Mochaccino", "Tiramisu  ", "Robusta   ", "Liberica  ", "Excelso   ", "Affogato  " };
    /*
     * private static int[] prices = { 21, 24, 29, 19, 23, 33, 33, 30, 66, 95, 34 };
     * private static int[] orders = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
     */
    final private Font mainFont = new Font("Monospace", Font.PLAIN, 12);

    CoffeeShop() {
        JPanel pCF = new JPanel();
        pCF.setLayout(new BorderLayout());

        // North
        JLabel lWelcome = new JLabel("*If your purchase reach Rp.100K, you will get a 15% discount!");
        lWelcome.setFont(mainFont);
        JPanel pNorth = new JPanel();
        pNorth.add(lWelcome);
        pCF.add(pNorth, BorderLayout.NORTH);

        // West
        JButton bPurchase = new JButton("Purchase");
        bPurchase.setFont(mainFont);
        JButton bReset = new JButton("Reset");
        bReset.setFont(mainFont);
        JPanel pWest = new JPanel();
        pWest.add(bPurchase);
        pWest.add(bReset);
        pWest.setLayout(new GridLayout(2, 1));
        pCF.add(pWest, BorderLayout.WEST);

        // Center
        JLabel lItem;
        JLabel lMenu = new JLabel("Available Menu:");
        JPanel pCenter = new JPanel();
        pCenter.add(lMenu);
        for (int i = 0; i < items.length; i++) {
            lItem = new JLabel(items[i]);
            pCenter.add(lItem);
        }
        pCenter.setLayout(new GridLayout((items.length + 1), 1));
        pCF.add(pCenter, BorderLayout.CENTER);

        // East
        JTextField tfCount1 = new JTextField("0");
        tfCount1.setSize(50, 50);
        JButton min1 = new JButton("-");
        min1.setSize(50, 50);
        min1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tfCount1.setText(Integer.toString(Integer.parseInt(tfCount1.getText()) - 1));
                if (Integer.parseInt(tfCount1.getText()) < 0) {
                    tfCount1.setText("0");
                }
            }
        });
        JButton plus1 = new JButton("+");
        plus1.setSize(50, 50);
        plus1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tfCount1.setText(Integer.toString(Integer.parseInt(tfCount1.getText()) + 1));
            }
        });
        JPanel pPlusOrMinus1 = new JPanel();
        pPlusOrMinus1.add(min1);
        pPlusOrMinus1.add(plus1);
        pPlusOrMinus1.setLayout(new GridLayout());
        JPanel pButtons1 = new JPanel();
        pButtons1.add(tfCount1);
        pButtons1.add(pPlusOrMinus1);
        pButtons1.setLayout(new GridLayout(1, 2, 5, 0));
        pCF.add(pButtons1, BorderLayout.EAST);

        // South
        double cost = 0;
        JPanel pSouth = new JPanel();
        JLabel lPrice = new JLabel("Price: Rp." + cost + "K");
        pSouth.add(lPrice);
        pCF.add(pSouth, BorderLayout.SOUTH);

        add(pCF);
        setSize(500, 800);
        setTitle("Welcome to Volgion Coffee Shop!");
        setMinimumSize(new Dimension(500, 800));
        setMaximumSize(new Dimension(500, 800));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CoffeeShop();
    }
}
