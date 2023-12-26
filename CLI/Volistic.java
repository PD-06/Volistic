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
