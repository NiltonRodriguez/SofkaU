Feature: Search the capital city of a country
  AS
    user of the system
  I WANT TO
    search the capital city of a country
  SO THAT
    I can visit the city

  Background:
    Given a user that wants to know the capital city of a country

  Scenario: Consult the capital city of a country
    When the user send the ISO code of Colombia "CO"
    Then the user obtains the capital city "Bogota"

  Scenario: Consult the capital city of a country that doesn't exist
    When the user send the ISO code "CQ" that doesn't exists
    Then the user obtains the the message "Country not found in the database"