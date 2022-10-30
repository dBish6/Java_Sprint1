package com.keyin.golf.json_data;

/* WriteTest.java
   Class performing test:
    - Method to create JSON objects from Members Class


   Author: Dominic Whelan
   Contributors:  David Bishop, Chris Doucette and Blake Waddleton
   Creation Date: Oct 25, 2022

 */

import com.keyin.golf.Member;
import com.keyin.golf.Membership;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class WriteTest {

    @Mock
    private Membership mockMembership;
    @Test
    public void testCreateMembershipObject(){


        Write writer = new Write();

        Member testMember = new Member(127L,"Bob Marley","some.email@hotmail.com","123 Main","277-5673");
        ArrayList<Member> memberList = new ArrayList<>();
        memberList.add(testMember);

        long mockMembershipID = 32;
        Mockito.when(mockMembership.getMembershipID()).thenReturn(mockMembershipID);
        Mockito.when(mockMembership.getMemberList()).thenReturn(memberList);


        JSONObject testObject = writer.createMembershipObj(mockMembership);
        JSONObject memberObj = (JSONObject) testObject.get("member");
        Long membershipID = (Long) memberObj.get("membershipID");

        Assertions.assertEquals(membershipID,mockMembership.getMembershipID());

    }
}
