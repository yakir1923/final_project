package com.example.final_project.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class MySecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT \"UserName\", \"Password\",\"enabled\" from \"Users\" where \"UserName\"=?")
                .authoritiesByUsernameQuery("SELECT \"Users\".\"UserName\", \"User_Roles\".\"Role_Name\" from \"Users\" inner join \"User_Roles\" ON \"Users\".\"User_Role\" = \"User_Roles\".\"Id\" WHERE \"Users\".\"UserName\"=?")
                .rolePrefix("ROLE_");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests().
                antMatchers("/admin/**").hasRole("Administrator")
                .antMatchers("/airline/**").hasAnyRole("Administrator", "Airline_Companie")
                .antMatchers("/customer/**").hasAnyRole("Administrator", "Customers")
                .antMatchers("/").permitAll()
                .and().formLogin();
    }

}
