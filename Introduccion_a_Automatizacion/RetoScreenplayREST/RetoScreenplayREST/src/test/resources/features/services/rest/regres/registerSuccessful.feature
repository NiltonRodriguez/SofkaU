Feature: User register
  AS
    user of the system
  I WANT TO
    register in the system
  SO THAT
    I can use the system services.

  Scenario: Register Successful
    Given the allowed user is in the website registration page
    When the user send a registration request with the email "eve.holt@reqres.in" and the password "pistol"
    Then the user sees a success response code and an id with a response token

  Scenario: Not allowed register
    Given a not allowed user of the website attempts to register
    When the user attempt a registration request with the email "snow.flake@reqres.in" and the password "snowflake"
    Then the user sees a bad request response code and an error message