package com.example.final_project.Facade;



import com.example.final_project.DAO.CustomerConnection;
import com.example.final_project.DAO.TicketConnection;
import com.example.final_project.POCO.Customers;
import com.example.final_project.POCO.Tickets;

import java.util.ArrayList;
import java.util.List;

public class CustomerFacade extends AirlineFacade{


    public void update_customer (Customers customer){
        if (loginToken.getId()==customer.UserId) {
            CustomerConnection connection = new CustomerConnection();
            connection.update(customer);
        }
    }
    public void add_ticket (Tickets ticket){
        if (loginToken.getId()==ticket.CustomerID) {
            TicketConnection connection = new TicketConnection();
            connection.add(ticket);
        }
    }
    public void remove_ticket (Tickets ticket){
        if (loginToken.getId()==ticket.CustomerID) {
            TicketConnection connection = new TicketConnection();
            connection.remove(ticket);
        }
    }
    public List<Tickets> get_my_tickets (){
        TicketConnection ticketConnection=new TicketConnection();
        List<Tickets> tickets=new ArrayList<>();
        ticketConnection.getAll().stream().filter(ticket -> ticket.CustomerID== loginToken.getId()).forEach(tickets::add);
        return tickets;
    }

}
