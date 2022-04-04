package com.example.final_project.DAO;



import com.example.final_project.POCO.Adminstrator;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminstratorsConnection implements DAO<Adminstrator>{
    public PGAConnection myConnection;
    public static List<Adminstrator> list=new ArrayList<>();
    public AdminstratorsConnection() {

    }


    @Override
    public Adminstrator get(int id) {
        try {
            myConnection= PGAConnection.getInstance();
            Statement stm=myConnection.connection.createStatement();
            var r=stm.executeQuery("SELECT * FROM \"Administrator\" WHERE \"Id\"="+id+"");
                 r.next();
                Adminstrator adminstrator=new Adminstrator();
                adminstrator.id=r.getInt("Id");
                adminstrator.firstName=r.getString("First_Name");
                adminstrator.lastName=r.getString("Last_Name");
                adminstrator.userId=r.getInt("User_Id");
                return adminstrator;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new Adminstrator();
    }

    @Override
    public List<Adminstrator> getAll() {
        try {
            myConnection= PGAConnection.getInstance();
            Statement stm=myConnection.connection.createStatement();
            var r=stm.executeQuery("SELECT * FROM \"Administrator\"");
            while (r.next()){
                Adminstrator adminstrator=new Adminstrator();
                adminstrator.id=r.getInt("Id");
                adminstrator.firstName=r.getString("First_Name");
                adminstrator.lastName=r.getString("Last_Name");
                adminstrator.userId=r.getInt("User_Id");
                list.add(adminstrator);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void add(Adminstrator adminstrator) {
        try {
            myConnection= PGAConnection.getInstance();
            Statement stm=myConnection.connection.createStatement();
            var r=stm.executeQuery("insert into \"Administrator\"(\"First_Name\",\"Last_Name\",\"User_Id\")" +
                    "values('"+adminstrator.firstName+"','"+
                    adminstrator.lastName+"','"+
                    adminstrator.userId+"')");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void remove(Adminstrator adminstrator) {
        try {

            myConnection= PGAConnection.getInstance();
            Statement stm=myConnection.connection.createStatement();
            var r=stm.executeQuery("DELETE FROM \"Administrator\" WHERE \"Id\"="+adminstrator.id+";");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Adminstrator adminstrator) {
        try {
            myConnection= PGAConnection.getInstance();
            Statement stm=myConnection.connection.createStatement();
            var r=stm.executeUpdate("UPDATE \"Administrator\"" +
                    " SET \"First_Name\"='"+adminstrator.firstName+
                    "',\"Last_Name\"='"+adminstrator.lastName+ "'," +
                    "\"User_Id\"='"+adminstrator.userId +
                    "' WHERE \"Id\"="+adminstrator.id);
            list.remove(adminstrator.id);
            list.add(adminstrator);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
