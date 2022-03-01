package simpleBookAPI;

import org.junit.Assert;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;



public class GET_Single_Book {
	
	@Test
	
	public  void getSingleBook() {
		
		
		RestAssured.baseURI="https://simple-books-api.glitch.me";
		
		RequestSpecification request =RestAssured.given();
		
		request.pathParam("bookId","3");
		
		Response response =request.when().get("/books/{bookId}");
		
		System.out.println("Responses returned from response body : "+response.getBody().asPrettyString());
		
		System.out.println("Responses returned from headers : "+response.getHeaders());
		
		response.then().assertThat().statusCode(200);
		
		response.then().assertThat().headers("Content-Type","application/json; charset=utf-8");
		
		
		String text=response.getBody().asPrettyString();
		boolean contain=text.contains("type");
		Assert.assertTrue(contain);
		
		response.then().assertThat().body("author", containsString("Brit Bennett"));
		response.then().assertThat().body("current-stock",equalTo(987));
		response.then().assertThat().body("price", equalTo(16.2F));
		response.then().assertThat().body("name", startsWith("The"));
		response.then().assertThat().body("name",endsWith("Half"));
		
		
		response.then().assertThat().time(lessThan(2500L));
		
		
	}
	

}
