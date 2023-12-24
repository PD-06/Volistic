package CLI;

import java.util.Scanner;

public class Anton { // mau bikin morse code translator katanya
            private final static Scanner BAPAKMU = new Scanner(System.in); // Amrul lo yang namain
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
                    if(mode == 1) {LetterToMorse();}
                    else if(mode == 2) {MorseToLetter();}
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
                    try {mode = Integer.parseInt(BAPAKMU.nextLine());}
                    catch(Exception e) {Main.pExcType("Please enter either '1' or '2'!");}
                    switch(mode) {
                        case 1, 2:
                            inputIsValid = true;
                            break;
                        default:
                            Main.pExcType("Please enter either '1' or '2'!");
                            break;
                    }
                }
            }
            static void iInput() {
                System.out.println("\nType what you want to be translated:");
                if(mode == 1) {System.out.println("(Alphabets):");}
                else {System.out.println("(Morse code):");}
                input = BAPAKMU.nextLine().toUpperCase();
            }
            static void LetterToMorse() {
                result = "";
                boolean pure = true;
                for (char c : input.toCharArray()) {
                    for (int j = 0; j < dictionary[0].length; j++) {
                        if (String.valueOf(c).equals(dictionary[0][j])) {
                            result = result.concat(dictionary[1][j] + " ");
                            break;
                        } else if(String.valueOf(c).equals(" ")) {result = result.concat("   ");}
                        else {
                            result = result.concat(c + " ");
                            pure = false;
                        }
                    }
                }
                if(!pure) {System.out.println("\n(Morse code):");}
                else {System.out.println("\n(Almost morse code):");}
            }
            static void MorseToLetter() {
                result = "";
                for (String s : input.split(" ", 0)) {
                    for (int j = 0; j < dictionary[1].length; j++) {
                        if (s.equals(dictionary[1][j])) {
                            result = result.concat(dictionary[0][j]);
                            break;
                        } else if (s.isEmpty()) {result = result.concat(" ");}
                        else {result = result.concat("?");}
                    }
                }
                System.out.println("\n(Alphabets):"); 
            }
            static void pResult() {System.out.println(result);}
            static void iQuit() {
                System.out.print("\n\nDo you want to translate again?\n(Y/n):");
                boolean inputIsValid = false;
                while(!inputIsValid) {
                    String quit = BAPAKMU.nextLine().toLowerCase();
                    switch(quit) {
                        case "y","yes","yeah","yup","yoi","yep","aye","":
                            inputIsValid = true;
                            isEnded = false;
                            break;
                        case "n","no","nah","nope","nay":
                            inputIsValid = true;
                            isEnded = true;
                            pQuit();
                            break;
                        default:
                            Main.pExcType("Invalid: response unknown.");
                            break;
                    }
                }
            }
            static void pQuit() {
                System.out.println("\nQuitting in:");
                for (int i = 3; i > 0; i--) {
                    System.out.println(i + "...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Something went wrong...");
                    }
                } 
            }
        }