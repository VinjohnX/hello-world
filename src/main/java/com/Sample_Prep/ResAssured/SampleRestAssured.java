package com.Sample_Prep.ResAssured;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;
import samplePayload.JSONPayloads;
import samplePayload.ReUseJsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
public class SampleRestAssured {
	
	
	@Test(testName="samplerest")
	public void resstPOSTPlaceAPI()
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key","qaclick123").header("Content-Type", "application/json").body(JSONPayloads.AddplacePOST())
				.when().post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200).body("scope" ,equalTo("APP")).body("status",equalTo("OK"))
		.header("Server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
		
		
		JsonPath js = new JsonPath(response);
		String PlacValue = js.getString("place_id");
		System.out.println(PlacValue);
		
		String address = "70 Summer walk, USA";
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body("{\r\n"
				+ "\"place_id\":\""+PlacValue+"\",\r\n"
				+ "\"address\":\""+address+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "").when().put("/maps/api/place/update/json").then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		String Getresponse = given().log().all().queryParam("key","qaclick123").queryParam("place_id",PlacValue).when().get("/maps/api/place/get/json").then().log().all()
		.assertThat().statusCode(200).body("address",equalTo(address)).extract().response().asString();
		
		
		String addressValue = ReUseJsonPath.rawMaps(Getresponse).getString("address");
		System.out.println(addressValue);
		Assert.assertEquals(addressValue, address);
		
	} 

	

}
