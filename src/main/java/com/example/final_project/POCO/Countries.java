package com.example.final_project.POCO;

public class Countries implements POCO {
    public int id;
    public String Name;


    public Countries() {
    }

    public Countries(int id, String name) {
        this.id = id;
        Name = name;
    }

    @Override
    public String toString() {
        return "Countries{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                '}';
    }
}
