Feature: Sign In
  As
    a customer of the store
  I WANT TO
    sign in into the website
  SO THAT
    I can buy clothes in the store

  Background:
    Given the client is in the landing page of Yours Logo and browse to the sign in section

  Scenario: Create account
    When the client wants to create an account, fill the form and submit it
    Then the client is redirected to my account and signed in

  Scenario: Sign in
    When the client want to sign in, fill the form and submit it
    Then the client sign in the website