package com.keyin.golf.json_data;

/* Read.java
   Class to Read (decode) the two JSON files; members.json & tournaments.json.

   Author: David Bishop
   Contributors: Dominic Whelan, Chris Doucette and Blake Waddleton.
   Creation Date: Oct 24, 2022

 */

import java.io.FileNotFoundException;
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
    public static void readMembersJSON() {

        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("src/main/golf.club.json/members.json")) {
            // Reads the JSON File above and then parses it to object form.
            Object obj = jsonParser.parse(reader);
            // To Json array.
            JSONArray memberArray = (JSONArray) obj;
//            System.out.println(memberArray);
            // Iterate over memberArray, one record at a time from the parseMemberObj function.
            memberArray.forEach(member -> parseMemberObj((JSONObject) member));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }
    protected static void parseMemberObj(JSONObject member) {
        String memberName; String email; String phone; String address;

        // First get the whole JSONObject to get specified values.
        JSONObject memberObj = (JSONObject) member.get("member");
        // Get member memberID, membershipType, membershipStartDate, membershipExpireDate, etc.
        Long memberID = (Long) memberObj.get("memberID");
        String membershipType = (String) memberObj.get("membershipType");
        String membershipStartDate = (String) memberObj.get("membershipStartDate");
        String membershipExpireDate = (String) memberObj.get("membershipExpireDate");
        String currentTournaments = (String) memberObj.get("currentTournaments");
        String pastTournaments = (String) memberObj.get("pastTournaments");
        String upcomingTournaments = (String) memberObj.get("upcomingTournaments");
        String familyPlayer = (String) memberObj.get("familyPlayer");

        if (Objects.equals(membershipType, "Standard") ||
            Objects.equals(membershipType, "Trail") ||
            Objects.equals(membershipType, "Special Offer")) {
            System.out.println("MemberID: " + memberID);
        }
        System.out.println("Membership Type: " + membershipType);
        System.out.println("Membership Start Date: " + membershipStartDate);
        System.out.println("Membership Expire Date: " + membershipExpireDate);
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
                System.out.println("MemberID: " + memberID);
                System.out.println("Name: " + memberName);
                System.out.println("Email: " + email);
                System.out.println("Phone: " + phone);
                System.out.println("Address: " + address);
            }
            System.out.println("Family Player(s): " + familyPlayer);
        } else {
            memberName = (String) memberObj.get("name");
            email = (String) memberObj.get("email");
            phone = (String) memberObj.get("phone");
            address = (String) memberObj.get("address");
            System.out.println("Name: " + memberName);
            System.out.println("Email: " + email);
            System.out.println("Phone: " + phone);
            System.out.println("Address: " + address);
        }
        System.out.println("Current Tournaments: " + currentTournaments);
        System.out.println("Past Tournaments: " + pastTournaments);
        System.out.println("Upcoming Tournaments: " + upcomingTournaments + "\n");
    }

    // Method to DISPLAY a member's JSON record by Id.
    public static void displayJSONMemberById(int Id) {
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
                // Gets the member objects.
                JSONObject memberObj = (JSONObject) jsonObjects.get("member");

                Long memberID = (Long) memberObj.get("memberID");
                String membershipType = (String) memberObj.get("membershipType");
                String membershipStartDate = (String) memberObj.get("membershipStartDate");
                String membershipExpireDate = (String) memberObj.get("membershipExpireDate");
                String memberName = (String) memberObj.get("name");
                String address = (String) memberObj.get("address");
                String email = (String) memberObj.get("email");
                String phone = (String) memberObj.get("phone");
                String currentTournaments = (String) memberObj.get("currentTournaments");
                String pastTournaments = (String) memberObj.get("pastTournaments");
                String upcomingTournaments = (String) memberObj.get("upcomingTournaments");
                String familyPlayer = (String) memberObj.get("familyPlayer");

                // Converts the inputted Id to Long because memberID is Long data type.
                Long userInputId = Long.valueOf(Id);

                // If membershipType does not equal Family Plan.
                if (!Objects.equals(membershipType, "Family Plan")) {
                    if (Objects.equals(memberID, userInputId)) {
                        System.out.println("MemberID: " + memberID);
                        System.out.println("Membership Type: " + membershipType);
                        System.out.println("Membership Start Date: " + membershipStartDate);
                        System.out.println("Membership Expire Date: " + membershipExpireDate);
                        System.out.println("Name: " + memberName);
                        System.out.println("Address: " + address);
                        System.out.println("Email: " + email);
                        System.out.println("Phone: " + phone);
                        System.out.println("Current Tournaments: " + currentTournaments);
                        System.out.println("Past Tournaments: " + pastTournaments);
                        System.out.println("Upcoming Tournaments: " + upcomingTournaments + "\n");
                    }
                } else {
                    // Else when membershipType equals Family Plan.
                    JSONArray familyMembers = (JSONArray) memberObj.get("familyMembers");
                    // Iterate though each familyMember object in the familyMembers JSONArray.
                    for (Object familyMember : familyMembers) {
                        // Then create the JSONObject out of the family members.
                        JSONObject members = (JSONObject) familyMember;
                            memberID = (Long) members.get("memberID");
                            memberName = (String) members.get("name");
                            address = (String) members.get("address");
                            email = (String) members.get("email");
                            phone = (String) members.get("phone");
                        if (Objects.equals(memberID, userInputId)) {
                            System.out.println("Membership Type: " + membershipType);
                            System.out.println("Membership Start Date: " + membershipStartDate);
                            System.out.println("Membership Expire Date: " + membershipExpireDate);
                            System.out.println("*Family Member*");
                            System.out.println("MemberID: " + memberID);
                            System.out.println("Name: " + memberName);
                            System.out.println("Email: " + email);
                            System.out.println("Phone: " + phone);
                            System.out.println("Address: " + address);
                            System.out.println("Family Player(s): " + familyPlayer);
                            System.out.println("Current Tournaments: " + currentTournaments);
                            System.out.println("Past Tournaments: " + pastTournaments);
                            System.out.println("Upcoming Tournaments: " + upcomingTournaments + "\n");
                        }
                    }
                }
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
        catch(ParseException e){
            e.printStackTrace();
        }
    }

    // Method to GET a member's JSON record by Id.
    public static JSONObject getMemberJSONRecordById(int Id) {
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
                // Gets the member objects.
                JSONObject memberObj = (JSONObject) jsonObjects.get("member");
                String membershipType = (String) memberObj.get("membershipType");
                // If membershipType does not equal Family Plan.
                if (!Objects.equals(membershipType, "Family Plan")) {
                    Long memberID = (Long) memberObj.get("memberID");
                    // Converts the inputted Id to Long because memberID is Long data type.
                    Long userInputId = Long.valueOf(Id);
                    if (Objects.equals(memberID, userInputId)) {
                        // Returns the jsonObject for further use within the project.
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
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
        catch(ParseException e){
            e.printStackTrace();
        }
        return null;
    }

// <=========================================/ tournaments.json Reader Start \=========================================>

    // Read all Tournaments
    public static void readTournamentsJSON() {

        JSONParser jsonParser = new JSONParser();
        try(FileReader reader = new FileReader("src/main/golf.club.json/tournaments.json")) {
            // Reads the JSON File above and then parses it to object form.
            Object obj = jsonParser.parse(reader);
            // To Json array.
            JSONArray tournamentArray = (JSONArray) obj;
            // Iterate over tournamentArray, one record at a time from the parseTournamentObj function.
            tournamentArray.forEach(tournament -> parseTournamentObj((JSONObject) tournament));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
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

    // Method to DISPLAY a member's JSON record by Id.
    public static void displayJSONTournamentById(int Id) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("src/main/golf.club.json/tournaments.json")) {
            // Reads JSON File above and then parses it to object form.
            Object obj = jsonParser.parse(reader);
            // To Json array.
            JSONArray tournamentArray = (JSONArray) obj;
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
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
        catch(ParseException e){
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
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
        catch(ParseException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
//        Read.readMembersJSON();
//        Read.readTournamentsJSON();
//        System.out.println(Read.getMemberJSONRecordById(124));
//        System.out.println(Read.getTournamentJSONRecordById(2));
//        Read.displayJSONMemberById(124);
        Read.displayJSONTournamentById(3);
    }
}
