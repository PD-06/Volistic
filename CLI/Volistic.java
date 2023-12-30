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

<<<<<<< HEAD
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
            System.out.print("\nEnter the ID of the program that you want to run: ");
            String chosenProgram = input.nextLine().trim().toLowerCase();
            switch (chosenProgram) {
                case "coffee shop", "1", "coffee": CoffeeShop.run(); break;
                case "bmi", "bmi calculator", "2": BMICalculator.run(); break;
                case "3", "tvc", "two variable calculator": TwoVarCalculator.run(); break;
                case "4", "tristan", "sleep duration calculator": Tristan.run(); break;
                case "5", "anton", "morse": Anton.run(); break;
                case "exit", "quit", "q": Main.quit();
=======
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
    static boolean onLoginPage = true;
    static void tryCloseLoginPage(LoginPage ow) {
        if(LoginPage.authenticationSuccessful) {
            try {Thread.sleep(1000);} catch(Exception e) {Main.pExcType("Thread sleep exception.");}
            ow.dispose();
            onLoginPage = false;
        }
    }
    public static void main(String[] args) {
        LoginPage lp = new LoginPage();
        while(onLoginPage) {
            tryCloseLoginPage(lp);
            try {Thread.sleep(17);} catch(Exception e) {Main.pExcType("Thread sleep exception.");}
        }
        
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
                Main.pExcType("Something went wrong. Please report immediately to: deffreus (Discord). Sorry for the inconvenience T-T");
                if (input.hasNextLine()) {input.nextLine();}
                try {Thread.sleep(2000);} catch (Exception ee) {Main.pExcType("Thread sleep error.");}
>>>>>>> login-page-GUI
            }
        }
        input.close();
    }
}
