package utilsAPIs;

public class ToolsQA_Constants {
	
	public static final String BASE_URI="https://bookstore.toolsqa.com";
	
	public static final String POST_ACCOUNT_USER_ENDPOINT="/Account/v1/User";
	
	public static final String GENERATE_TOKEN_ENDPOINT="/Account/v1/GenerateToken";
	
	public static final String GET_ACCOUNT_ENDPOINT="/Account/v1/User/{UUID}";
	
	public static final String GENERATE_TOKEN_PAYLOAD = "{\r\n" + "  \"userName\": \"Zlatan150\",\r\n" + "  \"password\": \"Zlatan123@\"\r\n" + "}";
	
	public static final String POST_ACCOUNT_USER_PAYLOAD_1 = "{\r\n" + "  \"userName\": \"Zlatan143\",\r\n" + "  \"password\": \"Zlatan123@\"\r\n" + "}";

	public static final String POST_ACCOUNT_USER_PAYLOAD_2 = "{\r\n" + "  \"userName\": \"Zlatan144\",\r\n" + "  \"password\": \"Zlatan123@\"\r\n" + "}";

	public static final String POST_ACCOUNT_USER_PAYLOAD_3 = "{\r\n" + "  \"userName\": \"Zlatan150\",\r\n" + "  \"password\": \"Zlatan123@\"\r\n" + "}";
}
