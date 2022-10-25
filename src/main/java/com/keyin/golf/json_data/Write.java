package com.keyin.golf.json_data;

/* Write.java
   Class that writes/edits Json files.

   Author: Dominic Whelan
   Contributors:  David Bishop, Chris Doucette and Blake Waddleton
   Creation Date: Oct 24, 2022

 */

import com.keyin.golf.Members;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Write {

//    public static JSONObject createMemberObj(Members member){
//
//        JSONObject objBody = new JSONObject();
//
//        objBody.put("memberID",member.getID());
//        objBody.put("membershipType", member.getMemberType());
//        objBody.put("membershipStartDate",member.getMemberStartDate());
//        objBody.put("membershipExpireDate", member.getMemberExpDate());
//        objBody.put("name", member.getName());
//        objBody.put("address", member.getAddress());
//        objBody.put("email", member.getEmail());
//        objBody.put("phone", member.getPhone());
//        objBody.put("currentTournaments", member.getCurrentTour());
//        objBody.put("pastTournaments",member.getPastTour());
//        objBody.put("upcomingTournaments",member.getUpcomingTour());
//
//        JSONObject memberObj = new JSONObject();
//
//        memberObj.put("member",objBody);
//
//        return memberObj;
//    }

    public static void toMembersFile(JSONObject memberObject){

        JSONParser jsonParser = new JSONParser();
        try(FileReader reader = new FileReader("src/main/golf.club.json/members.json")) {
            // Reads JSON File above and then parses it to object form.
            Object obj = jsonParser.parse(reader);
            // To Json array.
            JSONArray memberList = (JSONArray) obj;
            memberList.add(memberObject);


            try(FileWriter writer = new FileWriter("src/main/golf.club.json/members.json")){
                writer.write(String.valueOf(memberList));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        } catch (ParseException e) {
                e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        JSONObject testMember = new JSONObject();

        JSONObject obj = new JSONObject();
        obj.put("name","dominic");
        obj.put("email","some.email.email.com");

        testMember.put("member", obj);

        toMembersFile(testMember);
    }
}
