package VolisticCLI;

import java.util.Scanner;

public class BMICalculator {
            // Deklarasi variabel yang akan dipakai.
            static boolean bmirun, end, hasName;
            static String fname, category; // fname -> "Full Name"
            static Scanner bmiinput = new Scanner(System.in);
            static double weight, height, bmi;

            // Method buat jalanin bmi kalkulatornya
            static void run() {
                bmirun = true;
                end = false;
                // Biar bisa ngulang-ulang kalkulasi BMI
                while (bmirun) {
                    bmirun = false;
                    // 'try': kalau ada error (Exception) di sebuah line of code, langsung lompat ke 'catch'
                    try {
                        Main.clear(); // clear terminal
                        Main.hr(); // print horizontal line
                        // perhatiin penamaan methodnya: pWelcome -> "Print Welcome", iName -> "Input Name"
                        pWelcome();
                        Main.hr();
                        iName();
                        if (fname != "") // kalau namanya nggak kosong
                            hasName = true;
                        if (hasName) {System.out.println("\nHello " + fname + "!");} // kamu bisa lo nulis if begini
                        iWeight();
                        iHeight();
                        calcBMI(weight, height); // method ini pakai 'parameter': weight & height, buat dipakai di method 'calcBMI' nya
                        pResult();
                        iQuit();
                        if (end == false) {bmirun = true;} // kamu bisa lo nulis if begini
                    } catch (Exception e) { // ini catch!
                        Main.pExcType(
                                "You're not supposed to see this message.\nIf you do, report with a screenshot and how to replicate it here: deffreus (Discord)");
                        bmirun = true; // biar ngulang
                    }
                }
            }
            // timer buat quitting aja
            static void pQuit(int intSecond) {
                System.out.println("\nQuitting in:");
                for (int i = intSecond; i > 0; i--) {
                    System.out.println(i + "...");
                    try {
                        Thread.sleep(1000); // wait for 1000 milisecond = 1 second
                    } catch (Exception e) {
                        Main.pExcType("Thread sleep exception, dev's fault");
                    }
                }
            }
            // jujur ini kurang sih:
            static void iQuit() {
                System.out.println("\nDo you want to calculate again? (Y/n):");
                String option = bmiinput.nextLine();
                switch (option) {
                    case "N":
                    case "n":
                    case "No":
                    case "no":
                    case "NO":
                        end = true;
                        pQuit(3);
                        break;
                }
            }
            static void pResult() {
                System.out.println("\n"); // biar tetep misahin output walau `hasName == false`
                if (hasName)
                    System.out.println("Here is your result, " + fname + ":");
                System.out.println("Your weight      : " + Main.nice(weight) + " kg");
                System.out.println("Your height      : " + Main.nice(height) + " cm");
                System.out.printf("Your BMI index   : %.1f\n", bmi);
                System.out.println("\nYou're categorized as:\n" + category);
            }
            static void calcBMI(double w, double h) {
                bmi = w / (h * h * 0.0001); // pake 0.0001 karena unit nya centimeter
                if (bmi < 16) {
                    category = "Underweight (Severe thinness)";
                } else if (bmi <= 16.9) {
                    category = "Underweight (Moderate thinness)";
                } else if (bmi <= 18.4) {
                    category = "Underweight (Mild thinness)";
                } else if (bmi < 24.9) {
                    category = "Normal";
                } else if (bmi <= 29.9) {
                    category = "Overweight (Pre-obese)";
                } else if (bmi <= 34.9) {
                    category = "Obese (Class I)";
                } else if (bmi <= 39.9) {
                    category = "Obese (Class II)";
                } else {
                    category = "Obese (Class III)";
                }
            }
            static void pWelcome() {
                System.out.println("\nWelcome to the Volistic BMI Calculator!\n");
            }
            static void iName() {
                System.out.println("\nWhat is your full name? (blank to skip)");
                fname = bmiinput.nextLine();
            }
            static void iWeight() {
                boolean valid = false;
                while (!valid) { // minta terus input sampai input tersebut valid! (angka doang)
                    valid = true;
                    try {
                        System.out.println("\nWhat is your weight (kg)?");
                        weight = Double.parseDouble(bmiinput.nextLine());
                        if (weight > 635) {
                            System.out.println("I don't think you can be that fat.\n");
                            valid = false;
                        } else if (weight < 0.25) {
                            System.out.println("I don't think even a baby could be that light.\n");
                            valid = false;
                        }
                    } catch (Exception e) {
                        Main.pExcType("Something is wrong with your weight.");
                        valid = false;
                    }
                }
            }
            static void iHeight() {
                boolean valid = false;
                while (!valid) { // mirip yang di `iWeight()` (angka doang)
                    valid = true;
                    try {
                        System.out.println("\nWhat is your height (cm)?");
                        height = Double.parseDouble(bmiinput.nextLine());
                        if (height > 272) {
                            System.out.println(
                                    "Even the tallest man in the world, Robert Wadlow, doesn't reach that height.");
                            valid = false;
                        } else if (height < 25) {
                            System.out.println("That's kinda extremely small, what are you huh?");
                            valid = false;
                        }
                    } catch (Exception e) {
                        Main.pExcType("Something is wrong with your height.");
                        valid = false;
                    }
                }
            }
        }