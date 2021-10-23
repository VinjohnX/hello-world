package com.Sample_Prep.PreparationCodes;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class SampleListerners implements  ITestListener {
	public void onStart(ITestContext context)
	{
		
	}
	public void onTestFailure(ITestResult result) {
		
		SampleTestNG sn = new SampleTestNG();
		try {
			sn.onfailedTC();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("The Name "+result.getName());
	}
}
