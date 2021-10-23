package samplePayload;

import io.restassured.path.json.JsonPath;

public class ReUseJsonPath {
	public static JsonPath rawMaps(String Response)
	{
		JsonPath js  =new JsonPath(Response);
		return js;
		
	}

}
