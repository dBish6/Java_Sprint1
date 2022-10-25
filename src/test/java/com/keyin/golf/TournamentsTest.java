package com.keyin.golf;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

public class TournamentsTest {

    @Test
    public void testCreateNewTournament(){
        ArrayList<Integer> membersInTourney = new ArrayList<Integer>();
        membersInTourney.add(122);
        membersInTourney.add(123);
        membersInTourney.add(125);
        membersInTourney.add(126);
        membersInTourney.add(128);

        Date startDate = new Date(2022-10-28);
        Date endDate = new Date(2022-10-31);

        Tournaments tourney1 = new Tournaments(1, startDate, endDate, "A1 Greengrass Classic", "St. John's Country Club", 250, 1500, membersInTourney);

        Assertions.assertEquals("A1 Greengrass Classic", tourney1.getTournamentName());
        Assertions.assertNotEquals("St. John's Open", tourney1.getTournamentName());

        Assertions.assertEquals("St. John's Country Club", tourney1.getTournamentLocation());
        Assertions.assertNotEquals("Summerside Golf and Country Club", tourney1.getTournamentLocation());
    }
}
