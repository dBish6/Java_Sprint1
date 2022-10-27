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
import java.util.ArrayList;
import java.util.Date;

@Entity
public class Members {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String address;
    private String email;

    private int phoneNumber;
    private Date membershipStartDate;
    private Date membershipEndDate;

    private ArrayList<String> membershipType;

    private ArrayList<String> currentTournaments;

    private ArrayList<String> pastTournaments;

    private ArrayList<String> upcomingTournaments;


    public Members() {
        this.firstName = "";
        this.lastName = "";
        this.address = "";
        this.email = "";
        this.phoneNumber = 0;
        this.membershipStartDate = null;
        this.membershipEndDate = null;
        this.membershipType = new ArrayList<String>();
        this.currentTournaments = new ArrayList<String>();
        this.pastTournaments = new ArrayList<String>();
        this.upcomingTournaments = new ArrayList<String>();
    }

    public Members(String firstName, String lastName, String address, String email, int phoneNumber, Date membershipStartDate, Date membershipEndDate,ArrayList membershipType, ArrayList currentTournaments, ArrayList upcomingTournaments, ArrayList pastTournaments) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.membershipStartDate = membershipStartDate;
        this.membershipEndDate = membershipEndDate;
        this.membershipType = membershipType;
        this.currentTournaments = currentTournaments;
        this.pastTournaments = pastTournaments;
        this.upcomingTournaments = upcomingTournaments;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int setPhoneNumber(int phoneNumber) {
        return phoneNumber;
    }

    public Date getMembershipStartDate() {
        return membershipStartDate;
    }

    public void setMembershipStartDate(Date membershipStartDate) {
        this.membershipStartDate = membershipStartDate;
    }

    public Date getMembershipEndDate() {
        return membershipEndDate;
    }

    public void setMembershipEndDate(Date membershipEndDate) {
        this.membershipEndDate = membershipEndDate;
    }

    public void setMembershipType(ArrayList<String> membershipType) {
        this.membershipType = membershipType;
    }

    public ArrayList<String> getMembershipType() {
        return membershipType;
    }

    public ArrayList<String> getCurrentTournaments() {
        return currentTournaments;
    }

    public void setCurrentTournaments(ArrayList<String> currentTournaments) {
        this.currentTournaments = currentTournaments;
    }

    public ArrayList<String> getPastTournaments() {
        return pastTournaments;
    }

    public void setPastTournaments(ArrayList<String> pastTournaments) {
        this.pastTournaments = pastTournaments;
    }

    public ArrayList<String> getUpcomingTournaments() {
        return upcomingTournaments;
    }

    public void setUpcomingTournaments(ArrayList<String> upcomingTournaments) {
        this.upcomingTournaments = upcomingTournaments;
    }

}


