package VolisticCLI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tristan {
            static Scanner tristaninput = new Scanner(System.in);
            static boolean tristanIsRunning, tristanIsEnded;
            static int jam_tidur, menit_tidur, jam_bangun, menit_bangun;

            static void run() {
                tristanIsRunning = true;
                tristanIsEnded = false;
                while (tristanIsRunning) {
                    tristanIsRunning = false;
                    try {
                        Main.clear();
                        pWelcome();
                        iJamTidur();
                        iJamBangun();
                        pRes();
                        iQuit();
                        if (tristanIsEnded == false) {
                            tristanIsRunning = true;
                        }
                    } catch (Exception e) {
                        Main.pExcType(AnsiColor.RED + "CALCULATOR ERROR." + AnsiColor.RESET);
                    }
                }
            }
            static void pWelcome() {
                Main.hr();
                System.out.println("\nWelcome to the Tristan's Sleep Duration Calculator!\n");
                System.out.println("Write time in the 24 hour format!");
                System.out.println("Write '24:00' as '00:00' !");
                System.out.println("\n(Tristan gave the idea, and Deffreus made the code)\n");
                Main.hr();
            }
            static void iJamTidur() {
                boolean inputIsValid = false;
                while (!inputIsValid) {
                    List<String> waktuTidur = new ArrayList<>();
                    try {
                        inputIsValid = true;
                        System.out.println("\nAt what time did you slept? (e.g 22:15): ");
                        String[] rawWaktuTidur = tristaninput.nextLine().split(":", 0);
                        for(String i: rawWaktuTidur) {waktuTidur.add(i);}
                        jam_tidur = Integer.parseInt(waktuTidur.get(0));
                        menit_tidur = Integer.parseInt(waktuTidur.get(1));
                        // check validity:
                        if((jam_tidur >= 24 || jam_tidur < 0) || (menit_tidur < 0 || menit_tidur >= 60) || rawWaktuTidur.length > 2) {
                            inputIsValid = false;
                            Main.pExcType("That's not a valid time!");
                        }
                    } catch (Exception e) {
                        Main.pExcType("Please enter the hour and minutes in a valid format: HH:MM");
                        inputIsValid = false;
                        waktuTidur.clear();
                    }
                }
            }
            static void iJamBangun() {
                boolean inputIsValid = false;
                while (!inputIsValid) {
                    List<String> waktuBangun = new ArrayList<>();
                    try {
                        inputIsValid = true;
                        System.out.println("\nAt what time did you wake up? (e.g 03:50): ");
                        String[] rawWaktuBangun = tristaninput.nextLine().split(":", 0);
                        for(String i: rawWaktuBangun) {waktuBangun.add(i);}
                        jam_bangun = Integer.parseInt(waktuBangun.get(0));
                        menit_bangun = Integer.parseInt(waktuBangun.get(1));
                        // check validity:
                        if((jam_bangun >= 24 || jam_bangun < 0) || (menit_bangun < 0 || menit_bangun >= 60) || rawWaktuBangun.length > 2) {
                            inputIsValid = false; Main.pExcType("That's not a valid time!");
                        }
                    } catch (Exception e) {
                        Main.pExcType("Please enter the hour and minutes in a valid format: HH:MM");
                        inputIsValid = false;
                        waktuBangun.clear();
                    }
                }
            }
            static void pRes() {
                // kalkulasi durasi tidur:
                int tidur = jam_tidur*60+menit_tidur; int bangun = jam_bangun*60+menit_bangun;
                if(tidur > bangun) {tidur -= (24*60);}
                int hours = (bangun-tidur)/60; int minutes = (bangun-tidur)%60;

                // output formatting!
                // ketika tidur sama dengan bangun:
                if(hours+minutes == 0) {System.out.printf("\nYou sleep in less than a minute or what? :O\n");}
                // ketika tidur dibawah satu jam:
                else if(hours == 0 && minutes != 0) {
                    if(minutes == 1) {System.out.printf("\nYou've slept for a minute! XD\n");}
                    else {System.out.printf("\nYou've slept for %d minutes! :v\n", minutes);}
                }
                // ketika tidur tepat N jam:
                else if(minutes == 0 && hours != 0) {
                    if(hours == 1) System.out.printf("\nYou've slept for an hour! :p\n");
                    else {System.out.printf("\nYou've slept for %d hours! :>\n", hours);}
                } 
                // output format jam dan menit:
                else {
                    if(hours == 1 && minutes == 1) {System.out.printf("\nYou've slept for an hour and a minute! o_o\n");}
                    else if(hours == 1) {System.out.printf("\nYou've slept for an hours and %d minutes! :)\n", minutes);}
                    else if(minutes == 1) {System.out.printf("\nYou've slept for %d hours and a minute! c:\n", hours);}
                    else System.out.printf("\nYou slept for " + hours + " hours and " + minutes + " minutes! :D\n");
                }
            }
            static void iQuit() {
                String opt;
                boolean valid = false;
                while (valid != true) {
                    System.out.println("\nDo you want calculate again? (Y/n)");
                    opt = tristaninput.nextLine();
                    switch (opt) {
                        case "Y":
                        case "y":
                        case "Yes":
                        case "yes":
                        case "YES":
                        case "":
                            valid = true;
                            tristanIsEnded = false;
                            break;
                        case "n":
                        case "N":
                        case "No":
                        case "no":
                        case "NO":
                            valid = true;
                            tristanIsEnded = true;
                            System.out.println("\nThank you for using the Sleep Duration Calculator!! :D");
                            pQuit(3);
                            break;
                        default:
                            System.out.println("Invalid input!");
                    }
                }
            }
            static void pQuit(int second) {
                System.out.println("\nQuitting in:");
                for(int i = second; i > 0; i--) {
                    System.out.println(i + "...");
                    try {
                        Thread.sleep(1000);
                    } catch(Exception e) {
                        Main.pExcType("Thread sleep exception! Dev's fault, not yours!");
                    }
                }
            }
        }