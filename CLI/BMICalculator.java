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

import java.util.Scanner;

public class BMICalculator {
    // Program variables declaration
    private static boolean end;
    private static String fullName, category;
    private static final Scanner sc = new Scanner(System.in);
    private static double weight, height, bmi;

    // Similar to 'public static void main(String[] args)'
    static void run() {
        end = false;
        while (!end) {
            try {
                Main.clear();
                pWelcome();
                iName();
                iWeight();
                iHeight();
                calcBMI(weight, height);
                pResult();
                iQuit();
            } catch (Exception e) {
                System.out.println("BMI Calculator crashed. Please contact: deffreus (Discord)");
            }
        }
    }
    // Print a welcome message
    static void pWelcome() {
        Main.printHorizontalLine();
        System.out.println("\nWelcome to the Volistic BMI Calculator!\n");
        Main.printHorizontalLine();
    }
    // Ask for user's name
    static void iName() {
        System.out.print("\nEnter your full name (blank to skip): ");
        fullName = sc.nextLine();
        if (!fullName.isEmpty()) System.out.println("\nHello, " + fullName + "!");
    }
    // Ask for user's weight
    static void iWeight() {
        boolean inputIsValid = false;
        while (!inputIsValid) { //
            try {
                System.out.print("\nEnter your weight in kg: ");
                weight = Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Something is wrong with your weight");
                continue;
            }
            if (weight > 635) System.out.println("I don't think you can be that fat.");
            else if (weight <= 0) System.out.println("What are you?");
            else if (weight < 0.25) System.out.println("Are you a toothpick?");
            else inputIsValid = true;
        }
    }
    static void iHeight() {
        boolean inputIsValid = false;
        while (!inputIsValid) {
            try {
                System.out.print("\nEnter your height in cm: ");
                height = Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Something is wrong with your height.");
                continue;
            }
            if      (height > 272) System.out.println("Even the tallest man in the world, Robert Wadlow, doesn't reach that height.");
            else if (height <= 0) System.out.println("What are you?");
            else if (height < 25) System.out.println("A medium-sized banana is longer than you.");
            else inputIsValid = true;
        }
    }
    static void calcBMI(double w, double h) {
        bmi = w / (h * h * 0.0001); // 0.0001: cm squared --> m squared
        if      (bmi < 16)    category = "Underweight (Severe thinness)";
        else if (bmi <= 16.9) category = "Underweight (Moderate thinness)";
        else if (bmi <= 18.4) category = "Underweight (Mild thinness)";
        else if (bmi < 24.9)  category = "Normal";
        else if (bmi <= 29.9) category = "Overweight (Pre-obese)";
        else if (bmi <= 34.9) category = "Obese (Class I)";
        else if (bmi <= 39.9) category = "Obese (Class II)";
        else                  category = "Obese (Class III)";
    }
    static void pResult() {
        System.out.println("\n");
        if (!fullName.isEmpty()) System.out.println("Here is your result, " + fullName + ":");
        System.out.println("Your weight      : " + Main.wholeDouble2Int(weight) + " kg");
        System.out.println("Your height      : " + Main.wholeDouble2Int(height) + " cm");
        System.out.printf( "Your BMI index   : %.1f\n", bmi);
        System.out.print("\nYou're categorized as: " + category);
    }
    // Ask user if they want to repeat calculation
    static void iQuit() {
        System.out.println("\n");
        boolean inputIsValid = false;
        while(!inputIsValid) {
            System.out.print("\nDo you want to calculate again? (Y/n): ");
            switch (sc.nextLine().trim().toLowerCase()) {
                case "y","yes","yeah","yup","yoi","yep","aye","ye","":
                    inputIsValid = true;
                    break;
                case "n","no","nah","nope","nay":
                    end = true;
                    inputIsValid = true;
                    break;
                default:
                    Main.printExceptionInvalidInput("Response unknown");
                    break;
            }
        }
        if (end) printQuit();
    }
    // Print a 3-second quit timer
    static void printQuit() {
        System.out.println("\nQuitting in:");
        for (int i = 3; i > 0; i--) {
            System.out.println(i + "...");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                Main.printExceptionInvalidInput("Thread sleep exception");
            }
        }
    }
}