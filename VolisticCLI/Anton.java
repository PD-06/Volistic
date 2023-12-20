package VolisticCLI;

import java.util.Scanner;

public class Anton { // mau bikin morse code translator katanya
            static Scanner BAPAKMU = new Scanner(System.in); // Amrul lo yang namain
            static String dictionary[][] = {{"A" ,"B"   ,"C"   ,"D"  ,"E","F"   ,"G"  ,"H"   ,"I" ,"J"   ,"K"  ,"L"   ,"M" ,"N" ,"O"  ,"P"   ,"Q"   ,"R"  ,"S"  ,"T","U"  ,"V"   ,"W"  ,"X"   ,"Y"   ,"Z"   }, 
                                            {".-","_...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."} };
            static boolean isEnded, isRunning;
            static String input, result;
            static int mode;
            static void run() {;
                isRunning = true;
                isEnded = false;
                while(isRunning) {
                    input = "";
                    Main.clear();
                    pWelcome();
                    iMode();
                    iInput();
                    if(mode == 1) {LetterToMorse();}
                    else if(mode == 2) {MorseToLetter();};
                    pResult();
                    iQuit();
                    if(isEnded) {isRunning = false;}
                }
            }
            static void pWelcome() {
                Main.hr();
                System.out.println("\nWelcome to Anton's Morse Code Translator!");
                System.out.println("\"Thanks to Amrul for the program idea!\" — Deffreus");
                System.out.println("\n*Note: This program DO NOT accept input that's not alphabet or morse code!\n");
                Main.hr();
            }
            static void iMode() {
                boolean inputIsValid = false;
                while(!inputIsValid) {
                    System.out.println("\nSelect translation mode\n1 = Alphabet --> Morse Code\n2 = Morse Code --> Alphabet\n(Enter the number):");
                    try {
                        mode = Integer.parseInt(BAPAKMU.nextLine());
                        switch(mode) {
                            case 1:
                                inputIsValid = true;
                                break;
                            case 2:
                                inputIsValid = true;
                                break;
                            default:
                                Main.pExcType("Please enter either '1' or '2'!");
                                break;
                        }
                    } 
                    catch(Exception e) {
                        Main.pExcType("Please enter either '1' or '2'!");
                    }
                }
            }
            static void iInput() {
                System.out.println("\nType what you want to be translated:");
                if(mode == 1) {System.out.println("(Alphabets):");} else {System.out.println("(Morse code):");}
                input = (BAPAKMU.nextLine()).toUpperCase();
            }
            static void LetterToMorse() {
                result = "";
                char[] charsOfInput = input.toCharArray();
                for(int i = 0; i < charsOfInput.length; i++) {
                    for(int j = 0; j < dictionary[0].length; j++) {
                        if(String.valueOf(charsOfInput[i]).equals(dictionary[0][j])) {
                            result = result.concat(dictionary[1][j] + " "); 
                            break;
                        }
                    }
                }
                System.out.println("\n(Morse code):");
            }
            static void MorseToLetter() {
                result = "";
                String currentMorseLetter[] = input.split(" ", 0);
                for(int i = 0; i < currentMorseLetter.length; i++) {
                    for(int j = 0; j < dictionary[1].length; j++) {
                        if(currentMorseLetter[i].equals(dictionary[1][j])) {
                            // result.concat(dictionary[0][j]); // idk why, but this just doesn't work
                            result = result + dictionary[0][j];
                            break;
                        }
                    }
                }
                System.out.println("\n(Alphabets):"); 
            }
            static void pResult() {
                System.out.println(result);
            }
            static void iQuit() {
                System.out.println("\nDo you want to translate again?\n(Y/n):");
                boolean inputIsValid = false;
                while(!inputIsValid) {
                    String quit = BAPAKMU.nextLine();
                    switch(quit) {
                        case "Y":
                        case "y":
                        case "Yes":
                        case "yes":
                        case "YES":
                        case "":
                            inputIsValid = true;
                            isEnded = false;
                            break;
                        case "n":
                        case "N":
                        case "No":
                        case "no":
                        case "NO":
                            inputIsValid = true;
                            isEnded = true;
                            pQuit(3);
                            break;
                        default:
                            Main.pExcType("Invalid: response unknown.");
                            break;
                    }
                }
            }
            static void pQuit(int duration) {
                System.out.println("\nQuitting in:");
                for (int i = duration; i > 0; i--) {
                    System.out.println(i + "...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Something went wrong...");
                    }
                } 
            }
        }