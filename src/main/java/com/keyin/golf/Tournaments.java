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

    // Changed to private for now, will re-assess needs in Thursday morning's meeting
    public Tournaments getTournamentByIdForJson(Long tournamentId){
        // Date formatter
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMMMM dd, yyyy");

        // Creating new Read Object to receive Tournaments / Members objects
        Read read = new Read();
        JSONObject jsonObj = read.getTournamentJSONRecordById(Math.toIntExact(tournamentId));

        // First get the whole JSONObject to get specified values.
        JSONObject tournamentObj = (JSONObject) jsonObj.get("tournament");

        // Get member memberID, name, email, and phone, etc.
        Long tournamentID = (Long) tournamentObj.get("tournamentID");

        // Updating the date to a date object
        String tournamentStartDateString = (String) tournamentObj.get("tournamentStartDate");
        Date tournamentStartDate = null;

        try {
            tournamentStartDate = dateFormatter.parse(tournamentStartDateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        // Updating end date to a date object
        String tournamentEndDateString = (String) tournamentObj.get("tournamentEndDate");
        Date tournamentEndDate = null;
        try {
            tournamentEndDate = dateFormatter.parse(tournamentEndDateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

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

        // Creating and returning the Tournament Information
        Tournaments membersTournament = new Tournaments(tournamentID, tournamentStartDate, tournamentEndDate, tournamentName, location, entryFee, cashPrize, membersInTournament);

        return membersTournament;
    }

    // To do if Not updating Scores here
    // Create Tournament Object
    // Find All Members in the Tournament
    // Update this Tournament eg(Current to Past / Future to Current) by dates

    public void updateMemberTournamentsStatus(Member members){
        System.out.println("Before Updates");
        System.out.println("Upcoming Tournaments: " + members.getUpcomingTournaments());
        System.out.println("Current Tournaments" + members.getCurrentTournaments());
        System.out.println();

        // Checking all tournaments in Current List
        updateMemberCurrentTournaments(members);

        // Check Tournaments in the Future List
        updateMemberUpcomingTournaments(members);

        System.out.println("After Updates");
        System.out.println("Upcoming Tournaments: " + members.getUpcomingTournaments());
        System.out.println("Current Tournaments" + members.getCurrentTournaments());
        System.out.println();
    }

    public void updateMemberCurrentTournaments(Member member) {

        // Getting Members Current Tournaments Array from Members Object
        ArrayList<Long> currentTournamentsArray = member.getCurrentTournaments();

        // Size of array for counter
        int sizeOfArray = currentTournamentsArray.size();

        // Variables for Processing
        Long tourneyId = null;
        Tournaments currentTournament = new Tournaments();
        Tournaments tourney = new Tournaments();

        // Counter for Loop Control
        int counterForLoop = 0;
        //Counter for Index Control
        int counterForIndex = 0;

        while(counterForLoop < sizeOfArray){

            // Getting the current tourneyId
            tourneyId = currentTournamentsArray.get(counterForIndex);

            // Finding the current tournament and getting Start / End dates
            currentTournament = tourney.getTournamentByIdForJson((tourneyId));

            // Creating Date Objects
//            Date currentTournamentTournamentStartDate = currentTournament.getTournamentStartDate();
            Date currentTournamentTournamentEndDate = currentTournament.getTournamentEndDate();
            Date today = new Date();
            today.getDate();

            // Checking if current tournaments are still current.
            if(currentTournamentTournamentEndDate.compareTo(today) < 0){

                // Creating new ArrayList to receive current tourneys ArrayList from Members
                ArrayList<Long> updateCurrentTournament = new ArrayList<>();
                updateCurrentTournament = member.getCurrentTournaments();

                // Saving tournament to variable and adding to past Tournaments array
                Long changeTournamentToPast = updateCurrentTournament.get(counterForIndex);

                ArrayList<Long> pastTournamentsToUpdate = member.getPastTournaments();
                pastTournamentsToUpdate.add(changeTournamentToPast);
                member.setPastTournaments(pastTournamentsToUpdate);

                // Delete tournament from Current tournaments & update Current tournaments in Member Obj
                updateCurrentTournament.remove(counterForIndex);
                member.setCurrentTournaments(updateCurrentTournament);

                // Subtract one for counterForIndex
                counterForIndex--;
            }

            // Increasing the counters
            counterForLoop++;
            counterForIndex++;
        }

//        System.out.println("Current Tournaments: " + members.getCurrentTournaments());
//        System.out.println("Past Tournaments: "  + members.getPastTournaments());
    }

    public void updateMemberUpcomingTournaments(Member member) {
        // Getting Members Upcoming Tournaments Array from Members Object
        ArrayList<Long> upcomingTournamentsArray = member.getUpcomingTournaments();

        // Size of array for counter
        int sizeOfArray = upcomingTournamentsArray.size();

        // Variables for Processing
        Long tourneyId = null;
        Tournaments upcomingTournament = new Tournaments();
        Tournaments tourney = new Tournaments();

        // Counter for Loop Control
        int counterForLoop = 0;
        //Counter for Index Control
        int counterForIndex = 0;

        while(counterForLoop < sizeOfArray){

            // Getting the upcoming tourneyId
            tourneyId = upcomingTournamentsArray.get(counterForIndex);

            // Finding the upcoming tournament and getting Start / End dates
            upcomingTournament = tourney.getTournamentByIdForJson(tourneyId);

            // Creating Date Objects
            Date upcomingTournamentTournamentStartDate = upcomingTournament.getTournamentStartDate();

            Date today = new Date();
            today.getDate();

            // Checking if upcoming tournaments should now be current tournaments.
            if(today.compareTo(upcomingTournamentTournamentStartDate) > 0){

                // Creating new ArrayList to receive current tourneys ArrayList from Members
                ArrayList<Long> updateCurrentTournament = new ArrayList<>();
                updateCurrentTournament = member.getCurrentTournaments();

                // Saving tournament to variable and adding to Current Tournaments ArrayList
                if(updateCurrentTournament.size() != 0){
                    Long changeTournamentToCurrent = updateCurrentTournament.get(counterForIndex);
                    ArrayList<Long> currentTournamentsToUpdate = member.getCurrentTournaments();
                    currentTournamentsToUpdate.add(changeTournamentToCurrent);
                    member.setPastTournaments(currentTournamentsToUpdate);
                } else {

                }

                // Delete tournament from Upcoming tournaments & update Upcoming tournaments in Member Obj
                updateCurrentTournament.remove(counterForIndex);
                member.setCurrentTournaments(updateCurrentTournament);

                // Subtract one for counterForIndex
                counterForIndex--;
            }

            // Increasing the counters
            counterForLoop++;
            counterForIndex++;
        }

        System.out.println("Current Tournaments: " + member.getCurrentTournaments());
        System.out.println("Past Tournaments: "  + member.getPastTournaments());
    }


    public static void main(String[] args) throws Exception{

//        // Creating ArrayLists for what Beginning of tests
//        ArrayList<String> currentTournamentsBeginning = new ArrayList<>();
//
//        ArrayList<String> upcomingTournamentsBeginning = new ArrayList<>();
//        upcomingTournamentsBeginning.add("5");
//
//        // Creating Array Lists for what Test should equal at end
//        ArrayList<String> currentTournamentsEndTest = new ArrayList<>();
//        currentTournamentsEndTest.add("5");
//
//        ArrayList<String> upcomingTournamentsEndTest = new ArrayList<>();
//
//        Member member1 = new Member(2L, "Jimmy", "Rodgers", "Jimmy1_1@hotmail.com", "19 Kingpin Dr", "8670666");
//        member1.setCurrentTournaments(currentTournamentsBeginning);
//        member1.setPastTournaments(upcomingTournamentsBeginning);
//
//        Tournaments tourney = new Tournaments();
//
//        System.out.println("Test 1 - Currents");
//        System.out.println("Expected: " + currentTournamentsBeginning);
//        System.out.println("Actual: " + member1.getCurrentTournaments());
//        System.out.println("Test 1 - Upcoming");
//        System.out.println("Expected: " + upcomingTournamentsBeginning);
//        System.out.println("Actual: " + member1.getUpcomingTournaments());
//
////        Assertions.assertEquals(currentTournamentsBeginning, member1.getCurrentTournaments());
//
//        tourney.updateMemberCurrentTournaments(member1);
//        System.out.println();
//
////        Assertions.assertEquals(currentTournamentsEndTest, member1.getCurrentTournaments());
//        System.out.println("Test 2 - Currents");
//        System.out.println("Expected: " + currentTournamentsEndTest);
//        System.out.println("Actual: " + member1.getCurrentTournaments());
//        System.out.println("Test 2 - End");
//        System.out.println("Expected: " + currentTournamentsEndTest);
//        System.out.println("Actual: " + member1.getUpcomingTournaments());

    }

}
