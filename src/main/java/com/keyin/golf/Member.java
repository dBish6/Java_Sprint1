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

public class Member {

    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phoneNumber;

    private ArrayList<String> currentTournaments;

    private ArrayList<String> pastTournaments;

    private ArrayList<String> upcomingTournaments;

    public Member(){
        lastName = "";
        address = "";
        email = "";
        phoneNumber = "";
    }

    public Member(Long id, String firstName, String lastName, String email, String address, String phoneNumber ){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
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
