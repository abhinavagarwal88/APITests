package helpers;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.Random;

import io.restassured.response.Response;

public class APIRequestsHelpers {

	private static String exampleURL = System.getProperty("example_url");

	public static Response simpleGetRequest(String uri) { // send get request
		Response response = given().header("Content-Type", "application/json").when().get(uri).then().extract()
				.response();
		return response;
	}

	public static void verifyResponseStatusCode(Response response, int statusCode) { // verify response code
		response.then().assertThat().statusCode(statusCode);
	}

	public static Response simpleDeleteRequest(String uri) {
		Response response = given().header("Content-Type", "application/json").when().delete(uri).then().extract()
				.response();
		return response;
	}

	public static void verifyResponseHeader(Response response, String header, String message) { // verify response
																								// headers
		response.then().assertThat().header(header, equalTo(message));
	}

	public static String createURL(String path) { // create example app url for api calls
		String uri = exampleURL + path;
		return uri;
	}

}
