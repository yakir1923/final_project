package com.example.final_project.Service;
import aj.org.objectweb.asm.ModuleVisitor;

import antlr.collections.impl.LList;
import com.example.final_project.DTO.MassageFromUser;
import com.example.final_project.Repository.MassageFromUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
