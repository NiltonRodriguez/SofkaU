Feature: Send contact messages
  As
    client of the store
  I WANT TO
    send a message to the store team
  SO THAT
    I can ask some questions about the orders or the website

  Background:
    Given the client is in the landing page of Yours Logo

  Scenario: Contact the team about an order
    When the client browse to the contact us section, fill the form and submit message to customer service
    Then the client see a success alert

  Scenario: Contact the webmaster about the website
    When the client browse to the contact us section, fill the form and submit message to the webmaster
    Then the client see a success message