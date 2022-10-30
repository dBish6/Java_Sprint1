package com.keyin.golf;

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

@ExtendWith(MockitoExtension.class)
public class TournamentsTest {

        @Mock
        private Tournaments mockTournament;

    @Test
    public void testCreateNewTournament() {

        ArrayList<Long> membersInTourney = new ArrayList<>();
        membersInTourney.add(123L);
        membersInTourney.add(456L);
        membersInTourney.add(789L);

        Date startDate;
        try {
            startDate = new SimpleDateFormat("MMMMM dd, yyyy").parse("October 28, 2022");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Date endDate;
        try {
            endDate = new SimpleDateFormat("MMMMM dd, yyyy").parse("October 31, 2022");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Tournaments test1 = new Tournaments(123L, startDate, endDate, "Summerside Open", "Summerside Golf Club", 50L, 1000L, membersInTourney);
        Tournaments test2 = new Tournaments(456L, startDate, endDate, "PEI Fall Invitational", "Anderson Greek Golf Course", 100L, 2000L, membersInTourney);

        // Testing the creation of Tournament
//        Mockito.when(mockTournament.createNewTournament()).thenReturn(test1);
//        assertEquals(test1, mockTournament.createNewTournament());
//        assertNotEquals(test2, mockTournament.createNewTournament());
//
//        // Testing the get Tournament by ID
//        Mockito.when(mockTournament.getTournamentId()).thenReturn(test1.getTournamentId());
//        assertEquals(test1.getTournamentId(), mockTournament.getTournamentId());
//        assertNotEquals(test2.getTournamentId(), mockTournament.getTournamentId());
    }

    @Test
    public void testGetTournamentById() throws ParseException {
        // Using tournaments.json for testing
        Tournaments test1 = new Tournaments();
        Tournaments test2 = new Tournaments();

        test2 = test1.getTournamentByIdForJson(Long.valueOf(String.valueOf(1)));

        assertEquals(1L, test2.getTournamentId());
        Assertions.assertNotEquals(2L, test2.getTournamentId());
    }

    // This method checks Current tournaments for member and moves them current if they are now current
    @Test
    public void testUpdateMemberCurrentTournaments() {

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
        Member member1 = new Member(2L, "Jimmy Rodgers", "Jimmy1_1@hotmail.com", "19 Kingpin Dr", "8670666");
        member1.setCurrentTournaments(currentTournamentsBeginning);
        member1.setPastTournaments(pastTournamentsBegninning);

        Tournaments tourney = new Tournaments();

        Assertions.assertEquals(currentTournamentsBeginning, member1.getCurrentTournaments());
        Assertions.assertEquals(pastTournamentsBegninning, member1.getPastTournaments());

        tourney.updateMemberCurrentTournaments(member1);

        Assertions.assertEquals(currentTournamentsEndTest, member1.getCurrentTournaments());
        Assertions.assertEquals(pastTournamentsEndTest, member1.getPastTournaments());

    }

    // This method checks Upcoming tournaments for Member and moves them to Current if they are now current.
    @Test
    public void testMemberUpcomingTournaments() {
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

        Member member2 = new Member(2L, "Jimmy Rodgers", "Jimmy1_1@hotmail.com", "19 Kingpin Dr", "8670666");
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
    }

    @Test
    public void testUpdateMemberTournamentsStatus() {
        // Creating ArrayLists for what Beginning of tests
        ArrayList<Long> currentTournamentsBeginning = new ArrayList<>();
        currentTournamentsBeginning.add(2L);
        currentTournamentsBeginning.add(3L);

        ArrayList<Long> upcomingTournamentsBeginning = new ArrayList<>();
        upcomingTournamentsBeginning.add(4L);
        upcomingTournamentsBeginning.add(5L);

        ArrayList<Long> pastTournamentsBeginning = new ArrayList<>();
        pastTournamentsBeginning.add(1L);

        // Creating Array Lists for what Test should equal at end
        ArrayList<Long> currentTournamentsEndTest = new ArrayList<>();
        currentTournamentsEndTest.add(4L);

        ArrayList<Long> upcomingTournamentsEndTest = new ArrayList<>();
        upcomingTournamentsEndTest.add(5L);

        ArrayList<Long> pastTournamentsEndTest = new ArrayList<>();
        pastTournamentsEndTest.add(1L);
        pastTournamentsEndTest.add(2L);
        pastTournamentsEndTest.add(3L);

        Member member2 = new Member(2L, "Jimmy Rodgers", "Jimmy1_1@hotmail.com", "19 Kingpin Dr", "8670666");
        member2.setCurrentTournaments(currentTournamentsBeginning);
        member2.setUpcomingTournaments(upcomingTournamentsBeginning);
        member2.setPastTournaments(pastTournamentsBeginning);

        Tournaments tourney = new Tournaments();

        // Running Tests before running method
        Assertions.assertEquals(currentTournamentsBeginning, member2.getCurrentTournaments());
        Assertions.assertEquals(upcomingTournamentsBeginning, member2.getUpcomingTournaments());
        Assertions.assertNotEquals(upcomingTournamentsBeginning, member2.getCurrentTournaments());
        Assertions.assertNotEquals(currentTournamentsBeginning, member2.getUpcomingTournaments());

        tourney.updateMemberTournamentsStatus(member2);

        // Running Tests after running method
        Assertions.assertEquals(currentTournamentsEndTest, member2.getCurrentTournaments());
        Assertions.assertEquals(upcomingTournamentsEndTest, member2.getUpcomingTournaments());
        Assertions.assertNotEquals(upcomingTournamentsEndTest, member2.getCurrentTournaments());
        Assertions.assertNotEquals(currentTournamentsEndTest, member2.getUpcomingTournaments());
    }
}

