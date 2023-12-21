package CLI;

import java.util.Scanner;

public class TwoVarCalculator {
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
                        Main.pExcType(AnsiColor.RED + "CALCULATOR ERROR." + AnsiColor.RESET);
                    }
                }
                pQuit(3);
            }
            static void pQuit(int seconds) {
                System.out.println("\nThank you so much for using the Volistic Two Variable Calculator!! :D");
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
                System.out.println("\nWelcome to the Volistic's Two Variable Calculator!");
                System.out.println("(Enter 'quit' or 'exit' to exit)\n");
            }
        }