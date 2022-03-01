package empployeeAPIS;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;



public class POST_New_Employee_Record {

	
	@Test
	
	public void post_new_employee() {
		
		RestAssured.baseURI="http://dummy.restapiexample.com";
		
		RequestSpecification request=RestAssured.given();
		
		request.header("Content-Type", "application/json");
		
		String payload="{\r\n" + "\r\n" + "\"name\":\"huseyin\",\r\n" + 
				"\"salary\":\"123000\",\r\n" + "\"age\":\"23\"\r\n" + "\r\n" + "}";
		
		request.body(payload);
		
		Response response=request.when().post("/api/v1/create");
		
		System.out.println("The response code => "+response.getStatusCode());
		
		System.out.println("The response of the response body => "+response.getBody().asPrettyString());
		
		System.out.println("The response of the headers => "+response.getHeaders());
		
		response.then().assertThat().statusCode(200);
		
		String responseHeader=response.getHeaders().toString();
		boolean contain=responseHeader.contains("Content-Type");
		Assert.assertTrue(contain);
		
		response.then().assertThat().header("Content-Type", "application/json");
		
		response.then().assertThat().header("Display", "staticcontent_sol");
		
		response.then().assertThat().time(lessThan(3000L));
		
		response.then().assertThat().body("data.name",equalToIgnoringCase("huseyin"));
		
		response.then().assertThat().body("status", equalToIgnoringCase("success"));
		
		response.then().assertThat().body("message",startsWith("Successfully!"));
		
		response.then().assertThat().body("message",endsWith("added."));
		
	}
}
