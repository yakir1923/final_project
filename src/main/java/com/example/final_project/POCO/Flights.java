package com.example.final_project.POCO;

import java.sql.Timestamp;

public class Flights implements POCO {
    public int id;
    public int airlineCompanyId;
    public int originCountryId;
    public int destinationCountryId;
    public Timestamp departureTime;
    public Timestamp landingTime;
    public int remainingTickets;

    public Flights(int id, int airlineCompanyId, int originCountryId, int destinationCountryId, Timestamp departureTime, Timestamp landingTime, int remainingTickets) {
        this.id = id;
        this.airlineCompanyId = airlineCompanyId;
        this.originCountryId = originCountryId;
        this.destinationCountryId = destinationCountryId;
        this.departureTime = departureTime;
        this.landingTime = landingTime;
        this.remainingTickets = remainingTickets;
    }

    public Flights() {
    }

    @Override
    public String toString() {
        return "Flights{" +
                "id=" + id +
                ", airlineCompanyId=" + airlineCompanyId +
                ", originCountryId=" + originCountryId +
                ", destinationCountryId=" + destinationCountryId +
                ", departureTime=" + departureTime +
                ", landingTime=" + landingTime +
                ", remainingTickets=" + remainingTickets +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        Flights other=(Flights) obj;

        return (this.id==other.id
                &&this.airlineCompanyId==other.airlineCompanyId
                &&this.originCountryId==other.originCountryId
                &&this.destinationCountryId==other.destinationCountryId
                &&this.departureTime.toString().equals(other.departureTime.toString())
                &&this.landingTime.toString().equals(other.landingTime.toString())
                &&this.remainingTickets==other.remainingTickets);
    }
}
