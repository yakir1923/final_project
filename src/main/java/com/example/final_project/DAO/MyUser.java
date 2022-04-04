package com.example.final_project.DAO;

public class MyUser {
    private String url;
    private String userName;
    private String password;


    public MyUser() {
        this.url="jdbc:postgresql://localhost:5432/Airline";
        this.userName ="postgres";
        this.password="eliranM!2319";
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
