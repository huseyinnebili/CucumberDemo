package simpleBookAPI;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

public class GET_Api_Status {

	@Test

	public void verifiy_Api_Status() {

		RestAssured.baseURI = "https://simple-books-api.glitch.me";

		RequestSpecification get_api_Status = RestAssured.given();

		Response response = get_api_Status.when().get("/status");

		System.out.println("===== Response Body Returned ========");

		System.out.println(response.getBody().asPrettyString());

		System.out.println("Contente-Type = " + response.contentType());

		System.out.println("Status code is " + response.getStatusCode());

		System.out.println("Response time is " + response.time());

		System.out.println("======= All Headers Returned ============");
		System.out.println(response.getHeaders());

		
		// The first way to verify the status code
		response.then().assertThat().statusCode(200);

		// The second way to verify the status code
		int actual_status_code = response.getStatusCode();
		Assert.assertEquals(200, actual_status_code);

		
		
		// The first way to verify 'Content-Type' on the header
		response.then().assertThat().header("Content-Type", "application/json; charset=utf-8");

		// The second way to verify 'Content-Type' on the header
		String actual_content_type_text = response.getHeader("Content-Type");
		Assert.assertEquals("application/json; charset=utf-8", actual_content_type_text);

		
		
		// The first way to verify if the body contains a text
		String responseBody=response.getBody().asString();
		boolean contains=responseBody.contains("status");
		Assert.assertTrue(contains);
		
		// The first way to verify if the body contains a text
		Assert.assertTrue("status", true);
		
		//To verify the responses on the responseBody through hamcrest.Matchers. String assertions
		
		response.then().assertThat().body("status", containsString("OK"));
		response.then().assertThat().body("status", startsWith("OK"));
		response.then().assertThat().body("status",endsWith("OK"));
		response.then().assertThat().body("status", equalToIgnoringCase("OK"));
		
		response.then().assertThat().time(lessThan(2000L));
		
	}

}
