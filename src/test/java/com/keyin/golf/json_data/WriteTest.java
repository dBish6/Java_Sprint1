package com.keyin.golf.json_data;

/* WriteTest.java
   Class performing test:
    - Method to create JSON objects from Members Class


   Author: Dominic Whelan
   Contributors:  David Bishop, Chris Doucette and Blake Waddleton
   Creation Date: Oct 25, 2022

 */

import com.keyin.golf.Membership;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class WriteTest {

    @Mock
    private Membership member;

    @Test
    public void testCreateMemberObject(){

        long mockEntry = 127;
        Mockito.when(member.getId()).thenReturn(mockEntry);

        JSONObject testObject = Write.createMemberObj(member);

        JSONObject memberObj = (JSONObject) testObject.get("member");
        Long memberID = (Long) memberObj.get("memberID");

        Long mockID = member.getId();

        Assertions.assertEquals(memberID,mockID);
    }
}
