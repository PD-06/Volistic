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
                { "Coffee Shop", "BMI Calculator", "Two Variable Calculator (NEW)", "Sleep Duration Calculator (NEW)", "Morse Code Translator (NEW)" },
                { "1.0"        , "1.0.1"         , "1.0"                          , "1.0"                             , "1.0"                        } };
            private static String[][] contributors = {
            //  | Main Contributor | Others (1)       |
                { "Deffreus Theda"                    }, // Coffee Shop
                { "Deffreus Theda"                    }, // BMI Calculator
                { "Deffreus Theda"                    }, // Two Variable Calculator
                { "Tristan"        , "Deffreus Theda" }, // Sleep Duration Calculator
                { "Anton"          , "Deffreus Theda" }, // Morse Code Translator
            };

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
            static String getProgramsName(int index) {
                return programs[0][index];
            }
            static void pbanner() {
                System.out.printf(ansiColor.red + //
                        "__     __   ___    _        ____   ___    ___    _   _ \n" + //
                        "\\ \\   / /  / _ \\  | |      / ___| |_ _|  / _ \\  | \\ | |\n" + //
                        " \\ \\ / /  | | | | | |     | |  _   | |  | | | | |  \\| |\n" + //
                        "  \\ V /   | |_| | | |___  | |_| |  | |  | |_| | | |\\  |\n" + //
                        "   \\_/     \\___/  |_____|  \\____| |___|  \\___/  |_| \\_|\n" + //
                        "");
                System.out.println("\n -- Version 1.2.0 -- ");
                System.out.println("\nYou can contribute to this project here: https://github.com/PD-06/Volgion");
                System.out.println("Please report any bug here:\n    Discord    : deffreus" + ansiColor.reset);
            }
            static void pMainMenu() {
                System.out.println("\nPrograms menu:");
                for (int i = 0; i < getProgramsCount(); i++) {
                    System.out.print((i + 1) + " = " + getProgramsName(i) + " (V" + programs[1][i] + ")" + " by ");
                    int ContributorCount = contributors[i].length;
                    // yang ini gausah dipahamin gpp, aku juga bingung
                    for(int j = 0; j < ContributorCount; j++) {
                        System.out.print(contributors[i][j]);
                        if(ContributorCount == 2) {
                            if(j == ContributorCount-2) {System.out.print(" & ");}
                        } else { 
                            if(j < ContributorCount-2) {System.out.print(", ");}
                            if(j == ContributorCount-2) {System.out.print(", & ");}
                        }
                    } System.out.print("\n");
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
            static String nice(double valval) {
                int valint = (int) valval; String res = "";
                if(valint == valval) {res = Integer.toString(valint);}
                else {res = Double.toString(valval);}
                return res;
            }
        }

        class TwoVarCalculator {
            static Scanner tvcinput = new Scanner(System.in);
            static boolean tvcIsRunning, tvcIsEnded, operatorIsValid;
            private static String operator = "TRmSvJWbtu9FXgMBdtfEOt3e0e90Th2Z8u6SVZ0jB0aU4QSh0n";
            static double A, B;
            static int op;

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
                        if(!tvcIsEnded) {iA(); iB(); pRes(); iQuit();}
                        if(!tvcIsEnded) {tvcIsRunning = true;}
                    } catch (Exception e) {
                        Main.pExcType(ansiColor.red + "CALCULATOR ERROR." + ansiColor.reset);
                    }
                }
                pQuit(3);
            }
            static void pQuit(int seconds) {
                System.out.println("\nThank you so much for using the Volgion Two Variable Calculator!! :D");
                System.out.println("\nQuitting in:");
                for (int i = seconds; i > 0; i--) {
                    System.out.println(i + "...");
                    try {
                        Thread.sleep(1000); // wait for 1000 milisecond = 1 second
                    } catch (Exception e) {
                        Main.pExcType("Thread sleep exception, dev's fault");
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
                            Main.pExcType("Please enter yes or no!");
                    }
                }
            }
            static void pRes() {
                double resdouble = calc(operator);
                int resint = (int) calc(operator);
                if(resdouble == resint) {System.out.println("\nThe result of the calculation is: " + resint);}
                else {System.out.println("\nThe result of the calculation is: " + resdouble);}
            }
            static double calc(String val) {
                double result = 1;
                operatorIsValid = true;
                switch (val) {
                    case "1":
                    case "+":
                        op = 1;
                        result = A + B;
                        break;
                    case "2":
                    case "-":
                        op = 2;
                        result = A - B;
                        break;
                    case "3":
                    case "x":
                    case "*":
                        op = 3;
                        result = A * B;
                        break;
                    case "4":
                    case "/":
                        op = 4;
                        result = A / B;
                        break;
                    case "5":
                    case "^":
                    case "**":
                        op = 5;
                        for (int i = 0; i < B; i++)
                            result *= A;
                        break;
                    case "√":
                    case "6":
                        op = 6;
                        double exponent = 1 / B;
                        result = Math.pow(A, exponent);
                        break;
                    case "7":
                    case "%":
                        op = 7;
                        result = A % B;
                        break;
                    case "quit":
                    case "exit":   
                        tvcIsEnded = true;
                        break;
                    default:
                        operator = "TRmSvJWbtu9FXgMBdtfEOt3e0e90Th2Z8u6SVZ0jB0aU4QSh0n";
                        operatorIsValid = false;
                        break;
                }
                return result;
            }
            static void iB() {
                boolean BIsValid = false;
                while(!BIsValid) {
                    try {
                        System.out.println("\nPlease enter a value for the variable B: ");
                        B = Double.parseDouble(tvcinput.nextLine());
                        BIsValid = true;
                    } catch(Exception e) {
                        if(!tvcIsEnded) {Main.pExcType("Please enter a number for variable B!");}
                    }
                }
            }
            static void iA() {
                boolean AIsValid = false;
                while(!AIsValid) {
                    try {
                        System.out.println("\nPlease enter a value for the variable A: ");
                        A = Double.parseDouble(tvcinput.nextLine());
                        AIsValid = true;
                    } catch(Exception e) {
                        if(!tvcIsEnded) {Main.pExcType("Please enter a number for variable A!");}
                    }
                }
            }
            static void iOperator() {
                String calculations[][] = {
                    {"Symbol","Description"        ,"Name"          ,"Format" },
                    {"+"     ,"Increase A by B"    ,"Incrementation","(A + B)"},
                    {"-"     ,"Substract B from A" ,"Substraction"  ,"(A - B)"}, 
                    {"x"     ,"Multiply A and B"   ,"Multiplication","(A x B)"},
                    {"/"     ,"Divide A by B"      ,"Division"      ,"(A / B)"},
                    {"^"     ,"A to the Power of B","Exponentiation","(A^B)"  },
                    {"√"     ,"'B' root of A"      ,"Nth Root"      ,"(B√ A)" },
                    {"%"     ,"A modulo B"         ,"Modulus"       ,"(A % B)"}
                };
                System.out.println("\nWhat type of calculation you want?\n");
                for(int i = 1; i < calculations.length; i++) {System.out.printf("%s (%s) = %s\n", i, calculations[i][0], calculations[i][1]);}
                boolean keepAsking = true;
                while (keepAsking) {
                    keepAsking = true;
                    System.out.println("\n(Enter the index number or symbol):");
                    try {
                        operator = Main.nospace(tvcinput.nextLine());
                        calc(operator);
                        if(operatorIsValid) {keepAsking = false;}
                        else {Main.pExcType("Please enter the index number or symbol above!");}
                    } catch (Exception e) {
                        Main.pExcType("Please input a number or symbol!");
                        keepAsking = true;
                    }
                }
                if(!tvcIsEnded) {System.out.println("Selecting: " + calculations[op][2] + "... " + calculations[op][3]);}
            }
            static void pWelcome() {
                System.out.println("\nWelcome to the Volgion's Two Variable Calculator!");
                System.out.println("(Enter 'quit' or 'exit' to exit)\n");
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
                System.out.println("Your weight      : " + Main.nice(weight) + " kg");
                System.out.println("Your height      : " + Main.nice(height) + " cm");
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
            static int jam_tidur, menit_tidur, jam_bangun, menit_bangun;

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
            static void pQuit(int second) {
                System.out.println("\nQuitting in:");
                for(int i = second; i > 0; i--) {
                    System.out.println(i + "...");
                    try {
                        Thread.sleep(1000);
                    } catch(Exception e) {
                        Main.pExcType("Thread sleep exception! Dev's fault, not yours!");
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
                            System.out.println("Invalid input!");
                    }
                }
                System.out.println("\nThank you for using the Sleep Duration Calculator!! :D");
                pQuit(3);
            }
            static void pRes() {
                // kalkulasi durasi tidur:
                int tidur = jam_tidur*60+menit_tidur; int bangun = jam_bangun*60+menit_bangun;
                if(tidur > bangun) {tidur -= (24*60);}
                int hours = (bangun-tidur)/60; int minutes = (bangun-tidur)%60;

                // output formatting!
                // ketika tidur sama dengan bangun:
                if(hours+minutes == 0) {System.out.printf("\nYou sleep in less than a minute or what? :O\n");}
                // ketika tidur dibawah satu jam:
                else if(hours == 0 && minutes != 0) {
                    if(minutes == 1) {System.out.printf("\nYou've slept for a minute! XD\n");}
                    else {System.out.printf("\nYou've slept for %d minutes! :v\n", minutes);}
                }
                // ketika tidur tepat N jam:
                else if(minutes == 0 && hours != 0) {
                    if(hours == 1) System.out.printf("\nYou've slept for an hour! :p\n");
                    else {System.out.printf("\nYou've slept for %d hours! :>\n", hours);}
                } 
                // output format jam dan menit:
                else {
                    if(hours == 1 && minutes == 1) {System.out.printf("\nYou've slept for an hour and a minute! o_o\n");}
                    else if(hours == 1) {System.out.printf("\nYou've slept for an hours and %d minutes! :)\n", minutes);}
                    else if(minutes == 1) {System.out.printf("\nYou've slept for %d hours and a minute! c:\n", hours);}
                    else System.out.printf("\nYou slept for " + hours + " hours and " + minutes + " minutes! :D\n");
                }
            }
            static void iJamBangun() {
                boolean inputIsValid = false;
                while (!inputIsValid) {
                    try {
                        System.out.println("\nAt what time did you wake up? (Example = 03 50): ");
                        jam_bangun = tristaninput.nextInt();
                        menit_bangun = tristaninput.nextInt();
                        tristaninput.nextLine();
                        // check validity:
                        if((jam_bangun >= 24 || jam_bangun < 0) || (menit_bangun < 0 || menit_bangun >= 60)) {
                            inputIsValid = false; Main.pExcType("That's not a valid time!");
                        } else {inputIsValid = true;}
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
                        System.out.println("\nAt what time did you slept? (Example = 22 15): ");
                        jam_tidur = tristaninput.nextInt();
                        menit_tidur = tristaninput.nextInt();
                        tristaninput.nextLine();
                        // check validity:
                        if((jam_tidur >= 24 || jam_tidur < 0) || (menit_tidur < 0 || menit_tidur >= 60)) {
                            inputIsValid = false; Main.pExcType("That's not a valid time!");
                        } else {inputIsValid = true;}
                    } catch (Exception e) {
                        Main.pExcType("Please enter the hour and minutes in a valid format: $HOUR $MINUTES");
                        tristaninput.nextLine();
                    }
                }
            }
            static void pWelcome() {
                System.out.println("\nWelcome to the Tristan's Sleep Duration Calculator!\n");
                System.out.println("Write time in the 24 hour format!");
                System.out.println("Write '24 00' as '00 00' !");
            System.out.println("\n(Tristan gave the idea, and Deffreus made the code)\n");
            }
        }

        class Anton { // mau bikin morse code translator katanya
            static Scanner BAPAKMU = new Scanner(System.in); // Amrul lo yang namain
            static String dictionary[][] = {{"A" ,"B"   ,"C"   ,"D"  ,"E","F"   ,"G"  ,"H"   ,"I" ,"J"   ,"K"  ,"L"   ,"M" ,"N" ,"O"  ,"P"   ,"Q"   ,"R"  ,"S"  ,"T","U"  ,"V"   ,"W"  ,"X"   ,"Y"   ,"Z"   }, 
                                            {".-","_...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."} };
            static boolean isEnded, isRunning;
            static String input, result;
            static int mode;
            static void run() {;
                isRunning = true;
                isEnded = false;
                while(isRunning) {
                    input = "";
                    Main.clear();
                    pWelcome();
                    iMode();
                    iInput();
                    if(mode == 1) {LetterToMorse();}
                    else if(mode == 2) {MorseToLetter();};
                    pResult();
                    iQuit();
                    if(isEnded) {isRunning = false;}
                }
            }
            static void pWelcome() {
                Main.hr();
                System.out.println("\nWelcome to Anton's Morse Code Translator!");
                System.out.println("\"Thanks to Amrul for the program idea!\" — Deffreus");
                System.out.println("\n*Note: This program DO NOT accept input that's not alphabet or morse code!\n");
                Main.hr();
            }
            static void iMode() {
                boolean inputIsValid = false;
                while(!inputIsValid) {
                    System.out.println("\nSelect translation mode\n1 = Alphabet --> Morse Code\n2 = Morse Code --> Alphabet\n(Enter the number):");
                    try {
                        mode = Integer.parseInt(BAPAKMU.nextLine());
                        switch(mode) {
                            case 1:
                                inputIsValid = true;
                                break;
                            case 2:
                                inputIsValid = true;
                                break;
                            default:
                                Main.pExcType("Please enter either '1' or '2'!");
                                break;
                        }
                    } 
                    catch(Exception e) {
                        Main.pExcType("Please enter either '1' or '2'!");
                    }
                }
            }
            static void iInput() {
                System.out.println("\nType what you want to be translated:");
                if(mode == 1) {System.out.println("(Alphabets):");} else {System.out.println("(Morse code):");}
                input = (BAPAKMU.nextLine()).toUpperCase();
            }
            static void LetterToMorse() {
                result = "";
                char[] charsOfInput = input.toCharArray();
                for(int i = 0; i < charsOfInput.length; i++) {
                    for(int j = 0; j < dictionary[0].length; j++) {
                        if(String.valueOf(charsOfInput[i]).equals(dictionary[0][j])) {
                            result = result.concat(dictionary[1][j] + " "); 
                            break;
                        }
                    }
                }
                System.out.println("\n(Morse code):");
            }
            static void MorseToLetter() {
                result = "";
                String currentMorseLetter[] = input.split(" ", 0);
                for(int i = 0; i < currentMorseLetter.length; i++) {
                    for(int j = 0; j < dictionary[1].length; j++) {
                        if(currentMorseLetter[i].equals(dictionary[1][j])) {
                            // result.concat(dictionary[0][j]); // idk why, but this just doesn't work
                            result = result + dictionary[0][j];
                            break;
                        }
                    }
                }
                System.out.println("\n(Alphabets):"); 
            }
            static void pResult() {
                System.out.println(result);
            }
            static void iQuit() {
                System.out.println("\nDo you want to translate again?\n(Y/n):");
                boolean inputIsValid = false;
                while(!inputIsValid) {
                    String quit = BAPAKMU.nextLine();
                    switch(quit) {
                        case "Y":
                        case "y":
                        case "Yes":
                        case "yes":
                        case "YES":
                        case "":
                            inputIsValid = true;
                            isEnded = false;
                            break;
                        case "n":
                        case "N":
                        case "No":
                        case "no":
                        case "NO":
                            inputIsValid = true;
                            isEnded = true;
                            pQuit(3);
                            break;
                        default:
                            Main.pExcType("Invalid: response unknown.");
                            break;
                    }
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
