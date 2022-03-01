package toolsqaBookAPI;

import org.junit.Assert;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

public class GET_AllBooks {

	@Test
	public void verifyAllBooksRequest() {

		RestAssured.baseURI = "https://bookstore.toolsqa.com";

		System.out.println(RestAssured.baseURI);

		// We are building a request
		RequestSpecification getAllBooksRequest = RestAssured.given();

		// Now we are making an actual request to the server and getting a response
		Response response = getAllBooksRequest.when().get("/BookStore/v1/Books");

		// Another way to make a request
		getAllBooksRequest.when().request(Method.GET, "/BookStore/v1/Books");

		System.out.println("============== Check status code through response ==================");

		// We are getting the information from the response object
		System.out.println("The status code is " + response.getStatusCode());

		System.out.println("The second way to get status code from response object = " + response.statusCode());

		System.out.println("The body of the request = " + response.getBody().asPrettyString());

		System.out.println("To get all headers = " + response.getHeaders());

		System.out.println("To get a specific header = " + response.getHeader("Connection"));

		System.out.println("Verify that response status code is 200");

		
		// The first way to verify status code
		response.then().assertThat().statusCode(200);

		// The second way to verify status code
		int actual_status_code = response.getStatusCode();
		Assert.assertEquals(200, actual_status_code);

		
		System.out.println("Verify tha a response on the headers returned");

		
		// The first way to verify 'content-length- header
		System.out.println("Verify headers info");
		response.then().assertThat().header("Content-Length", "4514");

		// The second way to verify 'content-length- header
		String actual_content_length = response.getHeader("Content-Length");
		Assert.assertEquals("4514", actual_content_length);

		
		System.out.println("Verify that a response on the response body returned");

		
		// The first way to verify if the body contains a text
		String responseBody = response.getBody().asString();
		boolean contains = responseBody.contains("Nicholas C. Zakas");
		Assert.assertTrue(contains);

		// The second way to verify if the body contains a text
		Assert.assertTrue("Nicholas C. Zakas", true);

		
		//To verify the responses on the responseBody through hamcrest.Matchers. String assertions
		
		response.then().assertThat().body("books[2].isbn", equalToIgnoringCase("9781449337711"));
		response.then().assertThat().body("books[2].subTitle", equalToIgnoringCase("Harnessing the Power of the Web"));
		response.then().assertThat().body("books[5].title", startsWith("Programming"));
		response.then().assertThat().body("books[7].publisher", endsWith("Press"));
		response.then().assertThat().body("books[6].subTitle",containsString("Introduction"),"books[7].isbn",not(equalTo("9781593277575")));
		response.then().assertThat().body("books.pages",hasItems(234, 254, 238, 460, 278, 254, 472, 352));
		response.then().assertThat().body("books[0]", hasEntry("pages", 234));
		
		response.then().assertThat().time(lessThan(2000L));
	}

	
	}

