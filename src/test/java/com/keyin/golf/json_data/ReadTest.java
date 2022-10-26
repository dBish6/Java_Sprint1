package com.keyin.golf.json_data;

/* ReadTest.java
   To test the methods of the Read.java class.

   Author: David Bishop
   Contributors:  Dominic Whelan, Chris Doucette and Blake Waddleton
   Creation Date: Oct 25, 2022

 */

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class ReadTest {

    private static Read readClassMock;

//    @Mock
//    Read testCase = Read.class;
//    when(ExampleClass.methodToTest(foc)).thenCallRealMethod();

    @BeforeAll
    public static void before() {
    System.out.println("Setting it up!");
    readClassMock = Mockito.mock(Read.class);
    }

    @Test
    public void memberJsonMethodsTest() throws IOException, ParseException {
        System.out.println("*Running: memberJsonMethodsTest()*");



        readClassMock.readMembersJSON();
//        readClassMock.parseMemberObj();

        Assertions.assertThrows(FileNotFoundException.class, () -> {
           new FileReader("src/main/golf.club.json/members312.json");
        });
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/main/golf.club.json/members.json");
        Object obj = jsonParser.parse(reader);
        JSONObject jsonObj = (JSONObject) obj;

//        Assertions.assertNotNull(readClassMock.parseMemberObj(jsonObj));
    }

    @AfterAll
    public static void after() {
        System.out.println("Tests ended.");
    }
}
