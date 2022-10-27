package com.keyin.golf.json_data;

/* DeleteTestDemo.java
   A test demo of the methods of the Delete.java class.

   Author: David Bishop
   Contributors:  Dominic Whelan, Chris Doucette and Blake Waddleton
   Creation Date: Oct 25, 2022

 */

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DeleteTestDemo {

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

    public static final String TEXT_RESET = "\u001B[0m";
    private static final String TEXT_YELLOW = "\u001B[33m";

    private static int testStandardMembershipId;
    private static int testFamilyMembershipId;
    private static int testTournamentId;

    @BeforeAll
    public static void before() {
        System.out.println("Initial setup running...");

        testStandardMembershipId = 2;
        testFamilyMembershipId = 1;

        testTournamentId = 3;

        System.out.println("Test(s) start...\n");
    }

    @Test // Test for the two methods that deletes a JSON record by ID and writes to file.
    public void methodsTestDisplayById() {
        System.out.println(TEXT_YELLOW + "*Running: methodsTestDisplayById()*");

        Delete.deleteMemberJSONRecordByMembershipID(testStandardMembershipId);
        System.out.println("Standard Member Deletion Ran...");

        System.out.println("Tournament Deletion Ran..." + TEXT_RESET);
        Delete.deleteTournamentJSONRecordById(testTournamentId);
    }

    @Test // Test to check if a Family Plan JSONObject deletes the JSON record by ID and writes to file.
    public void methodTestDeleteFamilyMember() {
        System.out.println(TEXT_YELLOW + "*Running: methodsTestDisplayById()*");

        System.out.println("Family Plan Member Deletion Ran..." + TEXT_RESET);
        Delete.deleteMemberJSONRecordByMembershipID(testFamilyMembershipId);
    }

    // CTRL/CMD Z the deletion changes to the JSON files if need be.

    @AfterAll
    public static void after() {
        System.out.println("\nTest(s) ended.");
    }
}
