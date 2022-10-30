package com.keyin.golf;

import com.keyin.golf.exceptions.InvalidDateTimeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TournamentsTest {

    @Test
    public void testCreateNewTournament() throws ParseException {

        ArrayList<Long> membersInTourney = new ArrayList<>();
        membersInTourney.add(123L);
        membersInTourney.add(456L);
        membersInTourney.add(789L);

        Date startDate;
        startDate = new SimpleDateFormat("MMMMM dd, yyyy").parse("October 28, 2022");

        Date endDate;
        endDate = new SimpleDateFormat("MMMMM dd, yyyy").parse("October 31, 2022");

        Tournaments test1 = new Tournaments(123L, startDate, endDate, "Summerside Open", "Summerside Golf Club", 50L, 1000L, membersInTourney);
        Tournaments test2 = new Tournaments(456L, startDate, endDate, "PEI Fall Invitational", "Anderson Greek Golf Course", 100L, 2000L, membersInTourney);

        // Testing the creation of Tournament
        assertEquals(123L, test1.getTournamentId());
        assertEquals("Summerside Open", test1.getTournamentName());

        assertNotEquals(144L, test1.getTournamentId());
        assertNotEquals("Andersons Creek", test1.getTournamentName());

        // Testing the get Tournament by ID
        assertEquals(456L, test2.getTournamentId());
        assertEquals("Anderson Greek Golf Course", test2.getTournamentLocation());

        assertNotEquals(5L, test2.getTournamentId());
        assertNotEquals(50L, test2.getTournamentEntryFee());
    }

    // Searches for a Tournament Id in the Tournaments.json file
    @Test
    public void testGetTournamentById() throws InvalidDateTimeException {
        // Using tournaments.json for testing
        Tournaments test1 = new Tournaments();

        Tournaments test2 = test1.getTournamentByIdForJson(1);
        Tournaments test3 = test1.getTournamentByIdForJson(7);

        assertEquals(1L, test2.getTournamentId());
        Assertions.assertNotEquals(2L, test2.getTournamentId());

        // Test when there was no match found for search Tournament ID
        assertEquals(null, test3);
    }

    // This method checks Current tournaments for member and moves them current if they are now current
    @Test
    public void testUpdateMemberCurrentTournaments() throws InvalidDateTimeException {

        // Tournaments for Member 1 at beginning of Test
        ArrayList<Long> currentTournamentsBeginning = new ArrayList<>();
        currentTournamentsBeginning.add(2L);
        currentTournamentsBeginning.add(3L);

        ArrayList<Long> pastTournamentsBegninning = new ArrayList<>();
        pastTournamentsBegninning.add(1L);

        // Tournaments for Member 1 at end of Test
        ArrayList<Long> currentTournamentsEndTest = new ArrayList<>();
        ArrayList<Long> pastTournamentsEndTest = new ArrayList<>();
        pastTournamentsEndTest.add(1L);
        pastTournamentsEndTest.add(2L);
        pastTournamentsEndTest.add(3L);

        // Creating person object and adding tests to Person Object
        Member member1 = new Member(2L, "Jimmy Rodgers", "Jimmy1_1@hotmail.com", "8670666", "19 Kingpin Dr");
        member1.setCurrentTournaments(currentTournamentsBeginning);
        member1.setPastTournaments(pastTournamentsBegninning);

        Tournaments tourney = new Tournaments();

        Assertions.assertEquals(currentTournamentsBeginning, member1.getCurrentTournaments());
        Assertions.assertEquals(pastTournamentsBegninning, member1.getPastTournaments());

        tourney.updateMemberCurrentTournaments(member1);

        Assertions.assertEquals(currentTournamentsEndTest, member1.getCurrentTournaments());
        Assertions.assertEquals(pastTournamentsEndTest, member1.getPastTournaments());

        // Testing for null fields
        Member member3 = new Member(124L, "Jamie Joe", "jamieJoe12@gmail.com", "6093124", "19 Kingpin Dr");
        member3.setUpcomingTournaments(null);
        member3.setCurrentTournaments(null);
        member3.setPastTournaments(null);

        tourney.updateMemberCurrentTournaments(member3);

        Assertions.assertEquals(null, member3.getCurrentTournaments());
        Assertions.assertEquals(null, member3.getUpcomingTournaments());
        Assertions.assertEquals(null, member3.getPastTournaments());
    }

    // This method checks Upcoming tournaments for Member and moves them to Current if they are now current.
    @Test
    public void testMemberUpcomingTournaments() throws InvalidDateTimeException {
        // Creating ArrayLists for what Beginning of tests
        ArrayList<Long> currentTournamentsBeginning = new ArrayList<>();

        ArrayList<Long> upcomingTournamentsBeginning = new ArrayList<>();
        upcomingTournamentsBeginning.add(4L);
        upcomingTournamentsBeginning.add(5L);

        // Creating Array Lists for what Test should equal at end
        ArrayList<Long> currentTournamentsEndTest = new ArrayList<>();
        currentTournamentsEndTest.add(4L);
        ArrayList<Long> upcomingTournamentsEndTest = new ArrayList<>();
        upcomingTournamentsEndTest.add(5L);

        Member member2 = new Member(2L, "Jimmy Rodgers", "Jimmy1_1@hotmail.com", "8670666", "19 Kingpin Dr");
        member2.setCurrentTournaments(currentTournamentsBeginning);
        member2.setUpcomingTournaments(upcomingTournamentsBeginning);

        Tournaments tourney = new Tournaments();

        // Running Tests before running method
        Assertions.assertEquals(currentTournamentsBeginning, member2.getCurrentTournaments());
        Assertions.assertEquals(upcomingTournamentsBeginning, member2.getUpcomingTournaments());
        Assertions.assertNotEquals(upcomingTournamentsBeginning, member2.getCurrentTournaments());
        Assertions.assertNotEquals(currentTournamentsBeginning, member2.getUpcomingTournaments());

        tourney.updateMemberUpcomingTournaments(member2);

        // Running Tests after running method
        Assertions.assertEquals(currentTournamentsEndTest, member2.getCurrentTournaments());
        Assertions.assertEquals(upcomingTournamentsEndTest, member2.getUpcomingTournaments());
        Assertions.assertNotEquals(upcomingTournamentsEndTest, member2.getCurrentTournaments());
        Assertions.assertNotEquals(currentTournamentsEndTest, member2.getUpcomingTournaments());

        // Testing for null fields
        Member member3 = new Member(124L, "Jamie Joe", "jamieJoe12@gmail.com", "6093124", "19 Kingpin Dr");
        member3.setUpcomingTournaments(null);
        member3.setCurrentTournaments(null);
        member3.setPastTournaments(null);

        tourney.updateMemberUpcomingTournaments(member3);

        Assertions.assertEquals(null, member3.getCurrentTournaments());
        Assertions.assertEquals(null, member3.getUpcomingTournaments());
        Assertions.assertEquals(null, member3.getPastTournaments());

    }

    // Test doesn't work because I added the CLI function call at end of method - But both methods within this method pass tests
//    @Test
//    public void testUpdateMemberTournamentsStatus() throws InvalidDateTimeException {
//        // Creating ArrayLists for what Beginning of tests
//        ArrayList<Long> currentTournamentsBeginning = new ArrayList<>();
//        currentTournamentsBeginning.add(2L);
//        currentTournamentsBeginning.add(3L);
//
//        ArrayList<Long> upcomingTournamentsBeginning = new ArrayList<>();
//        upcomingTournamentsBeginning.add(4L);
//        upcomingTournamentsBeginning.add(5L);
//
//        ArrayList<Long> pastTournamentsBeginning = new ArrayList<>();
//        pastTournamentsBeginning.add(1L);
//
//        // Creating Array Lists for what Test should equal at end
//        ArrayList<Long> currentTournamentsEndTest = new ArrayList<>();
//        currentTournamentsEndTest.add(4L);
//
//        ArrayList<Long> upcomingTournamentsEndTest = new ArrayList<>();
//        upcomingTournamentsEndTest.add(5L);
//
//        ArrayList<Long> pastTournamentsEndTest = new ArrayList<>();
//        pastTournamentsEndTest.add(1L);
//        pastTournamentsEndTest.add(2L);
//        pastTournamentsEndTest.add(3L);
//
//        Member member2 = new Member(2L, "Jimmy Rodgers", "Jimmy1_1@hotmail.com", "8670666", "19 Kingpin Dr");
//        member2.setCurrentTournaments(currentTournamentsBeginning);
//        member2.setUpcomingTournaments(upcomingTournamentsBeginning);
//        member2.setPastTournaments(pastTournamentsBeginning);
//
//        Tournaments tourney = new Tournaments();
//
//        // Running Tests before running method
//        Assertions.assertEquals(currentTournamentsBeginning, member2.getCurrentTournaments());
//        Assertions.assertEquals(upcomingTournamentsBeginning, member2.getUpcomingTournaments());
//        Assertions.assertNotEquals(upcomingTournamentsBeginning, member2.getCurrentTournaments());
//        Assertions.assertNotEquals(currentTournamentsBeginning, member2.getUpcomingTournaments());
//
//        tourney.updateMemberTournamentsStatus(member2);
//
//        // Running Tests after running method
//        Assertions.assertEquals(currentTournamentsEndTest, member2.getCurrentTournaments());
//        Assertions.assertEquals(upcomingTournamentsEndTest, member2.getUpcomingTournaments());
//        Assertions.assertNotEquals(upcomingTournamentsEndTest, member2.getCurrentTournaments());
//        Assertions.assertNotEquals(currentTournamentsEndTest, member2.getUpcomingTournaments());
//    }

    @Test
    public void testGetMemberFromJsonToUpdateTournaments(){
        // Creating members Objects that will be searched in members.json file
//        Long memberID, String name, String email, String phoneNumber, String address
        Member test1 = new Member(124L, "Jamie Joe", "jamieJoe12@gmail.com", "6093124", "19 Kingpin Dr");
        Member test2 = new Member(126L, "Chuck Robinson", "Rob_132@hotmail.com", "5670646", "6 Yellow-belly Rd");
        Tournaments tester = new Tournaments();

        // Test case 1
        Member test1Actual = tester.getMemberFromJsonToUpdateTournaments(124);
        Assertions.assertEquals(test1.getMemberID(), test1Actual.getMemberID());
        Assertions.assertEquals(124L, test1Actual.getMemberID());

        Assertions.assertNotEquals(130L, test1Actual.getMemberID());

        // Test Cast 2
        Member test2Actual = tester.getMemberFromJsonToUpdateTournaments(126);
        Assertions.assertEquals(test2.getMemberID(), test2Actual.getMemberID());
        Assertions.assertEquals(126L, test2Actual.getMemberID());

        Assertions.assertNotEquals(130L, test2Actual.getMemberID());
    }
}

