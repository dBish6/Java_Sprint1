package com.keyin.golf;

/* Tournaments.java
   Class for members of the tournament...

   Author: Chris Doucette
   Contributors:  David Bishop, Dominic Whelan and Blake Waddleton
   Creation Date: Oct 24, 2022

 */

import com.keyin.golf.json_data.Read;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Tournaments {
    // Instance Variables
    private Long tournamentId;
    private Date tournamentStartDate;
    private Date tournamentEndDate;
    private String tournamentName;
    private String tournamentLocation;
    private Long tournamentEntryFee;
    private Long tournamentCashPrize;
    private ArrayList<Long> membersParticipating = new ArrayList<Long>();
    private ArrayList<Long> finalStandings;

    // Constructors
    public Tournaments(){
        this.tournamentId = null;
        this.tournamentStartDate = null;
        this.tournamentEndDate = null;
        this.tournamentName = "";
        this.tournamentLocation = "";
        this.tournamentEntryFee = null;
        this.tournamentCashPrize = null;
        this.membersParticipating = new ArrayList<Long>();
        this.finalStandings = new ArrayList<Long>();
    }

    public Tournaments(Long tournamentId, Date tournamentStartDate, Date tournamentEndDate, String tournamentName, String tournamentLocation, Long tournamentEntryFee, Long tournamentCashPrize, ArrayList membersParticipating) {
        this.tournamentId = tournamentId;
        this.tournamentStartDate = tournamentStartDate;
        this.tournamentEndDate = tournamentEndDate;
        this.tournamentName = tournamentName;
        this.tournamentLocation = tournamentLocation;
        this.tournamentEntryFee = tournamentEntryFee;
        this.tournamentCashPrize = tournamentCashPrize;
        this.membersParticipating = membersParticipating;
        this.finalStandings = new ArrayList<Long>();
    }

    public Tournaments(Tournaments tournament){
        this.tournamentId = tournament.tournamentId;
        this.tournamentStartDate = tournament.tournamentStartDate;
        this.tournamentEndDate = tournament.tournamentEndDate;
        this.tournamentName = tournament.tournamentName;
        this.tournamentLocation = tournament.tournamentLocation;
        this.tournamentEntryFee = tournament.tournamentEntryFee;
        this.tournamentCashPrize = tournament.tournamentCashPrize;
        this.membersParticipating = tournament.membersParticipating;
    }

    // Getters / Setters
    public String getTournamentLocation() { return tournamentLocation;}

    public void setTournamentLocation(String tournamentLocation) {
        this.tournamentLocation = tournamentLocation;
    }

    public Long getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Long tournamentId) {
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

    public Long getTournamentEntryFee() {
        return tournamentEntryFee;
    }

    public void setTournamentEntryFee(Long tournamentEntryFee) {
        this.tournamentEntryFee = tournamentEntryFee;
    }

    public Long getTournamentCashPrize() {
        return tournamentCashPrize;
    }

    public void setTournamentCashPrize(Long tournamentCashPrize) {
        this.tournamentCashPrize = tournamentCashPrize;
    }

    public ArrayList<Long> getMembersParticipating() {
        return membersParticipating;
    }

    public void setMembersParticipating(ArrayList<Long> membersParticipating) {
        this.membersParticipating = membersParticipating;
    }

    public ArrayList<Long> getFinalStandings() {
        return finalStandings;
    }

    public void setFinalStandings(ArrayList<Long> finalStandings) {
        this.finalStandings = finalStandings;
    }

    public String toString() {
        return "Tournaments{" +
                "tournamentId=" + tournamentId +
                ", tournamentStartDate=" + tournamentStartDate +
                ", tournamentEndDate=" + tournamentEndDate +
                ", tournamentName='" + tournamentName + '\'' +
                ", tournamentLocation='" + tournamentLocation + '\'' +
                ", tournamentEntryFee=" + tournamentEntryFee +
                ", tournamentCashPrize=" + tournamentCashPrize +
                ", MembersParticipatingId=" + membersParticipating +
                '}';
    }

    // Custom Methods
    // Gathering user input & creating a new Tournament to be written to JSON
    public Tournaments createNewTournament(){
        // Scanner to receiver user input
        Scanner userInput = new Scanner(System.in);

        // Prompt user to enter all information that is needed to create a tournament
        // Save all user information to instance variables
        System.out.println("Enter your tournament id: ");
        Long tourneyId = userInput.nextLong();

        userInput.nextLine();
        System.out.println("Enter the tournament name: ");
        String tourneyName = userInput.nextLine();

        userInput.nextLine();
        System.out.println("Enter the tournament start date (Format: March 2, 2022):");
        String tourneyStartDateString = userInput.nextLine();
        Date tourneyStartDate = null;
        try {
            tourneyStartDate = new SimpleDateFormat("MMMMM dd, yyyy").parse(tourneyStartDateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        userInput.nextLine();
        System.out.println("Enter the tournament end date (Format: March 2, 2022):");
        String tourneyEndDateString = userInput.nextLine();
        Date tourneyEndDate = null;
        try {
            tourneyEndDate = new SimpleDateFormat("MMMMM dd, yyyy").parse(tourneyEndDateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        userInput.nextLine();
        System.out.println("Enter the tournament golf club");
        String tourneyLocation = userInput.nextLine();

        System.out.println("Enter the tournament entry fee:");
        Long tourneyEntryFee = userInput.nextLong();

        System.out.println("Enter the tournament winning prize amount:");
        Long tourneyCashPrize = userInput.nextLong();

        userInput.nextLine();
        System.out.println("Enter the members memberId that are entered for tournament, separated by a comma(,):  ");
        String membersForTourney = userInput.nextLine();
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

    private static Date changeDateFormat(int tourneyStartDateInt) {
        int year = tourneyStartDateInt / 10000;
        int month = (tourneyStartDateInt % 10000) / 100;
        int day = tourneyStartDateInt % 100;

        return new GregorianCalendar(year, month-1, day).getTime();
    }

    // Changed to private for now, will re-assess needs in Thursday morning's meeting
    public Tournaments getTournamentById(Long tournamentId) throws ParseException {
        // Creating new Read Object to receive Tournaments / Members objects
        Read read = new Read();

        JSONObject jsonObj = read.getTournamentJSONRecordById((long) tournamentId);

        System.out.println(jsonObj);

        // First get the whole JSONObject to get specified values.
        JSONObject tournamentObj = (JSONObject) jsonObj.get("tournament");

        // Get member memberID, name, email, and phone, etc.
        Long tournamentID = (Long) tournamentObj.get("tournamentID");

        // Updating the date to a date object
        String tournamentStartDateString = (String) tournamentObj.get("tournamentStartDate");
        Date tournamentStartDate = new SimpleDateFormat("MMMMM dd, yyyy").parse(tournamentStartDateString);

        // Updating end date to a date object
        String tournamentEndDateString = (String) tournamentObj.get("tournamentEndDate");
        Date tournamentEndDate = new SimpleDateFormat("MMMMM dd, yyyy").parse(tournamentEndDateString);

        String tournamentName = (String) tournamentObj.get("name");
        String location = (String) tournamentObj.get("location");
        Long entryFee = (Long) tournamentObj.get("entryFee");
        Long cashPrize = (Long) tournamentObj.get("cashPrize");

        // Get membersParticipating and add to ArrayList
        ArrayList<Long> membersInTournament = new ArrayList<>();

        JSONArray membersParticipating = (JSONArray) tournamentObj.get("membersParticipating");
        // Iterate though each member object in the familyMembers JSONArray.
        for (Object member : membersParticipating) {
            // Then creates the JSONObject out of the JSONArray.
            JSONObject members = (JSONObject) member;
            // Iterates through each key in the members JSONObject.
            for (Object key : members.keySet()) {
                // Gets each of the keys values and adds to ArrayList
                membersInTournament.add((Long) members.get(key));
            }
        }

        Tournaments membersTournament = new Tournaments(tournamentID, tournamentStartDate, tournamentEndDate, tournamentName, location, entryFee, cashPrize, membersInTournament);

        return membersTournament;

        // In Separate Method Called Something like findMembersTournaments
        // To do if Not updating Scores here
            // Create Tournament Object
            // Find All Members in the Tournament
            // Update this Tournament eg(Current to Past / Future to Current) by dates

    }

    public void updateMemberTournamentsStatus(Members members){
        // Checking tournaments in members and updating their status (Eg Current, Past or Future)

        // Check Tournaments in the Current List

    }


    public static void main(String[] args) throws Exception{
        Tournaments tournaments1 = new Tournaments();
        Tournaments tournament2 = new Tournaments();

        tournament2 = tournaments1.getTournamentById(1L);

        System.out.println(tournament2);
    }

}
