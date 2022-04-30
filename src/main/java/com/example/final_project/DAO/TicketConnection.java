package com.example.final_project.DAO;


import com.example.final_project.POCO.Tickets;
import org.springframework.stereotype.Component;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class TicketConnection implements DAO<Tickets>{

    public static List<Tickets> ticketsList=new ArrayList<>();
    public Tickets ticket;
    public PGAConnection myConnection;
    public TicketConnection() {
    }

    @Override
    public Tickets get(int id) {
        try {
            myConnection= PGAConnection.getInstance();
            Statement stm=myConnection.connection.createStatement();
            var r=stm.executeQuery("SELECT * FROM \"Tickets\" WHERE \"Id\" = "+id+"");
            r.next();
            ticket = new Tickets();
            ticket.id=r.getInt("Id");
            ticket.CustomerID=r.getInt("Customer_Id");
            ticket.flightId=r.getInt("Flight_Id");
            return ticket;
        }catch (Exception e){
            System.out.println("Error from TicketConnection "+e.getMessage());
        }
        return new Tickets();
    }

    @Override
    public List<Tickets> getAll() {
        try {
            myConnection= PGAConnection.getInstance();
            Statement stm=myConnection.connection.createStatement();
            var r=stm.executeQuery("SELECT * FROM \"Tickets\"");
           while (r.next()) {
               ticket = new Tickets();
               ticket.id = r.getInt("Id");
               ticket.CustomerID = r.getInt("Customer_Id");
               ticket.flightId = r.getInt("Flight_Id");
               ticketsList.add(ticket);
           }
        }catch (Exception e){
            System.out.println("Error from AirlineCompanyConnection "+e.getMessage());
        }
        return ticketsList;
    }

    @Override
    public void add(Tickets ticket) {
        try {
            myConnection= PGAConnection.getInstance();
            Statement stm=myConnection.connection.createStatement();
            var r=stm.executeQuery("INSERT INTO public.\"Tickets\"(\n" +
                    "\t \"Flight_Id\", \"Customer_Id\")\n" +
                    "\tVALUES ('" +ticket.flightId+
                    "', '" +ticket.CustomerID+
                    "');");
        }catch (Exception e){
            System.out.println("Error from AirlineCompanyConnection "+e.getMessage());
        }
    }

    @Override
    public void remove(Tickets ticket) {
        try {
            myConnection = PGAConnection.getInstance();
            Statement stm = myConnection.connection.createStatement();
            var r = stm.executeQuery("DELETE FROM public.\"Tickets\"\n" +
                    "\tWHERE \"Id\"=" + ticket.id + ";");
            ticketsList.remove(ticket);
        } catch (Exception e) {
            System.out.println("Error from TicketConnection " + e.getMessage());
        }
    }


    @Override
    public void update(Tickets ticket) {
        try {
            myConnection = PGAConnection.getInstance();
            Statement stm = myConnection.connection.createStatement();
            var r = stm.executeUpdate("UPDATE public.\"Tickets\"\n" +
                    "\tSET \"Id\"='" +ticket.id+
                    "', \"Flight_Id\"='" +ticket.flightId+
                    "', \"Customer_Id\"='" +ticket.CustomerID+
                    "'\tWHERE <condition>;");
        } catch (Exception e) {
            System.out.println("Error from TicketConnection " + e.getMessage());
        }
    }
}
