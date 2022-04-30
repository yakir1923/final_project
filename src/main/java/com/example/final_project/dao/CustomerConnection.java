package com.example.final_project.dao;


import com.example.final_project.POCO.Customers;
import org.springframework.stereotype.Component;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerConnection implements DAO<Customers>{
    public static List<Customers> customersList =new ArrayList<>();
    public PGAConnection myConnection;

    public CustomerConnection() {
    }

    @Override
    public Customers get(int id) {
        try {
            myConnection=PGAConnection.getInstance();
            Statement statement=myConnection.connection.createStatement();
            var r= statement.executeQuery("SELECT * FROM \"Customers\" WHERE \"Id\"="+id+"");
            r.next();
            Customers customer=new Customers();
            customer.id=r.getInt("id");
            customer.firstName=r.getString("First_Name");
            customer.lastName=r.getString("Last_Name");
            customer.Address=r.getString("Address");
            customer.phoneNumber=r.getString("Phone_No");
            customer.creditCardNumber=r.getString("Credit_Card_No");
            customer.UserId=r.getInt("User_Id");
            return customer;
        }catch (Exception e){
            System.out.println(e.getMessage()+" error from customer connection");
        }
        return new Customers();
    }

    @Override
    public List<Customers> getAll() {
        try {
            myConnection=PGAConnection.getInstance();
            Statement statement=myConnection.connection.createStatement();
            var r= statement.executeQuery("SELECT * FROM \"Customers\"");
            while (r.next()) {
                Customers customer = new Customers();
                customer.id = r.getInt("id");
                customer.firstName = r.getString("First_Name");
                customer.lastName = r.getString("Last_Name");
                customer.Address = r.getString("Address");
                customer.phoneNumber = r.getString("Phone_No");
                customer.creditCardNumber = r.getString("Credit_Card_No");
                customer.UserId = r.getInt("User_Id");
                customersList.add(customer);
            }
        }catch (Exception e){
            System.out.println(e.getMessage()+" error from customer connection");
        }
        return customersList;
    }

    @Override
    public void add(Customers customers) {
        try {
            myConnection=PGAConnection.getInstance();
            Statement statement=myConnection.connection.createStatement();
            var r= statement.executeQuery("INSERT INTO public.\"Customers\"(\n" +
                    "\t, \"First_Name\", \"Last_Name\", \"Address\", \"Phone_No\", \"Credit_Card_No\", \"User_Id\")\n" +
                    "\tVALUES ('" +customers.firstName+
                    "', '" +customers.lastName+
                    "', '" +customers.Address+
                    "', '" +customers.phoneNumber+
                    "', '" +customers.creditCardNumber+
                    "', '" +customers.UserId+
                    "');");
        }catch (Exception e){
            System.out.println(e.getMessage()+" error from customer connection");
        }
        customersList.add(customers);
    }

    @Override
    public void remove(Customers customers) {
        try {
            myConnection=PGAConnection.getInstance();
            Statement statement=myConnection.connection.createStatement();
            var r= statement.executeQuery("DELETE FROM public.\"Customers\"\n" +
                    "\tWHERE \"Id\"="+customers.id+";");
        }catch (Exception e){
            System.out.println(e.getMessage()+" error from customer connection");
        }
        customersList.remove(customers);
    }

    @Override
    public void update(Customers customers) {
        try{
            myConnection=PGAConnection.getInstance();
            Statement stm=myConnection.connection.createStatement();
            var r=stm.executeUpdate("UPDATE public.\"Customers\"\n" +
                    "\tSET \"First_Name\"='" +customers.firstName+
                    "', \"Last_Name\"='?" +customers.lastName+
                    "', \"Address\"='?" +customers.Address+
                    "', \"Phone_No\"='?" +customers.phoneNumber+
                    "', \"Credit_Card_No\"='?" +customers.creditCardNumber+
                    "', \"User_Id\"='"+customers.UserId+"'"+
                    "\tWHERE \"Id\"="+customers.id+";");
        }catch (Exception e){
            System.out.println("Error from AirlineCompanyConnection " +e.getMessage());
        }
    }
}
