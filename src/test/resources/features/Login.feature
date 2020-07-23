@LoginFeature
Feature: Login functionality

  Background: 
    Given I go to Home page

  @test
  Scenario: User should be able to login into the application with correct credentials
    When I navigate to login page
    And I enter username as ""
    And I enter password as ""
    And I click on 'SIGN ME IN' button
    Then I should still see login page

  Scenario: I should not be logged in if entered only Password field and cliked sign me in
    When I enter in 'Password' field value "123456"
    And I click on 'SIGN ME IN' button
    Then I should still see login page

  Scenario: I should get Username or password is invalid when entered valid username and incorrect password
    When I enter in 'Username' field value "aman"
    And I enter in 'Password' field value "12345678"
    And I click on 'SIGN ME IN' button
    Then I should get message "Username or password is invalid"

  Scenario: I should get Username or password is invalid when entered invalid username and correct password
    When I enter in 'Username' field value "amang"
    And I enter in 'Password' field value "123456"
    And I click on 'SIGN ME IN' button
    Then I should get message "Username or password is invalid"
