package toolsqaBookAPI;

import static org.hamcrest.Matchers.*;
import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilsAPIs.ToolsQA_Constants;

public class POST_Account_User {

	// Long way

	//@Test

	public void creatUserTest_1() {

		RestAssured.baseURI = ToolsQA_Constants.BASE_URI;

		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");

		request.body(ToolsQA_Constants.POST_ACCOUNT_USER_PAYLOAD_1);

		Response response = request.when().post(ToolsQA_Constants.POST_ACCOUNT_USER_ENDPOINT);

		System.out.println(response.body().asPrettyString());

		System.out.println(response.getHeaders());

		System.out.println("The status code => " + response.statusCode());

		response.then().assertThat().statusCode(201);

		response.then().assertThat().body("username", startsWith("Zlatan"));

		response.then().assertThat().header("Content-Type", "application/json; charset=utf-8");

		String text = response.getBody().asString();
		boolean contain = text.contains("userID");
		Assert.assertTrue(contain);

	}

	// Short way_1

	//@Test

	public void creatUserTest_2() {

		RestAssured.baseURI = ToolsQA_Constants.BASE_URI;

		// The first way
		Response response = RestAssured.

				given().

				header("Content-Type", "application/json").body(ToolsQA_Constants.POST_ACCOUNT_USER_PAYLOAD_2).

				when().

				post(ToolsQA_Constants.POST_ACCOUNT_USER_ENDPOINT).prettyPeek();

		response.then().assertThat().statusCode(201);

		String responseBody = response.getBody().asString();
		boolean contain = responseBody.contains("userID");
		Assert.assertTrue(contain);

		Assert.assertTrue("books", true);

		String user_ID = response.getBody().jsonPath().getString("userID");
		System.out.println("The userID => " + user_ID);

	}

	// Short way_2

	@Test

	public void creatUserTest_3() {

		RestAssured.baseURI = ToolsQA_Constants.BASE_URI;

		RestAssured.

				given().

				header("Content-Type", "application/json").body(ToolsQA_Constants.POST_ACCOUNT_USER_PAYLOAD_3).

				when().

				post(ToolsQA_Constants.POST_ACCOUNT_USER_ENDPOINT).prettyPeek().

				then().

				assertThat().statusCode(201).and().

				assertThat().headers("Content-Type", "application/json; charset=utf-8").and().

				assertThat().time(lessThan(3000L)).and().

				assertThat().body("username", equalToIgnoringCase("Zlatan150"));

		Assert.assertTrue("books", true);

	}

}
