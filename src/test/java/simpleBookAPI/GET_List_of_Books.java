package simpleBookAPI;

import org.junit.Assert;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

public class GET_List_of_Books {

	@Test

	public void verify_of_list_of_Books() {

		RestAssured.baseURI = "https://simple-books-api.glitch.me";

		RequestSpecification getListOfBooks = RestAssured.given();

		Response response = getListOfBooks.when().get("/books");

		System.out.println("The status code is " + (response.getStatusCode()));

		System.out.println("The response body : " + response.getBody().asPrettyString());

		System.out.println("The response time is " + response.getTime());

		System.out.println("The headers body returned : " + response.getHeaders());

		System.out.println("The cookies returned : " + response.getCookies());

		
		// The first way to verify the status code
		response.then().assertThat().statusCode(200);

		// The second way to verify the status code
		int actual_status_code = response.getStatusCode();
		Assert.assertEquals(200, actual_status_code);

		
		
		// The first way to verify 'Connection' on the headers
		response.then().assertThat().header("Connection", "keep-alive");

		// The second way to verify 'Connection' on the headers
		String actual_connection_text = response.getHeader("Connection");
		Assert.assertEquals("keep-alive", actual_connection_text);
		
		
		
		// The first way to verify if the body contains a text
		String responseBody=response.getBody().asString();
		boolean contains=responseBody.contains("Viscount Who Loved Me");
		Assert.assertTrue(contains);
		
		// The first way to verify if the body contains a text
		Assert.assertTrue("Viscount Who Loved Me", true);
		
		
		//To verify the responses on the responseBody through hamcrest.Matchers. String assertions
        response.then().assertThat().body("[1].name",  containsString("Just as I Am"));
        response.then().assertThat().body("[1].name", startsWith("Just"));
        response.then().assertThat().body("[1].name", endsWith("I Am"));
        response.then().assertThat().body("[1].name", equalToIgnoringCase("Just as I Am"));
        response.then().assertThat().body("id", hasItems(1,2,3,4,5,6));
        response.then().assertThat().body("[3].name", startsWith("The Midnight"),"[1].type",not(equalToIgnoringCase("fiction")));
        
        response.then().assertThat().time(lessThan(1500L));
	}

}
