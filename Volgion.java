import java.util.Scanner;
import java.lang.Math;
import java.lang.String;

// Let start over again:
/*
 * Hello friends!
 * Here, you can change the code however you want,
 * Lines that start with '#' is a command, press Ccommand + Shift + P adn then type the following command!
 * 
 * If you want to publish the changes you made:
 * # Git: Commit
 * # Git: Push
 * 
 * Also, don't forget to Fetch frequently
 * # Git: Fetch
 */

public class Volgion {
    public static void main(String[] args) {
        class ansiColor {
            public static String red = "\u001B[31m";
            public static String reset = "\u001B[0m";
        }
        Scanner input = new Scanner(System.in);
        class Main {
            private static String[][] programs = {
                    { "Coffee Shop", "BMI Calculator", "Two Variable Calculator (BETA)", "Tristan's Sleep Duration Calculator", "Anton's Morse Code Translator (EXPERIMENTAL)" },
                    { "1.0", "1.0.1", "0.1", "0.2", "0.1" } };

            // private static String[][] contributors = {{"Muhammad Alfin Azza Pujaar"}};
            static void quit(int second) {
                System.out.println("\nQuitting in:");
                for (int i = second; i > 0; i--) {
                    System.out.println(i + "...");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        Main.pExcType("Thread sleep error");
                    }
                }
                Main.clear();
                System.exit(1);
            }

            public static void clear() {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }

            static int getProgramsCount() {
                return programs[0].length;
            }

            static void hr() {
                System.out.println("================================================================================");
            }

            /*
             * static void pContributors(int progId) {
             * String noun = "";
             * if(contributors[progId].length > 1) {
             * noun = "s";
             * }
             * System.out.println(programs[progId] + " awesome contributor" + noun + " : ");
             * for(int i = 0; i < contributors[progId].length; i++) {
             * System.err.println(contributors[progId][i]);
             * }
             * }
             */
            static String getProgramsName(int index) {
                return programs[0][index];
            }

            static void pbanner() {
                System.out.printf(ansiColor.red + "__     __   ___    _        ____   ___    ___    _   _ \n" + //
                        "\\ \\   / /  / _ \\  | |      / ___| |_ _|  / _ \\  | \\ | |\n" + //
                        " \\ \\ / /  | | | | | |     | |  _   | |  | | | | |  \\| |\n" + //
                        "  \\ V /   | |_| | | |___  | |_| |  | |  | |_| | | |\\  |\n" + //
                        "   \\_/     \\___/  |_____|  \\____| |___|  \\___/  |_| \\_|\n" + //
                        "");
                System.out.println("\nV1.0.4");
                System.out
                        .println("\nYou can contribute to this project here: https://github.com/DeffreusTheda/ComSci");
                System.out.println(
                        "Please report any bug here:\n    Email      : muhammad.alfin@praditadirgantara.sch.id\n    Discord    : deffreus (recommended)\n    WA         : +62 895-8077-31515"
                                + ansiColor.reset);
            }

            static void pMainMenu() {
                System.out.println("\nPrograms menu:");
                for (int i = 0; i < getProgramsCount(); i++) {
                    System.out.println((i + 1) + " = " + getProgramsName(i) + " (V" + programs[1][i] + ")");
                }
            }

            static void pExcType(String message) {
                System.out
                        .println(ansiColor.red + "Main.pExcType: (ERROR: INVALID INPUT): " + message + ansiColor.reset);
            }

            static String nospace(String string) {
                String res = string.replaceAll("\\s", "");
                return res;
            }

            static void pQuit() {
                System.out.println("\n(Type 'quit' or 'exit' to quit Volgion from this menu)");
            }
        }

        class TwoVarCalculator {
            static Scanner tvcinput = new Scanner(System.in);
            static boolean tvcIsRunning, tvcIsEnded;
            static String operator;
            static double A, B;

