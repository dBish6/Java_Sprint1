package com.keyin.golf.json_data;

/* Read.java
   Class for members of the tournament...

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
//    public static void main(String[] args)
    public void readMembersJSON()
    {

        JSONParser jsonParser = new JSONParser();
        try(FileReader reader = new FileReader("src/main/golf.club.json/members.json")) {
            // Reads JSON File above and then parses it to object form.
            Object obj = jsonParser.parse(reader);
            // To Json array.
            JSONArray memberList = (JSONArray) obj;
//            System.out.println(memberList);
            // Iterate over emp array, one record at a time from parseEmpObj function.
            memberList.forEach(member -> parseMemberObj((JSONObject) member));

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    private static void parseMemberObj(JSONObject member) {
        String memberName; String email; String phone; String address;

        JSONObject memberObj = (JSONObject) member.get("member");
        // Get member memberID, name, email, and phone, etc.
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
        if (Objects.equals(membershipType, "Family Plan")) {
            JSONArray familyMembers = (JSONArray) memberObj.get("familyMembers");
            int count = 1;
            // Iterate though each familyMember in the familyMembers JSONArray.
            for (Object familyMember : familyMembers) {
                JSONObject members = (JSONObject) familyMember;
//                System.out.println("FOR LOOP: " + members);
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
        // Somehow add these to the class here in this function.
    }

//    public void readTournamentsJSON()
    public static void main(String[] args)
    {
        JSONParser jsonParser = new JSONParser();
        try(FileReader reader = new FileReader("src/main/golf.club.json/tournaments.json")) {
            // Reads JSON File above and then parses it to object form.
            Object obj = jsonParser.parse(reader);
            // To Json array.
            JSONArray tournamentList = (JSONArray) obj;
           System.out.println(tournamentList);
            // Iterate over emp array, one record at a time from parseEmpObj function.
            tournamentList.forEach(tournament -> parsetournamentObj((JSONObject) tournament));

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    private static void parsetournamentObj(JSONObject tournament) {
        Long participatingMember; String memberStanding;

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
//        JSONObject membersParticipating = (JSONObject) tournamentObj.get("membersParticipating");
//        System.out.println("Members Participating: " + membersParticipating);

        JSONArray membersParticipating = (JSONArray) tournamentObj.get("membersParticipating");
//        System.out.println(membersParticipating);
        int count1 = 1; int count2 = 1;
        for (Object member : membersParticipating) {
            JSONObject members = (JSONObject) member;
                System.out.println("FOR LOOP: " + members);
            String mem = "member" + count1++;
            participatingMember = (Long) members.get("member");
            System.out.println("*Members Participating*");
            System.out.println("Member " + count2++ + ": " + participatingMember);
        }

        JSONArray finalStandings = (JSONArray) tournamentObj.get("finalStandings");
//        System.out.println(finalStandings.size());
        int count3 = 1;
        for (Object standing : finalStandings) {
            String s = Integer.toString(count3++);
            JSONObject standings = (JSONObject) standing;
            System.out.println(standings);
            System.out.println(s);
//            System.out.println("FOR LOOP: " + standing);
            memberStanding = (String) standings.get(s);
            System.out.println("*Final Standings*");
            System.out.println(count3++ + ": " + memberStanding);
        }
    }
}
