Feature: Tickets reservation
  AS
    client
  I WANT TO
    search for flying tickets
  SO THAT
    I can make a reservation.

  Background:
    Given a client that wants to make a flying tickets reservation on despegar website

  Scenario: Cheapest roundtrip flight.
    When the client fill the search form for a roundtrip flight and confirm the action
    #And the client select the cheapest flight
    Then the client see the information and the price of the selected flight