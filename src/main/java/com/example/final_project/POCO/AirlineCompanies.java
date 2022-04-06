package com.example.final_project.POCO;

public class AirlineCompanies implements POCO{
    public int id;
    public String name;
    public int CountryId;
    public int UserId;

    public AirlineCompanies(int id, String name, int countryId, int userId) {
        this.id = id;
        this.name = name;
        CountryId = countryId;
        UserId = userId;
    }

    public AirlineCompanies() {
    }

    @Override
    public String toString() {
        return "AirlineCompanies{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", CountryId=" + CountryId +
                ", UserId=" + UserId +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
       AirlineCompanies a= (AirlineCompanies) obj;
       return (this.id==a.id
       &&this.name.equals(a.name)
       &&this.CountryId==a.CountryId
       &&this.UserId==a.UserId);
    }
}
