package CLI;

import java.util.*;

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
                    // SCOPE FOR EDIT (START)
                    /*
                     * You can do this for switch statement
                     * Please include these as a valid identity for your program:
                     *     Name of your file (lower case & Title Case)
                     *     Program's index number
                     *     Program name shorthand (Optional)
                     * "More is better" - An opinion
                     */
                    case "Example":
                    case "example":
                    case "1":
                    case "e.g":
                    case "eg":
                    case "ex.":
                    case "ex":
                        Example.run();
                        break;
                    // SCOPE FOR EDIT (END)
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
