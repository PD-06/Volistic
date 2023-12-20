package VolisticCLI;

import java.util.*;

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

public class Volistic {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean run = true;
        while (run) {
            try {
                Main.clear();
                Main.pBanner();
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
                    case "Morse":
                    case "morse":
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
