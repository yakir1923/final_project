package com.example.final_project.DTO;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document("\"loggers\"")
public class AddLogger {

   @Id
   private int id;
   private String time;
}
