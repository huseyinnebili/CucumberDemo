package toolsqa_Book;


import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	public static final String GENERATE_TOKEN_PAYLOAD = "{\r\n" + "  \"userName\": \"JohnP\",\r\n" + "  \"password\": \"John@2047\"\r\n" + "}";

	public static String getUserName() {

		String generatedString = RandomStringUtils.randomAlphabetic(1);

		return ("John" + generatedString);
	}

	public static String getPassword() {

		String generatedString = RandomStringUtils.randomNumeric(4);

		return ("John@" + generatedString);
	}

	public static void main(String[] args) {

		System.out.println(getPassword());
		System.out.println(getUserName());
	}

}
