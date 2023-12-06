import java.util.Scanner;

// Let start over again:

public class Volgion {
    public static void main(String[ ] args) {
        class ansiColor {
            public static String red = "\u001B[31m";
            public static String reset = "\u001B[0m";
        }
        Scanner input = new Scanner(System.in);

        class main {
            private static String[] programs = {"Coffee Shop", "BMI Calculator (EXPERIMENTAL)"};
            private static String programVersion = "1.0", "0.1";
            // private static String[][] contributors = {{"Muhammad Alfin Azza Pujaar"}};
            public static void clear() {  
                System.out.print("\033[H\033[2J");  
                System.out.flush();  
            }
            static int getProgramsCount() {
                return programs.length;
            }
            static void hr() {
                System.out.println("================================================================================");
            }
            /*static void pContributors(int progId) {
                String noun = "";
                if(contributors[progId].length > 1) {
                    noun = "s";
                }
                System.out.println(programs[progId] + " awesome contributor" + noun + " : ");
                for(int i = 0; i < contributors[progId].length; i++) {
                    System.err.println(contributors[progId][i]);
                }
            }*/
            static String getProgramsName(int index) {
                return programs[index];
            }
            static void pbanner() {
                System.out.printf(ansiColor.red + "__     __   ___    _        ____   ___    ___    _   _ \n" + //
                        "\\ \\   / /  / _ \\  | |      / ___| |_ _|  / _ \\  | \\ | |\n" + //
                        " \\ \\ / /  | | | | | |     | |  _   | |  | | | | |  \\| |\n" + //
                        "  \\ V /   | |_| | | |___  | |_| |  | |  | |_| | | |\\  |\n" + //
                        "   \\_/     \\___/  |_____|  \\____| |___|  \\___/  |_| \\_|\n" + //
                        "");
                System.out.println("\nV" + programVersion);
                System.out.println("\nYou can contribute to this project here: https://github.com/DeffreusTheda/ComSci");
                System.out.println("Please report any bug here:\n    Email      : muhammad.alfin@praditadirgantara.sch.id\n    Discord    : deffreus (recommended)\n    WA         : +62 895-8077-31515" + ansiColor.reset);
            }
            static void pMainMenu() {
                System.out.println("\nPrograms menu:");
                for(int i = 0; i < getProgramsCount(); i++) {
                    System.out.println((i+1) + " = " + getProgramsName(i));
                }
            }
            static void pExcType(String message) {
                System.out.println(ansiColor.red + "main.pExcType: (ERROR: INVALID INPUT): " + message + ansiColor.reset);
            }
            static String nospace(String string) {
                String res = string.replaceAll("\\s", "");
                return res;
            }
        }

        class BMICalculator {
            static void run() {
                Scanner bmiInput = new Scanner(System.in);
                String fname;
                double weight, height, bmi;
                main.clear();
                System.out.println("Welcome to the Volgion's BMI Calculator!!");
                while(true) {
                    try {
                        System.out.println("\n\nWhat is your full name (Blank to skip)?");
                        fname = bmiInput.nextLine();
                        break;
                    } catch(Exception e) {
                        System.out.println("Something went wrong, please try again.");
                    }
                }
                while(true) {
                    try {
                        System.out.println("\nWhat is your weight in kilogram?");
                        weight = bmiInput.nextDouble();
                        break;
                    } catch(Exception e) {
                        System.out.println("Please enter a number!");
                        bmiInput.nextLine();
                    }
                }
                while(true) {
                    try {
                        System.out.println("\nWhat is your height in cm?");
                        height = bmiInput.nextDouble();
                        break;
                    } catch(Exception e) {
                        System.out.println("Please enter a number!");
                        bmiInput.nextLine();
                    }
                }
                bmi = weight/(height*height*0.0001);
                if(fname != "") System.out.println("\nHello, " + fname + "!");
                System.out.printf("Your BMI index is: %,.1f!\n", bmi);
                String category;
                if(bmi < 18.5) {
                   category = "Underweight"; 
                } else if(bmi <=  24.9) {
                    category = "Normal weight";
                } else if(bmi <= 29.9) {
                    category = "Overweight";
                } else if(bmi <= 34.9) {
                    category = "Obesity class I";
                } else if(bmi <= 39.9) {
                    category = "Obesity class II";
                } else {
                    category = "Obesity class III";
                }
                System.out.println("Your categorized as: " + category + "\n");
                while(true) {
                    System.out.println("\nPlease enter to quit.");
                    bmiInput.nextLine();
                    bmiInput.nextLine();
                    quit(3);
                    break;
                }
                bmiInput.close();
            }
            static void quit(int time) {
                try {
                    System.out.println("\n");
                    for(int t = time; t > 0; t--) {
                        System.out.println("Quitting in " + t + "...");
                        Thread.sleep(1000);
                    }
                } catch(Exception e) {

                }
            }
        }

        class coffeeShop {
            private static String[] items = {"Americano ", "Latte     ", "Cappuccino", "Espresso  ", "Arabica   ", "Mochaccino", "Tiramisu  ", "Robusta   ", "Liberica  ", "Excelso   ", "Affogato  "};
            private static int[] prices = {21, 24, 29, 19, 23, 33, 33, 30, 66, 95, 34};
            private static int[] orders = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            static boolean csrun = true, end = false;
            static Scanner csinput = new Scanner(System.in);
    
            // getter
            static int    getItemsCount() {
                return items.length;
            }
            static String getItems(int index) {
                return items[index];
            }
            static int    getPrices(int index) {
                return prices[index];
            }
            static int    getOrdersCount() {
                return orders.length;
            }
            
            // methods
            static void   command(String command) {
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
                        main.clear();
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
                        coffeeShop.end = true;
                        break;
                    case "help":
                        main.clear();
                        help();
                        break;
                    default:
                        main.clear();
                        main.pExcType("Command unknown.");
                        System.out.println("Type 'help' to display the help menu");
                        break;
                }
            }
            static void   list() {
                double total = 0, net = 0;
                boolean bdiscount = false, isEmpty = true;;
                for(int i = 0; i < getOrdersCount(); i++) {
                    if(orders[i] != 0) {
                        isEmpty = false;
                    }
                }
                if(isEmpty) {
                    System.out.println("Your list is empty, use 'add' to add an item.");
                } else {
                    for(int i = 0; i < getItemsCount(); i++) {
                        if(orders[i] != 0) {
                            System.out.println((i+1) + ". (" + orders[i] + " items) " + items[i] + " = (" + (orders[i] * getPrices(i)) + "K)");
                            total += (orders[i] * prices[i]);
                        }
                    }
                    System.out.printf("\nTotal price                = %,.0fK\n", total);
                    if(total >= 100) {
                        bdiscount = true;
                    }
                    if(bdiscount) {
                        net = (total * 0.85);
                    } else {
                        net = (int) total;
                    }
                    System.out.println("Discount (15%)             = " + bdiscount);
                    if((double) net == (int) net) {
                        System.out.println("Payment                    = " + (int) net + "K");
                    } else {
                        System.out.printf("Payment                    = %,.2fK\n", net);
                    }
                }
            }
            static void   help() {
                System.out.println("\nAvailable commands: \n'menu'      : show the items menu.\n'add'       : add an item and its amount to the order list.\n'remove'    : remove an amount of item from the order list\n'list'      : display your current orders list.\n'reset'     : discard the order list and make a new one.\n'done'      : finish choosing and purchase your order list.\n'quit'      : simply quit the program and goes back to Volgion main menu.\n'help'      : show this help menu.\n");
            }
            static void   run() {
                pWelcome();
                csrun = true;
                end = false;
                while (coffeeShop.csrun) {
                    coffeeShop.csrun = false;
                    try {
                        main.hr();
                        System.out.println("\nEnter your command: ");
                        command(csinput.nextLine());
                        if(coffeeShop.end == false) {
                            coffeeShop.csrun = true;
                        }
                    } catch (Exception e) {
                        main.pExcType("You're not supposed to see this message.\nIf you do, report with a screenshot here: deffreus (Discord)");
                        csinput.nextLine();
                        coffeeShop.csrun = true;
                    }
                }
            }
            static void   pMenu() {
                main.clear();
                System.out.println("\nAvailable items:");
                System.out.println(" 0 = (Cancel current command)");
                String space;
                for(int i = 0; i < getItemsCount(); i++) {
                    if(i < 9) {
                        space = " ";
                    } else {
                        space = "";
                    }
                    System.out.println(space + (i+1) + " = " + getItems(i) + "         (" + prices[i] + "K)");
                }
                System.out.println("\n");
            }
            static void   iAdd() {
                main.clear();
                pMenu();
                boolean bindex = true, bcount = true;;
                int index = 0;
                long count = 0;
                while (bindex) {
                    bindex = false;
                    try {
                        System.out.println("\nEnter the index number of the item you want to add: ");
                        index = csinput.nextInt();
                        csinput.nextLine();
                        if(index < 0 || index > getItemsCount()) {
                            System.out.println("(OUT OF RANGE) Please enter an integer between 0 to " + getItemsCount() + " (Inclusive) !");
                            bindex = true;
                        }
                    } catch (Exception e) {
                        main.pExcType("Please enter an integer number between 0 to " + getItemsCount() + " (Inclusive) !");
                        csinput.nextLine();
                        bindex = true;
                    }
                }
                if(index == 0) {
                    System.out.println("Cancelling adding item...");
                } else {
                    System.out.println("Selecting : " + main.nospace(items[index-1]) + " (" + prices[index-1] + "K)");
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
                            main.pExcType("Please enter a real integer number!");
                            csinput.nextLine();
                            bcount = true;
                            
                        }
                    }
                    if(count == 0) {
                        main.clear();
                        System.out.println("Cancelling adding item...");
                    } else {
                        main.clear();
                        orders[index-1] += count;
                        System.out.println("Your order list is updated successfully.\n");
                    }
                }
            }
            static void   iRemove() {
                main.clear();
                boolean isEmpty = true;
                int orderCount = 0, lastIndex = 0;
                for(int i = 0; i < getOrdersCount(); i++) {
                    if(orders[i] != 0) {
                        orderCount++;
                        isEmpty = false;
                        lastIndex = i+1;
                    }
                }
                if(isEmpty == true) {
                    System.out.println("Your list is empty, use 'add' to add an item.");
                } else {
                    System.out.println("Your current order list: ");
                    list();
                    boolean bindex = true, bcount = true;;
                    int index = 0;
                    long count = 0;
                    while (bindex) {
                        bindex = false;
                        try {
                            if(orderCount != 1) {
                                System.out.println("\nEnter the index number of the item you want to remove: ");
                                index = csinput.nextInt();
                                csinput.nextLine();
                                if(index < 0 || index > getItemsCount()) {
                                    System.out.println("(OUT OF RANGE) Please enter an integer between 0 to " + getItemsCount() + " (Inclusive) !");
                                    bindex = true;
                                } else if(orders[index-1] == 0) {
                                    System.out.println(main.nospace(items[index-1]) + " is not on your order list.");
                                }
                            } else {
                                index = lastIndex;
                            }
                        } catch (Exception e) {
                            main.pExcType("Please enter an integer between 0 to " + getItemsCount() + " (Inclusive) !");
                            csinput.nextLine();
                            bindex = true;
                        }
                    }
                    if(index == 0 || orders[index-1] == 0) {
                        System.out.println("Cancelling removing item...");
                    } else {
                        if(orderCount == 1) {
                            System.out.println("\nSelecting : " + main.nospace(items[index-1]) + " (" + prices[index-1] + "K)");
                        } else {
                            System.out.println("Selecting : " + main.nospace(items[index-1]) + " (" + prices[index-1] + "K)");
                        }
                        while (bcount) {
                            bcount = false;
                            try {
                                if(orderCount != 1) {
                                    System.out.println("\nHow many do you want to remove? (Type '0' to cancel)");
                                } else {
                                    System.out.println("\nHow many " + main.nospace(items[index-1]) + " do you want to remove? (Type '0' to cancel)");
                                }
                                count = csinput.nextLong();
                                csinput.nextLine();
                                if (count < 0) {
                                    System.out.println("(OUT OF RANGE) Please enter a non-negative integer number!");
                                    bcount = true;
                                }
                            } catch (Exception e) {
                                main.pExcType("Please enter a non-negative integer number!");
                                csinput.nextLine();
                                bcount = true;
                                
                            }
                        }
                        if(count == 0) {
                            System.out.println("Cancelling removing item...");
                        } else if (count >= orders[index-1]) {
                            System.out.println("Successfullly removed all " + main.nospace(items[index-1]) + ".");
                            orders[index-1] = 0;
                        } else {
                            System.out.println("Successfully removed " + count + " " + main.nospace(items[index-1]) + ".");
                            orders[index-1] -= count;
                        }
                    }
                }
            }
            static void   resetList() {
                main.clear();
                for(int i = 0; i < getOrdersCount(); i++) {
                    orders[i] = 0;
                }
                System.out.println("Your order list have been discarded!");
            }
            static void   done() {
                main.clear();
                boolean listIsEmpty = true;
                for(int i = 0; i < getItemsCount(); i++) {
                    if (orders[i] != 0) {
                        listIsEmpty = false;
                        break;
                    }
                }
                if(listIsEmpty) {
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
                            coffeeShop.csrun = false;
                            coffeeShop.end = true;
                            pQuit(3);
                            main.hr();
                            main.hr();
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
                            coffeeShop.csrun = false;
                            coffeeShop.end = true;
                            coffeeShop.resetVar();
                            coffeeShop.pQuit(5);;
                            break;
                        default:
                            System.out.println("Purchase cancelled, going back to listing your order!");
                    }
                }
            }
            static void   pWelcome() {
                main.clear();
                main.hr();
                System.out.println("\nWelcome to the Volgion's Coffee Shop!\n\n(If your total purchase reach Rp. 100K, you will get a 15% discount!)\nWhat will be your order?\n");
                help();
            }
            static void   resetVar() {
                for(int i = 0; i < getItemsCount(); i++) {
                    coffeeShop.orders[i] = 0;
                }
            }
            static void   pQuit(int duration) {
                System.out.println("\nQuitting in:");
                for(int i = duration; i > 0; i--) {
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
        while(run) {
            try {
                main.clear();
                main.pbanner();
                main.pMainMenu();
                System.out.println("\nSelect the program you want to run: ");
                String chosenProgram = input.nextLine();
                switch (chosenProgram) {
                    case "Coffee Shop":
                    case "1":
                        coffeeShop.run();
                        break;
                    case "BMI":
                    case "BMI Calculator":
                    case "2":
                        BMICalculator.run();
                        input.nextLine();
                        input.nextLine();
                        break;
                }
            } catch(Exception e) {
                main.pExcType("Something went wrong. Please report immediately to: deffreus (Discord). Sorry for the inconvenience T-T");
            }
        }
        input.close();
    }
}
