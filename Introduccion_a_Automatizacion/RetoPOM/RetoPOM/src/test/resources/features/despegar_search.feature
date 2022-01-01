Feature: Tickets reservation
  AS
    client
  I WANT TO
    search for flying tickets
  SO THAT
    I can make a reservation.

  Background:
    Given a client that wants to make a flying tickets reservation at despegar website

  Scenario: Cheapest roundtrip flight.
    When the client fill the search form for a roundtrip flight for three passengers and confirm the action
    And the client select the cheapest flight
    Then the client see the information and the full price of the selected flight

  Scenario: Cheapest one way flight.
    When the client fill the search form for a one way flight for one passenger and confirm the action
    And the client select the first flight
    Then the client see the information and the price of the selected flight