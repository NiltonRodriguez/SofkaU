Feature: Order
  As
    a client
  I WANT TO
    make an order
  SO THAT
    I can buy the products of the store.

  Background:
    Given a client that want to buy in zonafit

  Scenario: Clear the cart
    When the client select a product
    But the client go to the cart and confirm to clear it
    Then the client see a message with the cart empty

  Scenario: Make an order
    When the client select products and confirm the cart
    And the client fill the billing form and confirm the purchase
    Then the client see the billing and payment information
