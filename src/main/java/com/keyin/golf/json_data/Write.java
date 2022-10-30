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
import com.keyin.golf.Member;
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
    public JSONObject createMemberObj(Member member){
        Long memberID = member.getMemberID();
        String name = member.getName();
        String email = member.getEmail();
        String phone = member.getPhoneNumber();
        String address = member.getAddress();
        ArrayList<Long> pastTournaments = member.getPastTournaments();
        ArrayList<Long> currentTournaments = member.getCurrentTournaments();
        ArrayList<Long> upcomingTournaments = member.getUpcomingTournaments();

        JSONObject memberObject = new JSONObject();
        memberObject.put("memberID",memberID);
        memberObject.put("name",name);
        memberObject.put("email",email);
        memberObject.put("phone",phone);
        memberObject.put("address",address);
        memberObject.put("currentTournaments",currentTournaments);
        memberObject.put("pastTournaments",pastTournaments);
        memberObject.put("upcomingTournaments",upcomingTournaments);

        return memberObject;
    }

    public void addMemberToMembership(Member memberToAdd, Long membershipID){

        JSONParser jsonParser = new JSONParser();
        try(FileReader reader = new FileReader("src/main/golf.club.json/members.json")) {
            // Reads JSON File above and then parses it to object form.
            Object obj = jsonParser.parse(reader);
            // To Json array.
            JSONArray memberList = (JSONArray) obj;

            JSONObject newMember = new JSONObject();
            newMember.put("memberID",memberToAdd.getMemberID());
            newMember.put("name",memberToAdd.getName());
            newMember.put("email",memberToAdd.getEmail());
            newMember.put("phone",memberToAdd.getPhoneNumber());
            newMember.put("address",memberToAdd.getAddress());
            newMember.put("currentTournaments",memberToAdd.getCurrentTournaments());
            newMember.put("pastTournaments",memberToAdd.getPastTournaments());
            newMember.put("upcomingTournaments",memberToAdd.getUpcomingTournaments());

            memberList.forEach(member->{
                Boolean foundMatch = false;
                JSONObject memberObject = (JSONObject) member;
                if(memberObject.get("membershipID") == membershipID) {

                    foundMatch = true;

                    if (memberObject.get("membershipType") != "Family Plan") {
                        memberObject.put("membershipType", "Family Plan");
                        JSONObject firstMember = new JSONObject();
                        firstMember.put("memberID", memberObject.get("memberID"));
                        firstMember.put("name", memberObject.get("name"));
                        firstMember.put("email", memberObject.get("email"));
                        firstMember.put("phone", memberObject.get("phone"));
                        firstMember.put("address", memberObject.get("address"));
                        firstMember.put("currentTournaments", memberObject.get("currentTournaments"));
                        firstMember.put("pastTournaments", memberObject.get("pastTournaments"));
                        firstMember.put("upcomingTournaments", memberObject.get("upcomingTournaments"));

                        memberObject.remove("memberID");
                        memberObject.remove("name");
                        memberObject.remove("email");
                        memberObject.remove("phone");
                        memberObject.remove("address");
                        memberObject.remove("currentTournaments");
                        memberObject.remove("pastTournaments");
                        memberObject.remove("upcomingTournaments");

                        JSONArray familyMembers = new JSONArray();
                        familyMembers.add(firstMember);
                        familyMembers.add(newMember);
                        memberObject.put("familyMembers", familyMembers);
                        memberObject.put("monthlyMembershipCost",200L);

                    } else{
                        JSONArray familyMembers = (JSONArray) memberObject.get("familyMembers");
                        familyMembers.add(newMember);
                        int memberCount = familyMembers.size();
                        int newMembershipCost = memberCount * 100;
                        memberObject.put("monthlyMembershipCost",newMembershipCost);
                    }
                }
                if(!foundMatch){
                    System.err.println("ERROR: Membership ID not found");
                }
            });

        }  catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }
    public JSONObject createMembershipObj(Membership membership){

        JSONObject memberBody = new JSONObject();
        Long membershipID = membership.getMembershipID();
        String membershipType = membership.getMembershipType();
        Date membershipStartDate = membership.getMembershipStartDate();
        Date membershipEndDate = membership.getMembershipExpireDate();

        memberBody.put("membershipID",membershipID);
        memberBody.put("membershipType",membershipType);
        memberBody.put("membershipStartDate",membershipStartDate);
        memberBody.put("membershipExpireDate",membershipEndDate);

        if(Objects.equals(membershipType, "Family Plan")) {
            ArrayList<Member> memberList = membership.getMemberList();
            memberList.forEach(member -> {
                int memberCount = memberList.size();
                int monthlyMembershipCost = memberCount * 100;
                memberBody.put("monthlyMembershipCost",monthlyMembershipCost);

                JSONObject memberObject = new JSONObject();
                Long id = member.getMemberID();
                String name = member.getName();
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
            ArrayList<Member> memberList = membership.getMemberList();
            memberList.forEach(member -> {

                Long id = member.getMemberID();
                String name = member.getName();
                String email = member.getEmail();
                String phone = member.getPhoneNumber();
                String address = member.getAddress();
                ArrayList<Long> pastTournaments = member.getPastTournaments();
                ArrayList<Long> currentTournaments = member.getCurrentTournaments();
                ArrayList<Long> upcomingTournaments = member.getUpcomingTournaments();
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

    public JSONObject createTournamentObj(Tournaments tournament){
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

    private void addToFile(JSONObject objectToAdd, String filename){

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

}
