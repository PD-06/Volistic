// Define the folder for this file, allowing interaction with other .java file(s)
package VolisticCLI;

// Import a library for scanner
import java.util.Scanner;

// This is a comment line, prefixed by double '/'
// Comments will not be executed on code run

public class Example {
    /* 
     * Deffreus use camel case naming for variables and abbreviation for methods, you may follow it for consistency
     * SORRY: Almost all variables and methods will be static:
     * Static and non-static conflicts; Deffreus started out using statics.
    */
    static int favoriteNumber;
    // You already know scanner, right?
    static Scanner sc = new Scanner(System.in);
    /* 
     * This is the .run() method used by `Volistic.java` to run this program
     * Acts as a replacement to `public static void main(String[] args) {}` 
     * This is specific in the case of 'Volistic.java': that's just how 'our' code work at Volistic
     * Your codes should go to the .run() method 
    */
    static void run() {
        // For simplicity sake, break down what the program is doing into methods like these:
        pHelloWorld();
        iNumber();
        pOddEven(favoriteNumber);
        // Write the rest of your codes here
    }
    /* 
     * This is a method to print "Hello, World!" 
     * This is just a method naming practice that Deffreus use: pHelloWorld for 'Print Hello World'
     * Another example is iNumber for 'Input Number'
     * You can follow it or not, it's optional, consistency in codes is better
    */
    static void pHelloWorld() {
        System.out.println("Hello, World!");
    }
    /*
     * It's recommended to order the methods like they appear in run() for readibility
     */
    static void iNumber() {
        // '\n' is a newline character, you can see it as the representation enter/return key
        System.out.println("\nWhat's your favorite number?");
        // Semantic variable are a good practice, I guess
        boolean inputIsValid = false;
        // Loop until the user input is valid (an integer)
        while(!inputIsValid) {
            /* 
            * 'Try' a code block: if an exception occured, jump to the 'catch' code block
            * We use 'try' here as input could be non-int, causing an exception
            * https://www.javatpoint.com/exception-handling-in-java
            */ 
            try {
                /* 
                * This way of getting int input is RECOMMENDED
                * It clear buffer ✔️
                */
                favoriteNumber = Integer.parseInt(sc.nextLine());
                // This code won't get reached if an exception happen at line 61; understand line 52
                inputIsValid = true;
            } catch (Exception e) {
                // This Main class method is used to produce error log/warning to the default output
                Main.pExcType("Please enter an integer!");
            }
        }
    }
    /*
     * This method use parameter, the 'favNum' variable of the type int
     * Parameter is a local variable within a method that's derived from outside variable/value
     * Parameter value can be different, allowing different output/result from a method based on its code
     */
    static void pOddEven(int favNum) {
        // The the number divided by 2 doesn't leave a remainder: Even number
        if(favNum % 2 == 0) {System.out.println("Your number is even!");}
        // If not even, it's odd
        else {System.out.println("Your number is odd!");}
    }
}
