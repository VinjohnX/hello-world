Feature: Login Action

Background: To be ran before each scenario
 Given Open the browser
 When click on new tab

Scenario: Sucessfull Login of Portal
 Given User navigates to login page
 When User enters username and password
 Then Portal home page is displayed
 
@RegressionTest
Scenario Outline: Sucessfull Login of Website
 Given User navigates to Home page
 When User "<username>" and "<password>"
 Then Website "<page>" is displayed
Examples:
|username|password|page|
|Vineeth|Xavier|LandingPage|
|Preethi|Xavier|HomePage|


Scenario: Sucessfull Login of Website
 Given User navigates to Home page
 When User "username" and "password"
 Then Website "page" is displayed
 
Scenario: Sucessfull Login of Website
 Given User navigates to Home page
 When User "username" and "password"
 Then Website "page" is displayed
 
@SmokeTest
Scenario: first step is to login
 Given First step for login
 When Second step for login
 And Third step for login
 |Username|Password|
 |Sweter|Kees|
 |Nikil|Aaron|
 Then Fourth step of login
 |Page|
 |HomePage|
 |LastPage|