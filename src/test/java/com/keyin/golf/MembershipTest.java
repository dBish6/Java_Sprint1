package com.keyin.golf;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;


@ExtendWith(MockitoExtension.class)
public class MembershipTest {
    @Mock
    private Member mockMember;


    //Test to add a new person
    @Test
    public void testAddPerson(){
        Membership membership = new Membership();
        Long expectedMembershipID = 23L;
        membership.setMembershipID(23L);
        Assertions.assertEquals(expectedMembershipID, membership.getMembershipID());
        membership.addMember(mockMember);
        Assertions.assertNotNull(membership.getMemberList());
    }
    //Test to test the membership id


    @Test
    public void testMembershipId() {

        Membership membership = new Membership ();

        String result = String.valueOf(membership.getMembershipID());

        Assertions.assertEquals("23L", result);

        System.out.println("The membership id is suppose to be " + membership.getMembershipID());
    }

    //Test to find a certain person

    @Test
    public void testMembershipConstructor() {
        ArrayList<Member> mockMemberList = new ArrayList<Member>();
        mockMemberList.add(mockMember);
        Membership testMembership = new Membership();
        testMembership.setMembershipID(1L);
//        testMembership.setMembershipStartDate(new SimpleDateFormat(2022, 11, 28));
//        testMembership.setMembershipEndDate(new SimpleDateFormat(2023, 11, 28));
        testMembership.setMembershipType("Premium");


        Assertions.assertNotNull(testMembership.getMemberList());
        Assertions.assertEquals(1L, testMembership.getMembershipID());
//        Assertions.assertEquals(new Date(2022, 11, 28), testMembership.getMembershipStartDate());
//        Assertions.assertEquals(new Date(2022, 11, 28), testMembership.getMembershipEndDate());
        Assertions.assertEquals("Premium", testMembership.getMembershipType());
    }

}
