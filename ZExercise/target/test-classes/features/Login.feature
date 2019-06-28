#Author: syntax team   or john.smith@wellfargo.com
@sprint3
Feature: Login

  Background: 
    Given I see OrangeHrm logo

  @smoke @login
  Scenario: Valid login
    When I enter valid username and password
    And I click login button
    Then I successfully logged in

  @regression @login
  Scenario: Invalid login
    When I enter invalid username and password
    And I click login button
    Then I see error message is displayed

  @temp
  Scenario: Error message Validation
    When I enter invalid username and password I see errorMessage
      | UserName | Password   | ErrorMessage        |
      | Admin    | Admin123   | Invalid Credentials |
      | Admin1   | Syntax123! | Invalid Credentials |
      | Admin2   | Syntax123  | Invalid Credentials |

  @regression @temp
  Scenario Outline: Error message Validation 2
    When I enter invalid "<UserName>" and "<Password>" I see "<ErrorMessage>" 

    Examples: 
      | UserName | Password   | ErrorMessage        |
      | Admin    | Admin123   | Invalid Credentials |
      | Admin1   | Syntax123! | Invalid Credentials |
