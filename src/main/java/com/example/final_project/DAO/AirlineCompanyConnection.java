package com.example.final_project.DAO;


import com.example.final_project.POCO.AirlineCompanies;
import org.springframework.stereotype.Component;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class AirlineCompanyConnection implements DAO<AirlineCompanies>{

    PGAConnection myConnection;
    AirlineCompanies airlineCompany;
//    public static List<AirlineCompanies> airlinesList=new ArrayList<>();


    public AirlineCompanyConnection() {
    }

    @Override
    public AirlineCompanies get(int id) {
        try {
            myConnection= PGAConnection.getInstance();
            Statement stm=myConnection.connection.createStatement();
            var r=stm.executeQuery("SELECT * FROM \"Airline_Companies\" WHERE \"Id\" = "+id+" ");
            r.next();
            airlineCompany =new AirlineCompanies();
            airlineCompany.id=r.getInt("Id");
            airlineCompany.CountryId=r.getInt("Country_Id");
            airlineCompany.name=r.getString("Name");
            airlineCompany.UserId=r.getInt("User_Id");
            return airlineCompany;
        }catch (Exception e){
            System.out.println("Error from AirlineCompanyConnection "+e.getMessage());
        }
        return new AirlineCompanies();
    }

    @Override
    public List<AirlineCompanies> getAll() {
        List<AirlineCompanies> airlineCompanies=new ArrayList<>();
        try {
            myConnection=PGAConnection.getInstance();
            Statement stm=myConnection.connection.createStatement();
            var r=stm.executeQuery("SELECT * FROM \"Airline_Companies\"");
            while (r.next()){
                airlineCompany =new AirlineCompanies();
                airlineCompany.id=r.getInt("Id");
                airlineCompany.UserId=r.getInt("User_Id");
                airlineCompany.name=r.getString("Name");
                airlineCompany.CountryId=r.getInt("Country_Id");
                airlineCompanies.add(airlineCompany);
            }
        }catch (Exception e){
            System.out.println("Error from AirlineCompanyConnection "+e.getMessage());
        }
        return airlineCompanies;
    }

    @Override
    public void add(AirlineCompanies t) {
        try {
            myConnection=PGAConnection.getInstance();
            Statement stm=myConnection.connection.createStatement();
            var r=stm.executeQuery("INSERT INTO public.\"Airline_Companies\"(\n" +
                    "\t \"Name\", \"Country_Id\", \"User_Id\")\n" +
                    "\tVALUES ('" +t.name+
                    "', '" +t.CountryId+
                    "', '" +t.UserId+
                    "');");
        }catch (Exception e){
            System.out.println("Error from AirlineCompanyConnection "+e.getMessage());
        }

    }

    @Override
    public void remove(AirlineCompanies t) {
        try {
            myConnection=PGAConnection.getInstance();
            Statement stm=myConnection.connection.createStatement();
            var r=stm.executeQuery("DELETE FROM public.\"Airline_Companies\"\n" +
                    "\tWHERE \"Id\"="+t.id+";");
        }catch (Exception e){
            System.out.println("Error from AirlineCompanyConnection "+e.getMessage());
        }
    }

    @Override
    public void update(AirlineCompanies airlineCompany) {
        try{
            myConnection=PGAConnection.getInstance();
            Statement stm=myConnection.connection.createStatement();
            var r=stm.executeUpdate("UPDATE Table \"Airline_Companies\" \n" +
                    "SET \"Id\"="+airlineCompany.id+
                    ",\"Name\"='"+airlineCompany.name+
                    "',\"Country_Id\"='"+airlineCompany.CountryId+
                    "',\"User_Id\"='"+airlineCompany.UserId+"'");
        }catch (Exception e){
            System.out.println("Error from AirlineCompanyConnection " +e.getMessage());
        }
    }

    public AirlineCompanies get_airline_by_parameters(String name,int countryId,int UserId){
        try {
            myConnection= PGAConnection.getInstance();
            Statement stm=myConnection.connection.createStatement();
            var r=stm.executeQuery("SELECT * FROM \"Airline_Companies\" WHERE \"Name\" = "+name+" and "+"\"Country_Id\"="+countryId+"\"User_Id\"="+UserId);
            r.next();
            airlineCompany =new AirlineCompanies();
            airlineCompany.id=r.getInt("Id");
            airlineCompany.CountryId=r.getInt("Country_Id");
            airlineCompany.name=r.getString("Name");
            airlineCompany.UserId=r.getInt("User_Id");
            return airlineCompany;
        }catch (Exception e){
            System.out.println("Error from AirlineCompanyConnection "+e.getMessage());
        }
        return new AirlineCompanies();
    }

}
