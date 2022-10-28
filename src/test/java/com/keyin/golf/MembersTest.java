package com.keyin.golf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
@ExtendWith(MockitoExtension.class)
public class MembersTest {
    @Mock
    private Person mockMember;
    @Test
    public void testAddPerson(){
        Members members = new Members();
        Long expectedMembershipID = 23L;
        members.setMembershipID(23L);
        Assertions.assertEquals(expectedMembershipID,members.getMembershipID());
        members.addMember(mockMember);
        Assertions.assertNotNull(members.personList);
    }
}