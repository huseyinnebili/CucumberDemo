package empployeeAPIS;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class GET_Single_Employee {

	
	@Test
	
	public  void getSingleEmployeeData() {
		
		RestAssured.baseURI="http://dummy.restapiexample.com";
		
		RequestSpecification request=RestAssured.given();
		
		Response response=request.when().get("/api/v1/employee/12");
		
		System.out.println("The response body : "+response.getBody().asPrettyString());
		
		System.out.println("The response of the headers :"+response.getHeaders());
		
		
		// The first way to verify the status code
		response.then().assertThat().statusCode(200);
		
		// The second way to verify the status code
		int actual_status_code=response.getStatusCode();
		Assert.assertEquals(200, actual_status_code);
		
		
		
		// The first way to verify 'Content-Length' on the header
		String content_length=response.getHeader("Content-Length");
		Assert.assertEquals(content_length,"180");
		
		// The first way to verify 'Content-Length' on the header
		response.then().assertThat().header("Content-Length", "180");
		
		
		// The first way to verify if the body contains a text
		Assert.assertTrue("employee_name", true);
		
		// The second way to verify if the body contains a text
		String responseBody=response.getBody().asString();
		boolean contain=responseBody.contains("profile_image");
		Assert.assertTrue(contain);
	
		
		response.then().assertThat().body("data.employee_name", startsWith("Quinn"));
		response.then().assertThat().body("data.employee_name", endsWith("Flynn"));
		response.then().assertThat().body("data.employee_age", equalTo(22));
		response.then().assertThat().body("message", containsString("Successfully!"));
		response.then().assertThat().body("data", hasEntry("id", 12));
		
		response.then().assertThat().time(lessThan(3000L));
		
	}
}
