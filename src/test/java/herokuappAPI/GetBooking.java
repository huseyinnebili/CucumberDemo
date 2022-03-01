package herokuappAPI;

import org.junit.Assert;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

public class GetBooking {

	@Test
	public void getBooking() {

		RestAssured.baseURI = "https://restful-booker.herokuapp.com/";

		RequestSpecification request = RestAssured.given();

		Response response = request.when().get("/booking/2");

		System.out.println("The response body : " + response.getBody().asPrettyString());

		System.out.println("The response of the headers : " + response.getHeaders());

		System.out.println("The status code is " + response.statusCode());

		System.out.println("The response time is " + response.getTime());

		// The first way to verify status code
		response.then().assertThat().statusCode(200);
		
		// The second way to verify status code
		int actual_status_code=response.statusCode();
		Assert.assertEquals(200, actual_status_code);

		
		// The first way to verify if the body contains a text
		Assert.assertTrue("totalprice",true);
		
		// The second way to verify if the body contains a text
		String responseBody=response.getBody().asString();
		boolean contain=responseBody.contains("lastname");
		Assert.assertTrue(contain);
		
		boolean contain_2=responseBody.contains("checkout");
		Assert.assertTrue(contain_2);
		
		// The first way to verify 'content-length- header
		response.then().assertThat().header("content-type", "application/json; charset=utf-8");
		
		// The second way to verify 'content-length- header
		String actual_text=response.header("content-type");
		Assert.assertEquals("application/json; charset=utf-8", actual_text);
		
		
		String actual_text_2=response.header("Connection");
		Assert.assertEquals("keep-alive", actual_text_2);
		
		
		response.then().assertThat().body("firstname", containsString("Eric"));
		response.then().assertThat().body("totalprice", equalTo(699));
		response.then().assertThat().body("bookingdates.checkin", equalToIgnoringCase("2015-08-31"));
		response.then().assertThat().body("bookingdates", hasEntry("checkin", "2015-08-31"));
		

		response.then().assertThat().time(lessThan(2000L));
		
		
		
		
		
		
	}
}
