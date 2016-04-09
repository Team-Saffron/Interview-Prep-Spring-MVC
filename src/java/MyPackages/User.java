/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPackages;

import java.util.*;

public class User {
    
    private String username;
    private String passwrod;
    private String fullname;
    private String email;
    private Date dob;
    private String country;
    private String gender;
    private int age;
  
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    //other optional Attributes to be added later

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasswrod(String password) {
        this.passwrod = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPasswrod() {
        return passwrod;
    }   
}
