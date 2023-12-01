import java.util.Scanner;

// Let start over again:

public class Volgion {
    public static void main(String[ ] args) {
        Scanner input = new Scanner(System.in);
        
        class main {
            private static String[] programs = {"Coffee Shop (WIP)"};
            // private static String[][] contributors = {{"Muhammad Alfin Azza Pujaar"}};
            static int getProgramsCount() {
                return programs.length;
            }
            static void hr() {
                System.out.println("===============================================================================");
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
                System.out.println("__     __   ___    _        ____   ___    ___    _   _ \n" + //
                        "\\ \\   / /  / _ \\  | |      / ___| |_ _|  / _ \\  | \\ | |\n" + //
                        " \\ \\ / /  | | | | | |     | |  _   | |  | | | | |  \\| |\n" + //
                        "  \\ V /   | |_| | | |___  | |_| |  | |  | |_| | | |\\  |\n" + //
                        "   \\_/     \\___/  |_____|  \\____| |___|  \\___/  |_| \\_|\n" + //
                        "");
                System.out.println("\nYou can contribute to this project here: https://github.com/DeffreusTheda/ComSci");
                System.out.println("Please report any bug here:\n    Email      : muhammad.alfin@praditadirgantara.sch.id\n    Discord    : deffreus (recommended)\n    WA         : +62 895-8077-31515");
            }
            static void pMainMenu() {
                System.out.println("\nPrograms menu:");
                for(int i = 0; i < getProgramsCount(); i++) {
                    System.out.println((i+1) + " = " + getProgramsName(i));
                }
            }
            static void pExcType(String message) {
                System.out.println("main.pExcType: (ERROR: INVALID INPUT): " + message);
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
                    case "help":
                        help();
                        break;
                    default:
                        main.pExcType("coffeeShop.command()");
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
                System.out.println("\nAvailable commands: \n'menu'      : show the items menu.\n'add'       : add an item and its amount to the order list.\n'remove'    : remove an amount of item from the order list\n'list'      : display your current orders list.\n'reset'     : discard the order list and make a new one.\n'done'      : finish choosing and purchase your order list.\n'help'      : show this help menu.\n");
            }
            static void   run() {
                pWelcome();
                help();
                while (coffeeShop.csrun) {
                    coffeeShop.csrun = false;
                    try {
                        main.hr();
                        System.out.println("\nEnter your command: ");
                        String iCommand = csinput.nextLine();
                        command(iCommand);
                        if(coffeeShop.end == false) {
                            coffeeShop.csrun = true;
                        }
                    } catch (Exception e) {
                        main.pExcType("coffeeShop.run()");
                        csinput.nextLine();
                        coffeeShop.csrun = true;
                    }
                }
            }
            static void   pMenu() {
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
                        main.pExcType("coffeeShop.iAdd().while(bindex)");
                        csinput.nextLine();
                        bindex = true;
                    }
                }
                if(index == 0) {
                    System.out.println("Cancelling adding item...");
                } else {
                    System.out.println("Selecting : " + items[index-1] + " (" + prices[index-1] + "K)");
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
                            main.pExcType("coffeeShop.iAdd().while(bcount)");
                            csinput.nextLine();
                            bcount = true;
                            
                        }
                    }
                    if(count == 0) {
                        System.out.println("Cancelling adding item...");
                    } else {
                        orders[index-1] += count;
                    }
                }
            }
            static void   iRemove() {
                boolean isEmpty = true;
                for(int i = 0; i < getOrdersCount(); i++) {
                    if(orders[i] != 0) {
                        isEmpty = false;
                        break;
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
                            System.out.println("\nEnter the index number of the item you want to remove: ");
                            index = csinput.nextInt();
                            csinput.nextLine();
                            if(index < 0 || index > getItemsCount()) {
                                System.out.println("(OUT OF RANGE) Please enter an integer between 0 to " + getItemsCount() + " (Inclusive) !");
                                bindex = true;
                            }
                        } catch (Exception e) {
                            main.pExcType("coffeeShop.iAdd().while(bindex)");
                            csinput.nextLine();
                            bindex = true;
                        }
                    }
                    if(index == 0) {
                        System.out.println("Cancelling removing item...");
                    } else {
                        System.out.println("Selecting : " + items[index-1] + " (" + prices[index-1] + "K)");
                        while (bcount) {
                            bcount = false;
                            try {
                                System.out.println("\nHow many do you want to remove?");
                                count = csinput.nextLong();
                                csinput.nextLine();
                                if (count < 0) {
                                    System.out.println("(OUT OF RANGE) Please enter a non-negative integer number!");
                                    bcount = true;
                                }
                            } catch (Exception e) {
                                main.pExcType("coffeeShop.iAdd().while(bcount)");
                                csinput.nextLine();
                                bcount = true;
                                
                            }
                        }
                        if(count == 0) {
                            System.out.println("Cancelling removing item...");
                        } else if (count >= orders[index-1]) {
                            System.out.println("Removed all " + items[index-1]);
                            orders[index-1] = 0;
                        } else {
                            System.out.println("Removed " + count + " " + items[index-1]);
                            orders[index-1] -= count;
                        }
                    }
                }
            }
            static void   resetList() {
                for(int i = 0; i < getOrdersCount(); i++) {
                    orders[i] = 0;
                }
                System.out.println("List have been discarded!");
            }
            static void   done() {
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
                            System.out.println("You didn't buy anyting for now...\nCome back later!");
                            coffeeShop.csrun = false;
                            coffeeShop.end = true;
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
                            main.hr();
                            main.hr();
                            break;
                        default:
                            System.out.println("Purchase cancelled, going back to listing your order!");
                            break;
                    }
                }
                
            }
            static void   pWelcome() {
                main.hr();
                System.out.println("\nWelcome to the Volgion's Coffee Shop!\n\n(If your total purchase reach Rp. 100K, you will get a 15% discount!)\nWhat will be your order?\n");
                coffeeShop.pMenu();
            }
        }
        boolean run = true;
        while(run) {
            try {
                main.pbanner();
                main.pMainMenu();
                System.out.println("\nSelect the program you want to run: ");
                switch (input.nextLine()) {
                    case "Coffee Shop":
                    case "1":
                        coffeeShop.run();
                        break;
                    default:
                        break;
                }
            } catch(Exception e) {
                main.pExcType("while(run)");
            }
        }
        input.close();
    }
}
