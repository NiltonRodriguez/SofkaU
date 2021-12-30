Feature: Single user listing
  AS
    administrator of the system
  I WANT TO
    list an user information
  SO THAT
    I can validate the user information

  Scenario: List a single user
    Given an administrator of the website that wants to list a single user information
    When the administrator sends the list request
    Then the administrator see a success response code and the user information