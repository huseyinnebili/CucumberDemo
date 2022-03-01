package YouTubeDataAPI;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.startsWith;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilsAPIs.YouTubeDataAPI_Constants;
import utilsAPIs.YouTubeDataAPI_Global_Variables;

public class GET_Playlist {

	@Test

	public void get_Playlist() {

		RestAssured.baseURI = YouTubeDataAPI_Constants.BASE_URI;

		RestAssured.

				given().

				auth().oauth2(YouTubeDataAPI_Global_Variables.token).

				queryParam("part", YouTubeDataAPI_Global_Variables.PART).

				queryParam("channelId", YouTubeDataAPI_Global_Variables.CHANNELID_01).

				queryParam("key", YouTubeDataAPI_Global_Variables.API_KEY).

				when().

				get(YouTubeDataAPI_Constants.GET_PLAYLIST_ENDPOINT).prettyPeek().

				then().

				assertThat().statusCode(200).time(lessThan(5000L)).

				header("Content-Type", "application/json; charset=UTF-8").

				body("items[1].etag", equalToIgnoringCase("GrDXmq-X8yCsmNVz2-ZJmTnnOmY"))
				.body("items[1].id", equalToIgnoringCase("PLKWcPfZiScgCsMaLF5Nbn7FSja4n4lviC"))
				.body("pageInfo.totalResults", equalTo(14)).body("items[0].snippet.channelTitle", startsWith("Speak"))
				.body("items[0].snippet.channelTitle", endsWith("Vanessa"))
				.body("nextPageToken", containsString("CAUQAA"));

	}

	@Test

	public void get_Playlist_2() {

		RestAssured.baseURI = YouTubeDataAPI_Constants.BASE_URI;

		Response response = RestAssured.given().

				auth().oauth2(YouTubeDataAPI_Global_Variables.token)
				.queryParam("part", YouTubeDataAPI_Global_Variables.PART)
				.queryParam("channelId", YouTubeDataAPI_Global_Variables.CHANNELID_02)
				.queryParam("key", YouTubeDataAPI_Global_Variables.API_KEY).

				when().

				get(YouTubeDataAPI_Constants.GET_PLAYLIST_ENDPOINT).prettyPeek();

		response.then().assertThat().statusCode(200);
		
		response.then().assertThat().time(lessThan(5000L));
		
		response.then().assertThat().header("Server", "scaffolding on HTTPServer2");
		
		
		System.out.println("-----------------------------------------");
		String responseBody=response.getBody().jsonPath().get("items[2].snippet.channelTitle");
		System.out.println(responseBody);
		
		
		System.out.println("-----------------------------------");
		String responseBody_Description=response.getBody().jsonPath().get("items[0].snippet.localized.description");
		System.out.println(responseBody_Description);
		
		
		System.out.println("------------------------------------");
		boolean cookies=response.cookies().isEmpty();
		System.out.println(cookies);
		
		
		System.out.println("------------------------");
		String channel_Id=response.getBody().jsonPath().get("items[2].snippet.channelId");
		System.out.println(channel_Id);
		
		
		
		response.then().assertThat().body("items[0].snippet.title", equalToIgnoringCase("Learn Basic English Vocabulary"));
		
		response.then().assertThat().body("items[2].snippet.channelId", equalToIgnoringCase("UCeTVoczn9NOZA9blls3YgUg"));
		
		response.then().assertThat().body("items[2].snippet.title", containsString("Fun&Easy"));
		
		response.then().assertThat().body("items[2].snippet.channelTitle", startsWith("Learn English"));
		
		response.then().assertThat().body("items[3].snippet.title",endsWith("Reading Practice"));
		
		
		
		
		
		
		

	}

}
