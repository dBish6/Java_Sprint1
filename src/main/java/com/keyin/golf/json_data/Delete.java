package com.keyin.golf.json_data;

/* Delete.java
   Class for members of the tournament...

   Author: David Bishop
   Contributors: Dominic Whelan, Chris Doucette and Blake Waddleton
   Creation Date: Oct 26, 2022

 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Delete {
// <===========================================/ members.json Delete Start \===========================================>
    public static void deleteMemberJSONRecord(int Id) {

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
                        jsonObjects.remove("member");
                        break;
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
                            jsonObjects.remove("member");
                            break;
                        }
                    }
                }
//                if (((JSONObject) jsonObjects.get("member")).size() == 0) {
//                    json.remove(key);
//                } else {
//                    removeEmptyAndNullFields(json.get(key));
//                }
            }
            try (FileWriter writer = new FileWriter("src/main/golf.club.json/members.json")) {
                writer.write(memberArray.toJSONString());
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }

// <=========================================/ tournaments.json Reader Start \=========================================>

    public static void deleteTournamentJSONRecord(int Id) {

        JSONParser jsonParser = new JSONParser();
        try(FileReader reader = new FileReader("src/main/golf.club.json/tournaments.json")) {
            // Reads JSON File above and then parses it to object form.
            Object obj = jsonParser.parse(reader);
            // To Json array.
            JSONArray tournamentArray = (JSONArray) obj;
            // Iterate though the objects in the JSONArray.
            for (Object objects : tournamentArray) {
                // Then creates the JSONObject out of the objects.
                JSONObject jsonObjects = (JSONObject) objects;
                // Gets the member objects, so we can get the memberID.
                JSONObject tournamentObj = (JSONObject) jsonObjects.get("tournament");
                Long tournamentID = (Long) tournamentObj.get("tournamentID");
                // Converts the inputted Id to Long because memberID is Long data type.
                Long userInputId = Long.valueOf(Id);
                if (Objects.equals(tournamentID, userInputId)) {
                    jsonObjects.remove("tournament");
                }
                if (jsonObjects.size() == 0) {
                    jsonObjects.remove("tournament");
                }
            }
            try(FileWriter writer = new FileWriter("src/main/golf.club.json/tournaments.json")) {
                writer.write(tournamentArray.toJSONString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        deleteMemberJSONRecord(125);
//        deleteTournamentJSONRecord(2);
    }
}
