package com.example.final_project.aspect;


import com.example.final_project.DTO.AddLogger;
import com.example.final_project.service.AddLoggerService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Aspect
public class LoggerAspect {

    @Autowired
    AddLoggerService addLoggerService;

    DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("HH:mm:ss dd.MM.yyyy");


    @Before("com.example.final_project.aspect.AspectPointCut.allAddMethods()")
    public void beforeAdding(){
        int id=addLoggerService.getLength();
        AddLogger addLogger=new AddLogger(id,dateTimeFormatter.format(LocalDateTime.now()));
        addLoggerService.add(addLogger);
        System.out.println(addLogger);
    }

}
