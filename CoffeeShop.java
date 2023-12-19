import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CoffeeShop extends JFrame {
    private static String[] items = { "Americano ", "Latte     ", "Cappuccino", "Espresso  ", "Arabica   ",
            "Mochaccino", "Tiramisu  ", "Robusta   ", "Liberica  ", "Excelso   ", "Affogato  " };
    private static int[] prices = { 21, 24, 29, 19, 23, 33, 33, 30, 66, 95, 34 };
    private static int[] orders = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    final private Font westButtonFont = new Font("Georgia", Font.PLAIN, 20);
    double cost;
    boolean isDiscount;
    JLabel lRawCost, lIsDiscount, lFinalCost;
    JLabel[] tfCount;

    CoffeeShop() {
        JPanel pCF = new JPanel();
        cost = 0;
        isDiscount = false;
        pCF.setLayout(new BorderLayout(20, 15));

        /******************************** NORTH *********************************/
        JLabel lWelcome = new JLabel("*If your purchase reach Rp.100K, you will get a 15% discount!");
        lWelcome.setFont(new Font("MS Serif", Font.BOLD, 14));
        JPanel pNorth = new JPanel();
        pNorth.add(lWelcome);
        pCF.add(pNorth, BorderLayout.NORTH);

        /********************************* WEST *********************************/
        JButton bPurchase = new JButton("Purchase");
        bPurchase.setFont(westButtonFont);
        bPurchase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                update();
                boolean orderListIsEmpty = true;
                for (int i = 0; i < items.length; i++) {
                    if (orders[i] != 0) {
                        orderListIsEmpty = false;
                        break;
                    }
                }
                if (!orderListIsEmpty) {
                    // TODO: new Transaction();
                }
            }
        });
        JButton bReset = new JButton("Reset");
        bReset.setFont(westButtonFont);
        bReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cost = 0;
                for (int i = 0; i < items.length; i++) {
                    orders[i] = 0;
                    tfCount[i].setText("0");
                }
                update();
            }
        });
        JPanel pWest = new JPanel();
        pWest.add(bPurchase);
        pWest.add(bReset);
        pWest.setLayout(new GridLayout(2, 1));
        pCF.add(pWest, BorderLayout.WEST);

        /******************************** CENTER ********************************/
        JLabel lItem;
        JLabel lPrice;
        JLabel lItemList = new JLabel("Menu:");
        JLabel lPriceList = new JLabel("Price:");
        JPanel pCenter = new JPanel();
        pCenter.add(lItemList);
        pCenter.add(lPriceList);
        for (int i = 0; i < items.length; i++) {
            lItem = new JLabel(items[i]);
            pCenter.add(lItem);
            lPrice = new JLabel("(" + prices[i] + "K)");
            pCenter.add(lPrice);
        }
        pCenter.setLayout(new GridLayout((items.length + 1), 2, 30, 0));
        pCF.add(pCenter, BorderLayout.CENTER);

        /********************************* EAST *********************************/
        JPanel pEast = new JPanel();
        JLabel lOrder = new JLabel("Orders:");
        pEast.add(lOrder);
        JLabel lReduceButtons = new JLabel("");
        pEast.add(lReduceButtons);
        JLabel lIncreaseButtons = new JLabel("");
        pEast.add(lIncreaseButtons);
        tfCount = new JLabel[items.length];
        JButton[] bReduce = new JButton[items.length];
        JButton[] bIncrease = new JButton[items.length];
        for (int i = 0; i < tfCount.length; i++) {
            final int id = i;
            tfCount[i] = new JLabel("0");
            pEast.add(tfCount[i]);
            bReduce[i] = new JButton("-");
            bReduce[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent k) {
                    tfCount[id].setText(Integer.toString(Integer.parseInt(tfCount[id].getText()) - 1));
                    orders[id]--;
                    if (Integer.parseInt(tfCount[id].getText()) < 0) {
                        tfCount[id].setText("0");
                        orders[id] = 0;
                    }
                    update();
                }
            });
            pEast.add(bReduce[i]);
            bIncrease[i] = new JButton("+");
            bIncrease[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    tfCount[id].setText(Integer.toString(Integer.parseInt(tfCount[id].getText()) + 1));
                    orders[id]++;
                    update();
                }
            });
            pEast.add(bIncrease[i]);
        }
        pEast.setLayout(new GridLayout((items.length + 1), 3));
        pEast.setMaximumSize(new Dimension(225, 800));
        pCF.add(pEast, BorderLayout.EAST);

        /******************************** SOUTH *********************************/
        JPanel pSouth = new JPanel();
        // Price
        JLabel lTotalPrice = new JLabel("Total Price:");
        pSouth.add(lTotalPrice);
        lRawCost = new JLabel("Rp. " + nice(cost) + "K");
        pSouth.add(lRawCost);
        // Discount
        JLabel lDiscountState = new JLabel("Discount:");
        pSouth.add(lDiscountState);
        String discount = (isDiscount) ? "15%" : "None";
        lIsDiscount = new JLabel(discount);
        pSouth.add(lIsDiscount);
        // Final Cost
        JLabel lFinalCostStatement = new JLabel("Final Cost:");
        pSouth.add(lFinalCostStatement);
        double finalCost = (isDiscount) ? cost * 0.85 : cost;
        lFinalCost = new JLabel("Rp. " + nice(finalCost) + "K");
        pSouth.add(lFinalCost);
        // The rest
        pSouth.setLayout(new GridLayout(3, 2));
        pCF.add(pSouth, BorderLayout.SOUTH);

        /******************************** FRAME *********************************/
        add(pCF);
        setSize(600, 400);
        setMinimumSize(new Dimension(600, 400));
        setMaximumSize(new Dimension(600, 400));
        setTitle("Welcome to Volgion Coffee Shop!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(new Color(99, 97, 107));
        setVisible(true);
    }

    void update() {
        cost = 0;
        for (int i = 0; i < items.length; i++) {
            cost += orders[i] * prices[i];
        }
        lRawCost.setText("Rp. " + nice(cost) + "K");
        if (cost >= 100) {
            isDiscount = true;
        } else {
            isDiscount = false;
        }
        String discount = (isDiscount) ? "15%" : "None";
        lIsDiscount.setText(discount);
        double finalCost = (isDiscount) ? cost * 0.85 : cost;
        lFinalCost.setText("Rp. " + nice(finalCost) + "K");
    }

    String nice(double cc) {
        String res = (cc % 1 == 0) ? String.format("%.0f", cc) : String.format("%.1f", cc);
        return res;
    }

    public class Transaction extends JFrame {

        Transaction() {
            setLayout(new BorderLayout());
            /******************************** NORTH *********************************/
            // Upper Half
            ImageIcon iiVolgion = new ImageIcon("GUIFiles/VOLGION-NOBG.png");
            JLabel lVolgion = new JLabel(iiVolgion);
            JPanel pUpperNorth = new JPanel();
            pUpperNorth.add(lVolgion);
            pUpperNorth.setLayout(new GridLayout(1, 1));
            // Lower Half
            String date = java.time.LocalDate.now().toString();
            JLabel lDate = new JLabel(date);
            String time = java.time.LocalTime.now().toString();
            JLabel lTime = new JLabel(time);
            JPanel pLowerNorth = new JPanel();
            pLowerNorth.add(lDate);
            pLowerNorth.add(lTime);
            pLowerNorth.setLayout(new GridLayout(1, 23));

            JPanel pNorth = new JPanel();
            pNorth.add(pUpperNorth);
            pNorth.add(pLowerNorth);
            pNorth.setLayout(new GridLayout(2, 1));

            /******************************** CENTER ********************************/
            int orderCount = 0;
            int[] ordersIndex = {};
            for (int i = 0; i < orders.length; i++) {
                if (orders[i] > 0) {
                    ordersIndex[orderCount] = i;
                    orderCount++;
                }
            }
            JLabel[] lItem = new JLabel[orderCount];
            for (int i = 0; i < lItem.length; i++) {
                lItem[i] = new JLabel();
            }

            JPanel pCenter = new JPanel();

            /******************************** SOUTH *********************************/
            JPanel pSouth = new JPanel();

            /******************************** FRAME *********************************/
            add(pNorth, BorderLayout.NORTH);
            add(pSouth, BorderLayout.SOUTH);
            add(pCenter, BorderLayout.CENTER);
            setSize(500, 500);
            setVisible(true);
            setTitle("Volgion Coffee Shop Struck");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }

    public static void main(String[] args) {
        new CoffeeShop();
    }
}
