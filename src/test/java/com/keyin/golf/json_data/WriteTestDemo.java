package com.keyin.golf.json_data;

import com.keyin.golf.Member;
import com.keyin.golf.Membership;
import com.keyin.golf.Tournaments;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.Date;

public class WriteTestDemo {

    private static long testMembershipId;
    private static String testMembershipType;
    private static Date testMembershipStartDate;
    private static Date testMembershipExpireDate;
    private static long testMemberId;
    private static String testName;
    private static String testEmail;
    private static String testPhoneNumber;
    private static String testAddress;
    private static Long testTournamentId;
    private static Date testTournamentStartDate;
    private static Date testTournamentEndDate;
    private static String testTournamentName;
    private static String testTournamentLocation;
    private static Long testTournamentEntryFee;
    private static Long testTournamentCashPrize;
    private static ArrayList testMembersParticipating;
    private static ArrayList testFinalStandings;


    @BeforeAll
    public static void before() {
        System.out.println("Initial setup running...");

        testMembershipId = 27;
        testMembershipType = "Standard";
        testMemberId = 277;
        testMembershipStartDate = new Date(2023,06,5);
        testMembershipExpireDate = new Date(2024,06,5);
        testName = "Luke Skywalker";
        testEmail = "usetheforce@lightside.com";
        testPhoneNumber = "9086675";
        testAddress = "667 jedi way";

        testTournamentId = 402L;
        testTournamentName = "Test Open";
        testTournamentStartDate = new Date(2023,8,8);
        testTournamentEndDate = new Date(2023,8,9);
        testMembersParticipating = new ArrayList<Long>();
        testMembersParticipating.add(0,12L);
        testMembersParticipating.add(1,45L);
        testTournamentLocation = "Literally a meadow";
        testTournamentEntryFee = 100L;
        testTournamentCashPrize = 750L;

        System.out.println("Test(s) start...\n");
    }

    @Test
    public void testCreateMembership() {

        Member testMember = new Member(testMemberId,testName,testEmail,testPhoneNumber,testAddress);
        Membership testMembership = new Membership(testMembershipId, testMembershipType, testMembershipStartDate,testMembershipExpireDate);
        testMembership.addMember(testMember);

        Write writer = new Write();
        System.out.println("The member records before new member added");
        System.out.println();

        Read.readAllJSONMembers();

        System.out.println("The membership and member to be added");
        System.out.println();
        System.out.println(testMembership);
        System.out.println(testMember);

        System.out.println();
        System.out.println("The member records after new member added");
        System.out.println();

        writer.createMembershipObj(testMembership);

        Read.readAllJSONMembers();
    }

    @Test
    public void testCreateTournament(){

        Tournaments testTournament = new Tournaments(testTournamentId,testTournamentStartDate,testTournamentEndDate,testTournamentName,testTournamentLocation,testTournamentEntryFee,testTournamentCashPrize,testMembersParticipating,testFinalStandings);

        System.out.println("Tournaments before adding test tournament");

        Read.readAllJSONTournaments();

        System.out.println("Tournaments after new tournament added");

        Write writer = new Write();
        writer.createTournamentObj(testTournament);

        System.out.println(testTournament.getMembersParticipating());

        Read.readAllJSONTournaments();
    }
}
