package com.example.final_project.DAO;



import com.example.final_project.POCO.Users;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersConnection implements DAO<Users>{

    PGAConnection myConnection;

    public UsersConnection() {
    }

    @Override
    public Users get(int id) {
        try {
            myConnection= PGAConnection.getInstance();
            Statement stm=myConnection.connection.createStatement();
            var r=stm.executeQuery("SELECT * FROM \"Users\" WHERE \"Id\"="+id+"");
            r.next();
            Users user=new Users();
            user.userName=r.getString("UserName");
            user.password=r.getString("Password");
            user.email=r.getString("Email");
            user.userRole =r.getInt("User_Role");
            user.id=r.getInt("Id");
            return user;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new Users();
    }

    @Override
    public List<Users> getAll() {
        List<Users>usersList=new ArrayList<>();
        try {
            myConnection= PGAConnection.getInstance();
            Statement stm=myConnection.connection.createStatement();
            var r=stm.executeQuery("SELECT * FROM \"Users\"");
          while( r.next()) {
              Users user = new Users();
              user.userName = r.getString("UserName");
              user.password = r.getString("Password");
              user.email = r.getString("Email");
              user.userRole = r.getInt("User_Role");
              user.id = r.getInt("Id");
              usersList.add(user);
          }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return usersList;
    }

    @Override
    public void add(Users user) {
        try {
            myConnection= PGAConnection.getInstance();
            Statement stm=myConnection.connection.createStatement();
            var r=stm.executeUpdate("INSERT INTO \"Users\"(" +
                    " \"UserName\", \"Password\", \"Email\", \"User_Role\")" +
                    "VALUES ('" +user.userName+
                    "', '" +user.password+
                    "', '" +user.email+
                    "'," + user.userRole +
                    ");");
            }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void remove(Users users) {
        try {
            myConnection= PGAConnection.getInstance();
            Statement stm=myConnection.connection.createStatement();
            var r=stm.executeQuery("DELETE FROM public.\"Users\"\n" +
                    "\tWHERE \"Id\"="+users.id+";");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Users user) {
        try {
            myConnection= PGAConnection.getInstance();
            Statement stm=myConnection.connection.createStatement();
            var r=stm.executeUpdate("UPDATE public.\"Users\"\n" +
                    "\tSET \"Id\"='" + user.id+
                    "', \"UserName\"='" +user.userName+
                    "', \"Password\"='" +user.password+
                    "', \"Email\"='" +user.email+
                    "', \"User_Role\"=' " +user.userRole +
                    "'\tWHERE \"Id\"="+user.id+";");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public  Users get_user_by_username_and_password(String userName,String password){
        try {
            myConnection = PGAConnection.getInstance();
            Statement stm = myConnection.connection.createStatement();
            var r=stm.executeQuery("SELECT * FROM get_user_by_username('"+userName+"')");
            r.next();
            Users user=new Users();
            user.userName=r.getString("UserName");
            user.password=r.getString("Password");
            user.email=r.getString("Email");
            user.userRole =r.getInt("User_Role");
            user.id=r.getInt("Id");
            return user;
        }catch (Exception e){
            System.out.println(e.getMessage()+" from "+getClass().getName());
        }
        return new Users();
    }

}
