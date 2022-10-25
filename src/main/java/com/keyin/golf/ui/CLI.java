package com.keyin.golf.ui;

/* CLI.java
   The command line interface for members of The Golf Club! So, they can read the records, write
   a new record, etc.

   Author: David Bishop
   Contributors:  Dominic Whelan, Chris Doucette and Blake Waddleton
   Creation Date: Oct 25, 2022

 */

import com.keyin.golf.json_data.Read;

import java.util.Scanner;

public class CLI {

    public static void main(String[] args) {

        System.out.println("*The Golf Club*");
        userInterface();
    }


    public static void userInterface() {
        Scanner input = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            System.out.println("\t1. Display Members");
            System.out.println("\t2. Display Tournaments");
            System.out.println("\t3. Create New Member");
            System.out.println("\t4. Create New Tournament");
            System.out.println("\t5. Add a Value to Members");
            System.out.println("\t6. Add a Value to Tournaments");
            System.out.println("\t7. Delete Member Record");
            System.out.println("\t8. Delete Tournament Record");
            System.out.println("\t-  \"q\" to Quit");
            System.out.println("\tEnter your desired choice below:");
            switch (input.next()) {
                case "1":
                    System.out.println();
                    Read.readMembersJSON();
                    break;
                case "2":
                    System.out.println();
                    Read.readTournamentsJSON();
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    System.out.println("*Members*");
                    System.out.println("Enter the key for what value you intend to change:");
                    input.next();
                    break;
                case "6":
                    System.out.println("*Tournaments*");
                    System.out.println("Enter the key for what value you intend to change:");
                    input.next();
                    break;
                case "7":
                    System.out.println("*Members*");
                    System.out.println("Enter the memberID for record you wish to delete:");
                    input.next();
                    break;
                case "8":
                    System.out.println("*Tournaments*");
                    System.out.println("Enter the tournamentID for record you wish to delete:");
                    input.next();
                    break;
                case "q":
                    System.out.println("Quiting...");
                    quit = true;
                    break;
                default:
                    System.err.println("\nERROR: Please choose from the list from 1 to 8.");
                    userInterface();
            }
        }
    }
}
