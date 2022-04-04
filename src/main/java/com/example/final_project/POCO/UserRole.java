package com.example.final_project.POCO;

public class UserRole implements POCO{
    public int id;
    public String RoleName;

    public UserRole() {
    }

    public UserRole(int id, String roleName) {
        this.id = id;
        RoleName = roleName;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", RoleName='" + RoleName + '\'' +
                '}';
    }
}
