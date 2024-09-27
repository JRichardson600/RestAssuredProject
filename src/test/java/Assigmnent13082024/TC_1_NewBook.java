package Assigmnent13082024;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Assigmnent13082024_payload_1.Payload_2;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import net.minidev.json.JSONObject;

public class TC_1_NewBook extends Payload_2 {

	@Test
	public void book() {

		JSONObject payload = new JSONObject();
		payload.put("name", name);
		payload.put("isbn", isbn);
		payload.put("aisle", aisle);
		payload.put("author", author);

		System.out.println(ID);

		RestAssured.baseURI = "http://216.10.245.166";

		Response res = given().relaxedHTTPSValidation().log().all().headers("Content-Type", "application/json")
				.body(payload).when().post("Library/Addbook.php").then().log().all().extract().response();

		System.out.println("Response is : " + res);

		ResponseBody obj = res.getBody();
		int resCode = res.getStatusCode();

		JsonProcessing1 jData = obj.as(JsonProcessing1.class);
		String Msg = jData.Msg;
		String id = jData.ID;

		System.out.println("Msg Data is : " + Msg);
		System.out.println("job Data is : " + id);

		Assert.assertEquals("successfully added", Msg, "Validating the Msg");
		Assert.assertEquals(ID, id, "Validating the ID");
		Assert.assertEquals(200, resCode, "Validating the response code");

		// TC-1
		System.out.println("Test case is passed");

	}

}
