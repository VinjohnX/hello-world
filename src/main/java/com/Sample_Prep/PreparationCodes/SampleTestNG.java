package com.Sample_Prep.PreparationCodes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(SampleListerners.class)
public class SampleTestNG {
	
	public static WebDriver driver;
	@Test(invocationCount=1, timeOut = 1000 , dependsOnGroups= {"demo"})
	@Parameters({"TCname"})
	public void testcase1(@Optional("2@@") String TCname) throws InterruptedException
	{
		Thread.sleep(900);
		System.out.println("From Test case 1"+TCname);
		Assert.assertEquals(true, true);
		
	}
	@Test(groups= {"demo"}, dataProvider = "datainput")
	public void testcase2(int a, int b, int c)
	{
		System.out.println("From Test case 2"+a+b+c);
	}
	@Test(groups= {"demo"})
	public void testcase3()
	{
		System.out.println("From Test case 3");
		//WebDriver driver = new ChromeDriver();
	} 
	@Test(dataProvider = "Datainput-excel")
	public void testcase4(String fname, String lname) throws IOException
	{
		System.out.println("From Test case 4"+fname+lname);
	    driver = new ChromeDriver();
		driver.navigate().to("https://www.goibibo.com/");
		TakesScreenshot scr = (TakesScreenshot)driver;
		File Screesnhot =  	scr.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Screesnhot, new File("C:\\Users\\DELL\\eclipse-workspace\\PreparationCodes\\Snaps\\sample.jpg"));
		Assert.assertEquals(true, false);
		
	}
	@DataProvider(name = "datainput")
	public Object[][] sampleinput()
	{
		return new Object[][] {{2,3,5},{4,3,7}};
	}
	@DataProvider(name = "Datainput-excel")
	public Object[][] sampleinput2() throws IOException
	{
		FileInputStream fin = new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\PreparationCodes\\Resources\\Data_InputSheet.xlsx");
		XSSFWorkbook xbook1 = new XSSFWorkbook(fin);
		XSSFSheet xheet = xbook1.getSheetAt(0);
		XSSFRow xrow = xheet.getRow(1);
		int lastcolumn = xrow.getLastCellNum();
		int lastrow = xheet.getLastRowNum();
		System.out.println(lastcolumn+" "+lastrow);
		Object[][] exceldata = new Object[lastrow][lastcolumn-1];
		int l=0;
		for(int i =1;i<=lastrow;i++)
		{
			int m=0;
			for(int j=1;j<lastcolumn;j++)
			{
				exceldata [l][m] = xheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(exceldata[l][m]);
				m++;
			}
			l++;
		}
		xbook1.close();
		fin.close();
		return exceldata;
	}
	@BeforeMethod
	public void beforemethodTestcase()
	{
		System.out.println("From before method");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\eclipse-workspace\\PreparationCodes\\Driver\\chromedriver.exe");
		
	}
	@AfterMethod
	public void aftermethodTestcase()
	{
		System.out.println("From After method");
	}
	@BeforeClass
	public void beforeClassTestcase()
	{
		System.out.println("From before class method");
	}
	@AfterClass
	public void afterClassTestcase()
	{
		System.out.println("From After class method");
	}
	@BeforeTest
	public void beforeTestingTestcase()
	{
		System.out.println("From before Test method");
	}
	@AfterTest
	public void afterTestingTestcase()
	{
		System.out.println("From After Test method");
	}
	@BeforeSuite
	public void beforeSuiteTestcase()
	{
		System.out.println("From before Suite method");
	}
	@AfterSuite
	public void afterSuiteTestcase()
	{
		System.out.println("From After Suite method");
	}
	
	public void onfailedTC() throws IOException
	{
		System.out.println("Failed TC");
		TakesScreenshot scr = (TakesScreenshot)driver;
		File Screesnhot =  	scr.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Screesnhot, new File("C:\\Users\\DELL\\eclipse-workspace\\PreparationCodes\\Snaps\\sample1.jpg"));
	}


}
