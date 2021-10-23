package com.Sample_Prep.ResAssured;
import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import samplePayload.ReUseJsonPath;

public class JiraAPI_CookieAuthentication {
	
	@Test(testName="JIRA API 01")
	public void JiraAPIAuthentication()
	{
		String Fcoment = "This is the Second comment through Rest Assured";
		
		RestAssured.baseURI="http://localhost:8080";
		//Cookie Authentication API
		SessionFilter session = new SessionFilter();
		String response = given().header("content-type","application/json").body("{ \r\n"
				+ " \"username\": \"vineethTest\", \r\n"
				+ "\"password\": \"Jiratest@2021\"\r\n"
				+ " }")
		.filter(session).post("/rest/auth/1/session").then().assertThat().statusCode(200).log().all().extract().response().asString();
		//Create Issue API
		String createresponse = given().header("content-type","application/json").body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "        \"project\": {\r\n"
				+ "            \"key\": \"RES\"\r\n"
				+ "        },\r\n"
				+ "        \"summary\": \"Debit Card Defect\",\r\n"
				+ "        \"description\":\"Creating an Second issue using Rest API postman\",\r\n"
				+ "        \"issuetype\": {\r\n"
				+ "            \"name\": \"Bug\"\r\n"
				+ "        }\r\n"
				+ "      \r\n"
				+ "    }\r\n"
				+ "}").filter(session).when().log().all().post("/rest/api/2/issue").then().assertThat().statusCode(201).extract().response().asString();
		
		JsonPath js = ReUseJsonPath.rawMaps(createresponse);
		String IssueID = js.getString("id");
		//Add Comment JIRA API
		given().pathParam("id",IssueID).log().all().header("content-type","application/json").body("{\r\n"
				+ "    \"body\": \"This is the first comment through Rest Assured\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}").filter(session).when()
		.post("/rest/api/2/issue/{id}/comment").then().log().all().assertThat().statusCode(201);
		
		//Add Comment Second time
		String seconCmt = given().pathParam("id",IssueID).log().all().header("content-type","application/json").body("{\r\n"
				+ "    \"body\": \""+Fcoment +"\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}").filter(session).when()
		.post("/rest/api/2/issue/{id}/comment").then().log().all().assertThat().statusCode(201).extract().response().asString();
		
		JsonPath js2 = ReUseJsonPath.rawMaps(seconCmt);
		String commtID = js2.getString("id");
		
		//Add Attachment JIRA API
		given().log().all().header("X-Atlassian-Token","no-check").header("content-type","multipart/form-data").pathParam("ID", IssueID).filter(session)
		.multiPart("file",new File("JIRA_Attachment.txt")).when().post("/rest/api/2/issue/{ID}/attachments").then().log().all().statusCode(200);
		
		
		//get Issue
		String Issuedetail  = given().log().all().filter(session).pathParam("ID",IssueID).queryParam("fields", "comment").when().get("/rest/api/2/issue/{ID}").then()
		.log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println(Issuedetail);
		JsonPath js1 = ReUseJsonPath.rawMaps(Issuedetail);
		int Comtcount = js1.getInt("fields.comment.comments.size()");
		for(int i=0;i<Comtcount;i++)
		{
			String getComtID = js1.getString("fields.comment.comments["+i+"].id");
			System.out.println(getComtID);
			if(getComtID.equalsIgnoreCase(commtID))
			{
				String commentval = js1.getString("fields.comment.comments["+i+"].body");
				System.out.println(commentval);
			   Assert.assertEquals(Fcoment, commentval);
			}
		}
		
	}
	

}
