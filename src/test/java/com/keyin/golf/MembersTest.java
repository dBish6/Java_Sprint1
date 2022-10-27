package com.keyin.golf;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    private Members mockMember;

    @Test
    public void testGetMembersByFirstName(){
            Members tommy = new Members();
            tommy.setId(1L);
            tommy.setFirstName("Tommy");

            Members john = new Members();
            john.setId(2L);
            john.setFirstName("John");

            List<Members> membersList = new ArrayList<Members>();


            membersList.add(tommy);
            Mockito.when(mockMember.getFirstName()).thenReturn(tommy.getFirstName());
            assertEquals(tommy.getFirstName(),mockMember.getFirstName());
            Mockito.when(mockMember.getFirstName()).thenReturn(john.getFirstName());



    }

}
