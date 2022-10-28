package com.keyin.golf;
/* Members.java
   Class for members of the tournament...
   Author: Blake Waddleton
   Contributors:  David Bishop, Chris Doucette and Blake Waddleton
   Creation Date: Oct 24, 2022
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;
@Entity
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long membershipID;
    private Date membershipStartDate;
    private Date membershipEndDate;
    private String membershipType;
    public ArrayList<Person> personList = new ArrayList<>();
    public void addMember(Person person){
        personList.add(person);
    }
    public Members() {
        this.membershipStartDate = null;
        this.membershipEndDate = null;
        this.membershipType = "";
    }
    public Members(Long membershipID, Date membershipStartDate, Date membershipEndDate,String membershipType) {
        this.membershipID = membershipID;
        this.membershipStartDate = membershipStartDate;
        this.membershipEndDate = membershipEndDate;
        this.membershipType = membershipType;
    }
    public Long getMembershipID() {
        return membershipID;
    }
    public void setMembershipID(Long membershipID) {
        this.membershipID = membershipID;
    }
    public Date getMembershipStartDate() {
        return membershipStartDate;
    }
    public void setMembershipStartDate(Date membershipStartDate) {
        this.membershipStartDate = membershipStartDate;
    }
    public Date getMembershipEndDate() {
        return membershipEndDate;
    }
    public void setMembershipEndDate(Date membershipEndDate) {
        this.membershipEndDate = membershipEndDate;
    }
    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }
    public String getMembershipType() {
        return membershipType;
    }
}