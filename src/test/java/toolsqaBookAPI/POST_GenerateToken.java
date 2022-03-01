package toolsqaBookAPI;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.startsWith;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilsAPIs.ToolsQA_Constants;

public class POST_GenerateToken {

	// Short way_1

	//@Test

	public void generateToken_1() {

		RestAssured.baseURI = ToolsQA_Constants.BASE_URI;

		RestAssured.

				given().

				contentType("application/json").body(ToolsQA_Constants.GENERATE_TOKEN_PAYLOAD).

				when().

				post(ToolsQA_Constants.GENERATE_TOKEN_ENDPOINT).prettyPeek().

				then().

				assertThat().statusCode(200).and().

				assertThat().header("Server", "nginx/1.17.10 (Ubuntu)").and().

				assertThat().time(lessThan(3000L)).and().

				assertThat().body("status", equalToIgnoringCase("Success")).and().

				assertThat().body("result", startsWith("User")).and().

				assertThat().body("result", endsWith("successfully.")).and().

				assertThat().body("result", containsString("authorized"));

	}

	// Short way_2

	@Test

	public void generateToken_2() {

		RestAssured.baseURI = ToolsQA_Constants.BASE_URI;

		Response response = RestAssured.

				given().

				contentType("application/json").body(ToolsQA_Constants.GENERATE_TOKEN_PAYLOAD).

				when().

				post(ToolsQA_Constants.GENERATE_TOKEN_ENDPOINT).prettyPeek();

		String tokenFromResponseBody = response.getBody().jsonPath().get("token");

		System.out.println("Token from response body => " + tokenFromResponseBody);

		response.then().assertThat().statusCode(200);

		response.then().assertThat().time(lessThan(3000L));

		response.then().assertThat().body("result", equalToIgnoringCase("User authorized successfully."));

		response.then().assertThat().header("Connection", "keep-alive");

		response.then().assertThat().header("X-Powered-By", "Express");
		
		System.out.println("The status line => "+response.getStatusLine());

	}

}
