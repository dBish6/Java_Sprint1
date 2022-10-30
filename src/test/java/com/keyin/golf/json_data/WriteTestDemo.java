package com.keyin.golf.json_data;

import com.keyin.golf.Member;
import com.keyin.golf.Membership;
import org.junit.jupiter.api.BeforeAll;

import java.util.Date;

public class WriteTestDemo {

    private static long testMembershipId;
    private static String testMembershipType;
    private static Date testMembershipStartDate;
    private static Date testMembershipExpireDate;
    private static long testMemberId;
    private static String testName;
    private static String testEmail;
    private static String testPhoneNumber;
    private static String testAddress;

    @BeforeAll
    public static void before() {
        System.out.println("Initial setup running...");

        testMembershipId = 27;
        testMembershipType = "Standard";
        testMemberId = 277;
        testMembershipStartDate = new Date(2023,06,5);
        testMembershipExpireDate = new Date(2024,06,5);
        testName = "Luke Skywalker";
        testEmail = "usetheforce@lightside.com";
        testPhoneNumber = "9086675";
        testAddress = "667 jedi way";


        System.out.println("Test(s) start...\n");
    }

    public static void main(String[] args) {

        Member testMember = new Member(testMemberId,testName,testEmail,testPhoneNumber,testAddress);
        Membership testMembership = new Membership(testMembershipId, testMembershipType, testMembershipStartDate,testMembershipExpireDate);

    }
}
