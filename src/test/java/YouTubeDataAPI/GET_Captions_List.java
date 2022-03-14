package YouTubeDataAPI;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.lessThan;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilsYouTubeDataAPI.YouTubeDataAPI_Constants;
import utilsYouTubeDataAPI.YouTubeDataAPI_Global_Variables;

public class GET_Captions_List {

	@Test

	public void getCaptionsList() {

		RestAssured.baseURI = YouTubeDataAPI_Constants.BASE_URI;

		RestAssured.

				given().

				contentType("application/json").

				auth().oauth2(YouTubeDataAPI_Global_Variables.token).

				queryParam("part", YouTubeDataAPI_Global_Variables.PART).

				queryParam("videoId", YouTubeDataAPI_Global_Variables.videoId).

				when().

				get(YouTubeDataAPI_Constants.GET_CAPTIONS_LIST_ENDPOINT).prettyPeek().

				then().assertThat().statusCode(200).

				header("Content-Encoding", "gzip").

				time(lessThan(3000L)).

				body("items[0].snippet.audioTrackType", equalToIgnoringCase("unknown")).

				body("items[0].id", equalToIgnoringCase("AgKn68RBw25hQaAycNAswoR77D7oKva00dJu7dQ0TFs=")).

				body("items[0].snippet.videoId", containsString("KGqBsi4-RaY"));

	}

	@Test

	public void getCaptionsList_2() {

		
		RestAssured.baseURI=YouTubeDataAPI_Constants.BASE_URI;
		
	Response response=	RestAssured.
		
		given().
		
		contentType("application/json").
		
		auth().oauth2(YouTubeDataAPI_Global_Variables.token).
		
		queryParam("part", YouTubeDataAPI_Global_Variables.PART).
		
		queryParam("videoId", YouTubeDataAPI_Global_Variables.videoId).
		
		when().
		
		get(YouTubeDataAPI_Constants.GET_CAPTIONS_LIST_ENDPOINT).prettyPeek();
	
	
	response.then().assertThat().statusCode(200);
	
	response.then().assertThat().header("Server", "scaffolding on HTTPServer2");
	
	response.then().assertThat().time(lessThan(3000L));
	
	
	String video_Id=response.getBody().jsonPath().get("items[0].snippet.videoId");
	System.out.println("VideoId => "+video_Id);
	
	
	String id=response.getBody().jsonPath().get("items[0].id");
	System.out.println("Id => "+id);
	
	
	response.then().assertThat().body("items[0].kind",startsWith("you"));
	response.then().assertThat().body("items[0].kind", endsWith("caption"));
	response.then().assertThat().body("items[0].snippet.isEasyReader",equalTo(false));
	
	}
}