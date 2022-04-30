package com.example.final_project.service;


import com.example.final_project.DTO.AddLogger;
import com.example.final_project.repository.AddLoggerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddLoggerService {

    @Autowired
    AddLoggerRepo addLoggerRepo;

    public void add(AddLogger addLogger){
        addLoggerRepo.save(addLogger);
    }
    public int getLength(){
        return (addLoggerRepo.findAll().size()+1);
    }
}
