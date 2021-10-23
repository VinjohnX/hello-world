package com.Sample_Prep.ResAssured;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;
import samplePayload.JSONPayloads;
import samplePayload.ReUseJsonPath;

public class ComplexJSONParser {
	
	@Test(testName="MockResponsedemo")
	public void JsonParsingExample()
	{
		JsonPath js = ReUseJsonPath.rawMaps(JSONPayloads.mockresponse());
		//1. Print No of courses returned by API
		int CourseSize = js.getInt("courses.size()");
		System.out.println("The course Size "+CourseSize);
		//2.Print Purchase Amount
		int ppAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println("The Purcahse amount is "+ppAmount);
		//3. Print Title of the first course
		String firstCourse = js.getString("courses[0].title");
		System.out.println("The first Course name is "+firstCourse);
		//4. Print All course titles and their respective Prices
		
		for (int i=0;i<CourseSize;i++)
		{
			String coursename = js.getString("courses["+i+"].title");
			int price = js.getInt("courses["+i+"].price");
			//Also we can get the integer value using get , if needed convert to String
           System.out.println(js.get("courses["+i+"].price"));
			System.out.println("CourseName- "+coursename);
			System.out.println("Price is "+price);
					
		}
		
		//5. Print no of copies sold by RPA Course
		for(int i=0;i<CourseSize;i++)
		{
			String coursename = js.getString("courses["+i+"].title");
			if(coursename.equals("RPA"))
			{
				int copiesNo = js.getInt("courses["+i+"].copies");
				System.out.println("The no of copies for "+coursename+" is "+copiesNo);
				break;
			}
		}
		//6. Verify if Sum of all Course prices matches with Purchase Amount
		double sum = 0.0;
		for(int i=0;i<CourseSize;i++)
		{
			String coursename = js.getString("courses["+i+"].title");
		    int copiesNo = js.getInt("courses["+i+"].copies");
		    int price = js.getInt("courses["+i+"].price");
		    sum = sum+ (copiesNo*price);
				System.out.println("The no of copies for "+coursename+" is "+copiesNo);
			
			
		}
		System.out.println("The SUM is "+sum);
		int pAmount = js.getInt("dashboard.purchaseAmount");
		if(sum==pAmount)
		{
			System.out.println("The Sum is equal to Purchase Amount");
		}
		else
		{
			System.out.println("The Sum is not equal to Purchase Amount");
		}
		org.testng.Assert.assertEquals(sum, pAmount);
	}

}
