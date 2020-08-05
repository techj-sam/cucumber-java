@Checkout
Feature: Order and Checkout for already registered user

  Background:
    Given I login with correct credentials

  Scenario: User can select an item from evening dress category and complete checkout process
    When I navigate to "DRESSES" tab
    And I select "Evening Dresses" as subcategory
    And I select "Printed Dress" item and add it to cart
    Then I proceed to checkout
    And I see that cart is filled with "Printed Dress" item
    And I see summary of order and proceed ahead
    And I confirm address and proceed ahead
    And I agree terms of service and proceed ahead
    And I confirm the amount to be paid and select payment option "Pay by cheque"
    Then I confirm my order
    And I can see order completion message
      | Your order on My Store is complete. |






