package com.keyin.golf;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class TournamentsTest {
    @Mock
    private Tournaments mockTournament;

    @Test
    public void testCreateNewTournament(){

        ArrayList<Long> membersInTourney = new ArrayList<>();
        membersInTourney.add(123L);
        membersInTourney.add(456L);
        membersInTourney.add(789L);

        Date startDate = new Date(2022,10-1,28);
        Date endDate = new Date(2022, 10-1, 31);

        Tournaments test1 = new Tournaments(123L, startDate, endDate, "Summerside Open", "Summerside Golf Club", 50L, 1000L, membersInTourney);
        Tournaments test2 = new Tournaments(456L, startDate, endDate, "PEI Fall Invitational", "Anderson Greek Golf Course", 100L, 2000L, membersInTourney);

        // Testing the creation of Tournament
        Mockito.when(mockTournament.createNewTournament()).thenReturn(test1);
        assertEquals(test1, mockTournament.createNewTournament());
        assertNotEquals(test2, mockTournament.createNewTournament());

        // Testing the get Tournament by ID
        Mockito.when(mockTournament.getTournamentId()).thenReturn(test1.getTournamentId());
        assertEquals(test1.getTournamentId(), mockTournament.getTournamentId());
        assertNotEquals(test2.getTournamentId(), mockTournament.getTournamentId());
     }

     @Test
     public void testGetTournamentsById(long tournamentId){
         ArrayList<Long> membersInTourney = new ArrayList<>();
         membersInTourney.add(123L);
         membersInTourney.add(456L);
         membersInTourney.add(789L);

         Date startDate = new Date(2022,10-1,28);
         Date endDate = new Date(2022, 10-1, 31);

         Tournaments test1 = new Tournaments(123L, startDate, endDate, "Summerside Open", "Summerside Golf Club", 50L, 1000L, membersInTourney);
         Tournaments test2 = new Tournaments(456L, startDate, endDate, "PEI Fall Invitational", "Anderson Greek Golf Course", 100L, 2000L, membersInTourney);
         Tournaments test3 = new Tournaments();

         // Testing the get Tournament by ID
//         Mockito.when(mockTournament.getTournamentById(123)).thenReturn(test1));
//         assertEquals(test1.getTournamentId(), mockTournament.getTournamentId());
//         assertNotEquals(test2.getTournamentId(), mockTournament.getTournamentId());
     }

     }

