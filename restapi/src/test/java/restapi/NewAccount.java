package restapi;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class NewAccount extends RestAssuredBase {

	@Test(dependsOnMethods = { "restapi.LoginUIBank.loginUiBankMethod" })
	// method to create a new account
	public void createAccountUiBank() {
		//Set the URI
		RestAssured.baseURI = "https://uibank-api.azurewebsites.net/api/";

		// adding authorization header
		// and adding body field with the data
		Response response = RestAssured.given().contentType(ContentType.JSON).header("authorization", auth_id)
				.body("{\r\n" + "    \"friendlyName\": \"Jayasiri89\",\r\n" + "    \"type\": \"checking\",\r\n"
						+ "    \"userId\": \"620f1dc88932d4005f2a8874\",\r\n" + "    \"balance\": 1000,\r\n"
						+ "    \"accountNumber\": 36522245\r\n" + "}")
				.post("accounts");
		// Get a JsonPath view of the response body and extract user_id
		JsonPath path = response.jsonPath();
		user_Id = path.get("userId");
		// Assert the status code
		Assert.assertEquals(response.statusCode(), 200);

		// Print the response and status code
		System.out.println(response.statusCode());
		response.prettyPrint();

	}
}
