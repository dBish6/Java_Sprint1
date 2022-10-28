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
    public static JSONObject createMemberObj(Membership member){

        JSONObject objBody = new JSONObject();
        Long membershipID = member.getMembershipID();
        String membershipType = member.getMembershipType();
        Date membershipStartDate = member.getMembershipStartDate();
        Date membershipEndDate = member.getMembershipEndDate();

        objBody.put("membershipID",membershipID);
        objBody.put("membershipType",membershipType);
        objBody.put("membershipStartDate",membershipStartDate);
        objBody.put("membershipExpireDate",membershipEndDate);

        if(Objects.equals(membershipType, "Family Plan")) {
            JSONArray familyMembers = new JSONArray();
            member.memberList.forEach(person -> {
                int memberCount = member.memberList.size();
                int monthlyMembershipCost = memberCount * 100;
                objBody.put("monthlyMembershipCost",monthlyMembershipCost);

                JSONObject personObject = new JSONObject();
                Long id = person.getId();
                String name = person.getFirstName() + " " + person.getLastName();
                String email = person.getEmail();
                String phone = person.getPhoneNumber();
                String address = person.getAddress();
                ArrayList<String> pastTournaments = person.getPastTournaments();
                ArrayList<String> currentTournaments = person.getCurrentTournaments();
                ArrayList<String> upcomingTournaments = person.getUpcomingTournaments();
                personObject.put("memberID",id);
                personObject.put("name",name);
                personObject.put("email",email);
                personObject.put("phone",phone);
                personObject.put("address",address);
                personObject.put("currentTournaments",currentTournaments);
                personObject.put("pastTournaments",pastTournaments);
                personObject.put("upcomingTournaments",upcomingTournaments);

                objBody.put("familyMembers",personObject);
            });
        } else {
            if(Objects.equals(membershipType, "Standard")){
            int monthlyMembershipCost = 125;
            objBody.put("monthlyMembershipCost",monthlyMembershipCost);
        } else if(Objects.equals(membershipType, "Trial")){
            int monthlyMembershipCost = 0;
            objBody.put("monthlyMembershipCost",monthlyMembershipCost);
        } else if(Objects.equals(membershipType, "Special Offer")){
            int monthlyMembershipCost = 115;
            objBody.put("monthlyMembershipCost",monthlyMembershipCost);
        }
            member.memberList.forEach(person -> {

                Long id = person.getId();
                String name = person.getFirstName() + " " + person.getLastName();
                String email = person.getEmail();
                String phone = person.getPhoneNumber();
                String address = person.getAddress();
                ArrayList<String> pastTournaments = person.getPastTournaments();
                ArrayList<String> currentTournaments = person.getCurrentTournaments();
                ArrayList<String> upcomingTournaments = person.getUpcomingTournaments();
                objBody.put("memberID", id);
                objBody.put("name", name);
                objBody.put("email", email);
                objBody.put("phone", phone);
                objBody.put("address", address);
                objBody.put("currentTournaments", currentTournaments);
                objBody.put("pastTournaments", pastTournaments);
                objBody.put("upcomingTournaments", upcomingTournaments);
            });
        }
        JSONObject memberObject = new JSONObject();
        memberObject.put("member",objBody);

        return memberObject;
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
