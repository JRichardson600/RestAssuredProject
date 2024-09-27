package Assigmnent13082024;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import Assigmnent13082024_payload_1.Payload_2;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import net.minidev.json.JSONObject;

public class TC_4_DeleteBook extends TC_1_NewBook {
	@Test
	public void deleteBookById()  {
		
		
		JSONObject payload = new JSONObject();
		payload.put("ID", ID);
		
		RestAssured.baseURI="http://216.10.245.166";
		
		String response= given().log().all()
				.body(payload)
				.when().post("/Library/DeleteBook.php")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		

		
		System.out.println("Response is : "+response);
		
		JsonPath js = new JsonPath(response);	
		String msg = js.getString("msg");

		System.out.println("book name is : "+msg);

		Assert.assertEquals("book is successfully deleted",msg,"Validating the Msg");
		
//		//TC-4
		System.out.println("Test case is passed");
		
	}
}