            static void run() {
                tvcIsRunning = true;
                tvcIsEnded = false;
                while (tvcIsRunning) {
                    tvcIsRunning = false;
                    try {
                        Main.clear();
                        Main.hr();
                        pWelcome();
                        Main.hr();
                        iOperator();
                        iA();
                        iB();
                        pRes();
                        iQuit();
                        if (tvcIsEnded == false) {
                            tvcIsRunning = true;
                        }
                    } catch (Exception e) {
                        Main.pExcType(ansiColor.red + "CALCULATOR ERROR." + ansiColor.reset);
                    }
                }
            }

            static void iQuit() {
                String opt;
                boolean valid = false;
                while (valid != true) {
                    System.out.println("\nDo you want calculate again? (Y/n)");
                    opt = tvcinput.nextLine();
                    switch (opt) {
                        case "Y":
                        case "y":
                        case "Yes":
                        case "yes":
                        case "YES":
                        case "":
                            valid = true;
                            tvcIsEnded = false;
                            break;
                        case "n":
                        case "N":
                        case "No":
                        case "no":
                        case "NO":
                            valid = true;
                            tvcIsEnded = true;
                            break;
                        default:
                            System.out.println("Invalid input.");
                    }
                }
            }

            static void pRes() {
                System.out.println("\nThe result of the calculation is: " + calc(operator));
            }

            static double calc(String val) {
                double result = 1;
                switch (val) {
                    case "1":
                    case "+":
                        result = A + B;
                        break;
                    case "2":
                    case "-":
                        result = A - B;
                        break;
                    case "3":
                    case "x":
                    case "*":
                        result = A * B;
                        break;
                    case "4":
                    case "/":
                        result = A / B;
                        break;
                    case "5":
                    case "^":
                    case "**":
                        for (int i = 0; i < B; i++)
                            result *= A;
                        break;
                    case "√":
                    case "6":
                        double exponent = 1 / B;
                        result = Math.pow(A, exponent);
                        break;
                    case "7":
                    case "%":
                        result = A % B;
                        break;
                    default:
                        break;
                }
                return result;
            }

            static void iB() {
                System.out.println("\nPlease enter a value for the variable B: ");
                B = Double.parseDouble(tvcinput.nextLine());
            }

            static void iA() {
                System.out.println("\nPlease enter a value for the variable A: ");
                A = Double.parseDouble(tvcinput.nextLine());
            }

            static void iOperator() {
                System.out.println("\nWhat type of calculation you want?\n");
                System.out.println("1 (+) = Increase A by B");
                System.out.println("2 (-) = Substract B from A");
                System.out.println("3 (x) = Multiply A and B");
                System.out.println("4 (/) = Divide A by B");
                System.out.println("5 (^) = A to the power of B");
                System.out.println("6 (√) = 'B' root of A");
                System.out.println("7 (%) = A modulo B");
                boolean keepAsking = true;
                while (keepAsking) {
                    System.out.println("\n(Enter the index number or symbol):");
                    try {
                        operator = Main.nospace(tvcinput.nextLine());
                        keepAsking = false;
                    } catch (Exception e) {
                        Main.pExcType("Please input a number!");
                        keepAsking = true;
                    }
                }
            }

            static void pWelcome() {
                System.out.println("\nWelcome to the Volgion's Two Variable Calculator!\n");
            }
        }

        class BMICalculator {
            // Deklarasi variabel yang akan dipakai.
            static boolean bmirun, end, hasName;
            static String fname, category; // fname -> "Full Name"
            static Scanner bmiinput = new Scanner(System.in);
            static double weight, height, bmi;

