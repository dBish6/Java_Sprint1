package com.keyin.golf.json_data;

/* Write.java
   Class that writes/edits Json files.
   Methods to create JSON objects
   Method to add object to desired file
   Methods that change the value of given parameters

   Author: Dominic Whelan
   Contributors:  David Bishop, Chris Doucette and Blake Waddleton
   Creation Date: Oct 24, 2022

 */

// imports
import com.keyin.golf.Membership;
import com.keyin.golf.Tournaments;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.FileWriter;
// imports for Error handling
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Date;

public class Write {

    // leave commented until Members Class methods required are completed
    public static JSONObject createMemberObj(Membership membership){

        JSONObject memberBody = new JSONObject();
        Long membershipID = membership.getMembershipID();
        String membershipType = membership.getMembershipType();
        Date membershipStartDate = membership.getMembershipStartDate();
        Date membershipEndDate = membership.getMembershipEndDate();

        memberBody.put("membershipID",membershipID);
        memberBody.put("membershipType",membershipType);
        memberBody.put("membershipStartDate",membershipStartDate);
        memberBody.put("membershipExpireDate",membershipEndDate);

        if(Objects.equals(membershipType, "Family Plan")) {
            JSONArray familyMembers = new JSONArray();
            membership.memberList.forEach(member -> {
                int memberCount = membership.memberList.size();
                int monthlyMembershipCost = memberCount * 100;
                memberBody.put("monthlyMembershipCost",monthlyMembershipCost);

                JSONObject memberObject = new JSONObject();
                Long id = member.getId();
                String name = member.getFirstName() + " " + member.getLastName();
                String email = member.getEmail();
                String phone = member.getPhoneNumber();
                String address = member.getAddress();
                ArrayList<Long> pastTournaments = member.getPastTournaments();
                ArrayList<Long> currentTournaments = member.getCurrentTournaments();
                ArrayList<Long> upcomingTournaments = member.getUpcomingTournaments();
                memberObject.put("memberID",id);
                memberObject.put("name",name);
                memberObject.put("email",email);
                memberObject.put("phone",phone);
                memberObject.put("address",address);
                memberObject.put("currentTournaments",currentTournaments);
                memberObject.put("pastTournaments",pastTournaments);
                memberObject.put("upcomingTournaments",upcomingTournaments);

                memberBody.put("familyMembers",memberObject);
            });
        } else {
            if(Objects.equals(membershipType, "Standard")){
            int monthlyMembershipCost = 125;
            memberBody.put("monthlyMembershipCost",monthlyMembershipCost);
        } else if(Objects.equals(membershipType, "Trial")){
            int monthlyMembershipCost = 0;
            memberBody.put("monthlyMembershipCost",monthlyMembershipCost);
        } else if(Objects.equals(membershipType, "Special Offer")){
            int monthlyMembershipCost = 115;
            memberBody.put("monthlyMembershipCost",monthlyMembershipCost);
        }
            membership.memberList.forEach(person -> {

                Long id = person.getId();
                String name = person.getFirstName() + " " + person.getLastName();
                String email = person.getEmail();
                String phone = person.getPhoneNumber();
                String address = person.getAddress();
                ArrayList<Long> pastTournaments = person.getPastTournaments();
                ArrayList<Long> currentTournaments = person.getCurrentTournaments();
                ArrayList<Long> upcomingTournaments = person.getUpcomingTournaments();
                memberBody.put("memberID", id);
                memberBody.put("name", name);
                memberBody.put("email", email);
                memberBody.put("phone", phone);
                memberBody.put("address", address);
                memberBody.put("currentTournaments", currentTournaments);
                memberBody.put("pastTournaments", pastTournaments);
                memberBody.put("upcomingTournaments", upcomingTournaments);
            });
        }
        JSONObject memberObject = new JSONObject();
        memberObject.put("member",memberBody);

        addToFile(memberObject,"src/main/golf.club.json/members.json");
        return memberObject;
    }

    public static JSONObject createTournamentObj(Tournaments tournament){
        JSONObject tournamentObject = new JSONObject();
        Long tournamentID = tournament.getTournamentId();
        Date tournamentStartDate = tournament.getTournamentStartDate();
        Date tournamentEndDate = tournament.getTournamentEndDate();
        String tournamentName = tournament.getTournamentName();
        String location = tournament.getTournamentLocation();
        Long entryFee = tournament.getTournamentEntryFee();
        Long cashPrize = tournament.getTournamentCashPrize();
        JSONObject membersParticipating = new JSONObject();
        ArrayList<Long> members = tournament.getMembersParticipating();
        int count;
        members.forEach(member->{
            String key = "member" + members.indexOf(member);
            membersParticipating.put(key,member);
        });
//        ArrayList<Long> finalStandings = tournament.getFinalStandings();
//        finalStandings.forEach(standing->{
//
//        });
        tournamentObject.put("tournamentID",tournamentID);
        tournamentObject.put("tournamentStartDate",tournamentStartDate);
        tournamentObject.put("tournamentEndDate",tournamentEndDate);
        tournamentObject.put("name",tournamentName);
        tournamentObject.put("location",location);
        tournamentObject.put("entryFee",entryFee);
        tournamentObject.put("cashPrize",cashPrize);
        tournamentObject.put("membersParticipating",members);

        JSONObject completeObject = new JSONObject();
        completeObject.put("tournament",tournamentObject);

        addToFile(completeObject,"src/main/golf.club.json/tournaments.json");
        return completeObject;
    }

    public static void addToFile(JSONObject objectToAdd, String filename){

        JSONParser jsonParser = new JSONParser();
        try(FileReader reader = new FileReader(filename)) {
            // Reads JSON File above and then parses it to object form.
            Object obj = jsonParser.parse(reader);
            // To Json array.
            JSONArray objectList = (JSONArray) obj;
            objectList.add(objectToAdd);


            try(FileWriter writer = new FileWriter(filename)){
                writer.write(objectList.toJSONString());
            }
        }  catch (IOException | ParseException e) {
                e.printStackTrace();
        }
    }



    public static void main(String[] args) {

        JSONObject testMember = new JSONObject();

        JSONObject obj = new JSONObject();
        obj.put("name","dominic");
        obj.put("email","some.email.email.com");

        testMember.put("member", obj);

        addToFile(testMember,"src/main/golf.club.json/members.json");
    }
}
