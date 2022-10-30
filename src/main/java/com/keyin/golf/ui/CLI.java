package com.keyin.golf.ui;

/* CLI.java
   The command line interface for members of The Golf Club! So, they can read the records, write
   a new record, etc.

   Author: David Bishop
   Contributors:  Dominic Whelan, Chris Doucette and Blake Waddleton
   Creation Date: Oct 25, 2022

 */

import com.keyin.golf.Member;
import com.keyin.golf.Membership;
import com.keyin.golf.Tournaments;
import com.keyin.golf.exceptions.InvalidDateTimeException;
import com.keyin.golf.json_data.Add;
import com.keyin.golf.json_data.Delete;
import com.keyin.golf.json_data.Read;
import com.keyin.golf.json_data.Write;

import java.text.ParseException;
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
            System.out.println(TEXT_GREEN + "\t5. " + TEXT_YELLOW + "Create New Member/Membership");
            System.out.println(TEXT_GREEN + "\t6. " + TEXT_YELLOW + "Create New Tournament");
            System.out.println(TEXT_GREEN + "\t7. " + TEXT_YELLOW + "Add/Edit a Value to Members");
            System.out.println(TEXT_GREEN + "\t8. " + TEXT_YELLOW + "Add/Edit a Value to Tournaments");
            System.out.println(TEXT_GREEN + "\t9. " + TEXT_YELLOW + "Delete a Member Record");
            System.out.println(TEXT_GREEN + "\t10. " + TEXT_YELLOW + "Delete a Tournament Record");
            System.out.println(TEXT_GREEN + "\t11. " + TEXT_YELLOW + "Update a Members Tournament Statuses");
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
                    System.out.println(TEXT_YELLOW + "\n*Memberships/Member*");
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
                    System.out.println(TEXT_GREEN + """
                            Enter choice:
                                1. Add a Member to an existing Membership
                                2. Create Member and Membership
                            """
                            + TEXT_RESET);
                        int userInputId3 = input.nextInt();

                    System.out.println();
                    if(userInputId3 == 1){
                        System.out.println("Enter Membership ID to add member");
                        Long membershipID = input.nextLong();
                        Member newMember = Membership.createNewMember();
                        Write writer = new Write();
                        writer.addMemberToMembership(newMember,membershipID);
                    }else if(userInputId3 == 2){
                        Member newMember = Membership.createNewMember();
                        Membership.createNewMembership(newMember);
                    } else {
                        System.err.println("ERROR: Invalid Entry");
                    }
                    break;
                case "6":
                    System.out.println(TEXT_YELLOW + "\n*Create Tournaments*");
//                    System.out.println(TEXT_GREEN + "Enter the <whatever> for the tournament you wish to create:"
//                            + TEXT_RESET);
//                    int userInputId4 = input.nextInt();
//                    System.out.println();
                    quit = true;
                    Tournaments tournaments = new Tournaments();
                    try {
                        tournaments.createNewTournament();
                    } catch (InvalidDateTimeException e) {
                        throw new RuntimeException(e);
                    }

                    break;
                case "7":
                    System.out.println(TEXT_YELLOW + "\n*Members*");
                    System.out.println(TEXT_GREEN + "Enter Member ID, field to add/edit and value to set:"
                            + TEXT_RESET);
                    System.out.println("Enter Member ID: ");
                    int userInputId5 = input.nextInt();
                    System.out.println("Enter field to Add/Change (name,email,phone, etc.): ");
                    String userInputKey1 = input.next();
                    System.out.println("Enter value to be set to the field: ");
                    String userInputValue1 = input.next();
                    Add.setMemberDetailValue(userInputId5, userInputKey1,userInputValue1);
                    break;
                case "8":
                    System.out.println(TEXT_YELLOW + "\n*Tournaments*");
//                    System.out.println(TEXT_GREEN + "Enter the ID, key and value you intend to change:"
//                            + TEXT_RESET);
//                    int userInputId6 = input.nextInt();
//                    String userInputKey2 = input.next();
//                    String userInputValue2 = input.next();
                    quit = true;
                    Tournaments tournamentsChange = new Tournaments();
                    try {
                        tournamentsChange.getUserInputToUpdateTournaments();
                    } catch (InvalidDateTimeException e) {
                        throw new RuntimeException(e);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "9":
                    System.out.println(TEXT_YELLOW + "\n*Members*");
                    System.out.println(TEXT_GREEN + "Enter the membershipID for the record you wish to delete:"
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
                case "11":
                    System.out.println(TEXT_YELLOW + "\n*Tournaments*");
                    quit = true;

                    Tournaments tournamentsGetMember = new Tournaments();
                    try {
                        tournamentsGetMember.getUserInputtedMemberId();
                    } catch (InvalidDateTimeException e) {
                        throw new RuntimeException(e);
                    }
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
