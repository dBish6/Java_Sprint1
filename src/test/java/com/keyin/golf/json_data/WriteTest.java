package com.keyin.golf.json_data;

import com.keyin.golf.Members;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

//@ExtendWith(MockitoExtension.class)
//public class WriteTest {
//
//    @Mock
//    private Members member;
//
//    @Test
//    public void testCreateMemberObject(){
//
//        Mockito.when(member.getID()).thenReturn(127);
//
//        JSONObject testObject = Write.createMemberObj(member);
//
//        JSONObject memberObj = (JSONObject) testObject.get("member");
//        int memberID = (int) memberObj.get("memberID");
//
//        double mockID = member.getID();
//
//        Assertions.assertEquals(memberID,mockID);
//    }
//}
