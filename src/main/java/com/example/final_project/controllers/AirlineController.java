package com.example.final_project.controllers;

import com.example.final_project.facade.AirlineFacade;
import com.example.final_project.facade.FacadeBase;
import com.example.final_project.POCO.*;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("airline")
public class AirlineController {


    AirlineFacade airlineFacade=new AirlineFacade();

    @GetMapping("/")
    public List<Flights> get_my_flights(){
        return airlineFacade.get_my_flights();
    }

    @PutMapping("/update_airline")
    public void update(@RequestBody AirlineCompanies airlineCompany){
        airlineFacade.update_airline(airlineCompany);
    }
    @PostMapping("/add_flight")
    public void add_flight(@RequestBody Flights flights){
        airlineFacade.add_flight(flights);
    }
    @PutMapping("/update_flight")
    public void update_flight(@RequestBody Flights flights){
        airlineFacade.update_flight(flights);
    }
    @DeleteMapping("/remove_flight")
    public void remove_flight(@RequestBody Flights flights){
        airlineFacade.remove_flight(flights);
    }

    @GetMapping("/get_all_flights")
    public List<Flights> get_all_flights(){
        return airlineFacade.get_all_flights();
    }

    @RequestMapping("/get_flight_by_id/{id}")
    public Flights get_flight_by_id(@PathVariable int id){
        return airlineFacade.get_flight_by_id(id);
    }


    @RequestMapping("/get_flights_by_parameters/{origin_country_id}/{destination_country_id}/{date}")
    public List<Flights> get_flights_by_parameters(@PathVariable int origin_country_id, @PathVariable int destination_country_id, @PathVariable Timestamp date){
        return airlineFacade.get_flights_by_parameters(origin_country_id, destination_country_id, date);
    }

    @GetMapping("/get_all_airlines")
    public List<AirlineCompanies> get_all_airlines(){
        return airlineFacade.get_all_airlines();
    }


    @RequestMapping("/get_airline_by_id/{id}")
    public AirlineCompanies get_airline_by_id(@PathVariable int id){
        return airlineFacade.get_airline_by_id(id);
    }

    @RequestMapping("/get_airline_by_parameters/{name}/{countryId}/{UserId}")
    public AirlineCompanies get_airline_by_parameters(@PathVariable String name,@PathVariable int countryId,@PathVariable int UserId){
        return airlineFacade.get_airline_by_parameters(name, countryId, UserId);
    }

    @GetMapping("/get_all_countries")
    public List<Countries> get_all_countries(){
        return airlineFacade.get_all_countries();
    }

    @RequestMapping("get_country_by_id/{id}")
    public Countries get_country_by_id(@PathVariable int id){
        return airlineFacade.get_country_by_id(id);
    }

    @PostMapping("/create_new_user")
    public void create_new_user(@RequestBody Users user){
        airlineFacade.create_new_user(user);
    }

    @RequestMapping("/_login/{userName}/{password}")
    public FacadeBase _login(@PathVariable String userName, @PathVariable String password){
        return airlineFacade.login(userName, password);
    }

    @PostMapping("/addCustomer")
    public void addCustomer(@RequestBody Customers customer ){
        airlineFacade.addCustomer(customer);
    }


}
