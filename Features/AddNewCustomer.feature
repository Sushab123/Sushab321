Feature: Customer
@Devansh
Scenario Outline: Add New Customer
Given User launch Chrome Browser
When User open url "https://admin-demo.nopcommerce.com/login"
When User enter Email as "<email>" and password as "<password>"
When User click on Login button
Then User can view dashboard
When User click on customer menu
And User click on customer menu item
And User click on new add button
Then User can view and add customer page
When User enter customer info as "<newEmail>" and "<newPass>" and "<fName>" and "<lName>" and "<gender>" and"<Dob>"and "<comName>" and "<adminComment>"
And User click on save button
Then User can view configuration msg "The new customer has been added successfully"
And close browser

Examples:
|email                       |password    |newEmail|nPass|fName|lName|gender|Dob|comName|adminComment|
|admin@yourstore.com         |admin       |sun12@gmail.com|321456|Suni|Joshi|Female|1990|ABC|Testcase1|
