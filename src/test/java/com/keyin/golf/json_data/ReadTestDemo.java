package com.keyin.golf.json_data;

/* ReadTestDemo.java
   A test demo of the methods of the Read.java class.

   Author: David Bishop
   Contributors:  Dominic Whelan, Chris Doucette and Blake Waddleton
   Creation Date: Oct 25, 2022

 */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class ReadTestDemo {

    private static final String TEXT_RESET = "\u001B[0m";
    private static final String TEXT_YELLOW = "\u001B[33m";

    private static int testStandardMembershipId;
    private static int testFamilyMembershipId;
    private static int testTournamentId;
    private static int testFamilyMemberId;
    private static int testMemberId;

    @BeforeAll
    public static void before() {
    System.out.println("Initial setup running...");

    testStandardMembershipId = 4;
    testFamilyMembershipId = 1;

    testTournamentId = 2;

    testFamilyMemberId = 123;
    testMemberId = 127;

    System.out.println("Test(s) start...\n");
    }

    @Test // Test for the two methods that display all contents from the two JSON files.
    public void methodsTestDisplayAll() {
        System.out.println(TEXT_YELLOW + "*Running: methodsTestDisplayAll()*");

        System.out.println("<-----------readAllJSONMembers() Start----------->" + TEXT_RESET);
        Read.readAllJSONMembers();

        System.out.println(TEXT_YELLOW + "<-----------readAllJSONTournaments() Start----------->" + TEXT_RESET);
        Read.readAllJSONTournaments();
    }

    @Test // Test for the two methods that display contents by ID.
    public void methodsTestDisplayById() {
        System.out.println(TEXT_YELLOW + "*Running: methodsTestDisplayById()*");

        System.out.println("Displays a Standard Member" + TEXT_RESET);
        Read.displayJSONMemberByMembershipID(testStandardMembershipId);
        System.out.println(TEXT_YELLOW + "Displays a Family Plan Member" + TEXT_RESET);
        Read.displayJSONMemberByMembershipID(testFamilyMembershipId);

        System.out.println(TEXT_YELLOW + "Displays Tournament" + TEXT_RESET);
        Read.displayJSONTournamentById(testTournamentId);
    }

    @Test // Test for the two methods that gets/returns the JSONObject by ID.
    public void methodsTestGetJSONRecordById() {
        System.out.println(TEXT_YELLOW + "*Running: methodsTestGetJSONRecordById()*");

        System.out.println("Standard Member Object" + TEXT_RESET);
        System.out.println(Read.getMemberJSONRecordByMemberID(testFamilyMemberId));
        System.out.println(TEXT_YELLOW + "Family Plan Member Object" + TEXT_RESET);
        System.out.println(Read.getMemberJSONRecordByMemberID(testMemberId));

        System.out.println(TEXT_YELLOW + "Tournament Object" + TEXT_RESET);
        System.out.println(Read.getTournamentJSONRecordById(testTournamentId));
    }

    @AfterAll
    public static void after() {
        System.out.println("\nTest(s) ended.");
    }
}
