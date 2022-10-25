package com.keyin.golf;

/* Tournaments.java
   Class for members of the tournament...

   Author: Chris Doucette
   Contributors:  David Bishop, Dominic Whelan and Blake Waddleton
   Creation Date: Oct 24, 2022

 */

import java.util.ArrayList;
import java.util.Date;

public class Tournaments {
    // Instance Variables
    private int tournamentId;
    private Date tournamentStartDate;
    private Date tournamentEndDate;
    private String tournamentName;
    private String tournamentLocation;
    private int entryFee;
    private int cashPrize;
    private ArrayList<Integer> membersParticipating = new ArrayList<Integer>();
    private ArrayList<String> finalStandings = new ArrayList<String>();

    // Constructors

    public Tournaments(int tournamentId, Date tournamentStartDate, Date tournamentEndDate, String tournamentName, String tournamentLocation, int entryFee, int cashPrize, ArrayList<Integer> membersParticipating) {
        this.tournamentId = tournamentId;
        this.tournamentStartDate = tournamentStartDate;
        this.tournamentEndDate = tournamentEndDate;
        this.tournamentName = tournamentName;
        this.tournamentLocation = tournamentLocation;
        this.entryFee = entryFee;
        this.cashPrize = cashPrize;
        this.membersParticipating = membersParticipating;
    }

    public Tournaments(Tournaments tournament){
        this.tournamentId = tournament.tournamentId;
        this.tournamentStartDate = tournament.tournamentStartDate;
        this.tournamentEndDate = tournament.tournamentEndDate;
        this.tournamentName = tournament.tournamentName;
        this.tournamentLocation = tournament.tournamentLocation;
        this.entryFee = tournament.entryFee;
        this.cashPrize = tournament.cashPrize;
        this.membersParticipating = tournament.membersParticipating;
    }

    // Getters / Setters

    public String getTournamentLocation() { return tournamentLocation;}

    public void setTournamentLocation(String tournamentLocation) {
        this.tournamentLocation = tournamentLocation;
    }

    public int getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    public Date getTournamentStartDate() {
        return tournamentStartDate;
    }

    public void setTournamentStartDate(Date tournamentStartDate) {
        this.tournamentStartDate = tournamentStartDate;
    }

    public Date getTournamentEndDate() {
        return tournamentEndDate;
    }

    public void setTournamentEndDate(Date tournamentEndDate) {
        this.tournamentEndDate = tournamentEndDate;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public int getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(int entryFee) {
        this.entryFee = entryFee;
    }

    public int getCashPrize() {
        return cashPrize;
    }

    public void setCashPrize(int cashPrize) {
        this.cashPrize = cashPrize;
    }

    public ArrayList<Integer> getMembersParticipating() {
        return membersParticipating;
    }

    public void setMembersParticipating(ArrayList<Integer> membersParticipating) {
        this.membersParticipating = membersParticipating;
    }

    public ArrayList<String> getFinalStandings() {
        return finalStandings;
    }

    public void setFinalStandings(ArrayList<String> finalStandings) {
        this.finalStandings = finalStandings;
    }

    // Custom Methods
    public void CreateNewTournament(){
        // Write data to JSON Tournament file
    }

    public void getTournament(){

    }
}
