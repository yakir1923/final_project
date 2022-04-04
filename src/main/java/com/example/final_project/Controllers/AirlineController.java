package com.example.final_project.Controllers;

import com.example.final_project.Facade.AirlineFacade;
import com.example.final_project.POCO.AirlineCompanies;
import com.example.final_project.POCO.Flights;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}
