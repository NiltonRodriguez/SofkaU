Feature: Convert from Celsius to Fahrenheit
  As
    user of the converter
  I WANT TO
    validate that the functionality of the Celsius to Fahrenheit converter works correctly
  SO THAT
    I can make correct physics operations

  Scenario: Convert Celsius degrees to Fahrenheit
    Given a user of the converter that wants to convert "37" Celsius
    When the user executes the converter to Fahrenheit
    Then the user obtains the result "98.6"

  Scenario: Convert an incorrect Celsius value to Fahrenheit
    Given a user od the converter that set "A" as Celsius
    When the user attempt to convert it to Fahrenheit
    Then the user obtains the message "Error"