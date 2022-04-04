package com.example.final_project.POCO;

public class Adminstrator implements POCO {
    public int id;
    public String firstName;
    public String lastName;
    public int userId;

    public Adminstrator(int id, String firstName, String lastName, int userId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = userId;
    }

    public Adminstrator() {
    }

    @Override
    public String toString() {
        return "Adminstrator{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userId=" + userId +
                '}';
    }
}
