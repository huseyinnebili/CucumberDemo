package githubAPI;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.startsWith;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilsAPIs.GitHub_Constants;
import utilsAPIs.GitHub_Global_Variables;

public class Post_Create_Get_And_Delete_Repo {

	@Test

	public void create_Repo() {

		System.out.println("============= Print out create_Repo =========== ");

		RestAssured.baseURI = GitHub_Constants.BASE_URI;

		Response response = RestAssured.

				given().

				contentType("application/json").

				auth().oauth2(GitHub_Global_Variables.token).

				body(GitHub_Constants.POST_CREATE_REPO_PAYLOAD).

				when().

				post(GitHub_Constants.POST_CREATE_REPO_ENDPOINT).prettyPeek();

		response.then().assertThat().statusCode(201).time(lessThan(3000L)).

				header("Content-Type", "application/json; charset=utf-8").

				body("name", equalToIgnoringCase("MyFirstRepo_4")).

				body("visibility", containsString("public"));

		String repo_name = response.getBody().jsonPath().get("name");
		Assert.assertEquals(repo_name, "MyFirstRepo_4");

		String full_name = response.getBody().jsonPath().get("full_name");
		Assert.assertEquals(full_name, "huseyinnebili/MyFirstRepo_4");

	}

	@Test

	public void getRepo() {

		System.out.println("============= Print out getRepo =========== ");

		RestAssured.baseURI = GitHub_Constants.BASE_URI;

		Response response = RestAssured.

				given().

				pathParam("owner", GitHub_Global_Variables.owner).

				pathParam("repo", "MyFirstRepo_4").

				when().

				get(GitHub_Constants.GET_REPO_ENDPOINT).prettyPeek();

		       
		       response.then().

				assertThat().statusCode(200).time(lessThan(3000L)).

				header("X-Frame-Options", "deny").

				body("owner.login", equalToIgnoringCase("huseyinnebili")).

				body("full_name", startsWith("huseyinnebili"));
		       
		       String private_text=response.getBody().jsonPath().getString("private");
		       
		       Assert.assertEquals(private_text, "false");

				

	}

	@Test

	public void delete_Repo() {

		System.out.println("============= Print out delete_Repo =========== ");

		RestAssured.baseURI = GitHub_Constants.BASE_URI;

		RestAssured.

				given().

				auth().oauth2(GitHub_Global_Variables.token).

				pathParam("owner", GitHub_Global_Variables.owner).

				pathParam("repo", "MyFirstRepo_4").

				when().

				delete(GitHub_Constants.DELETE_REPO_ENDPOINT).prettyPeek().

				then().

				assertThat().statusCode(204).

				time(lessThan(3000L)).

				header("X-Content-Type-Options", "nosniff");
	}

}
