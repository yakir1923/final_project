package com.example.final_project.controllers;


import com.example.final_project.facade.AdministratorFacade;
import com.example.final_project.POCO.*;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("admin")
public class AdministratorController {


    AdministratorFacade administratorFacade=new AdministratorFacade();

    @GetMapping("/")
    public List<Customers> getAllCustomers(){
        return administratorFacade.get_all_customers();
    }

    @PostMapping("/addAirline")
    public void addAirline(@RequestBody AirlineCompanies airlineCompany){
        administratorFacade.add_airline(airlineCompany);
    }

    @PostMapping("/add_customer")
    public void add_customer(@RequestBody Customers customers) {
        administratorFacade.add_customer(customers);
    }

    @PostMapping("/add_administrator")
    public void add_administrator(@RequestBody Adminstrator adminstrator){
        administratorFacade.add_administrator(adminstrator);
    }
    @DeleteMapping("/remove_airline")
    public void remove_airline(@RequestBody AirlineCompanies airlineCompanies){
        administratorFacade.remove_airline(airlineCompanies);
    }

    @DeleteMapping("/remove_customer")
    public void remove_customer(@RequestBody Customers customers){
        administratorFacade.remove_customer(customers);
    }

    @DeleteMapping("/remove_administrator")
    public void remove_administrator(@RequestBody Adminstrator adminstrator){
        administratorFacade.remove_administrator(adminstrator);
    }

    @GetMapping("/get_all_flights")
    public List<Flights> get_all_flights(){
        return administratorFacade.get_all_flights();
    }

    @RequestMapping("/get_flight_by_id/{id}")
    public Flights get_flight_by_id(@PathVariable int id){
        return administratorFacade.get_flight_by_id(id);
    }


    @RequestMapping("/get_flights_by_parameters/{origin_country_id}/{destination_country_id}/{date}")
    public List<Flights> get_flights_by_parameters(@PathVariable int origin_country_id, @PathVariable int destination_country_id, @PathVariable Timestamp date){
        return administratorFacade.get_flights_by_parameters(origin_country_id, destination_country_id, date);
    }

    @GetMapping("/get_all_airlines")
    public List<AirlineCompanies> get_all_airlines(){
        return administratorFacade.get_all_airlines();
    }


    @RequestMapping("/get_airline_by_id/{id}")
    public AirlineCompanies get_airline_by_id(@PathVariable int id){
        return administratorFacade.get_airline_by_id(id);
    }

    @RequestMapping("/get_airline_by_parameters/{name}/{countryId}/{UserId}")
    public AirlineCompanies get_airline_by_parameters(@PathVariable String name,@PathVariable int countryId,@PathVariable int UserId){
        return administratorFacade.get_airline_by_parameters(name, countryId, UserId);
    }

    @GetMapping("/get_all_countries")
    public List<Countries> get_all_countries(){
        return administratorFacade.get_all_countries();
    }

    @RequestMapping("get_country_by_id/{id}")
    public Countries get_country_by_id(@PathVariable int id){
        return administratorFacade.get_country_by_id(id);
    }

    @PostMapping("/create_new_user")
    public void create_new_user(@RequestBody Users user){
        administratorFacade.create_new_user(user);
    }


}
