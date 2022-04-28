package com.example.final_project.POCO;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Users implements POCO {

    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
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
