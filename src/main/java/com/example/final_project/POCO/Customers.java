package com.example.final_project.POCO;

public class Customers implements POCO {

    public int id;
    public String firstName;
    public String lastName;
    public String Address;
    public String phoneNumber;
    public String creditCardNumber;
    public int UserId;

    public Customers(int id, String firstName, String lastName, String address, String phoneNumber, String creditCardNumber, int userId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        Address = address;
        this.phoneNumber = phoneNumber;
        this.creditCardNumber = creditCardNumber;
        UserId = userId;
    }

    public Customers() {
    }

    @Override
    public String toString() {
        return "Customers{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", Address='" + Address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", UserId=" + UserId +
                '}';
    }
}
