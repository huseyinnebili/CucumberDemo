package utilsAPIs;

public class GitHub_Constants {

	public static final String BASE_URI = "https://api.github.com";

	public static final String POST_CREATE_REPO_ENDPOINT = "/user/repos";

	public static final String POST_CREATE_REPO_PAYLOAD = "{\r\n" + "  \"name\": \"MyFirstRepo_4\"\r\n" + "}";
	
	public static final String DELETE_REPO_ENDPOINT = "/repos/{owner}/{repo}";
	
	public static final String GET_REPO_ENDPOINT = "/repos/{owner}/{repo}";

}
