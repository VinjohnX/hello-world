package com.Sample_Prep.ResAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class StaticJSONPayload {
	
	@Test(priority=0)
	public void SampleStaticJSON() throws IOException 
	{
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String sed = given().log().all().queryParam("key ", "qaclick123").header("Content-Type", "application/json")
		.body(new String(Files.readAllBytes(Paths.get("E:\\RestAssured\\Section-7\\StaticJSONPayload.json"))))
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP")).extract().response().asString();	
		
		System.out.println(sed);
		}

}
