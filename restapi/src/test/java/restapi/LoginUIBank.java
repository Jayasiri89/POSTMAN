package restapi;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class LoginUIBank extends RestAssuredBase{
	
	@Test //Login to UiBank
	public void loginUiBankMethod()
	{
		// set Url/ Endpoint
		RestAssured.baseURI="https://uibank-api.azurewebsites.net/api/";
		
		//construct the body
		Response response = RestAssured.given().contentType(ContentType.JSON)
				.body("{\r\n"
						+ "    \"username\": \"jsiri90@gmail.com\",\r\n"
						+ "    \"password\": \"Abhi1234@\"\r\n"
						+ "}")
				.post("users/login");
		
		// Get a JsonPath view of the response body and extract authorization id
		JsonPath path = response.jsonPath();
		auth_id=path.get("id");
		
		//Assertion to check if status code is equal to 200
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println(response.statusCode());

		//Print the response
		response.prettyPrint();
	}

}
