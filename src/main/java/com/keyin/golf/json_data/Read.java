package com.keyin.golf.json_data;

/* Read.java
   Class for members of the tournament...

   Author: Dominic Whelan
   Contributors:  David Bishop, Chris Doucette and Blake Waddleton
   Creation Date: Oct 24, 2022

 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Read {

    public static void main(String[] args) {

        JSONParser jsonParser = new JSONParser();
        try(FileReader reader = new FileReader("src/json/employee.json")) {
            // Reads JSON File above and then parses it to object form.
            Object obj = jsonParser.parse(reader);
            // To Json array.
            JSONArray empList = (JSONArray) obj;
            System.out.println(empList);
            // Iterate over emp array, one record at a time from parseEmpObj function.
            empList.forEach(emp -> parseEmpObj((JSONObject) emp));

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    private static void parseEmpObj(JSONObject emp) {
        JSONObject empObj = (JSONObject) emp.get("employee");
        // Get emp roleNum, created, name, email, and phone.
        String roleNum = (String) empObj.get("roleNum");
        String createdDate = (String) empObj.get("created");
        String name = (String) empObj.get("name");
        String email = (String) empObj.get("email");
        String phone = (String) empObj.get("phone");
        System.out.println("RoleNum: " + roleNum);
        System.out.println("Created: " + createdDate);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone + "\n");
        // Somehow add these to the class here in this function.
    }
}
