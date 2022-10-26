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
import java.util.Date;

@Entity
public class Members {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;
    private String lastName;
    private String address;
    private String email;

    private int phoneNumber;
    private Date membershipStartDate;
    private double membershipDuration;

    private String currentTournaments;

    private String pastTournaments;

    private String upcomingTournaments;


    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public int setPhoneNumber(int phoneNumber){
        return phoneNumber;
    }

    public Date getMembershipStartDate() {
        return membershipStartDate;
    }

    public void setMembershipStartDate(Date membershipStartDate) {
        this.membershipStartDate = membershipStartDate;
    }

    public double getMembershipDuration() {
        return membershipDuration;
    }

    public void setMembershipDuration(double membershipDuration) {
        this.membershipDuration = membershipDuration;
    }

    public String getCurrentTournaments() {
        return currentTournaments;
    }

    public void setCurrentTournaments(String currentTournaments) {
        this.currentTournaments = currentTournaments;
    }

    public String getPastTournaments() {
        return pastTournaments;
    }

    public void setPastTournaments(String pastTournaments) {
        this.pastTournaments = pastTournaments;
    }

    public String getUpcomingTournaments() {
        return upcomingTournaments;
    }

    public void setUpcomingTournaments(String upcomingTournaments) {
        this.upcomingTournaments = upcomingTournaments;
    }
    public static void main(String[] args) {

    }
}


