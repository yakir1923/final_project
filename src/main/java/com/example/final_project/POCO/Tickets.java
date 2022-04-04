package com.example.final_project.POCO;

public class Tickets implements POCO {
    public int id;
    public int flightId;
    public int CustomerID;

    public Tickets(int id, int flightId, int customerID) {
        this.id = id;
        this.flightId = flightId;
        CustomerID = customerID;
    }

    public Tickets() {
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "id=" + id +
                ", flightId=" + flightId +
                ", CustomerID=" + CustomerID +
                '}';
    }
}
