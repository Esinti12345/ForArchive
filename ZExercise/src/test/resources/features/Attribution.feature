#Author: esinorhan@gmail.com
@tag
Feature: As an user, I should be able to fill contact info

  @tag1
  Scenario: Attribution contact us info
    Given I navigate in into FOURSQUARE for attribution
    And I am on Attribution Page
    When I click on LET'S TALK
    And I fill  all contact infos
    And click to contact us button
    Then i see the valid mail message
