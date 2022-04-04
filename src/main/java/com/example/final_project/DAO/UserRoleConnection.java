package com.example.final_project.DAO;

import com.example.final_project.POCO.UserRole;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRoleConnection implements DAO<UserRole>{
    public  static List<UserRole> userRoleList=new ArrayList<>();
    PGAConnection myConnection;
    UserRole userRole;

    public UserRoleConnection() {
    }

    @Override
    public UserRole get(int id) {
        try {
            myConnection=PGAConnection.getInstance();
            Statement stm = myConnection.connection.createStatement();
            var r=stm.executeQuery("SELECT * FROM public.\"User_Roles\" where \"Id\"="+id+";");
                r.next();
                userRole=new UserRole();
                userRole.id=r.getInt("Id");
                userRole.RoleName=r.getString("Role_Name");
                return userRole;

        }catch (Exception e){
            System.out.println(e.getMessage()+" from "+getClass().getName());
        }
        return new UserRole();
    }

    @Override
    public List<UserRole> getAll() {
        try {
            myConnection=PGAConnection.getInstance();
            Statement stm = myConnection.connection.createStatement();
            var r=stm.executeQuery("SELECT \"Id\", \"Role_Name\"\n" +
                    "\tFROM public.\"User_Roles\";");
            while (r.next()){
                userRole=new UserRole();
                userRole.id=r.getInt("Id");
                userRole.RoleName=r.getString("Role_Name");
                userRoleList.add(userRole);
            }
        }catch (Exception e){
            System.out.println(e.getMessage()+" from "+getClass().getName());
        }
        return userRoleList;
    }

    @Override
    public void add(UserRole userRole) {
        try {
            myConnection= PGAConnection.getInstance();
            Statement stm=myConnection.connection.createStatement();
            var r=stm.executeQuery("INSERT INTO public.\"User_Roles\"(\n" +
                    "\t\"Role_Name\")\n" +
                    "\tVALUES ('"+userRole.RoleName+"');");
            userRoleList.add(userRole);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void remove(UserRole userRole) {
        try {
            myConnection= PGAConnection.getInstance();
            Statement stm=myConnection.connection.createStatement();
            var r=stm.executeQuery("DELETE FROM public.\"User_Roles\"\n" +
                    "\tWHERE \"Id\"="+userRole.id+";");
            userRoleList.add(userRole);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(UserRole userRole) {
        try {
            myConnection= PGAConnection.getInstance();
            Statement stm=myConnection.connection.createStatement();
            var r=stm.executeUpdate("UPDATE public.\"User_Roles\"\n" +
                    "\tSET \"Id\"=" +userRole.id+
                    ", \"Role_Name\"='" +userRole.RoleName+
                    "'\tWHERE \"Id\"="+userRole.id+";");
            userRoleList.add(userRole);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
