package com.example.final_project.controllers;

import com.example.final_project.DTO.MassageFromUser;
import com.example.final_project.service.MassegeFromUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contactus")
public class MassageFromUserController {

    @Autowired
    MassegeFromUserService massegeFromUserService;


    @GetMapping("/massages")
    public List<MassageFromUser> getAll(){
        return massegeFromUserService.getAllMassages();
    }

    @GetMapping("/massage/{id}")
    MassageFromUser getById(@PathVariable int id){
        var res=massegeFromUserService.getMassageFromUser(id);
        return (res!=null? res:new MassageFromUser());
    }
    @PostMapping("/addMassage")
    public void add(@RequestBody MassageFromUser massage){
        massegeFromUserService.addMassegeFromUser(massage);
    }


}
