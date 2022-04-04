package com.example.final_project.Facade;


public class LoginToken {
   private int id;
   private   String name;
   private int userRole;

    public LoginToken(int id, String name, int userRole) {
        this.id = id;
        this.name = name;
        this.userRole = userRole;
    }

    public LoginToken() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "LoginToken{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}
