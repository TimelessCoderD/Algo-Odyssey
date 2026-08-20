package program;

import java.util.Scanner;

public class OutputFormatting {
    public static void main(String[] args) {

        // print() keeps the cursor on the same line
        System.out.print("Hello ");
        System.out.print("Dev");

        System.out.println();

        // println() moves to the next line
        System.out.println("Welcome to Algo-Odyssey!");
        System.out.println("Learning Java.");

        // Printing multiple values
        String name = "Dev";
        int age = 35;

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);

        // Using escape sequences
        System.out.println("Hello\nWorld");
        System.out.println("Name:\t" + name);

        // Printing quotes
        System.out.println("He said, \"Hello!\"");
    }

}