            // Method buat jalanin bmi kalkulatornya
            static void run() {
                bmirun = true;
                end = false;
                // Biar bisa ngulang-ulang kalkulasi BMI
                while (bmirun) {
                    bmirun = false;
                    // 'try': kalau ada error (Exception) di sebuah line of code, langsung lompat ke 'catch'
                    try {
                        Main.clear(); // clear terminal
                        Main.hr(); // print horizontal line
                        // perhatiin penamaan methodnya: pWelcome -> "Print Welcome", iName -> "Input Name"
                        pWelcome();
                        Main.hr();
                        iName();
                        if (fname != "") // kalau namanya nggak kosong
                            hasName = true;
                        if (hasName) {System.out.println("\nHello " + fname + "!");} // kamu bisa lo nulis if begini
                        iWeight();
                        iHeight();
                        calcBMI(weight, height); // method ini pakai 'parameter': weight & height, buat dipakai di method 'calcBMI' nya
                        pResult();
                        iQuit();
                        if (end == false) {bmirun = true;} // kamu bisa lo nulis if begini
                    } catch (Exception e) { // ini catch!
                        Main.pExcType(
                                "You're not supposed to see this message.\nIf you do, report with a screenshot and how to replicate it here: deffreus (Discord)");
                        bmirun = true; // biar ngulang
                    }
                }
            }
            // timer buat quitting aja
            static void pQuit(int intSecond) {
                System.out.println("\nQuitting in:");
                for (int i = intSecond; i > 0; i--) {
                    System.out.println(i + "...");
                    try {
                        Thread.sleep(1000); // wait for 1000 milisecond = 1 second
                    } catch (Exception e) {
                        Main.pExcType("Thread sleep exception, dev's fault");
                    }
                }
            }
            // jujur ini kurang sih:
            static void iQuit() {
                System.out.println("\nDo you want to calculate again? (Y/n):");
                String option = bmiinput.nextLine();
                switch (option) {
                    case "N":
                    case "n":
                    case "No":
                    case "no":
                    case "NO":
                        end = true;
                        pQuit(3);
                        break;
                }
            }
            static void pResult() {
                System.out.println("\n"); // biar tetep misahin output walau `hasName == false`
                if (hasName)
                    System.out.println("Here is your result, " + fname + ":");
                System.out.println("Your weight      : " + weight);
                System.out.println("Your height      : " + height);
                System.out.printf("Your BMI index   : %.1f\n", bmi);
                System.out.println("\nYou're categorized as:\n" + category);
            }
            static void calcBMI(double w, double h) {
                bmi = w / (h * h * 0.0001); // pake 0.0001 karena unit nya centimeter
                if (bmi < 16) {
                    category = "Underweight (Severe thinness)";
                } else if (bmi <= 16.9) {
                    category = "Underweight (Moderate thinness)";
                } else if (bmi <= 18.4) {
                    category = "Underweight (Mild thinness)";
                } else if (bmi < 24.9) {
                    category = "Normal";
                } else if (bmi <= 29.9) {
                    category = "Overweight (Pre-obese)";
                } else if (bmi <= 34.9) {
                    category = "Obese (Class I)";
                } else if (bmi <= 39.9) {
                    category = "Obese (Class II)";
                } else {
                    category = "Obese (Class III)";
                }
            }
            static void pWelcome() {
                System.out.println("\nWelcome to the Volgion BMI Calculator!\n");
            }
            static void iName() {
                System.out.println("\nWhat is your full name? (blank to skip)");
                fname = bmiinput.nextLine();
            }
            static void iWeight() {
                boolean valid = false;
                while (!valid) { // minta terus input sampai input tersebut valid! (angka doang)
                    valid = true;
                    try {
                        System.out.println("\nWhat is your weight (kg)?");
                        weight = Double.parseDouble(bmiinput.nextLine());
                        if (weight > 635) {
                            System.out.println("I don't think you can be that fat.\n");
                            valid = false;
                        } else if (weight < 0.25) {
                            System.out.println("I don't think even a baby could be that light.\n");
                            valid = false;
                        }
                    } catch (Exception e) {
                        Main.pExcType("Something is wrong with your weight.");
                        valid = false;
                    }
                }
            }
            static void iHeight() {
                boolean valid = false;
                while (!valid) { // mirip yang di `iWeight()` (angka doang)
                    valid = true;
                    try {
                        System.out.println("\nWhat is your height (cm)?");
                        height = Double.parseDouble(bmiinput.nextLine());
                        if (height > 272) {
                            System.out.println(
                                    "Even the tallest man in the world, Robert Wadlow, doesn't reach that height.");
                            valid = false;
                        } else if (height < 25) {
                            System.out.println("That's kinda extremely small, what are you huh?");
                            valid = false;
                        }
                    } catch (Exception e) {
                        Main.pExcType("Something is wrong with your height.");
                        valid = false;
                    }
                }
            }
        }

