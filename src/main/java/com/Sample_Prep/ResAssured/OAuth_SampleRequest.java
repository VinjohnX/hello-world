package com.Sample_Prep.ResAssured;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import samplePayload.ReUseJsonPath;

import static io.restassured.RestAssured.*;
public class OAuth_SampleRequest {
	
	@Test
	public void OAuth_AuthorizationCode()
	{
		//GMail Login using Selenium is disabled by google.In our Current code we are manually entering code by authorizing GMAIL in browser
		String AuthCode = "4%2F0AX4XfWhx3FgSkcFBdDZrHW4DM0oP4Lr9Sx_2BTVw3cBfIIIU9WMWQmGlT_FJ5_EHBamAvA";
		
		String AccessTokenresponse = given().urlEncodingEnabled(false).log().all().queryParams("code",AuthCode).queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W").queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
		.queryParams("grant_type", "authorization_code").when().log().all().post("https://www.googleapis.com/oauth2/v4/token").asString();
		
		JsonPath js = ReUseJsonPath.rawMaps(AccessTokenresponse);
		
		String Token = js.getString("access_token");
		
		String Actualresponse = given().log().all().queryParam("access_token", Token).when().log().all().
				get("https://rahulshettyacademy.com/getCourse.php").asString();
		
		System.out.println(Actualresponse);
		
	

}
}
