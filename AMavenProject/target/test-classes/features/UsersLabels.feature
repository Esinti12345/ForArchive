#Author: esinorhan@gmail.com
Feature: Users Label Verification

  Scenario: Users Label Verification
    Given I logged in into OrangeHRM website
    And I am on Users Page
    When I click on Add Users
    Then I see the following location labels
      | Employee Name    |
      | Username         |
      | ESS Role         |
      | Supervisor Role  |
      | Admin Role       |
      | Status           |
      | Password         |
      | Confirm Password |
