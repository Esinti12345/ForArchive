#Author: esinorhan@gmail.com
Feature: Add and Verify Locations

  Background: 
    Given: I logged in into OrangeHRM website to test
 And I am on Locations Page

  Scenario: Add new locations by specifying mandatory fields only
    When I provide locations "<name>" , "<country>" , "<city>" and "<zip code>" 
    Then I location  added "<name>" successfully

  Scenario: Locations labels verification
    When I click on Add Locations
    Then I see following location labels
      | Name            |
      | Country         |
      | Time Zone       |
      | State/Province  |
      | City            |
      | Zip/Postal Code |
      | Phone           |
      | Fax             |
      | Address         |
      | Notes           |
