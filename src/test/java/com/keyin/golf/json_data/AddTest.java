package com.keyin.golf.json_data;

import com.keyin.golf.Member;
import com.keyin.golf.Tournaments;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AddTest {

    @Test
    public void testSetMemberDetailValue(){
        int idOfMember = 125;
        String keyToChange = "address";
        String valueToSet = "123 Main St.";

        System.out.println();
        System.out.println("Member information before changes");
        System.out.println(Read.getMemberJSONRecordByMemberID(125));

        System.out.println();
        System.out.println("Member information after changes");
        Add.setMemberDetailValue(idOfMember,keyToChange,valueToSet);

        System.out.println(Read.getMemberJSONRecordByMemberID(125));

    }

    @Test
    public void testSetMemberTournamentDetails(){

        int idOfMember2 = 127;
        Tournaments t = new Tournaments();
        ArrayList<Long> upcomingTournamentsToEnter = new ArrayList<>();
        upcomingTournamentsToEnter.add(5L);

        Member memberObject = t.getMemberFromJsonToUpdateTournaments(idOfMember2);

        System.out.println();
        System.out.println("Member details before update");
        System.out.println(memberObject.getUpcomingTournaments());

        memberObject.setUpcomingTournaments(upcomingTournamentsToEnter);
        Add.setMemberTournamentDetails(memberObject);

        System.out.println();
        System.out.println("Member details after update");
        System.out.println(t.getMemberFromJsonToUpdateTournaments(idOfMember2));

    }

}
