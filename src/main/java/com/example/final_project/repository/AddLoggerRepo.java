package com.example.final_project.repository;

import com.example.final_project.DTO.AddLogger;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddLoggerRepo extends MongoRepository<AddLogger,Integer> {

}
