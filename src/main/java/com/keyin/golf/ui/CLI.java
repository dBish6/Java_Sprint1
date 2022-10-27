package com.keyin.golf.ui;

/* CLI.java
   The command line interface for members of The Golf Club! So, they can read the records, write
   a new record, etc.

   Author: David Bishop
   Contributors:  Dominic Whelan, Chris Doucette and Blake Waddleton
   Creation Date: Oct 25, 2022

 */

import com.keyin.golf.json_data.Delete;
import com.keyin.golf.json_data.Read;

import java.util.Scanner;

public class CLI {

    public static void main(String[] args) {

        System.out.println("\t*The Golf Club*");
        userInterface();
    }


    public static void userInterface() {
        Scanner input = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            System.out.println("\t1. Display Members");
            System.out.println("\t2. Display Tournaments");
            System.out.println("\t3. Display a Specific Member");
            System.out.println("\t4. Display a Specific Tournament");
            System.out.println("\t5. Create New Member");
            System.out.println("\t6. Create New Tournament");
            System.out.println("\t7. Add a Value to Members");
            System.out.println("\t8. Add a Value to Tournaments");
            System.out.println("\t9. Delete a Member Record");
            System.out.println("\t10. Delete a Tournament Record");
            System.out.println("\t-  \"q\" to Quit");
            System.out.println("\tEnter your desired choice below:");
            switch (input.next()) {
                case "1":
                    System.out.println();
                    Read.readAllJSONMembers();
                    break;
                case "2":
                    System.out.println();
                    Read.readAllJSONTournaments();
                    break;
                case "3":
                    System.out.println("*Members*");
                    System.out.println("Enter the membershipID for the record you wish to display:");
                    int userInputId1 = input.nextInt();
                    System.out.println();
                    Read.displayJSONMemberByMembershipID(userInputId1);
                    break;
                case "4":
                    System.out.println("*Tournaments*");
                    System.out.println("Enter the tournamentID for the record you wish to display:");
                    int userInputId2 = input.nextInt();
                    System.out.println();
                    Read.displayJSONTournamentById(userInputId2);
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    System.out.println("*Members*");
                    System.out.println("Enter the key for what value you intend to change:");
                    input.next();
                    break;
                case "8":
                    System.out.println("*Tournaments*");
                    System.out.println("Enter the key for what value you intend to change:");
                    input.next();
                    break;
                case "9":
                    System.out.println("*Members*");
                    System.out.println("Enter the memberID for the record you wish to delete:");
                    int userInputId3 = input.nextInt();
                    System.out.println("Deleting...");
                    Delete.deleteMemberJSONRecord(userInputId3);
                    System.out.println("JSON Record was successfully deleted.\n");
                    break;
                case "10":
                    System.out.println("*Tournaments*");
                    System.out.println("Enter the tournamentID for the record you wish to delete:");
                    int userInputId4 = input.nextInt();
                    System.out.println("Deleting...");
                    Delete.deleteTournamentJSONRecord(userInputId4);
                    System.out.println("JSON Record was successfully deleted.\n");
                    break;
                case "q":
                    System.out.println("Quiting...");
                    quit = true;
                    break;
                default:
                    System.err.println("\nERROR: Please choose from the list from 1 to 10.");
                    userInterface();
            }
        }
    }
}
