@LoginFeature
Feature: Login functionality

  Background:
    Given I go to Home page

  Scenario Outline:: User should be able to login into the application with correct credentials
    When I navigate to login page
    And I enter username as "<username>"
    And I enter password as "<password>"
    And I click on Sign-in button
    Then I should be able login to the application

    Examples:
      | username            | password   |
      | Test12@gmail7.com   | automate1* |
      | demotest@gmail1.com | cucumber1* |

  @LoginValidation
  Scenario Outline: User should not not able to login into the application with incorrect credentials
    When I navigate to login page
    And I enter username as "<username>"
    And I enter password as "<password>"
    And I click on Sign-in button
    Then I should see following error message
      | Authentication failed. |
    And I should not able to login to the application

    Examples:
      | username              | password   |
      | Test1234@gmail.com    | heav678**  |
      | Test7987979@gmail.com | automate6* |

