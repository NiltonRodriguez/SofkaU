Feature: User register.
  AS
    user of the system
  I WANT TO
    register in the system
  SO THAT
    I can use the system services.

  Scenario: Register Successful
    Given the user is in the website registration page with the email "eve.holt@reqres.in" and the password "pistol"
    When the user send a registration request
    Then the user sees a success response code and an id with a response token