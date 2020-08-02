@GuestUser
Feature: Activities by Guest User

  Background:
    Given I go to Home page

  Scenario: As a Guest, User can select and add items to cart but can not checkout unless sign-in to the application
    When I navigate to "DRESSES" tab
    And I select "Evening Dresses" as subcategory
    And I select "Printed Dress" item and add it to cart
    Then I proceed to checkout
    And I see summary of order and proceed ahead
    Then I can see sign-in section or create an account section
    And I enter email address and complete create account process
    And I confirm address and proceed ahead
    And I agree terms of service and proceed ahead
    And I confirm the amount to be paid and select payment option "Pay by cheque"
    Then I confirm my order
    And I can see order completion message
      | Your order on My Store is complete. |







