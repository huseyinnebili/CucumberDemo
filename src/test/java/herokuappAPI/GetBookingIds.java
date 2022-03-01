package herokuappAPI;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;



public class GetBookingIds {
	
	@Test
	
	public void getBookingIds() {
		
		RestAssured.baseURI="https://restful-booker.herokuapp.com/";
		
		RequestSpecification request=RestAssured.given();
		
		Response response=request.when().get("booking");
		
		System.out.println("The status code is "+response.statusCode());
		
		System.out.println("The response body : "+response.getBody().asPrettyString());
		
		System.out.println("The response on the headers : "+response.getHeaders());
		
		System.out.println("The response time is "+response.getTime());
		
		
		response.then().assertThat().statusCode(200);
		
		Assert.assertEquals(200, response.getStatusCode());
		
		// The first way to verify 'contentType- header
		response.then().assertThat().contentType("application/json; charset=utf-8");
		
		
		// The second way to verify 'contentType- header
		String contentType=response.getHeader("content-Type");
		Assert.assertEquals("application/json; charset=utf-8", contentType);
		
		
		response.then().assertThat().header("X-Powered-By", "Express");
		
		String  X_Powered_By=response.getHeader("X-Powered-By");
		Assert.assertEquals("Express", X_Powered_By);
		
		
		response.then().assertThat().header("Via", "1.1 vegur");
		
		String Via=response.getHeader("Via");
		Assert.assertEquals("1.1 vegur",Via );
		
        
		String responseBody=response.getBody().asString();
		boolean contain=responseBody.contains("bookingid");
		Assert.assertTrue(contain);
		
		
		response.then().assertThat().body("bookingid", hasItems(9,13,7));
		response.then().assertThat().body("[0].bookingid", equalTo(19));
		
		
		response.then().assertThat().time(lessThan(2000L));
		
		
	}

}
