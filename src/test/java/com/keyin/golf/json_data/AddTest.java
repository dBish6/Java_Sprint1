package com.keyin.golf.json_data;

import org.junit.jupiter.api.Test;

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

    }

}
