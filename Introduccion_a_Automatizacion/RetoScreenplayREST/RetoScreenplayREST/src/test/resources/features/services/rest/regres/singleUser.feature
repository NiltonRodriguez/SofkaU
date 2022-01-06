Feature: Single user listing
  AS
    administrator of the system
  I WANT TO
    list an user information
  SO THAT
    I can validate the user information

  Background:
    Given an administrator of the website that wants to list a single user information

  Scenario: List a single user
    When the administrator sends the list request for user "2"
    Then the administrator see a success response code and the user information

  Scenario: List a non existent user
    When the administrator sends the list request for the non existent user "13"
    Then the administrator see a Not Found response code