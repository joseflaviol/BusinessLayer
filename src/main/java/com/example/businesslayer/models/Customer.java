package com.example.businesslayer.models;

public class Customer {

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private String address;
    private String country;
    private String state;

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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String toJson() {
        return "{\"firstName\": \"" + this.getFirstName() +
                "\", \"lastName\": \"" + this.getLastName() +
                "\", \"emailAddress\": \"" + this.getEmailAddress() +
                "\", \"phoneNumber\": \"" + this.getPhoneNumber() +
                "\", \"address\": \"" + this.getAddress() +
                "\", \"country\": \"" + this.getCountry() +
                "\", \"state\": \"" + this.getState() +
                "\"}";
    }

}
