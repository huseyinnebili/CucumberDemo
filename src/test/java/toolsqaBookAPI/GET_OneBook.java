package toolsqaBookAPI;

import org.junit.Assert;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

public class GET_OneBook {

	@Test

	public void getOneBookTest() {

		RestAssured.baseURI = "https://bookstore.toolsqa.com";

		RequestSpecification request = RestAssured.given();

		request.queryParam("ISBN", "9781449337711");

		Response response = request.when().get("/BookStore/v1/Book");

		// System.out.println("The response on the response body returned :
		// "+response.body().asPrettyString());
		System.out.println("The response on the response body returned : " + response.prettyPrint());

		System.out.println("The response on the headers returned : " + response.getHeaders());

		// The first way to verify status code
		int actual_status_code = response.getStatusCode();
		Assert.assertEquals(200, actual_status_code);

		// The second way to verify status code
		response.then().assertThat().statusCode(200);

		// The first way to verify if the body contains a text
		Assert.assertTrue("Harnessing the Power of the Web", true);

		// The second way to verify if the body contains a text
		String responseBody = response.getBody().asString();
		boolean contains = responseBody.contains("Harnessing the Power of the Web");
		Assert.assertTrue(contains);
       
		//To verify the responses on the responseBody through hamcrest.Matchers. String assertions
		response.then().assertThat().body("subTitle", equalToIgnoringCase("Harnessing the Power of the Web"));
		response.then().assertThat().body("publisher", containsString("Reilly Media"));
		response.then().assertThat().body("author",startsWith("Gle"));
		response.then().assertThat().body("title", endsWith("NET"));
		response.then().assertThat().body("isbn",equalToIgnoringCase("9781449337711"),"title", endsWith("NET"));
		response.then().assertThat().body("subTitle", not(equalToIgnoringCase("Harnessing the Power of the Wb")));
		
		

		// The first way to verify 'content-length- header
		response.then().assertThat().header("Content-Length", "585");

		// The second way to verify 'content-length- header
		String content_length = response.getHeader("Content-Length");
		Assert.assertEquals("585", content_length);
		
		
		response.then().assertThat().time(lessThan(2000L));

	}

	}


