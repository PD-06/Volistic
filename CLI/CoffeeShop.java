package CLI;

import java.util.Scanner;

public class CoffeeShop {
            private static String[] items = { "Americano ", "Latte     ", "Cappuccino", "Espresso  ", "Arabica   ",
                    "Mochaccino", "Tiramisu  ", "Robusta   ", "Liberica  ", "Excelso   ", "Affogato  " };
            private static int[] prices = { 21, 24, 29, 19, 23, 33, 33, 30, 66, 95, 34 };
            private static int[] orders = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
            static boolean csrun = true, end = false;
            static Scanner csinput = new Scanner(System.in);

            // getter
            static int getItemsCount() {
                return items.length;
            }
            static String getItems(int index) {
                return items[index];
            }
            static int getPrices(int index) {
                return prices[index];
            }
            static int getOrdersCount() {
                return orders.length;
            }

            static void command(String command) {
                switch (command) {
                    case "menu":
                        pMenu();
                        break;
                    case "add":
                        iAdd();
                        break;
                    case "rm":
                    case "remove":
                        iRemove();
                        break;
                    case "ls":
                    case "list":
                        Main.clear();
                        list();
                        break;
                    case "rst":
                    case "reset":
                        resetList();
                        break;
                    case "fin":
                    case "done":
                        done();
                        break;
                    case "quit":
                        CoffeeShop.resetVar();
                        pQuit(3);
                        CoffeeShop.end = true;
                        break;
                    case "help":
                        Main.clear();
                        help();
                        break;
                    default:
                        Main.clear();
                        Main.pExcType("Command unknown.");
                        System.out.println("Type 'help' to display the help menu");
                        break;
                }
            }
            static void list() {
                double total = 0, net = 0;
                boolean bdiscount = false, isEmpty = true;
                ;
                for (int i = 0; i < getOrdersCount(); i++) {
                    if (orders[i] != 0) {
                        isEmpty = false;
                    }
                }
                if (isEmpty) {
                    System.out.println("Your list is empty, use 'add' to add an item.");
                } else {
                    for (int i = 0; i < getItemsCount(); i++) {
                        if (orders[i] != 0) {
                            System.out.println((i + 1) + ". (" + orders[i] + " items) " + items[i] + " = ("
                                    + (orders[i] * getPrices(i)) + "K)");
                            total += (orders[i] * prices[i]);
                        }
                    }
                    System.out.printf("\nTotal price                = %,.0fK\n", total);
                    if (total >= 100) {
                        bdiscount = true;
                    }
                    if (bdiscount) {
                        net = (total * 0.85);
                    } else {
                        net = (int) total;
                    }
                    System.out.println("Discount (15%)             = " + bdiscount);
                    if (net == (int) net) {
                        System.out.println("Payment                    = " + (int) net + "K");
                    } else {
                        System.out.printf("Payment                    = %,.2fK\n", net);
                    }
                }
            }
            static void help() {
                System.out.println(
                        "\nAvailable commands: \n'menu'      : show the items menu.\n'add'       : add an item and its amount to the order list.\n'remove'    : remove an amount of item from the order list\n'list'      : display your current orders list.\n'reset'     : discard the order list and make a new one.\n'done'      : finish choosing and purchase your order list.\n'quit'      : simply quit the program and goes back to Volistic Main menu.\n'help'      : show this help menu.\n");
            }
            static void run() {
                pWelcome();
                csrun = true;
                end = false;
                while (CoffeeShop.csrun) {
                    CoffeeShop.csrun = false;
                    try {
                        Main.hr();
                        System.out.println("\nEnter your command: ");
                        command(csinput.nextLine());
                        if (CoffeeShop.end == false) {
                            CoffeeShop.csrun = true;
                        }
                    } catch (Exception e) {
                        Main.pExcType(
                                "You're not supposed to see this message.\nIf you do, report with a screenshot here: deffreus (Discord)");
                        csinput.nextLine();
                        CoffeeShop.csrun = true;
                    }
                }
            }
            static void pMenu() {
                Main.clear();
                System.out.println("\nAvailable items:");
                System.out.println(" 0 = (Cancel current command)");
                String space;
                for (int i = 0; i < getItemsCount(); i++) {
                    if (i < 9) {
                        space = " ";
                    } else {
                        space = "";
                    }
                    System.out.println(space + (i + 1) + " = " + getItems(i) + "         (" + prices[i] + "K)");
                }
                System.out.println("\n");
            }
            static void iAdd() {
                Main.clear();
                pMenu();
                boolean bindex = true, bcount = true;
                ;
                int index = 0;
                long count = 0;
                while (bindex) {
                    bindex = false;
                    try {
                        System.out.println("\nEnter the index number of the item you want to add: ");
                        index = csinput.nextInt();
                        csinput.nextLine();
                        if (index < 0 || index > getItemsCount()) {
                            System.out.println("(OUT OF RANGE) Please enter an integer between 0 to " + getItemsCount()
                                    + " (Inclusive) !");
                            bindex = true;
                        }
                    } catch (Exception e) {
                        Main.pExcType(
                                "Please enter an integer number between 0 to " + getItemsCount() + " (Inclusive) !");
                        csinput.nextLine();
                        bindex = true;
                    }
                }
                if (index == 0) {
                    System.out.println("Cancelling adding item...");
                } else {
                    System.out
                            .println("Selecting : " + Main.nospace(items[index - 1]) + " (" + prices[index - 1] + "K)");
                    while (bcount) {
                        bcount = false;
                        try {
                            System.out.println("\nHow many do you want to order?");
                            count = csinput.nextLong();
                            csinput.nextLine();
                            if (count < 0) {
                                System.out.println("(OUT OF RANGE) Please enter a real integer number!");
                                bcount = true;
                            }
                        } catch (Exception e) {
                            Main.pExcType("Please enter a real integer number!");
                            csinput.nextLine();
                            bcount = true;

                        }
                    }
                    if (count == 0) {
                        Main.clear();
                        System.out.println("Cancelling adding item...");
                    } else {
                        Main.clear();
                        orders[index - 1] += count;
                        System.out.println("Your order list is updated successfully.\n");
                    }
                }
            }
            static void iRemove() {
                Main.clear();
                boolean isEmpty = true;
                int orderCount = 0, lastIndex = 0;
                for (int i = 0; i < getOrdersCount(); i++) {
                    if (orders[i] != 0) {
                        orderCount++;
                        isEmpty = false;
                        lastIndex = i + 1;
                    }
                }
                if (isEmpty == true) {
                    System.out.println("Your list is empty, use 'add' to add an item.");
                } else {
                    System.out.println("Your current order list: ");
                    list();
                    boolean bindex = true, bcount = true;
                    ;
                    int index = 0;
                    long count = 0;
                    while (bindex) {
                        bindex = false;
                        try {
                            if (orderCount != 1) {
                                System.out.println("\nEnter the index number of the item you want to remove: ");
                                index = csinput.nextInt();
                                csinput.nextLine();
                                if (index < 0 || index > getItemsCount()) {
                                    System.out.println("(OUT OF RANGE) Please enter an integer between 0 to "
                                            + getItemsCount() + " (Inclusive) !");
                                    bindex = true;
                                } else if (orders[index - 1] == 0) {
                                    System.out.println(Main.nospace(items[index - 1]) + " is not on your order list.");
                                }
                            } else {
                                index = lastIndex;
                            }
                        } catch (Exception e) {
                            Main.pExcType("Please enter an integer between 0 to " + getItemsCount() + " (Inclusive) !");
                            csinput.nextLine();
                            bindex = true;
                        }
                    }
                    if (index == 0 || orders[index - 1] == 0) {
                        System.out.println("Cancelling removing item...");
                    } else {
                        if (orderCount == 1) {
                            System.out.println("\nSelecting : " + Main.nospace(items[index - 1]) + " ("
                                    + prices[index - 1] + "K)");
                        } else {
                            System.out.println(
                                    "Selecting : " + Main.nospace(items[index - 1]) + " (" + prices[index - 1] + "K)");
                        }
                        while (bcount) {
                            bcount = false;
                            try {
                                if (orderCount != 1) {
                                    System.out.println("\nHow many do you want to remove? (Type '0' to cancel)");
                                } else {
                                    System.out.println("\nHow many " + Main.nospace(items[index - 1])
                                            + " do you want to remove? (Type '0' to cancel)");
                                }
                                count = csinput.nextLong();
                                csinput.nextLine();
                                if (count < 0) {
                                    System.out.println("(OUT OF RANGE) Please enter a non-negative integer number!");
                                    bcount = true;
                                }
                            } catch (Exception e) {
                                Main.pExcType("Please enter a non-negative integer number!");
                                csinput.nextLine();
                                bcount = true;

                            }
                        }
                        if (count == 0) {
                            System.out.println("Cancelling removing item...");
                        } else if (count >= orders[index - 1]) {
                            System.out.println("Successfullly removed all " + Main.nospace(items[index - 1]) + ".");
                            orders[index - 1] = 0;
                        } else {
                            System.out.println(
                                    "Successfully removed " + count + " " + Main.nospace(items[index - 1]) + ".");
                            orders[index - 1] -= count;
                        }
                    }
                }
            }
            static void resetList() {
                Main.clear();
                for (int i = 0; i < getOrdersCount(); i++) {
                    orders[i] = 0;
                }
                System.out.println("Your order list have been discarded!");
            }
            static void done() {
                Main.clear();
                boolean listIsEmpty = true;
                for (int i = 0; i < getItemsCount(); i++) {
                    if (orders[i] != 0) {
                        listIsEmpty = false;
                        break;
                    }
                }
                if (listIsEmpty) {
                    System.out.println("Your list is empty.");
                    System.out.println("\nQuit purchase? (y/n): ");
                    switch (csinput.nextLine()) {
                        case "":
                        case "Y":
                        case "Yes":
                        case "yes":
                        case "ye":
                        case "Ye":
                        case "y":
                            System.out.println("You haven't buy anything for now...\nCome back later!");
                            CoffeeShop.csrun = false;
                            CoffeeShop.end = true;
                            pQuit(3);
                            Main.hr();
                            Main.hr();
                            break;
                        default:
                            break;
                    }
                } else {
                    System.out.println("Your order will be :");
                    list();
                    System.out.println("\nConfirm purchase? (y/n): ");
                    switch (csinput.nextLine()) {
                        case "":
                        case "Y":
                        case "Yes":
                        case "yes":
                        case "ye":
                        case "Ye":
                        case "y":
                            System.out.println("Purchase completed!\nEnjoy your coffee!");
                            CoffeeShop.csrun = false;
                            CoffeeShop.end = true;
                            CoffeeShop.resetVar();
                            System.out.println("\n\n" + //
                            "                ██    ██    ██                                    \n" + //
                            "              ██      ██  ██                                      \n" + //
                            "              ██    ██    ██                                      \n" + //
                            "                ██  ██      ██                                    \n" + //
                            "                ██    ██    ██                                    \n" + //
                            "                                                                  \n" + //
                            "            ████████████████████                                  \n" + //
                            "            ██                ██████                              \n" + //
                            "            ██                ██  ██                              \n" + //
                            "            ██                ██  ██                              \n" + //
                            "            ██                ██████                              \n" + //
                            "              ██            ██                                    \n" + //
                            "          ████████████████████████                                \n" + //
                            "          ██                    ██                                \n" + //
                            "            ████████████████████                                  \n");
                            CoffeeShop.pQuit(5);
                            break;
                        default:
                            System.out.println("Purchase cancelled, going back to listing your order!");
                    }
                }
            }
            static void pWelcome() {
                Main.clear();
                Main.hr();
                System.out.println(
                        "\nWelcome to the Volistic's Coffee Shop!\n\n(If your total purchase reach Rp. 100K, you will get a 15% discount!)\nWhat will be your order?\n");
                help();
            }
            static void resetVar() {
                for (int i = 0; i < getItemsCount(); i++) {
                    CoffeeShop.orders[i] = 0;
                }
            }
            static void pQuit(int duration) {
                System.out.println("\nQuitting in:");
                for (int i = duration; i > 0; i--) {
                    System.out.println(i + "...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Something went wrong...");
                    }
                }
            }
        }