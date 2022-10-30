package com.keyin.golf;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.Date;



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

    //Test to find a certain person
    @Test
    public void testMembershipConstructor() {
        ArrayList<Member> mockMemberList = new ArrayList<Member>();
        mockMemberList.add(mockMember);
        Membership testMembership = new Membership();
        testMembership.setMembershipID(1L);

        testMembership.setMembershipStartDate(new Date(2022, 11, 28));
        testMembership.setMembershipExpireDate(new Date(2022, 11, 28));

        testMembership.setMembershipType("Premium");


        Assertions.assertNotNull(testMembership.getMemberList());
        Assertions.assertEquals(1L, testMembership.getMembershipID());

        Assertions.assertEquals(new Date(2022, 11, 28), testMembership.getMembershipStartDate());
        Assertions.assertEquals(new Date(2022, 11, 28), testMembership.getMembershipExpireDate());
        Assertions.assertEquals("Premium", testMembership.getMembershipType());
    }
}
