package com.cov.covproxym.utils;

public class UserDto {
     private  String firstName ;
    private  String lastName ;
    private  String password ;
    private  String sexe ;
    private int phoneNumber ;
    private String userName ;

    public String getvMarque() {
        return vMarque;
    }

    public void setvMarque(String vMarque) {
        this.vMarque = vMarque;
    }

    private String vMarque;


    public UserDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
