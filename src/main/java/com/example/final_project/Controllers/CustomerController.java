package com.example.final_project.Controllers;

import com.example.final_project.Facade.CustomerFacade;
import com.example.final_project.POCO.Customers;
import com.example.final_project.POCO.Tickets;
import org.springframework.web.bind.annotation.*;

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

}
