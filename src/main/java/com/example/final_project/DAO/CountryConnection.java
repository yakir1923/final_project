package com.example.final_project.DAO;



import com.example.final_project.POCO.Countries;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryConnection implements DAO<Countries>{
    //public static List<Countries> countriesList;
    public Countries country;
    public PGAConnection myConnection;

    public CountryConnection() {
    }

    @Override
    public Countries get(int id) {
        try {
            myConnection= PGAConnection.getInstance();
            Statement stm=myConnection.connection.createStatement();
            var r=stm.executeQuery("SELECT * FROM \"Countries\" WHERE \"Id\"="+id+"");
            r.next();
            country=new Countries();
            country.id=r.getInt("Id");
            country.Name=r.getString("Name");
            return country;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new Countries();
    }

    @Override
    public List<Countries> getAll() {
        List<Countries> countriesList=new ArrayList<>();
        try {
            myConnection= PGAConnection.getInstance();
            Statement stm=myConnection.connection.createStatement();
            var r=stm.executeQuery("SELECT * FROM \"Countries\"");
            while (r.next()) {
                country = new Countries();
                country.id = r.getInt("Id");
                country.Name = r.getString("Name");
                countriesList.add(country);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return countriesList;
    }

    @Override
    public void add(Countries country) {
        try {
            myConnection= PGAConnection.getInstance();
            Statement stm=myConnection.connection.createStatement();
            var r=stm.executeQuery("INSERT INTO public.\"Countries\"(\n" +
                    "\t \"Name\")\n" +
                    "\tVALUES ('"+country.Name+"');");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void remove(Countries country) {
        try {
            myConnection= PGAConnection.getInstance();
            Statement stm=myConnection.connection.createStatement();
            var r=stm.executeQuery("DELETE FROM public.\"Countries\"\n" +
                    "\tWHERE \"Id\"="+country.id+";");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Countries country) {
        try {
            myConnection= PGAConnection.getInstance();
            Statement stm=myConnection.connection.createStatement();
            var r=stm.executeUpdate("UPDATE public.\"Countries\"\n" +
                    "\tSET \"Id\"='" +country.id+
                    "', \"Name\"='"+country.Name+"'"+
                    "\tWHERE <condition>;");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
