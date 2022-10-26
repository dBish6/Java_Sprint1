package com.keyin.golf.json_data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class DeleteTest {

//    public static void deleteMemberJSONRecord(int Id) {
//
//        JSONParser jsonParser = new JSONParser();
//        try(FileReader reader = new FileReader("src/main/golf.club.json/members.json")) {
//            // Reads JSON File above and then parses it to object form.
//            Object obj = jsonParser.parse(reader);
//            System.out.println(obj);
//            // To Json array.
//            JSONArray memberArray = (JSONArray) obj;
//            // Iterate though the objects in the JSONArray.
//            for (Object objects : memberArray) {
//                // Then creates the JSONObject out of the objects.
//                JSONObject jsonObjects = (JSONObject) objects;
//                // Gets the member objects, so we can get the memberID.
//                JSONObject memberObj = (JSONObject) jsonObjects.get("member");
//                Long memberID = (Long) memberObj.get("memberID");
//                System.out.println(memberID);
//                // Converts the inputted Id to Long because memberID is Long data type.
//                Long userInputId = Long.valueOf(Id);
//                if (Objects.equals(memberID, userInputId)) {
//                    jsonObjects.remove("member");
//                }
//            }
//            System.out.println(memberArray);
//            // Iterate over memberArray, one record at a time from the parseMemberObj function.
//            // memberArray.forEach(member -> parseMemberObj((JSONObject) member));
//        }
//        catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        catch (ParseException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        deleteMemberJSONRecord(125);
//    }
}
