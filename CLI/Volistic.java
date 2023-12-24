package CLI;

import java.util.*;

// Let start over again:
/*
 * Hello friends!
 * Here, you can change the code however you want,
 * Lines that start with '#' is a command, press Command + Shift + P adn then type the following command!
 * 
 * If you want to publish the changes you made:
 * # Git: Commit
 * # Git: Push
 * 
 * Also, don't forget to Fetch frequently
 * # Git: Fetch
 */

public class Volistic {
    static boolean run;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        run = true;
        while (run) {
            Main.clear();
            Main.pBanner();
            Main.pQuit();
            Main.pMainMenu();
            System.out.print("\nSelect the program you want to run: ");
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
                    Main.quit();
                    break;
            }
        }
        input.close();
    }
}
