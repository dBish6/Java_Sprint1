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
import com.keyin.golf.Members;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.FileWriter;
// imports for Error handling
import java.io.FileNotFoundException;
import java.io.IOException;

public class Write {

    // leave commented until Members Class methods required are completed
    public static JSONObject createMemberObj(Members member){

        JSONObject objBody = new JSONObject();

        objBody.put("memberID",member.getId());
//                     Missing from Members Class
//        objBody.put("membershipType", member.getMemberType());
        objBody.put("membershipStartDate",member.getMembershipStartDate());
//                     Needs to be calculated using membershipDuration
//        objBody.put("membershipExpireDate", member.getMemberExpDate());
                  // Need to concatenate with firstName and lastName
        objBody.put("name", (member.getFirstName() + " " + member.getLastName()));
        objBody.put("address", member.getAddress());
        objBody.put("email", member.getEmail());
        objBody.put("phone", member.getPhoneNumber());
        objBody.put("currentTournaments", member.getCurrentTournaments());
        objBody.put("pastTournaments",member.getPastTournaments());
        objBody.put("upcomingTournaments",member.getUpcomingTournaments());

        JSONObject memberObj = new JSONObject();

        memberObj.put("member",objBody);

        return memberObj;
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
