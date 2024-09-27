package Assigmnent13082024;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import Assigmnent13082024_payload_1.Payload_2;

public class TC_2_GetBookByAuthorName extends TC_1_NewBook{

	
	@Test
	public void getbook() {
//		SessionFilter s= new SessionFilter(); 
		
		RestAssured.baseURI="http://216.10.245.166";
		
		String response= given().log().all().queryParam("AuthorName", author)
				.when().get("/Library/GetBook.php")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println("Response is : "+response);
		
		JsonPath js = new JsonPath(response);	
		String book_name = js.getString("[0].book_name");
		String isbn = js.getString("[0].isbn");
		int aisle = js.getInt("[0].aisle");
		
	
		System.out.println("book name is : "+book_name);
		System.out.println("isbn Data is : "+isbn);
		System.out.println("aisle Data is : "+aisle);
		
		Assert.assertEquals(name,book_name,"Validating the book name");
		Assert.assertEquals(isbn,isbn,"Validating the isbn");
		Assert.assertEquals(aisle,aisle,"Validating the aisle");

		
		//TC-2
		System.out.println("Test case is passed");
		
	}
}
