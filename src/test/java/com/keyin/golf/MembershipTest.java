package com.keyin.golf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MembershipTest {
    @Mock
    private Member mockMember;
    @Test
    public void testAddPerson(){
        Membership membership = new Membership();
        Long expectedMembershipID = 23L;
        membership.setMembershipID(23L);
        Assertions.assertEquals(expectedMembershipID, membership.getMembershipID());
        membership.addMember(mockMember);
        Assertions.assertNotNull(membership.getMemberList());
    }
}