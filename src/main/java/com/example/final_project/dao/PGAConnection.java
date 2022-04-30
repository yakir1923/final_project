package com.example.final_project.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class PGAConnection {
   private static PGAConnection myConnection;
   public Connection connection=null;
    MyUser myUser;

    private PGAConnection() {
        myUser=new MyUser();
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(myUser.getUrl(), myUser.getUserName(), myUser.getPassword());
        }catch (Exception e){
            System.out.println(e.getMessage()+" from MyConnection");
        }
    }
    public static PGAConnection getInstance(){
        if (myConnection==null) {
            myConnection = new PGAConnection();
            return myConnection;
        }else {
            return myConnection;
        }
    }
}
