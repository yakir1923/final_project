package com.example.final_project.Controllers;


import com.example.final_project.Facade.AnonymousFacade;
import com.example.final_project.Facade.FacadeBase;
import com.example.final_project.POCO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class AnonymousController {


    AnonymousFacade anonymousFacade=new AnonymousFacade();


    @GetMapping("/get_all_flights")
    public List<Flights> get_all_flights(){
        return anonymousFacade.get_all_flights();
    }

    @RequestMapping("/get_flight_by_id/{id}")
    public Flights get_flight_by_id(@PathVariable int id){
       return anonymousFacade.get_flight_by_id(id);
    }


    @RequestMapping("/get_flights_by_parameters/{origin_country_id}/{destination_country_id}/{date}")
    public List<Flights> get_flights_by_parameters(@PathVariable int origin_country_id, @PathVariable int destination_country_id, @PathVariable Timestamp date){
        return anonymousFacade.get_flights_by_parameters(origin_country_id, destination_country_id, date);
    }

    @GetMapping("/get_all_airlines")
    public List<AirlineCompanies> get_all_airlines(){
        return anonymousFacade.get_all_airlines();
    }


    @RequestMapping("/get_airline_by_id/{id}")
    public AirlineCompanies get_airline_by_id(@PathVariable int id){
        return anonymousFacade.get_airline_by_id(id);
    }

    @RequestMapping("/get_airline_by_parameters/{name}/{countryId}/{UserId}")
    public AirlineCompanies get_airline_by_parameters(@PathVariable String name,@PathVariable int countryId,@PathVariable int UserId){
       return anonymousFacade.get_airline_by_parameters(name, countryId, UserId);
    }

    @GetMapping("/get_all_countries")
    public List<Countries> get_all_countries(){
        return anonymousFacade.get_all_countries();
    }

    @RequestMapping("get_country_by_id/{id}")
    public Countries get_country_by_id(@PathVariable int id){
        return anonymousFacade.get_country_by_id(id);
    }

    @PostMapping("/create_new_user")
    public void create_new_user(@RequestBody Users user){
        anonymousFacade.create_new_user(user);
    }

    @RequestMapping("/_login/{userName}/{password}")
    public FacadeBase _login(@PathVariable String userName,@PathVariable String password){
        return anonymousFacade.login(userName, password);
    }

    @PostMapping("/addCustomer")
    public void addCustomer(@RequestBody Customers customer ){
        anonymousFacade.addCustomer(customer);
    }




}
