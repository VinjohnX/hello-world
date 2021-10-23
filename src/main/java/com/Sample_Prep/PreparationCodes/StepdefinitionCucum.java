package com.Sample_Prep.PreparationCodes;

import java.util.List;
import java.util.Map;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepdefinitionCucum {

	@Given("Open the browser")
	public void open_the_browser() {
	   System.out.println("Background Given Statment");
	}
	@When("click on new tab")
	public void click_on_new_tab() {
		System.out.println("Background When Statment");   
	}
	@Before(order=1)
	public void before_each_Scenario()
	{
		System.out.println("Method before each scenario");
	}
	@Before(order=0)
	public void before_each_Scenario_2()
	{
		System.out.println("Method before each scenario_2");
	}
	@Before("@RegressionTest")
	public void before_each_Scenario_tags()
	{
		System.out.println("Method before each scenario only for regression scenario");
	}
	@After(order=0)
	public void after_each_Scenario()
	{
		System.out.println("Method After each scenario");
	}
	@After(order=1)
	public void after_each_Scenario_2()	
	{
		System.out.println("Method After each scenario_2");
	}
	@After("@SmokeTest")
	public void after_each_Scenario_tags()
	{
		System.out.println("Method After each scenario_SmokeTest");
	}
	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Message from Given method");
	    //throw new io.cucumber.java.PendingException();
	}
	@Given("User navigates to Home page")
	public void user_navigates_to_Home_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Message from Given method 2");
	    //throw new io.cucumber.java.PendingException();
	}
	@When("User enters username and password")
	public void user_enters_username_and_password() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Message from When method");
	    //throw new io.cucumber.java.PendingException();
	}
	@When("^User \"(.*)\" and \"(.*)\"$")
	public void user_enters_uname_and_pwd(String uname, String password) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Message from When method 2 "+uname+" "+password);
	    //throw new io.cucumber.java.PendingException();
	}
	@Then("Portal home page is displayed")
	public void portal_home_page_is_displayed() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Message from When method");
	   // throw new io.cucumber.java.PendingException();
	}
	@Then("^Website \"(.*)\" is displayed$")
	public void website_page_is_displayed(String page) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Message from When method 2 "+ page);
	   // throw new io.cucumber.java.PendingException();
	}

	@Given("First step for login")
	public void first_step_for_login() {
	    System.out.println("Given method from First Step for login");
	}
	@When("Second step for login")
	public void second_step_for_login() {
		System.out.println("Given method from Second Step for login");
	}
	@When("Third step for login")
	public void third_step_for_login(io.cucumber.datatable.DataTable userdetails) {
		List<Map<String,String>> data = userdetails.asMaps(String.class,String.class);
		for(Map<String,String> d:data)
		{
			System.out.println("ThirdStepfor Login"+d.get("Username")+d.get("Password"));
		}
	    
	}
	@Then("Fourth step of login")
	public void fourth_step_of_login(io.cucumber.datatable.DataTable Pagedetails) {
		
		List<Map<String,String>> pages = Pagedetails.asMaps(String.class,String.class);
		for(Map<String,String> p : pages)
		{
			System.out.println("Fourth step of login"+p.get("Page"));
		}
	}



}
