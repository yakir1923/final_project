package com.example.final_project.controllers;

import com.example.final_project.facade.CustomerFacade;
import com.example.final_project.facade.FacadeBase;
import com.example.final_project.POCO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerFacade customerFacade;

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

}
