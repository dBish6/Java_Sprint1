package com.keyin.golf.json_data;

/* Read.java
   Class to Read (decode) the two JSON files; members.json & tournaments.json.

   Author: David Bishop
   Contributors: Dominic Whelan, Chris Doucette and Blake Waddleton.
   Creation Date: Oct 24, 2022

 */

import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Read {
// <===========================================/ members.json Reader Start \===========================================>

    // Read All Members
    public static void readAllJSONMembers() {

        JSONParser jsonParser = new JSONParser();
        try(FileReader reader = new FileReader("src/main/golf.club.json/members.json")) {
            // Reads the JSON File above and then parses it to object form.
            Object obj = jsonParser.parse(reader);
            // To Json array.
            JSONArray memberArray = (JSONArray) obj;
//            System.out.println(memberArray);
            // Iterate over memberArray, one record at a time from the parseMemberObj function.
            memberArray.forEach(member -> parseMemberObj((JSONObject) member));
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    // Helper Function...
    protected static void parseMemberObj(JSONObject member) {
        String memberName; String email; String phone; String address;
        JSONArray currentTournaments; JSONArray pastTournaments; JSONArray upcomingTournaments;

        // First get the whole JSONObject to get specified values.
        JSONObject memberObj = (JSONObject) member.get("member");
        // Get member memberID, membershipID, membershipType, membershipStartDate, membershipExpireDate, etc.
        Long memberID = (Long) memberObj.get("memberID");
        Long membershipID = (Long) memberObj.get("membershipID");
        String membershipType = (String) memberObj.get("membershipType");
        String membershipStartDate = (String) memberObj.get("membershipStartDate");
        String membershipExpireDate = (String) memberObj.get("membershipExpireDate");
        Long monthlyMembershipCost = (Long) memberObj.get("monthlyMembershipCost");

        if (Objects.equals(membershipType, "Standard") ||
                Objects.equals(membershipType, "Trail") ||
                Objects.equals(membershipType, "Special Offer")) {
            System.out.println("MemberID: " + memberID);
        }
        System.out.println("membershipID: " + membershipID);
        System.out.println("Membership Type: " + membershipType);
        System.out.println("Membership Start Date: " + membershipStartDate);
        System.out.println("Membership Expire Date: " + membershipExpireDate);
        System.out.println("Monthly Membership Cost: $" + monthlyMembershipCost);
        // If membershipType equals Family Plan.
        if (Objects.equals(membershipType, "Family Plan")) {
            JSONArray familyMembers = (JSONArray) memberObj.get("familyMembers");
            int count = 1;
            // Iterate though each familyMember object in the familyMembers JSONArray.
            for (Object familyMember : familyMembers) {
                // Then create the JSONObject out of the family members.
                JSONObject members = (JSONObject) familyMember;
                System.out.println("*Family Member " + count++ + "*");
                memberID = (Long) members.get("memberID");
                memberName = (String) members.get("name");
                email = (String) members.get("email");
                phone = (String) members.get("phone");
                address = (String) members.get("address");
                currentTournaments = (JSONArray) members.get("currentTournaments");
                pastTournaments = (JSONArray) members.get("pastTournaments");
                upcomingTournaments = (JSONArray) members.get("upcomingTournaments");
                System.out.println("MemberID: " + memberID);
                System.out.println("Name: " + memberName);
                System.out.println("Email: " + email);
                System.out.println("Phone: " + phone);
                System.out.println("Address: " + address);
                System.out.println("Current Tournaments: " + currentTournaments);
                System.out.println("Past Tournaments: " + pastTournaments);
                System.out.println("Upcoming Tournaments: " + upcomingTournaments);
            }
            System.out.println();
        } else {
            memberName = (String) memberObj.get("name");
            email = (String) memberObj.get("email");
            phone = (String) memberObj.get("phone");
            address = (String) memberObj.get("address");
            currentTournaments = (JSONArray) memberObj.get("currentTournaments");
            pastTournaments = (JSONArray) memberObj.get("pastTournaments");
            upcomingTournaments = (JSONArray) memberObj.get("upcomingTournaments");
            System.out.println("Name: " + memberName);
            System.out.println("Email: " + email);
            System.out.println("Phone: " + phone);
            System.out.println("Address: " + address);
            System.out.println("Current Tournaments: " + currentTournaments);
            System.out.println("Past Tournaments: " + pastTournaments);
            System.out.println("Upcoming Tournaments: " + upcomingTournaments + "\n");
        }
    }

    // Method to DISPLAY a member's JSON record by Id.
    public static void displayJSONMemberByMembershipID(int Id) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("src/main/golf.club.json/members.json")) {
            // Reads JSON File above and then parses it to object form.
            Object obj = jsonParser.parse(reader);
            // To Json array.
            JSONArray memberArray = (JSONArray) obj;
            Long storedID = null;
            // Iterate though the objects in the JSONArray.
            for (Object objects : memberArray) {
                // Then creates the JSONObject out of the objects.
                JSONObject jsonObjects = (JSONObject) objects;
                // Gets the member objects.
                JSONObject memberObj = (JSONObject) jsonObjects.get("member");

                Long memberID = (Long) memberObj.get("memberID");
                Long membershipID = (Long) memberObj.get("membershipID");
                String membershipType = (String) memberObj.get("membershipType");
                String membershipStartDate = (String) memberObj.get("membershipStartDate");
                String membershipExpireDate = (String) memberObj.get("membershipExpireDate");
                Long monthlyMembershipCost = (Long) memberObj.get("monthlyMembershipCost");
                String memberName = (String) memberObj.get("name");
                String address = (String) memberObj.get("address");
                String email = (String) memberObj.get("email");
                String phone = (String) memberObj.get("phone");
                JSONArray currentTournaments = (JSONArray) memberObj.get("currentTournaments");
                JSONArray pastTournaments = (JSONArray) memberObj.get("pastTournaments");
                JSONArray upcomingTournaments = (JSONArray) memberObj.get("upcomingTournaments");

                // Converts the inputted Id to Long because membershipID is Long data type.
                Long userInputId = Long.valueOf(Id);

                // If membershipType does not equal Family Plan.
                if (!Objects.equals(membershipType, "Family Plan")) {
                    if (Objects.equals(membershipID, userInputId)) {
                        // For error checking.
                        storedID = membershipID;
                        System.out.println("MemberID: " + memberID);
                        System.out.println("membershipID: " + membershipID);
                        System.out.println("Membership Type: " + membershipType);
                        System.out.println("Membership Start Date: " + membershipStartDate);
                        System.out.println("Membership Expire Date: " + membershipExpireDate);
                        System.out.println("Monthly Membership Cost: $" + monthlyMembershipCost);
                        System.out.println("Name: " + memberName);
                        System.out.println("Address: " + address);
                        System.out.println("Email: " + email);
                        System.out.println("Phone: " + phone);
                        System.out.println("Current Tournaments: " + currentTournaments);
                        System.out.println("Past Tournaments: " + pastTournaments);
                        System.out.println("Upcoming Tournaments: " + upcomingTournaments + "\n");
                    }
                } else if (Objects.equals(membershipID, userInputId)) {
                    // Else when membershipType equals Family Plan.
                    JSONArray familyMembers = (JSONArray) memberObj.get("familyMembers");
                    // Iterate though each familyMember object in the familyMembers JSONArray.
                    System.out.println("membershipID: " + membershipID);
                    System.out.println("Membership Type: " + membershipType);
                    System.out.println("Membership Start Date: " + membershipStartDate);
                    System.out.println("Membership Expire Date: " + membershipExpireDate);
                    System.out.println("Monthly Membership Cost: $" + monthlyMembershipCost);
                    storedID = membershipID;
                    int count = 1;
                    for (Object familyMember : familyMembers) {
                        // Then create the JSONObject out of the family members.
                        JSONObject members = (JSONObject) familyMember;
                        memberID = (Long) members.get("memberID");
                        memberName = (String) members.get("name");
                        address = (String) members.get("address");
                        email = (String) members.get("email");
                        phone = (String) members.get("phone");
                        currentTournaments = (JSONArray) members.get("currentTournaments");
                        pastTournaments = (JSONArray) members.get("pastTournaments");
                        upcomingTournaments = (JSONArray) members.get("upcomingTournaments");

                        System.out.println("*Family Member " + count++ + "*");
                        System.out.println("MemberID: " + memberID);
                        System.out.println("Name: " + memberName);
                        System.out.println("Email: " + email);
                        System.out.println("Phone: " + phone);
                        System.out.println("Address: " + address);
                        System.out.println("Current Tournaments: " + currentTournaments);
                        System.out.println("Past Tournaments: " + pastTournaments);
                        System.out.println("Upcoming Tournaments: " + upcomingTournaments);
                    }
                    System.out.println();
                }
            }
            if (storedID != Long.valueOf(Id)) {
                System.err.println("ERROR: No member matches given ID.");
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    // Method to GET a member's JSON record by Id.
    public static JSONObject getMemberJSONRecordByMemberID(int Id) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("src/main/golf.club.json/members.json")) {
            // Reads JSON File above and then parses it to object form.
            Object obj = jsonParser.parse(reader);
            // To Json array.
            JSONArray memberArray = (JSONArray) obj;
            // Iterate though the objects in the JSONArray.
            for (Object objects : memberArray) {
                // Then creates the JSONObject out of the objects.
                JSONObject jsonObjects = (JSONObject) objects;
                // Gets the member objects, so we can get the memberID.
                JSONObject memberObj = (JSONObject) jsonObjects.get("member");
                String membershipType = (String) memberObj.get("membershipType");
                // If membershipType does not equal Family Plan.
                if (!Objects.equals(membershipType, "Family Plan")) {
                    Long memberID = (Long) memberObj.get("memberID");
                    // Converts the inputted Id to Long because memberID is Long data type.
                    Long userInputId = Long.valueOf(Id);
                    if (Objects.equals(memberID, userInputId)) {
                        return jsonObjects;
                    }
                } else {
                    // Else when membershipType equals Family Plan.
                    JSONArray familyMembers = (JSONArray) memberObj.get("familyMembers");
                    // Iterate though each familyMember object in the familyMembers JSONArray.
                    for (Object familyMember : familyMembers) {
                        // Then create the JSONObject out of the family members.
                        JSONObject members = (JSONObject) familyMember;
                        Long memberID = (Long) members.get("memberID");
                        Long userInputId = Long.valueOf(Id);
                        if (Objects.equals(memberID, userInputId)) {
                            return jsonObjects;
                        }
                    }
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
// <=========================================/ tournaments.json Reader Start \=========================================>

    // Read all Tournaments
    public static void readAllJSONTournaments() {

        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("src/main/golf.club.json/tournaments.json")) {
            // Reads the JSON File above and then parses it to object form.
            Object obj = jsonParser.parse(reader);
            // To Json array.
            JSONArray tournamentArray = (JSONArray) obj;
//            System.out.println(tournamentList);
            // Iterate over tournamentArray, one record at a time from the parseTournamentObj function.
            tournamentArray.forEach(tournament -> parseTournamentObj((JSONObject) tournament));
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    // Helper Function...
    protected static void parseTournamentObj(JSONObject tournament) {
        // First get the whole JSONObject to get specified values.
        JSONObject tournamentObj = (JSONObject) tournament.get("tournament");
        // Get member memberID, name, email, and phone, etc.
        Long tournamentID = (Long) tournamentObj.get("tournamentID");
        String tournamentStartDate = (String) tournamentObj.get("tournamentStartDate");
        String tournamentEndDate = (String) tournamentObj.get("tournamentEndDate");
        String tournamentName = (String) tournamentObj.get("name");
        String location = (String) tournamentObj.get("location");
        Long entryFee = (Long) tournamentObj.get("entryFee");
        Long cashPrize = (Long) tournamentObj.get("cashPrize");
        System.out.println("tournamentID: " + tournamentID);
        System.out.println("tournamentStartDate: " + tournamentStartDate);
        System.out.println("tournamentEndDate: " + tournamentEndDate);
        System.out.println("Name: " + tournamentName);
        System.out.println("location: " + location);
        System.out.println("Entry Fee: " + entryFee);
        System.out.println("Cash Prize: " + cashPrize);

        // Get membersParticipating...
        JSONArray membersParticipating = (JSONArray) tournamentObj.get("membersParticipating");
        System.out.println("*Members Participating*");
        // Iterate though each member object in the familyMembers JSONArray.
        for (Object member : membersParticipating) {
            // Then creates the JSONObject out of the JSONArray.
            JSONObject members = (JSONObject) member;
            // Iterates through each key in the members JSONObject.
            for (Object key : members.keySet()) {
                // Gets each of the keys values.
                Long memberValue = (Long) members.get(key);
                // I don't know how this prints downwards, pretty cool though.
                System.out.print(key + ", ");
                System.out.println(memberValue);
            }
        }

        // Get finalStandings...
        JSONArray finalStandings = (JSONArray) tournamentObj.get("finalStandings");
        System.out.println("*Final Standings*");
        if (finalStandings != null) {
            // Creates the JSONObject out of the JSONArray.
            for (Object standing : finalStandings) {
                JSONObject standings = (JSONObject) standing;
                // Iterates through each of the keys in the standings JSONObject.
                for (Object key : standings.keySet()) {
                    // Gets each of the keys values.
                    String standingValue = (String) standings.get(key);
                    System.out.print(key + ", ");
                    System.out.println(standingValue);
                }
            }
            System.out.println();
        } else {
            System.out.println(finalStandings + "\n");
        }
    }

    // Method to get a tournament's JSON record by Id.
    public static JSONObject getTournamentJSONRecordById(Long Id) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("src/main/golf.club.json/tournaments.json")) {
            // Reads JSON File above and then parses it to object form.
            Object obj = jsonParser.parse(reader);
            // To Json array.
            JSONArray tournamentArray = (JSONArray) obj;
            Long storedID = null;
            // Iterate though the objects in the JSONArray.
            for (Object objects : tournamentArray) {
                // Then creates the JSONObject out of the objects.
                JSONObject jsonObjects = (JSONObject) objects;
                // Gets the tournament objects.
                JSONObject tournamentObj = (JSONObject) jsonObjects.get("tournament");
                Long tournamentID = (Long) tournamentObj.get("tournamentID");
                String tournamentStartDate = (String) tournamentObj.get("tournamentStartDate");
                String tournamentEndDate = (String) tournamentObj.get("tournamentEndDate");
                String tournamentName = (String) tournamentObj.get("name");
                String location = (String) tournamentObj.get("location");
                Long entryFee = (Long) tournamentObj.get("entryFee");
                Long cashPrize = (Long) tournamentObj.get("cashPrize");

                Long userInputId = Long.valueOf(Id);
                if (Objects.equals(tournamentID, userInputId)) {
                    // For error checking.
                    storedID = tournamentID;
                    System.out.println("tournamentID: " + tournamentID);
                    System.out.println("tournamentStartDate: " + tournamentStartDate);
                    System.out.println("tournamentEndDate: " + tournamentEndDate);
                    System.out.println("Name: " + tournamentName);
                    System.out.println("location: " + location);
                    System.out.println("Entry Fee: " + entryFee);
                    System.out.println("Cash Prize: " + cashPrize);

                    JSONArray membersParticipating = (JSONArray) tournamentObj.get("membersParticipating");
                    System.out.println("*Members Participating*");
                    for (Object member : membersParticipating) {
                        JSONObject members = (JSONObject) member;
                        for (Object key : members.keySet()) {
                            Long memberValue = (Long) members.get(key);
                            System.out.print(key + ", ");
                            System.out.println(memberValue);
                        }
                    }

                    JSONArray finalStandings = (JSONArray) tournamentObj.get("finalStandings");
                    System.out.println("*Final Standings*");
                    if (finalStandings != null) {
                        for (Object standing : finalStandings) {
                            JSONObject standings = (JSONObject) standing;
                            for (Object key : standings.keySet()) {
                                String standingValue = (String) standings.get(key);
                                System.out.print(key + ", ");
                                System.out.println(standingValue);
                            }
                        }
                        System.out.println();
                    } else {
                        System.out.println(finalStandings + "\n");
                    }
                }
            }
            if (storedID != Long.valueOf(Id)) {
                System.err.println("ERROR: No tournament matches given ID.");
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    // Method to get a tournament's JSON record by Id.
    public static JSONObject getTournamentJSONRecordById(int Id) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("src/main/golf.club.json/tournaments.json")) {
            Object obj = jsonParser.parse(reader);
            JSONArray tournamentArray = (JSONArray) obj;
            for (Object objects : tournamentArray) {
                JSONObject jsonObjects = (JSONObject) objects;
                JSONObject tournamentObj = (JSONObject) jsonObjects.get("tournament");
                Long tournamentID = (Long) tournamentObj.get("tournamentID");
                Long userInputId = Long.valueOf(Id);
                if (Objects.equals(tournamentID, userInputId)) {
                    return jsonObjects;
                }
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
