package com.keyin.golf;

import com.keyin.golf.json_data.Write;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TournamentsTest {
    @Mock
    private Tournaments mockTournament;

    @Test
    public void testCreateNewTournament(){

        ArrayList<Integer> membersInTourney = new ArrayList<>();
        membersInTourney.add(123);
        membersInTourney.add(456);
        membersInTourney.add(789);

        Date startDate = new Date(2022,10-1,28);
        Date endDate = new Date(2022, 10-1, 31);

        Tournaments test1 = new Tournaments(123, startDate, endDate, "Summerside Open", "Summerside Golf Club", 50, 1000, membersInTourney);
        Tournaments test2 = new Tournaments(456, startDate, endDate, "PEI Fall Invitational", "Anderson Greek Golf Course", 100, 2000, membersInTourney);

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
     public void testGetTournamentsById(int tournamentId){
         ArrayList<Integer> membersInTourney = new ArrayList<>();
         membersInTourney.add(123);
         membersInTourney.add(456);
         membersInTourney.add(789);

         Date startDate = new Date(2022,10-1,28);
         Date endDate = new Date(2022, 10-1, 31);

         Tournaments test1 = new Tournaments(123, startDate, endDate, "Summerside Open", "Summerside Golf Club", 50, 1000, membersInTourney);
         Tournaments test2 = new Tournaments(456, startDate, endDate, "PEI Fall Invitational", "Anderson Greek Golf Course", 100, 2000, membersInTourney);
         Tournaments test3 = new Tournaments();

         // Testing the get Tournament by ID
//         Mockito.when(mockTournament.getTournamentById(123)).thenReturn(test1));
//         assertEquals(test1.getTournamentId(), mockTournament.getTournamentId());
//         assertNotEquals(test2.getTournamentId(), mockTournament.getTournamentId());
     }

     }

