package com.example.final_project.DAO;



import com.example.final_project.POCO.Flights;
import org.springframework.stereotype.Component;

import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
public class FlightConnection implements DAO<Flights>{
    public Flights flight;
    public PGAConnection myConnection;

    public FlightConnection() {
    }

    @Override
    public Flights get(int id) {
        try {
            myConnection= PGAConnection.getInstance();
            Statement stm=myConnection.connection.createStatement();
            var r=stm.executeQuery("SELECT * FROM \"Flights\" WHERE \"Id\" = "+id+"");
            r.next();
            flight=new Flights();
            flight.id=r.getInt("Id");
            flight.airlineCompanyId=r.getInt("Airline_Company_Id");
            flight.originCountryId=r.getInt("Origin_Country_Id");
            flight.destinationCountryId=r.getInt("Destination_Country_Id");
            flight.departureTime=r.getTimestamp("Departure_Time");
            flight.landingTime=r.getTimestamp("Landing_Time");
            flight.remainingTickets=r.getInt("Remaining_Tickets");
            return flight;
        }catch (Exception e){
            System.out.println("Error from FlightConnection "+e.getMessage());
        }
        return new Flights();
    }

    @Override
    public List<Flights> getAll() {
        List<Flights> flightsList=new ArrayList<>();
        try {
            myConnection= PGAConnection.getInstance();
            Statement stm=myConnection.connection.createStatement();
            var r=stm.executeQuery("SELECT * FROM \"Flights\"");
            while (r.next()) {
                flight = new Flights();
                flight.id = r.getInt("Id");
                flight.airlineCompanyId = r.getInt("Airline_Company_Id");
                flight.originCountryId = r.getInt("Origin_Country_Id");
                flight.destinationCountryId = r.getInt("Destination_Country_Id");
                flight.departureTime = r.getTimestamp("Departure_Time");
                flight.landingTime = r.getTimestamp("Landing_Time");
                flight.remainingTickets = r.getInt("Remaining_Tickets");
                flightsList.add(flight);
            }
        }catch (Exception e){
            System.out.println("Error from FlightConnection "+e.getMessage());
        }
        return flightsList;
    }

    @Override
    public void add(Flights flight) {

        try {
            if (flight.remainingTickets>=0) {
                myConnection = PGAConnection.getInstance();
                Statement stm = myConnection.connection.createStatement();
                var r = stm.executeQuery("INSERT INTO public.\"Flights\"(\n" +
                        "\t \"Airline_Company_Id\", \"Origin_Country_Id\", \"Destination_Country_Id\", \"Departure_Time\", \"Landing_Time\", \"Remaining_Tickets\")\n" +
                        "\tVALUES ('" + flight.airlineCompanyId +
                        "', '" + flight.originCountryId +
                        "', '" + flight.destinationCountryId +
                        "', '" + flight.departureTime +
                        "', '" + flight.landingTime +
                        "', '" + flight.remainingTickets +
                        "');");
            }else {
                System.out.println("cant have negative tickets number");
            }
        }catch (Exception e){
            System.out.println("Error from AirlineCompanyConnection "+e.getMessage());
        }
    }

    @Override
    public void remove(Flights flight) {
        try {
            myConnection=PGAConnection.getInstance();
            Statement stm=myConnection.connection.createStatement();
            var r=stm.executeQuery("DELETE FROM public.\"Flights\"" +
                    " WHERE \"Id\"="+flight.id+";");
        }catch (Exception e){
            System.out.println("Error from FlightConnection  "+e.getMessage());
        }
    }

    @Override
    public void update(Flights flight) {
        try {
            if (flight.remainingTickets>=0) {
                myConnection = PGAConnection.getInstance();
                Statement stm = myConnection.connection.createStatement();
                var r = stm.executeUpdate("UPDATE public.\"Flights\"" +
                        " SET \"Airline_Company_Id\"=" + flight.airlineCompanyId +
                        ", \"Origin_Country_Id\"=" + flight.originCountryId +
                        ", \"Destination_Country_Id\"=" + flight.destinationCountryId +
                        ", \"Departure_Time\"='" + flight.departureTime +
                        "', \"Landing_Time\"='" + flight.landingTime +
                        "', \"Remaining_Tickets\"=" + flight.remainingTickets +
                        " WHERE \"Id\"=" + flight.id + ";");
            }else {
                System.out.println("cant have negative tickets number");
            }

        }catch (Exception e){
            System.out.println("Error from AirlineCompanyConnection "+e.getMessage());
        }
    }

    public List<Flights> get_flights_by_parameters(int origin_country_id, int destination_country_id, Timestamp date){
        List<Flights> flightsList=new ArrayList<>();
        try {
            myConnection = PGAConnection.getInstance();
            Statement stm = myConnection.connection.createStatement();
            var r=stm.executeQuery("SELECT * FROM get_Flights_by_parameters("+origin_country_id+","+destination_country_id+",'"+date+"')");
            while (r.next()){
                flight=new Flights();
                flight.id=r.getInt("Id");
                flight.airlineCompanyId=r.getInt("Airline_Company_Id");
                flight.originCountryId=r.getInt("Origin_Country_Id");
                flight.destinationCountryId=r.getInt("Destination_Country_Id");
                flight.departureTime=r.getTimestamp("Departure_Time");
                flight.landingTime=r.getTimestamp("Landing_Time");
                flight.remainingTickets=r.getInt("Remaining_Tickets");
                flightsList.add(flight);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage() + " from " + getClass().getName());
        }
        return flightsList;
    }

    public List<Flights> get_flights_by_airline_id(int _airline_id){
        List<Flights> flightsList1=new ArrayList<>();
        try {
            myConnection=PGAConnection.getInstance();
            Statement stm=myConnection.connection.createStatement();
            var r=stm.executeQuery("SELECT * FROM get_flights_by_airline_id("+_airline_id+")");
            while (r.next()) {
                flight = new Flights();
                flight.id = r.getInt("Id");
                flight.airlineCompanyId = r.getInt("Airline_Company_Id");
                flight.originCountryId = r.getInt("Origin_Country_Id");
                flight.destinationCountryId = r.getInt("Destination_Country_Id");
                flight.departureTime = r.getTimestamp("Departure_Time");
                flight.landingTime = r.getTimestamp("Landing_Time");
                flight.remainingTickets = r.getInt("Remaining_Tickets");
                flightsList1.add(flight);
            }
        }catch (Exception e){
            System.out.println("Error from AirlineCompanyConnection "+e.getMessage());
        }
        return flightsList1;
    }

}
