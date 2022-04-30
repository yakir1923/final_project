package com.example.final_project.controllers;

import com.example.final_project.facade.AirlineFacade;
import com.example.final_project.facade.FacadeBase;
import com.example.final_project.POCO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/airline")
public class AirlineController {

    @Autowired
    AirlineFacade airlineFacade;

    @GetMapping("/")
    public List<Flights> get_my_flights(){
        return airlineFacade.get_my_flights();
    }

    @PutMapping("/update_airline")
    public void updateFlight(@RequestBody AirlineCompanies airlineCompany){
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


}
