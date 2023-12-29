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

public class Tristan {
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean end;
    private static int sleepTime, wakeUpTime;

    static void run() {
        boolean isRunning = true;
        end = false;
        while (isRunning) {
            isRunning = false;
            try {
                Main.clear();
                printWelcome();
                inputSleepTime();
                inputWakeUpTime();
                printResult();
                iQuit();
                if (!end) isRunning = true;
            } catch (Exception e) {System.out.printf("%sCalculator crashed.%s",AnsiColor.RED,AnsiColor.RESET);}
        }
    }
    static void printWelcome() {
        Main.printHorizontalLine();
        System.out.println("\nWelcome to Tristan's Sleep Duration Calculator!\n");
        System.out.println("Note: Please use the 24 hour format!\n");
        Main.printHorizontalLine();
    }
    static void inputSleepTime() {
        boolean inputIsValid = false;
        int sleepHour, sleepMinute;
        while (!inputIsValid) {
            System.out.print("\nEnter the time when you start sleeping (HH:MM): ");
            char[] input = Main.noSpace(scanner.nextLine()).toCharArray();
            if (input.length!=5) {
                printInvalidFormat();
                continue;
            }
            if (input[2]!=':') {
                printInvalidFormat();
                continue;
            }
            try {
                sleepHour = Integer.parseInt(String.valueOf(input[0])) * 10 + Integer.parseInt(String.valueOf(input[1]));
            } catch (Exception e) {
                printInvalidFormat();
                continue;
            }
            if (sleepHour>24) {
                printInvalidTime();
                continue;
            }
            try {
                sleepMinute = Integer.parseInt(String.valueOf(input[3])) * 10 + Integer.parseInt(String.valueOf(input[4]));
            } catch (Exception e) {
                printInvalidFormat();
                continue;
            }
            if (sleepMinute>=60) {
                printInvalidTime();
                continue;
            }
            sleepTime = sleepHour * 60 + sleepMinute;
            if (sleepTime>1440) {
                printInvalidTime();
                continue;
            }
            inputIsValid = true;
        }
    }
    static void printInvalidFormat() {Main.printExceptionInvalidInput("Not in format 'HH:MM'");}
    static void printInvalidTime() {Main.printExceptionInvalidInput("Invalid time");}
    static void inputWakeUpTime() {
        boolean inputIsValid = false;
        int wakeUpHour, wakeUpMinute;
        while (!inputIsValid) {
            System.out.print("\nEnter the time when you wake up (HH:MM): ");
            char[] input = Main.noSpace(scanner.nextLine()).toCharArray();
            if (input.length!=5) {
                printInvalidFormat();
                continue;
            }
            if (input[2]!=':') {
                printInvalidFormat();
                continue;
            }
            try {wakeUpHour = Integer.parseInt(String.valueOf(input[0])) * 10 + Integer.parseInt(String.valueOf(input[1]));}
            catch (Exception e) {printInvalidFormat(); continue;}
            if (wakeUpHour>24) {
                printInvalidTime();
                continue;
            }
            try {wakeUpMinute = Integer.parseInt(String.valueOf(input[3])) * 10 + Integer.parseInt(String.valueOf(input[4]));}
            catch (Exception e) {
                printInvalidFormat();
                continue;
            }
            if (wakeUpMinute>=60) {
                printInvalidTime();
                continue;
            }
            wakeUpTime = wakeUpHour * 60 + wakeUpMinute;
            if (wakeUpTime>1440) {
                printInvalidTime();
                continue;
            }
            inputIsValid = true;
        }
    }
    static void printResult() {
        if (sleepTime > wakeUpTime) wakeUpTime += (24*60);
        int durationHour = (wakeUpTime-sleepTime)/60;
        int durationMinute = (wakeUpTime-sleepTime)%60;
        if (durationHour+durationMinute == 0) {System.out.print("\nYou sleep in less than a minute or what? :O\n");}
        else if (durationHour == 0 && durationMinute != 0) {
            if (durationMinute == 1) {System.out.print("\nYou've slept for a minute! XD\n");}
            else {System.out.printf("\nYou've slept for %d minutes! :v\n", durationMinute);}
        }
        else if (durationHour != 0 && durationMinute == 0) {
            if (durationHour == 1) System.out.print("\nYou've slept for an hour! :p\n");
            else {System.out.printf("\nYou've slept for %d hours! :>\n", durationHour);}
        }
        else {
            if (durationHour == 1 && durationMinute == 1) {System.out.print("\nYou've slept for an hour and a minute! o_o\n");}
            else if (durationHour == 1) {System.out.printf("\nYou've slept for an hour and %d minutes! :)\n", durationMinute);}
            else if (durationMinute == 1) {System.out.printf("\nYou've slept for %d hours and a minute! c:\n", durationHour);}
            else System.out.printf("\nYou slept for %s hours and %d minutes! :D\n", durationHour, durationMinute);
        }
    }
    static void iQuit() {
        String opt;
        boolean valid = false;
        while (!valid) {
            System.out.println("\nDo you want calculate again? (Y/n)");
            opt = scanner.nextLine().trim().toLowerCase();
            valid = true;
            switch (opt) {
                case "y", "yes", "yeah", "yup", "yoi", "yep", "aye", "ye", "":
                    end = false;
                    break;
                case "n", "no", "nah", "nope", "nay":
                    end = true;
                    System.out.println("\nThank you for using the Sleep Duration Calculator!! :D");
                    printQuit();
                    break;
                default:
                    Main.printExceptionInvalidInput("Response unknown.");
                    valid = false;
            }
        }
    }
    static void printQuit() {
        System.out.println("\nQuitting in:");
        for (int i = 3; i > 0; i--) {
            System.out.println(i + "...");
            try {
                Thread.sleep(1000);
            } catch(Exception e) {
                Main.printRed("Thread sleep exception found");
            }
        }
    }
}