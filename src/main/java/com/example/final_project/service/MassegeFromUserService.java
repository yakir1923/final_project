package com.example.final_project.service;

import com.example.final_project.DTO.MassageFromUser;
import com.example.final_project.repository.MassageFromUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MassegeFromUserService {

    @Autowired
    MassageFromUserRepo massageFromUserRepo;

    public List<MassageFromUser> getAllMassages(){
        List<MassageFromUser> massages=new ArrayList<>();
        massageFromUserRepo.findAll().forEach(massages::add);
        return massages;
    }
    public MassageFromUser getMassageFromUser(int id){
        var res=massageFromUserRepo.findById(id);
        return res.orElse(new MassageFromUser());
    }

    public void addMassegeFromUser(MassageFromUser massage){
        massageFromUserRepo.save(massage);
    }
}
