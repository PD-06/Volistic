/********************************************************************************
 * Copyright (c) 2024 PD`06
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *******************************************************************************/

package CLI;

import java.util.Arrays;
import java.util.Scanner;

public class CoffeeShop {
    private static final String[] items = { "Americano ","Latte     ","Cappuccino","Espresso  ","Arabica   ","Mochaccino","Tiramisu  ","Robusta   ","Liberica  ","Excelso   ","Affogato  "};
    private static final int[] prices = { 21, 24, 29, 19, 23, 33, 33, 30, 66, 95, 34 };
    private static final int[] stock = new int[items.length];
    private static final int[] orders = new int[items.length];
    private static boolean isRunning, end;
    private static final Scanner scanner = new Scanner(System.in);

    static void run() {
        init();
        printWelcome();
        isRunning = true;
        end = false;
        while (isRunning) {
            printHelp();
            System.out.printf("\nEnter your command%s: ",commands);
            command(scanner.nextLine().trim().toLowerCase());
            if (end) isRunning = false;
        }
    }
    static void init() {
        for (int i = 0; i < stock.length; i++) stock[i] = (int) (Math.random() * (200 / items.length));
        Arrays.fill(orders, 0);
    }
    static void printWelcome() {
        Main.clear();
        Main.printHorizontalLine();
        System.out.println("\nWelcome to the Volistic Coffee Shop!");
        System.out.println("\n(If your total purchase reach Rp. 100K, you will get a 15% discount!)");
    }
    static void printHelp() {
        System.out.print("\n");
        Main.printHorizontalLine();
        System.out.println("""
        
        (Available commands)
        'menu'      : show the coffee menu
        'add'       : add an amount of coffee to your order
        'remove'    : remove an amount of coffee from your order
        'list'      : display your order list
        'reset'     : discard your order list
        'purchase'  : purchase your order list
        'quit'      : goes back to Volistic main menu
        """);
        Main.printHorizontalLine();
    }
    static void command(String command) {
        switch (command) {
            case "menu":
                printMenu(true);
                break;
            case "add":
                iAdd();
                break;
            case "rm","remove":
                iRemove();
                break;
            case "ls","list":
                Main.clear();
                list();
                break;
            case "rst","reset":
                resetList();
                break;
            case "done","purchase":
                purchase();
                break;
            case "quit","q":
                purchase(); // Who could've thought lol
                break;
            default:
                Main.clear();
                Main.printExceptionInvalidInput("Command unknown");
        }
    }
    static void printMenu(boolean printOnly) {
        Main.clear();
        if(!printOnly) System.out.println(" 0 = Cancel current command\n");
        System.out.println("Available coffees:\n");
        System.out.println("ID | Coffee Name      | Stock | Price\n");
        for (int i = 0; i < items.length; i++) {
            String IDSpace = ""; if (i < 9) IDSpace = " ";
            String QTYSpace = " ";if(stock[i]<100)QTYSpace="  ";if(stock[i]<10)QTYSpace="   ";
            System.out.printf("%s%d | %s       | %s%d  | (%dK)\n",IDSpace,i+1,items[i],QTYSpace,stock[i],prices[i]);
        }
    }
    static void iAdd() {
        boolean IDIsValid = false, QTYIsValid = false;
        short index = 0, count = 0;

        Main.clear();
        printMenu(false);
        while (!IDIsValid) {
            System.out.print("\nEnter the coffee ID: ");
            try {index = Short.parseShort(scanner.nextLine());}
            catch (Exception e) {
                Main.printExceptionInvalidInput("Not an ID");
                continue;
            }
            if (index < 0 || index > items.length) Main.printExceptionInvalidInput("Unknown ID");
            else IDIsValid = true;
        }
        if (index == 0) {
            System.out.println("Cancelling adding item...");
            return;
        }
        if (stock[index-1] == 0) {
            System.out.printf("We've run out of %s today...\n",Main.noSpace(items[index-1]));
            return;
        }
        System.out.println("Selecting : " + Main.noSpace(items[index-1]) + " (" + prices[index-1] + "K)");
        while (!QTYIsValid) {
            System.out.print("\nEnter the amount: ");
            try {count = Short.parseShort(scanner.nextLine());}
            catch (Exception e) {
                Main.printExceptionInvalidInput("Not a number");
                continue;
            }
            if(count < 0) Main.printExceptionInvalidInput("Must be a positive integer");
            else if(count > stock[index-1]) {
                if(stock[index-1]==0) System.out.printf("Sorry, we run out of %s today...\n",Main.noSpace(items[index-1]));
                else System.out.printf("Sorry, we only have %d %s left today...\n",stock[index-1],Main.noSpace(items[index-1]));
            }
            else QTYIsValid = true;
        }
        Main.clear();
        if (count == 0) System.out.println("Cancelling adding item...");
        else {
            orders[index-1] += count;
            stock[index-1] -= count;
            System.out.printf("Successfully added %d %s.\n", count, Main.noSpace(items[index-1]));
        }
    }
    static void iRemove() {
        boolean isEmpty = true, isOnlyOne = false, IDIsValid = false, AmountIsValid = false;
        short orderCount = 0, ID = 0, lastNonEmptyID = -1;
        long count = 0;

        Main.clear();
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] != 0) {
                orderCount++;
                isEmpty = false;
                lastNonEmptyID = (short) (i+1);
            }
        }
        if (isEmpty) {
            System.out.println("Your order list is empty, use 'add' to add an item.");
            return;
        } else System.out.println("Your current order list: \n");
        if (orderCount == 1) {
            isOnlyOne = true;
            ID = lastNonEmptyID;
        }
        list();
        if(!isOnlyOne) {
            while (!IDIsValid) {
                System.out.print("\nEnter the coffee ID: ");
                try {ID = Short.parseShort(scanner.nextLine());}
                catch (Exception e) {
                    Main.printExceptionInvalidInput("Not an ID");
                    continue;
                }
                if (ID < 0 || ID > items.length) Main.printExceptionInvalidInput("Unknown ID");
                else if (orders[ID-1] == 0) System.out.printf("%s is not on your order list.\n",Main.noSpace(items[ID-1]));
                else IDIsValid = true;
            }
            if (ID == 0) {
                System.out.println("Cancelling removing item...");
                return;
            }
            System.out.printf("Selecting : %s (%dK)\n",Main.noSpace(items[ID-1]),prices[ID-1]);
        }
        while (!AmountIsValid) {
            if(!isOnlyOne) System.out.printf("\nEnter the amount of %s to remove: ",Main.noSpace(items[ID-1]));
            else System.out.printf("\nEnter the amount of %s to remove: ",Main.noSpace(items[lastNonEmptyID-1]));
            try {count = Long.parseLong(scanner.nextLine());}
            catch (Exception e) {
                Main.printExceptionInvalidInput("Not a number");
                continue;
            }
            if (count < 0) Main.printExceptionInvalidInput("Must be a non-negative number");
            else AmountIsValid = true;
        }
        if (count == 0) System.out.println("Cancelling removing item...");
        else if (count >= orders[ID-1]) {
            System.out.printf("Successfully removed all %s.\n",Main.noSpace(items[ID-1]));
            stock[ID-1] += orders[ID-1];
            orders[ID-1] = 0;
        } else {
            System.out.printf("Successfully removed %d %s.\n",count,Main.noSpace(items[ID-1]));
            orders[ID-1] -= (int) count;
            stock[ID-1] += (int) count;
        }
    }
    static void list() {
        int grossPrice = 0;
        double netPrice;
        boolean isDiscount = false, isEmpty = true;
        for (int order : orders) {
            if (order != 0) {
                isEmpty = false;
                break;
            }
        }
        if (isEmpty) {
            System.out.println("Your order list is empty, use 'add' to add an item.");
            return;
        }
        System.out.println("ID | Coffee Name      | QTY | Price\n");
        for (int i = 0; i < items.length; i++) {
            if (orders[i] != 0) {
                String IDSpace = "", QTYSpace = "";
                if (i < 9) IDSpace = " ";
                if(orders[i]<100)QTYSpace=" ";if (orders[i] < 10) QTYSpace = "  ";
                System.out.printf("%s%d | %s       | %s%d | (%dK)\n",IDSpace,i+1,items[i],QTYSpace,orders[i],prices[i]);
                grossPrice += orders[i] * prices[i];
            }
        }
        System.out.printf("\nGross price                 = %dK\n", grossPrice);
        if (grossPrice >= 100) {
            isDiscount = true;
            netPrice = (grossPrice * 0.85);
        } else netPrice = grossPrice;
        String discount = "None";
        if(isDiscount) discount = "15%";
        System.out.printf("Discount                    = %s\n",discount);
        if (netPrice == (int)netPrice) System.out.printf("Net price                   = %dK\n",(int)netPrice);
        else System.out.printf("Net price                   = %.2fK\n",netPrice);
    }
    static void resetList() {
        Main.clear();
        // If list is empty
        boolean isEmpty = true;
        for (int order : orders) {
            if (order != 0) {
                isEmpty = false;
                break;
            }
        }
        if(isEmpty) {
            System.out.println("Your order list is already empty.");
            return;
        }
        // If list is not empty
        for(int i = 0; i < orders.length; i++) {
            stock[i] += orders[i];
            orders[i] = 0;
        }
        System.out.println("Your order list have been discarded!");
    }
    static void purchase() {
        Main.clear();
        boolean listIsEmpty = true;
        for (int order : orders) {
            if (order != 0) {
                listIsEmpty = false;
                break;
            }
        }
        if (listIsEmpty) {
            System.out.println("Your list is empty.");
            System.out.print("\nLeave empty handed? (y/n): ");
            switch (scanner.nextLine().trim().toLowerCase()) {
                case "y", "yes", "yeah", "yup", "yoi", "yep", "aye", "ye", "":
                    System.out.println("You haven't buy anything for now...\nCome back later!");
                    isRunning = false;
                    end = true;
                    printQuit(3);
                    return;
                case "n", "no", "nah", "nope", "nay":
                    if (!secretIsActivated) {
                        System.out.println("""
                        Sorry if things seem overpriced...
                        Special for you, all coffee cost 10K less!
                        You like it now?""");
                        activateSecret();
                    }
                    return;
                default:
                    Main.printExceptionInvalidInput("Response unknown.");
                    return;
            }
        }
        System.out.println("Your order will be:\n");
        list();
        boolean responseIsValid = false;
        while(!responseIsValid) {
            System.out.print("\nPurchase now? (Y/n): ");
            switch (scanner.nextLine().trim().toLowerCase()) {
                case "y", "yes", "yeah", "yup", "yoi", "yep", "aye", "ye", "":
                    System.out.println("\nPurchase completed!\nEnjoy your coffee!");
                    end = true;
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
                    responseIsValid = true;
                    printQuit(5);
                    break;
                case "n", "no", "nah", "nope", "nay":
                    responseIsValid = true;
                    break;
                default:
                    Main.printExceptionInvalidInput("Response unknown.");
            }
        }
    }
    static void printQuit(int duration) {
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
    static void activateSecret() {
        if(!secretIsActivated) {
            for (int i = 0; i < prices.length; i++) prices[i] -= 10;
            secretIsActivated = true;
        }
        commands = ", sweetheart";
    }
    private static String commands = "";
    private static boolean secretIsActivated = false;
}