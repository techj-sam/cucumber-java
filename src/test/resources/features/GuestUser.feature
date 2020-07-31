@GuestUser
Feature: Activities by Guest User

  Background:
    Given I go to Home page

  Scenario: As a Guest, User can select and add items to cart but can not checkout unless sign-in to the application
    When I navigate to "DRESSES" tab
    And I select "Evening Dresses" as subcategory
    And I select "Printed Dress" item and add it to cart
    Then I proceed to checkout
    Then I can see sign-in section or create an account section
    And I enter following email address and start create account process
      |  |



