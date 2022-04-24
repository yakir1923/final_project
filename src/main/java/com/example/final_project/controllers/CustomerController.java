package com.example.final_project.controllers;

import com.example.final_project.facade.CustomerFacade;
import com.example.final_project.facade.FacadeBase;
import com.example.final_project.POCO.*;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/Customer")
public class CustomerController {

    CustomerFacade customerFacade=new CustomerFacade();

    @GetMapping("/get_my_tickets")
    public List<Tickets> get_my_tickets(){
        return customerFacade.get_my_tickets();
    }


    @DeleteMapping("/remove_ticket")
    public void remove_ticket(@RequestBody Tickets tickets){
        customerFacade.remove_ticket(tickets);
    }

    @PostMapping("/add_ticket")
    public void add_ticket(@RequestBody Tickets tickets){
        customerFacade.add_ticket(tickets);
    }

    @PutMapping("/update_customer")
    public void update_customer(@RequestBody Customers customers){
        customerFacade.update_customer(customers);
    }

    @GetMapping("/get_all_flights")
    public List<Flights> get_all_flights(){
        return customerFacade.get_all_flights();
    }

    @RequestMapping("/get_flight_by_id/{id}")
    public Flights get_flight_by_id(@PathVariable int id){
        return customerFacade.get_flight_by_id(id);
    }


    @RequestMapping("/get_flights_by_parameters/{origin_country_id}/{destination_country_id}/{date}")
    public List<Flights> get_flights_by_parameters(@PathVariable int origin_country_id, @PathVariable int destination_country_id, @PathVariable Timestamp date){
        return customerFacade.get_flights_by_parameters(origin_country_id, destination_country_id, date);
    }

    @GetMapping("/get_all_airlines")
    public List<AirlineCompanies> get_all_airlines(){
        return customerFacade.get_all_airlines();
    }


//    @RequestMapping("/get_airline_by_id/{id}")
//    public AirlineCompanies get_airline_by_id(@PathVariable int id){
//        return customerFacade.get_airline_by_id(id);
//    }

    @RequestMapping("/get_airline_by_parameters/{name}/{countryId}/{UserId}")
    public AirlineCompanies get_airline_by_parameters(@PathVariable String name,@PathVariable int countryId,@PathVariable int UserId){
        return customerFacade.get_airline_by_parameters(name, countryId, UserId);
    }

    @GetMapping("/get_all_countries")
    public List<Countries> get_all_countries(){
        return customerFacade.get_all_countries();
    }

    @RequestMapping("get_country_by_id/{id}")
    public Countries get_country_by_id(@PathVariable int id){
        return customerFacade.get_country_by_id(id);
    }

    @PostMapping("/create_new_user")
    public void create_new_user(@RequestBody Users user){
        customerFacade.create_new_user(user);
    }

    @RequestMapping("/_login/{userName}/{password}")
    public FacadeBase _login(@PathVariable String userName, @PathVariable String password){
        return customerFacade.login(userName, password);
    }

    @PostMapping("/addCustomer")
    public void addCustomer(@RequestBody Customers customer ){
        customerFacade.addCustomer(customer);
    }

}
