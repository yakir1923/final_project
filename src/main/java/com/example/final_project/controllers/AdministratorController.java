package com.example.final_project.controllers;


import com.example.final_project.facade.AdministratorFacade;
import com.example.final_project.POCO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdministratorController {


    @Autowired
    AdministratorFacade administratorFacade;

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

}
