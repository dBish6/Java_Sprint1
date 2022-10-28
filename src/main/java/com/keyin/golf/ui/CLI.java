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

    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_CYAN = "\u001B[36m";
    public static final String TEXT_WHITE = "\u001B[37m";

    public static void main(String[] args) {

        System.out.println(TEXT_GREEN + """
                 _____ _             ____       _  __    ____ _       _    \s
                |_   _| |__   ___   / ___| ___ | |/ _|  / ___| |_   _| |__ \s
                  | | | '_ \\ / _ \\ | |  _ / _ \\| | |_  | |   | | | | | '_ \\\s
                  | | | | | |  __/ | |_| | (_) | |  _| | |___| | |_| | |_) |
                  |_| |_| |_|\\___|  \\____|\\___/|_|_|    \\____|_|\\__,_|_.__/\s
                                                                            """.indent(1));
        userInterface();
    }


    public static void userInterface() {
        Scanner input = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            System.out.println(TEXT_GREEN + "\t1. " + TEXT_YELLOW + "Display Members");
            System.out.println(TEXT_GREEN + "\t2. " + TEXT_YELLOW + "Display Tournaments");
            System.out.println(TEXT_GREEN + "\t3. " + TEXT_YELLOW + "Display a Specific Member");
            System.out.println(TEXT_GREEN + "\t4. " + TEXT_YELLOW + "Display a Specific Tournament");
            System.out.println(TEXT_GREEN + "\t5. " + TEXT_YELLOW + "Create New Member");
            System.out.println(TEXT_GREEN + "\t6. " + TEXT_YELLOW + "Create New Tournament");
            System.out.println(TEXT_GREEN + "\t7. " + TEXT_YELLOW + "Add a Value to Members");
            System.out.println(TEXT_GREEN + "\t8. " + TEXT_YELLOW + "Add a Value to Tournaments");
            System.out.println(TEXT_GREEN + "\t9. " + TEXT_YELLOW + "Delete a Member Record");
            System.out.println(TEXT_GREEN + "\t10. " + TEXT_YELLOW + "Delete a Tournament Record");
            System.out.println(TEXT_GREEN + "\t- " + TEXT_YELLOW +  "\"q\" to Quit");
            System.out.println(TEXT_GREEN + "\n\tEnter your desired choice below:" + TEXT_RESET);
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
                    System.out.println(TEXT_YELLOW + "\n*Members*");
                    System.out.println(TEXT_GREEN + "Enter the membershipID for the record you wish to display:"
                            + TEXT_RESET);
                    int userInputId1 = input.nextInt();
                    System.out.println();
                    Read.displayJSONMemberByMembershipID(userInputId1);
                    break;
                case "4":
                    System.out.println(TEXT_YELLOW + "\n*Tournaments*");
                    System.out.println(TEXT_GREEN + "Enter the tournamentID for the record you wish to display:"
                            + TEXT_RESET);
                    int userInputId2 = input.nextInt();
                    System.out.println();
                    Read.displayJSONTournamentById(userInputId2);
                    break;
                case "5":
                    System.out.println(TEXT_YELLOW + "\n*Members*");
                    System.out.println(TEXT_GREEN + "Enter the <whatever> for the member you wish to create:"
                            + TEXT_RESET);
                    int userInputId3 = input.nextInt();
                    System.out.println();
                    break;
                case "6":
                    System.out.println(TEXT_YELLOW + "\n*Tournaments*");
                    System.out.println(TEXT_GREEN + "Enter the <whatever> for the tournament you wish to create:"
                            + TEXT_RESET);
                    int userInputId4 = input.nextInt();
                    System.out.println();
                    break;
                case "7":
                    System.out.println(TEXT_YELLOW + "\n*Members*");
                    System.out.println(TEXT_GREEN + "Enter the ID, key and value you intend to change:"
                            + TEXT_RESET);
                    int userInputId5 = input.nextInt();
                    String userInputKey1 = input.next();
                    String userInputValue1 = input.next();
                    break;
                case "8":
                    System.out.println(TEXT_YELLOW + "\n*Tournaments*");
                    System.out.println(TEXT_GREEN + "Enter the ID, key and value you intend to change:"
                            + TEXT_RESET);
                    int userInputId6 = input.nextInt();
                    String userInputKey2 = input.next();
                    String userInputValue2 = input.next();
                    break;
                case "9":
                    System.out.println(TEXT_YELLOW + "\n*Members*");
                    System.out.println(TEXT_GREEN + "Enter the memberID for the record you wish to delete:"
                            + TEXT_RESET);
                    int userInputId7 = input.nextInt();
                    System.out.println(TEXT_GREEN + "\nDeleting...");
                    Delete.deleteMemberJSONRecordByMembershipID(userInputId7);
                    System.out.println(TEXT_GREEN + "JSON Record was successfully deleted.\n");
                    break;
                case "10":
                    System.out.println(TEXT_YELLOW + "\n*Tournaments*");
                    System.out.println(TEXT_GREEN + "Enter the tournamentID for the record you wish to delete:"
                            + TEXT_RESET);
                    int userInputId8 = input.nextInt();
                    System.out.println(TEXT_GREEN + "\nDeleting...");
                    Delete.deleteTournamentJSONRecordById(userInputId8);
                    System.out.println(TEXT_GREEN + "JSON Record was successfully deleted.\n");
                    break;
                case "q":
                    System.out.println(TEXT_GREEN + "\nQuiting...");
                    quit = true;
                    break;
                default:
                    System.err.println("\nERROR: Please choose from the list from 1 to 10.");
            }
        }
    }
}
