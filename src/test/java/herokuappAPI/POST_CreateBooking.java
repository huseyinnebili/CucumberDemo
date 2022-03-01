package herokuappAPI;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POST_CreateBooking {
	
	@Test
	
	public void createBooking() {
		
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		
		RequestSpecification request=RestAssured.given();
		
		request.header("Content-Type", "application/json");
		
		String payload="{\r\n" + 
				"    \"firstname\" : \"Huseyin\",\r\n" + 
				"    \"lastname\" : \"Nebil\",\r\n" + 
				"    \"totalprice\" : 112,\r\n" + 
				"    \"depositpaid\" : true,\r\n" + 
				"    \"bookingdates\" : {\r\n" + 
				"        \"checkin\" : \"2018-01-01\",\r\n" + 
				"        \"checkout\" : \"2019-01-01\"\r\n" + 
				"    },\r\n" + 
				"    \"additionalneeds\" : \"Breakfast\"\r\n" + 
				"}";
		
		request.body(payload);
		
		Response response=request.when().post("/booking");
		
		System.out.println("The status code => "+response.statusCode());
		
		System.out.println("The response of the response body => "+response.getBody().asPrettyString());
		
		System.out.println("The rsponse of the headers => "+response.getHeaders());

		
		
	}

}
