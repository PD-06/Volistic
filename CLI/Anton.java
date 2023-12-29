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

public class Anton { // Amrul named it
            private final static Scanner BAPAKMU = new Scanner(System.in); // Amrul named it
            private final static String[][] dictionary = { {"A" ,"B"   ,"C"   ,"D"  ,"E","F"   ,"G"  ,"H"   ,"I" ,"J"   ,"K"  ,"L"   ,"M" ,"N" ,"O"  ,"P"   ,"Q"   ,"R"  ,"S"  ,"T","U"  ,"V"   ,"W"  ,"X"   ,"Y"   ,"Z"   ,"0"    ,"1"    ,"2"    ,"3"    ,"4"    ,"5"    ,"6"    ,"7"    ,"8"    ,"9"    },
                                                           {".-","_...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..","-----",".----","..---","...--","....-",".....","-....","--...","---..","----."} };
            private static boolean isEnded;
            private static String input, result;
            private static int mode;
            static void run() {
                boolean isRunning = true;
                isEnded = false;
                while(isRunning) {
                    input = "";
                    Main.clear();
                    pWelcome();
                    iMode();
                    iInput();
                    if (mode == 1) {LetterToMorse();}
                    else if (mode == 2) {MorseToLetter();}
                    pResult();
                    iQuit();
                    if (isEnded) isRunning = false;
                }
            }
            static void pWelcome() {
                Main.printHorizontalLine();
                System.out.println("\nWelcome to Anton's Morse Code Translator!");
                System.out.println("\n*Note: 3 space in morse = 1 space in alphabets, and vice versa!\n");
                Main.printHorizontalLine();
            }
            static void iMode() {
                boolean inputIsValid = false;
                while(!inputIsValid) {
                    mode = 0;
                    System.out.print("\nSelect translation mode\n1 = Alphabet --> Morse Code\n2 = Morse Code --> Alphabet\n(Enter the number): ");
                    try {mode = Integer.parseInt(BAPAKMU.nextLine());}
                    catch(Exception e) {Main.printExceptionInvalidInput("Please enter either '1' or '2'!");}
                    switch (mode) {
                        case 1, 2:
                            inputIsValid = true;
                            break;
                        default: Main.printExceptionInvalidInput("Not '1' or '2'");
                    }
                }
            }
            static void iInput() {
                System.out.println("\n\nType what you want to be translated:");
                if (mode == 1) {System.out.println("(Alphabets): ");}
                else {System.out.println("(Morse code): ");}
                input = BAPAKMU.nextLine().toUpperCase();
            }
            static void LetterToMorse() {
                result = "";
                boolean pure = true;
                for (char c : input.toCharArray()) {
                    boolean found = false;
                    if (String.valueOf(c).equals(" ")) {
                        result = result.concat("  ");
                        found = true;
                    } else for (int j = 0; j < dictionary[0].length; j++) {
                        if (String.valueOf(c).equals(dictionary[0][j])) {
                            result = result.concat(dictionary[1][j] + " ");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        result = result.concat(String.format("%s%s %s",AnsiColor.RED,c,AnsiColor.RESET));
                        pure = false;
                    }
                }
                if (pure) {System.out.println("\n(Morse code):");}
                else {System.out.println("\n(Almost morse code):");}
            }
            static void MorseToLetter() {
                result = "";
                int emptyCount = 1;
                for (String s : input.split(" ", 0)) {
                    boolean found = false;
                    if (s.isEmpty()) {
                        emptyCount++;
                        if(emptyCount==3) {
                            result = result.concat(" ");
                            emptyCount = 0;
                        }
                        continue;
                    } else for (int j = 0; j < dictionary[1].length; j++) {
                        if (s.equals(dictionary[1][j])) {
                            result = result.concat(dictionary[0][j]);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {result = result.concat("?");}
                }
                System.out.println("\n(Alphabets):"); 
            }
            static void pResult() {System.out.printf("%s\n",result);}
            static void iQuit() {
                boolean inputIsValid = false;
                while(!inputIsValid) {
                    System.out.print("\nTranslate again? (Y/n): ");
                    String quit = BAPAKMU.nextLine().trim().toLowerCase();
                    switch (quit) {
                        case "y","yes","yeah","yup","yoi","yep","aye","":
                            inputIsValid = true;
                            isEnded = false;
                            break;
                        case "n","no","nah","nope","nay":
                            inputIsValid = true;
                            isEnded = true;
                            printQuit();
                            break;
                        default: Main.printExceptionInvalidInput("Response unknown");
                    }
                }
            }
            static void printQuit() {
                System.out.println("\nQuitting in:");
                for (int i = 3; i > 0; i--) {
                    System.out.println(i + "...");
                    try {Thread.sleep(1000);}
                    catch (InterruptedException e) {System.out.println("Something went wrong...");}
                } 
            }
        }