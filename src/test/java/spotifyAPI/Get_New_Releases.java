package spotifyAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_New_Releases {

	public static void main(String[] args) {


		RestAssured.baseURI="https://api.spotify.com";
		
		RequestSpecification request=RestAssured.given();
		
		Response response=request.when().get("/v1/browse/new-releases");
		
		System.out.println(response.getBody().asPrettyString());

	}

}
