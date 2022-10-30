package com.keyin.golf;

/* Member.java
   Class for Member Object
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
    private String name;
    private String email;
    private String phoneNumber;
    private String address;

    private ArrayList<Long> currentTournaments;
    private ArrayList<Long> pastTournaments;
    private ArrayList<Long> upcomingTournaments;

    // Constructors
    public Member(){
        this.memberID = null;
        this.name = null;
        this.address = null;
        this.email = null;
        this.phoneNumber = null;
        this.currentTournaments = new ArrayList<Long>();
        this.pastTournaments = new ArrayList<Long>();
        this.upcomingTournaments = new ArrayList<Long>();
    }

    public Member(Long memberID, String name, String email,  String phoneNumber, String address ) {
        this.memberID = memberID;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String fullName) {
        this.name = fullName;
    }

//    public String getLastName() {
//        return lastName;
//    }

//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }

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
                ", name=" + this.name +
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
