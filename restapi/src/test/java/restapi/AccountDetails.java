package restapi;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AccountDetails extends RestAssuredBase {
	
	@Test(dependsOnMethods = {"restapi.LoginUIBank.loginUiBankMethod"})
	//method to verify the account details present for a user
	public void verifyAccounts()
	{
		RestAssured.baseURI="https://uibank-api.azurewebsites.net/api/";

		Response response = RestAssured.given()
							.header("authorization", auth_id)
							.get("accounts");
		//Assert the status code
		Assert.assertEquals(response.statusCode(), 200);
		
		//Print the response and status code
		response.prettyPrint();
		System.out.println(response.statusCode());
	}

}
