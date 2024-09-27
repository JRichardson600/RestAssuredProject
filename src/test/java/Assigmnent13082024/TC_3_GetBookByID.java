package Assigmnent13082024;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import Assigmnent13082024_payload_1.Payload_2;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TC_3_GetBookByID extends  TC_1_NewBook {
	
	
	@Test
	public void getbookById()  {
	
		RestAssured.baseURI="http://216.10.245.166";
		
		String response= given().log().all().queryParam("ID",ID)
				.when().get("Library/GetBook.php")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println("Response is : "+response);
		
		JsonPath js = new JsonPath(response);	
		String book_name = js.getString("[0].book_name");
		String isbn = js.getString("[0].isbn");
		int aisle = js.getInt("[0].aisle");
		String author = js.getString("[0].author");

		System.out.println("book name is : "+book_name);
		System.out.println("isbn Data is : "+isbn);
		System.out.println("aisle Data is : "+aisle);
		System.out.println("author Data is : "+author);
		
		Assert.assertEquals(name,book_name,"Validating the book_name");
		Assert.assertEquals(isbn,isbn,"Validating the ID");
		Assert.assertEquals(aisle,aisle,"Validating the aisle");
		Assert.assertEquals(author,author,"Validating the author");
		
		//TC-3
		System.out.println("Test case is passed");
		
	}
}
