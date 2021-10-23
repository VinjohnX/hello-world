package com.Sample_Prep.PreparationCodes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sample_GlobalSQA {
	
	
	WebDriver driver;
	@BeforeTest
	public void BeforeSample_GlobalSQA()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\eclipse-workspace\\PreparationCodes\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
	
	}
	@Test(testName = "GlobalSQA" , enabled=false)
	public void sampleDomelements() throws InterruptedException
	{
		driver.get("https://www.globalsqa.com/demo-site/");
		driver.manage().window().maximize();
		System.out.println("The program is executing");
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Tabs")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[text()='Simple Accordion']")).click();
		Thread.sleep(3000);
	    driver.switchTo().frame(3);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h3[text()='Section 2']")).click();
		String s = driver.findElement(By.xpath("//h3[text()='Section 2']/following::p[1]")).getText();
		
		System.out.println("The Value of "+s);
		
	}
	
	@Test(testName="TestAutomationPratice")
	public void testAutomationElements() throws InterruptedException
	{
		driver.navigate().to("https://testautomationpractice.blogspot.com/");
		Thread.sleep(2000);
		Actions act1 = new Actions(driver);
		act1.doubleClick(driver.findElement(By.xpath("//button[text()='Copy Text']"))).perform();
		Thread.sleep(2000);
		String s = driver.findElement(By.xpath("//input[@id='field2']")).getAttribute("value");
		System.out.println(s);
		Assert.assertEquals(s, "Hello World!","The mesage is incorrect");
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='14']")).click();
		Thread.sleep(1000);
		SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date d = new Date();
		System.out.println(fm.format(d));
		
	}
	
	@AfterTest
	public void afterDomelemts()
	{
		driver.close();
	}

}
