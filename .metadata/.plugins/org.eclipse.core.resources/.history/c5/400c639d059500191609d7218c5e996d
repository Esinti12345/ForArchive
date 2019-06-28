#Author: syntax team     //john.smith@wellfargo.com
@sprint3
Feature: Login

@smoke @login
Scenario: Valid login
Given I navigated to OrangeHrm
And I see OrangeHrm logo
When I enter valid username and password
And I click login button
Then I successfully logged in 
And I close browser

@regression @login
Scenario: Invalid login
Given I navigated to OrangeHrm
And I see OrangeHrm logo
When I enter invalid username and password
And I click login button
Then I see error message is displayed
And I close browser