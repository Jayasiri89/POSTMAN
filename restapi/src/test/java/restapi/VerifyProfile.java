package restapi;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class VerifyProfile extends RestAssuredBase {

	@Test(dependsOnMethods = { "restapi.LoginUIBank.loginUiBankMethod" })

	// method to verify the profile
	public void verifyRegisterdProfile() {
		RestAssured.baseURI = "https://uibank-api.azurewebsites.net/api/";

		Response response = RestAssured.given().contentType(ContentType.JSON).header("authorization", auth_id)
				.pathParams("user_id", user_Id).get("users/{user_id}");

		JsonPath path = response.jsonPath();
		// asserting the reponse body
		Assert.assertEquals(path.get("email"), "jsiri90@gmail.com");

		// Assert the status code
		Assert.assertEquals(response.statusCode(), 200);

		// Print the response and status code
		System.out.println(response.statusCode());
		response.prettyPrint();
	}

}
