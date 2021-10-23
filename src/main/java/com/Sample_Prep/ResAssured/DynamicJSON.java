package com.Sample_Prep.ResAssured;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import samplePayload.JSONPayloads;
import samplePayload.ReUseJsonPath;

public class DynamicJSON {
	
	@Test(dataProvider="BookData",priority = 1)
	public void sampledynamicJSONoperation(String Ibn, String Aisle)
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String resp = given().header("Content-Type","application/json")
		.body(JSONPayloads.DynamicRequest(Ibn,Aisle))
		.when()
		.post("/Library/Addbook.php").then().log().all()
		.assertThat().statusCode(200)
		.extract().response().asString();
		
		JsonPath js = ReUseJsonPath.rawMaps(resp);
		String id = js.getString("ID");
		System.out.println("The ID of the book added is "+id);
	}
	
	@Test(dataProvider = "BookData",priority=2)
	public void sampledynamicDeleteOperation(String Ibn, String Aisle)
	{
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String resp = given().header("Content-Type","application/json")
				.body(JSONPayloads.DynamicRequestDelete(Ibn, Aisle))
				.when()
				.delete("/Library/DeleteBook.php")
				.then().log().all().statusCode(200)
				.extract().response().asString();
		JsonPath js = ReUseJsonPath.rawMaps(resp);
		String msg = js.getString("msg");
		Assert.assertEquals(msg, "book is successfully deleted");
		
	}
	
	@DataProvider(name="BookData")
	public Object[][] getData()
	{
		Object[][] data1 = new Object[][] {{"zwrr3","75341"},{"yipoi","65912"},{"Kreq","1987"}};
		return data1;
	}
	
	
}
