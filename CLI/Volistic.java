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

public class Volistic {
    static boolean run;
    static boolean onLoginPage = true;
    static void tryCloseLoginPage(LoginPage ow) {
        if(LoginPage.authenticationSuccessful) {
            try {
                Thread.sleep(1000);
            } catch(Exception e) {
                Main.printInvalidInputException("Thread sleep exception.");
            }
            ow.dispose();
            onLoginPage = false;
        }
    }
    public static void main(String[] args) {
        LoginPage lp = new LoginPage();
        while(onLoginPage) {
            tryCloseLoginPage(lp);
            try {
                Thread.sleep(17);
            } catch(Exception e) {
                Main.printInvalidInputException("Thread sleep exception.");
            }
        }
        Scanner input = new Scanner(System.in);
        boolean run = true;
        try {
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
                    case "exit", "quit", "q": Main.quit(); run = false;
                }
            }
        } catch (Exception e) {
            Main.printInvalidInputException("Something went wrong. Please report immediately to: deffreus (Discord). Sorry for the inconvenience T-T");
            if (input.hasNextLine()) {input.nextLine();}
            try {Thread.sleep(2000);} catch (Exception ee) {Main.printInvalidInputException("Thread sleep error.");}
        }
        input.close();
    }
}
