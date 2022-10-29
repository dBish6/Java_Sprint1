package com.keyin.golf;

/* Person.java
   Class for Person Object
   set/get personal details
   set/get tournament information

   Author: Dominic Whelan
   Contributors:  David Bishop, Chris Doucette and Blake Waddleton
   Creation Date: Oct 27, 2022

 */

import java.util.ArrayList;
import java.util.Date;

public class Member {

    // Instance Variables
    private Long memberID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;

    private ArrayList<Long> currentTournaments;
    private ArrayList<Long> pastTournaments;
    private ArrayList<Long> upcomingTournaments;

    // Constructors
    public Member(){
        super();
        this.memberID = null;
        this.firstName = null;
        this.lastName = null;
        this.address = null;
        this.email = null;
        this.phoneNumber = null;
        this.currentTournaments = new ArrayList<Long>();
        this.pastTournaments = new ArrayList<Long>();
        this.upcomingTournaments = new ArrayList<Long>();
    }

    public Member(Long memberID, String firstName, String lastName, String email,  String phoneNumber, String address ) {
        super();
        this.memberID = memberID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Member(Long memberID, String firstName, String lastName, String email,  String phoneNumber, String address ) {
        this.memberID = memberID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    // Getters and Setters
    public Long getMemberID() {
        return memberID;
    }

    public void setMemberID(Long memberID) {
        this.memberID = memberID;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public ArrayList<Long> getCurrentTournaments() {
        return currentTournaments;
    }

    public void setCurrentTournaments(ArrayList<Long> currentTournaments) {
        this.currentTournaments = currentTournaments;
    }

    public ArrayList<Long> getPastTournaments() {
        return pastTournaments;
    }

    public void setPastTournaments(ArrayList<Long> pastTournaments) {
        this.pastTournaments = pastTournaments;
    }

    public ArrayList<Long> getUpcomingTournaments() {
        return upcomingTournaments;
    }

    public void setUpcomingTournaments(ArrayList<Long> upcomingTournaments) {
        this.upcomingTournaments = upcomingTournaments;
    }

    // Custom Methods
    @Override
    public String toString() {
        return "Member: {" +
                "memberId=" + this.memberID +
                ", name=" + this.firstName + " " + this.lastName +
                ", email=" + this.email +
                ", phone='" + this.phoneNumber +
                ", address=" + this.address +
                ", currentTournaments=" + this.currentTournaments +
                ", pastTournaments=" + this.pastTournaments +
                ", upcomingTournaments=" + this.upcomingTournaments +
                "}";
    }

    public static void main(String[] args) {
        Member m1 = new Member();
        System.out.println(m1);
    }
}
