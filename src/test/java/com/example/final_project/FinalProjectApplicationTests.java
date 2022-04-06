package com.example.final_project;

import com.example.final_project.Facade.AdministratorFacade;
import com.example.final_project.Facade.AirlineFacade;
import com.example.final_project.Facade.AnonymousFacade;
import com.example.final_project.Facade.CustomerFacade;
import com.example.final_project.POCO.AirlineCompanies;
import com.example.final_project.POCO.Countries;
import com.example.final_project.POCO.Customers;
import com.example.final_project.POCO.Flights;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Timestamp;

@SpringBootTest
class FinalProjectApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	void checkAnonymous(){
		AnonymousFacade anonymousFacade=new AnonymousFacade();
		HttpClient client=HttpClient.newHttpClient();
		HttpRequest request=HttpRequest
				.newBuilder(URI.create("http://localhost:8080/get_flight_by_id/5"))
				.build();

		HttpResponse<String> response=null;
		try{
			response=client.send(request,HttpResponse.BodyHandlers.ofString());
		}catch (Exception e){
			System.out.println(e.getMessage()+" from checkAnonymous test");
		}

		GsonBuilder builder=new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson=builder.create();

		var expected=gson.fromJson(response.body(), Flights.class);
//		var current=new Flights(5,1,1,2,
//				Timestamp.valueOf("2020-07-23 12:00:00"),
//				Timestamp.valueOf("2020-07-24 15:00:00"),150);
		var current=anonymousFacade.get_flight_by_id(5);
		Assert.assertEquals(current,expected);
	}

	@Test
	void checkAdmin(){
		AdministratorFacade administratorFacade=new AdministratorFacade();
		var current=administratorFacade.get_airline_by_id(2);
		HttpClient client=HttpClient.newHttpClient();
		HttpRequest request=HttpRequest
				.newBuilder(URI.create("http://localhost:8080/admin/get_airline_by_id/2"))
				.build();
		HttpResponse<String> response=null;
		try{
			response=client.send(request,HttpResponse.BodyHandlers.ofString());
		}catch (Exception e){
			System.out.println(e.getMessage()+" from admin test");
		}
		GsonBuilder builder=new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson=builder.create();

		var expected=gson.fromJson(response.body(), AirlineCompanies.class);
		Assert.assertEquals(current,expected);


	}


	@Test
	void checkCustomer(){
		CustomerFacade customerFacade=new CustomerFacade();
		var current=customerFacade.get_country_by_id(1);
		HttpClient client=HttpClient.newHttpClient();
		HttpRequest request=HttpRequest
				.newBuilder(URI.create("http://localhost:8080/Customer/get_country_by_id/1"))
				.build();
		HttpResponse<String> response=null;
		try {
			response=client.send(request,HttpResponse.BodyHandlers.ofString());
		}catch (Exception e){
			System.out.println(e.getMessage()+" from customer test");
		}
		GsonBuilder builder=new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson=builder.create();

		var expected=gson.fromJson(response.body(), Countries.class);
		Assert.assertEquals(current,expected);

	}



	@Test
	void checkAirline(){
		AirlineFacade airlineFacade=new AirlineFacade();
		var current =airlineFacade.get_airline_by_id(1);
		HttpClient client=HttpClient.newHttpClient();
		HttpRequest request=HttpRequest
				.newBuilder(URI.create("http://localhost:8080/get_airline_by_id/1"))
				.build();
		HttpResponse<String> response=null;
		try {
			response=client.send(request,HttpResponse.BodyHandlers.ofString());
		}catch (Exception e){
			System.out.println(e.getMessage()+" from airline test");
		}

		GsonBuilder builder=new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson=builder.create();

		var expected=gson.fromJson(response.body(),AirlineCompanies.class);
		Assert.assertEquals(current,expected);
	}

}
