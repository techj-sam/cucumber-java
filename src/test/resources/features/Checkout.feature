@Checkout
Feature: Order and Checkout

  Background:
    Given I login with correct credentials

  Scenario: User can select an item from evening dress category and complete checkout process
    When I navigate to "DRESSES" tab
