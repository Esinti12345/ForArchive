#Author: syntax team     //john.smith@wellfargo.com
Feature: Add Course

  Background: 
    Given I logged in into OrangeHrm to add a course
    And I click on Training link
    And I click on Courses link
    And I click on Add Course button

  @smoke
  Scenario: Add Course
    When I provide CourseTitle and Coordinator
    And I click on save course button
    Then I see successfully save text

  @smoke
  Scenario: Add Course With Parameters
    When I provide "Algebra" and "j"
    And I click on save course button
    Then I see successfully save text

  @smoke
  Scenario Outline: Add Course from example list
    When I provide "<CourseTitle>" and "<Coordinator>" from example
    And I click on save course button
    Then I see successfully save text

    Examples: 
      | CourseTitle    | Coordinator |
      | Science        | j           |
      | Social Studies | d           |
      | ELA            | r           |

  @temp
  Scenario: Add Course from map
    When I provide CourseTitle and Coordinator from below
      | CourseTitle    | Coordinator |
      | Science        | j           |
      | Social Studies | d           |
      | ELA            | r           |
      