package com.keyin.golf;

/* Members.java
   Class for members of the tournament...

   Author: Blake Waddleton
   Contributors:  David Bishop, Chris Doucette and Blake Waddleton
   Creation Date: Oct 24, 2022
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

@Entity
public class Membership {
    // Instance Variables
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long membershipID;
    private String membershipType;
    private Date membershipStartDate;
    private Date membershipExpireDate;
    private Long monthlyMembershipCost;
    private ArrayList<Member> memberList = new ArrayList<>();

    // Constructors
    public Membership() {
        this.membershipID = null;
        this.membershipStartDate = null;
        this.membershipExpireDate = null;
        this.membershipType = null;
        this.monthlyMembershipCost = null;
    }

    public Membership(Long membershipID, String membershipType, Date membershipStartDate, Date membershipExpireDate,
                       Long monthlyMembershipCost)
    {
        this.membershipID = membershipID;
        this.membershipType = membershipType;
        this.membershipStartDate = membershipStartDate;
        this.membershipExpireDate = membershipExpireDate;
        this.monthlyMembershipCost = monthlyMembershipCost;
    }

    // Getters and Setters
    public ArrayList<Member> getMemberList(){
        return memberList;
    }

    public Long getMembershipID() {
        return membershipID;
    }

    public void setMembershipID(Long membershipID) {
        this.membershipID = membershipID;
    }

    public Date getMembershipStartDate() {
        return membershipStartDate;
    }

    public void setMembershipStartDate(Date membershipStartDate) {
        this.membershipStartDate = membershipStartDate;
    }

    public Date getMembershipExpireDate() {
        return membershipExpireDate;
    }

    public void setMembershipExpireDate(Date membershipExpireDate) {
        this.membershipExpireDate = membershipExpireDate;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public String getMembershipType() {
        return membershipType;
    }

    // Custom Methods
    public void addMember(Member member){
        memberList.add(member);
    }

    @Override
    public String toString() {
        return "Membership: {" +
                "membershipID=" + this.membershipID +
                ", membershipType=" + this.membershipType +
                ", membershipStartDate=" + this.membershipStartDate +
                ", membershipExpireDate='" + this.membershipExpireDate +
                ", monthlyMembershipCost='" + this.monthlyMembershipCost +
                "}";
    }

    // Gathering user input & creating a new Tournament to be written to JSON
    public Membership createNewMemberAndMembership(){
        // Scanner to receiver user input
        Scanner userInput = new Scanner(System.in);

        // Prompt user to enter all information that is needed to create a tournament
        // Save all user information to instance variables
        System.out.println("Enter the memberID: ");
        int memberID = userInput.nextInt();

        userInput.nextLine();
        System.out.println("Enter the membershipID: ");
        int membershipID = userInput.nextInt();

        userInput.nextLine();
        System.out.println("Enter the tournament name: ");
        String tourneyName = userInput.next();

        userInput.nextLine();
        System.out.println("Enter the membership start date (Format: March 2, 2022):");
        String membershipStartDateString = userInput.next();
        Date membershipStartDate = new Date();
        try {
            membershipStartDate = new SimpleDateFormat("MMMMM dd, yyyy").parse(membershipStartDateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        userInput.nextLine();
        System.out.println("Enter the membership expiry date (Format: March 2, 2022):");
        String membershipExpireDateString = userInput.next();
        Date membershipExpireDate = new Date();
        try {
            membershipExpireDate = new SimpleDateFormat("MMMMM dd, yyyy").parse(membershipExpireDateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        userInput.nextLine();
        System.out.println("Enter the monthly cost of the membership: ");
        int monthlyMembershipCost = userInput.nextInt();

        userInput.nextLine();
        System.out.println("Enter the member's first and last name:");
        String name = userInput.next();

        userInput.nextLine();
        System.out.println("Enter the member's email:");
        Long email = userInput.nextLong();

        userInput.nextLine();
        System.out.println("Enter the member's phone:");
        Long phone = userInput.nextLong();

        userInput.nextLine();
        System.out.println("Enter the member's address:");
        Long address = userInput.nextLong();

        userInput.nextLine();
        System.out.println("Enter the tournamentID(s) of the Current Tournaments this member is in, separated by a comma(,): ");
        int membersCurrentTournaments = userInput.nextInt();
        ArrayList<Long> membersForTournamentInteger = new ArrayList<>();

        membersCurrentTournaments = Math.toIntExact(Long.valueOf(membersCurrentTournaments));

        // Changing String array into Int array
        for(int i = 0; i < membersCurrentTournaments.length; i++){
            membersForTournamentInteger.add(Integer.parseInt(membersCurrentTournaments[i]));
        }

        userInput.nextLine();
        System.out.println("Enter the tournamentID(s) of the Current Tournaments this member is in, separated by a comma(,): ");
        int membersForTourney = userInput.nextInt();
        ArrayList<Integer> membersForTournamentInteger = new ArrayList<>();

        // Separating String into String array
        String[] membersForTournamentString = membersForTourney.split("\\s*,\\s*");

        // Changing String array into Int array
        for(int i = 0; i < membersForTournamentString.length; i++){
            membersForTournamentInteger.add(Integer.parseInt(membersForTournamentString[i]));
        }

        userInput.nextLine();
        System.out.println("Enter the tournamentID(s) of the Current Tournaments this member is in, separated by a comma(,): ");
        int membersForTourney = userInput.nextInt();
        ArrayList<Integer> membersForTournamentInteger = new ArrayList<>();

        // Separating String into String array
        String[] membersForTournamentString = membersForTourney.split("\\s*,\\s*");

        // Changing String array into Int array
        for(int i = 0; i < membersForTournamentString.length; i++){
            membersForTournamentInteger.add(Integer.parseInt(membersForTournamentString[i]));
        }

        // Close the scanner
        userInput.close();

        // Call the constructor to create new Tournament Instance
        Tournaments newTourney = new Tournaments(tourneyId, tourneyStartDate, tourneyEndDate, tourneyName, tourneyLocation, tourneyEntryFee, tourneyCashPrize, membersForTournamentInteger );


        // Write data to JSON Tournament file

        return newTourney;
    }
}