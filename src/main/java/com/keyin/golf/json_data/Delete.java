package com.keyin.golf.json_data;

/* Delete.java
   Class to Delete records from the two JSON files; members.json & tournaments.json.

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

    public static void deleteMemberJSONRecordByMembershipID(int Id) {

        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("src/main/golf.club.json/members.json")) {
            // Reads JSON File above and then parses it to object form.
            Object obj = jsonParser.parse(reader);
            // To Json array.
            JSONArray memberArray = (JSONArray) obj;
            JSONArray newMemberArray = new JSONArray();
            Long storedID = null;
            // Iterate though the objects in the JSONArray.
            for (Object objects : memberArray) {
                // Then creates the JSONObject out of the objects.
                JSONObject jsonObjects = (JSONObject) objects;
                // Gets the member object, so we can get the memberID.
                JSONObject memberObj = (JSONObject) jsonObjects.get("member");
                Long membershipID = (Long) memberObj.get("membershipID");
                // Converts the inputted Id to Long because membershipID is Long data type.
                Long userInputId = Long.valueOf(Id);
                // For error checking; when the loop reaches the Id, store it in a variable.
                if (Objects.equals(membershipID, userInputId)) {
                    storedID = membershipID;
                }
                // When the loop reaches the inputted membershipID, skip it and don't add it to the newArray.
                // Tried to use continue for skipping, wouldn't let me.
                if (!Objects.equals(membershipID, userInputId)) {
                    newMemberArray.add(jsonObjects);
                }
            }
            if (storedID != Long.valueOf(Id)) {
                System.err.println("ERROR: No member matches given ID.");
            } else {
                try (FileWriter writer = new FileWriter("src/main/golf.club.json/members.json")) {
                    writer.write(newMemberArray.toJSONString());
                }
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

// <=========================================/ tournaments.json Reader Start \=========================================>

    public static void deleteTournamentJSONRecordById(int Id) {

        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("src/main/golf.club.json/tournaments.json")) {
            Object obj = jsonParser.parse(reader);
            JSONArray tournamentArray = (JSONArray) obj;
            JSONArray newTournamentArray = new JSONArray();
            Long storedID = null;
            for (Object objects : tournamentArray) {
                JSONObject jsonObjects = (JSONObject) objects;
                JSONObject tournamentObj = (JSONObject) jsonObjects.get("tournament");
                Long tournamentID = (Long) tournamentObj.get("tournamentID");
                Long userInputId = Long.valueOf(Id);
                if (Objects.equals(tournamentID, userInputId)) {
                    storedID = tournamentID;
                }
                if (!Objects.equals(tournamentID, userInputId)) {
                    newTournamentArray.add(jsonObjects);
                }
            }
            if (storedID != Long.valueOf(Id)) {
                System.err.println("ERROR: No tournament matches given ID.");
            } else {
                try (FileWriter writer = new FileWriter("src/main/golf.club.json/tournaments.json")) {
                    writer.write(newTournamentArray.toJSONString());
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
