package com.example.final_project.POCO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Users implements POCO {
    public int id;
    public String userName;
    public String password;
    public String email;
    public int userRole;

    public Users(int id, String userName, String password, String email, int userRole) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.userRole = userRole;
    }


    public Users() {
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}