        class CoffeeShop {
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

            // Methods
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
                        "\nAvailable commands: \n'menu'      : show the items menu.\n'add'       : add an item and its amount to the order list.\n'remove'    : remove an amount of item from the order list\n'list'      : display your current orders list.\n'reset'     : discard the order list and make a new one.\n'done'      : finish choosing and purchase your order list.\n'quit'      : simply quit the program and goes back to Volgion Main menu.\n'help'      : show this help menu.\n");
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
                            CoffeeShop.pQuit(5);
                            ;
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
                        "\nWelcome to the Volgion's Coffee Shop!\n\n(If your total purchase reach Rp. 100K, you will get a 15% discount!)\nWhat will be your order?\n");
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

        class Tristan {
            static Scanner tristaninput = new Scanner(System.in);
            static boolean tristanIsRunning, tristanIsEnded;
            static int jam_tidur, menit_tidur, jam_bangun, menit_bangun, durasi_kiri, durasi_kanan;

            static void run() {
                tristanIsRunning = true;
                tristanIsEnded = false;
                while (tristanIsRunning) {
                    tristanIsRunning = false;
                    try {
                        Main.clear();
                        Main.hr();
                        pWelcome();
                        Main.hr();
                        iJamTidur();
                        iJamBangun();
                        pRes();
                        iQuit();
                        if (tristanIsEnded == false) {
                            tristanIsRunning = true;
                        }
                    } catch (Exception e) {
                        Main.pExcType(ansiColor.red + "CALCULATOR ERROR." + ansiColor.reset);
                    }
                }
            }

            static void iQuit() {
                String opt;
                boolean valid = false;
                while (valid != true) {
                    System.out.println("\nDo you want calculate again? (Y/n)");
                    opt = tristaninput.nextLine();
                    switch (opt) {
                        case "Y":
                        case "y":
                        case "Yes":
                        case "yes":
                        case "YES":
                        case "":
                            valid = true;
                            tristanIsEnded = false;
                            break;
                        case "n":
                        case "N":
                        case "No":
                        case "no":
                        case "NO":
                            valid = true;
                            tristanIsEnded = true;
                            break;
                        default:
                            System.out.println("Invalid input.");
                    }
                }
            }

            static void pRes() {
                durasi_kiri = (24 * 60) - (jam_tidur * 60 + menit_tidur);
                durasi_kanan = jam_bangun * 60 + menit_bangun;
                int durasi_total = durasi_kanan + durasi_kiri;
                System.out.println("\nThe duration of your sleep is: " + durasi_total / 60 + " hours, and "
                        + durasi_total % 60 + " minutes!");
            }

            static void iJamBangun() {
                boolean inputIsValid = false;
                while (!inputIsValid) {
                    try {
                        System.out.println("\nAt what time do you usually wakr up? (Format = $HOUR $MINUTES): ");
                        jam_bangun = tristaninput.nextInt();
                        menit_bangun = tristaninput.nextInt();
                        tristaninput.nextLine();
                        inputIsValid = true;
                    } catch (Exception e) {
                        Main.pExcType("Please enter the hour and minutes in a valid format: $HOUR $MINUTES");
                        tristaninput.nextLine();
                    }
                }
            }

            static void iJamTidur() {
                boolean inputIsValid = false;
                while (!inputIsValid) {
                    try {
                        System.out.println("\nAt what time do you usually sleep? (Format = $HOUR $MINUTES): ");
                        jam_tidur = tristaninput.nextInt();
                        menit_tidur = tristaninput.nextInt();
                        tristaninput.nextLine();
                        inputIsValid = true;
                    } catch (Exception e) {
                        Main.pExcType("Please enter the hour and minutes in a valid format: $HOUR $MINUTES");
                        tristaninput.nextLine();
                    }

                }
            }

            static void pWelcome() {
                System.out.println("\nWelcome to the Tristan's Sleep Duration Calculator!\n");
            }
        }

        class Anton { // mau bikin morse code translator katanya
            static Scanner BAPAKMU = new Scanner(System.in);
            static String dictionary[][] = {{"A" ,"B"   ,"C"   ,"D"  ,"E","F"   ,"G"  ,"H"   ,"I" ,"J"   ,"K"  ,"L"   ,"M" ,"N" ,"O"  ,"P"   ,"Q"   ,"R"  ,"S"  ,"T","U"  ,"V"   ,"W"  ,"X"   ,"Y"   ,"Z"   }, 
                                        {".-","_...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."} };
            static boolean isEnded, isRunning;
            static String input, result[];
            static int mode;
            static void run() {;
                Main.clear();
                pWelcome();
                iMode();
                iInput();
                if(mode == 1) {LetterToMorse();}
                else if(mode == 2) {MorseToLetter();};
                pResult();
                iQuit();
            }
            static void pWelcome() {
                Main.hr();
                System.out.println("\nWelcome to Anton's Morse Code Translator!");
                Main.hr();
            }
            static void iMode() {
                boolean inputIsValid = false;
                while(!inputIsValid) {
                    System.out.println("\nSelect mode:\n1 = Letters to Morse Code\n2 = Morse Code to Letters");
                    try {
                        mode = Integer.parseInt(BAPAKMU.nextLine());
                        switch(mode) {
                            case 1:
                                LetterToMorse();
                                inputIsValid = true;
                                break;
                            case 2:
                                MorseToLetter();
                                inputIsValid = true;
                                break;
                        }
                    } 
                    catch(Exception e) {
                        Main.pExcType("(INVALID INPUT): Please enter either '1' or '2'!");
                        if(BAPAKMU.hasNextLine()) {BAPAKMU.nextLine();}
                    }
                }
            }
            static void iInput() {
                System.out.println("\nType what you want to be translated:");
                input = (BAPAKMU.nextLine()).toUpperCase();
            }
            static void LetterToMorse() {
                
            }
            static void MorseToLetter() {}
            static void pResult() {}
            static void iQuit() {}
        }

        boolean run = true;
        while (run) {
            try {
                Main.clear();
                Main.pbanner();
                Main.pQuit();
                Main.pMainMenu();
                System.out.println("\nSelect the program you want to run: ");
                String chosenProgram = input.nextLine();
                switch (chosenProgram) {
                    case "Coffee Shop":
                    case "1":
                        CoffeeShop.run();
                        break;
                    case "BMI":
                    case "BMI Calculator":
                    case "2":
                        BMICalculator.run();
                        break;
                    case "3":
                        TwoVarCalculator.run();
                        break;
                    case "4":
                    case "Tristan":
                    case "Tristan's Sleep Duration Calculator":
                        Tristan.run();
                        break;
                    case "5":
                    case "Anton":
                    case "Morse Code":
                        Anton.run();
                        break;
                    case "exit":
                    case "quit":
                        Main.quit(3);
                        break;
                }
            } catch (Exception e) {
                Main.pExcType(
                        "Something went wrong. Please report immediately to: deffreus (Discord). Sorry for the inconvenience T-T");
                if (input.hasNextLine()) {
                    input.nextLine();
                }
                try {
                    Thread.sleep(2000);
                } catch (Exception ee) {
                    Main.pExcType("Thread sleep error.");
                }
            }
        }
        input.close();
    }
}
