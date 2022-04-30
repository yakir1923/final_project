package com.example.final_project;

import com.example.final_project.POCO.Adminstrator;
import com.example.final_project.POCO.Flights;
import com.example.final_project.POCO.UserRole;
import com.example.final_project.POCO.Users;
import com.example.final_project.dao.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.User;


@SpringBootApplication
public class FinalProjectApplication {

	public static void main(String[] args) {
		var context=SpringApplication.run(FinalProjectApplication.class, args);

		AdminstratorsConnection adminstratorsConnection=context.getBean(AdminstratorsConnection.class);
		AirlineCompanyConnection airlineCompanyConnection=context.getBean(AirlineCompanyConnection.class);
		CountryConnection countryConnection=context.getBean(CountryConnection.class);
		CustomerConnection customerConnection=context.getBean(CustomerConnection.class);
		FlightConnection flightConnection=context.getBean(FlightConnection.class);
		TicketConnection ticketConnection=context.getBean(TicketConnection.class);
		UserRoleConnection userRoleConnection=context.getBean(UserRoleConnection.class);
		UsersConnection usersConnection=context.getBean(UsersConnection.class);

	}

}
