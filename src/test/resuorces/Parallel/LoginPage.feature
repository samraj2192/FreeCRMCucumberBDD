@Login
Feature: Login page feature

@Dryrun
Scenario: Login page title
Given user is on login page
When user gets the title of the page
Then page title should be "Login - My Store"

@Dryrun
Scenario: Forgot Password link
Given user is on login page
Then forgot your password link should be displayed

@Dryrun @skip
Scenario: Login with correct credentials
Given user is on login page
When user enters username "samraj.bhowmik@gmail.com"
And user enters password "Samraj@12345"
And user clicks on Login button
Then user gets the title of the page
And page title should be "My account - My Store"