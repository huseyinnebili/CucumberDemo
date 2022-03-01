package toolsqaBookAPI;

import org.junit.Test;

import io.restassured.RestAssured;
import utilsAPIs.ToolsQA_Global_Variables;
import utilsAPIs.ToolsQA_Constants;

import static org.hamcrest.Matchers.*;

public class GET_Account {

	@Test

	public void getAccount() {

		RestAssured.baseURI = ToolsQA_Constants.BASE_URI;

		RestAssured.

				given().

				// header("Authorization","Bearer"+APIGlobalVariables.token)
				auth().oauth2(ToolsQA_Global_Variables.token).pathParam("UUID", ToolsQA_Global_Variables.UUID).

				when().

				get(ToolsQA_Constants.GET_ACCOUNT_ENDPOINT).prettyPeek().

				then().

				assertThat().statusCode(200).and().

				assertThat().header("Content-Length", "83").and().

				assertThat().time(lessThan(3000L)).and().

				assertThat().body("userId", equalToIgnoringCase("ef320f9e-d8a1-4991-8c59-f647baec3c60")).and().

				assertThat().body("username", equalToIgnoringCase("Zlatan150"));

	}

}
