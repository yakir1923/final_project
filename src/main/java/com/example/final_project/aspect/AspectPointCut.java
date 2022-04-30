package com.example.final_project.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectPointCut {

    @Pointcut("execution(* com.example.final_project.dao.*.add*(..))")
    public void allAddMethods() {
        System.out.println("================================>");
    }

}
