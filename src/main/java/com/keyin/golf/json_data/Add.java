package com.keyin.golf.json_data;

/* Add.java
   Class that changes/add a given value in json data
   Method that will edit member details (email, phone, and address)
   More to be added....

   Author: Dominic Whelan
   Contributors:  David Bishop, Chris Doucette and Blake Waddleton
   Creation Date: Oct 26, 2022

 */

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class Add {

    // Used to set personal data ( phone,email, and address )
    public static void setMemberDetailValue(int ID, String keyToChange, String valueToSet) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("src/main/golf.club.json/members.json")) {
            Object obj = jsonParser.parse(reader);
            JSONArray memberList = (JSONArray) obj;
            memberList.forEach(member -> {
                JSONObject memberObj = (JSONObject) member;
                JSONObject objDetails = (JSONObject) memberObj.get("member");
                String membershipType = (String) objDetails.get("membershipType");
                if (Objects.equals(membershipType, "Family Plan")) {
                    JSONArray familyMembers = (JSONArray) objDetails.get("familyMembers");
                    familyMembers.forEach(fMember -> {
                        JSONObject fmObj = (JSONObject) fMember;
                        Long memberID = (Long) fmObj.get("memberID");
                        if (memberID == ID) {
                            fmObj.put(keyToChange, valueToSet);
                            try(FileWriter writer = new FileWriter("src/main/golf.club.json/members.json")){
                                writer.write(memberList.toJSONString());
                            } catch (IOException e){
                                e.printStackTrace();
                            }
                        }
                    });
                } else {
                    Long memberID = (Long) objDetails.get("memberID");
                    if (memberID == ID) {
                        objDetails.put(keyToChange, valueToSet);
                        try(FileWriter writer = new FileWriter("src/main/golf.club.json/members.json")){
                            writer.write(memberList.toJSONString());
                        } catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }
            });
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        setMemberDetailValue(123,"phone","5671423");
    }
}