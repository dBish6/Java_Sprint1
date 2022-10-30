package com.keyin.golf;

/* Members.java
   Class for members of the tournament...

   Author: Blake Waddleton
   Contributors:  David Bishop, Chris Doucette and Blake Waddleton
   Creation Date: Oct 24, 2022
 */

import com.keyin.golf.json_data.Write;
import org.json.simple.JSONObject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
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
    private ArrayList<Member> memberList = new ArrayList<>();

    private Long monthlyMembershipCost;

    // Constructors
    public Membership() {
        this.membershipID = null;
        this.membershipStartDate = null;
        this.membershipExpireDate = null;
        this.membershipType = null;
        this.monthlyMembershipCost = null;
    }

    public Membership(Long membershipID, String membershipType, Date membershipStartDate, Date membershipExpireDate) {
        this.membershipID = membershipID;
        this.membershipType = membershipType;
        this.membershipStartDate = membershipStartDate;
        this.membershipExpireDate = membershipExpireDate;
        if (Objects.equals(membershipType, "Standard")) {
            this.monthlyMembershipCost = 125L;
        } else if (Objects.equals(membershipType, "Special Offer")) {
            this.monthlyMembershipCost = 115L;
        } else if (Objects.equals(membershipType, "Premium")) {
            this.monthlyMembershipCost = 150L;
        } else if (Objects.equals(membershipType, "Trial")) {
            this.monthlyMembershipCost = 0L;
        }
    }

    // Getters and Setters
    public ArrayList<Member> getMemberList() {
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
    public void addMember(Member member) {
        memberList.add(member);
        if (Objects.equals(this.membershipType, "Family Plan")) {
            this.monthlyMembershipCost = memberList.size() * 100L;
        }
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

    // Gathering user input & creating a new Member/Membership to be written to JSON
    public static Member createNewMember(){
        Scanner userInput = new Scanner(System.in);
        // Prompt user to enter all information that is needed to create a Member
        // Save all user information to instance variables
        System.out.println("Enter the memberID: ");
        Long memberID = userInput.nextLong();

        userInput.nextLine();
        System.out.println("Enter the member's full name:");
        String fullName = userInput.next();

        userInput.nextLine();
        System.out.println("Enter the member's email:");
        String email = userInput.next();

        userInput.nextLine();
        System.out.println("Enter the member's phone number:");
        String phone = userInput.next();

        userInput.nextLine();
        System.out.println("Enter the member's address:");
        String address = userInput.next();

        Member newMember = new Member(memberID, fullName, email, phone, address);

        return newMember;
    }
    public static void createNewMembership(Member member) {
        // Scanner to receiver user input
        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter the membershipID: ");
        Long membershipID = userInput.nextLong();

        userInput.nextLine();
        System.out.println("""
                Enter choice (1-4) for membership type
                 1. Standard @ $125/month
                 2. Family Plan @ $100/month per member
                 3. Special Offer @ $115/month
                 4. Premium @ $150/month
                 5. Trial Free(1 week)
                """);
        int membershipTypeChoice = 0;
        while (membershipTypeChoice == 0) {
            int choice = userInput.nextInt();
            if (choice < 1 || choice > 5) {
                System.err.println("Invalid Entry, Please Try Again");
            } else {
                membershipTypeChoice = choice;
            }
        }
        String membershipType;
        if (membershipTypeChoice == 1) {
            membershipType = "Standard";
        } else if (membershipTypeChoice == 2) {
            membershipType = "Family Plan";
        } else if (membershipTypeChoice == 3) {
            membershipType = "Special Offer";
        } else if (membershipTypeChoice == 4) {
            membershipType = "Premium";
        } else {
            membershipType = "Trial";
        }

        userInput.nextLine();
        System.out.println("Enter the Membership start date (Format: March 2, 2022):");
        String membershipStartDateString = userInput.nextLine();
        Date membershipStartDate = null;
        try {
            membershipStartDate = new SimpleDateFormat("MMMMM dd, yyyy").parse(membershipStartDateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Enter the Membership end date (Format: March 2, 2022):");
        String membershipExpireDateString = userInput.nextLine();
        Date membershipExpireDate = null;
        try {
            membershipExpireDate = new SimpleDateFormat("MMMMM dd, yyyy").parse(membershipExpireDateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Membership newMembership = new Membership(membershipID, membershipType, membershipStartDate, membershipExpireDate);

        newMembership.addMember(member);

        Write writer = new Write();
        JSONObject newMembershipObject = writer.createMembershipObj(newMembership);
        writer.addToFile(newMembershipObject,"src/main/golf.club.json/members.json");
    }
}