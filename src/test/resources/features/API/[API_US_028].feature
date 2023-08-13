
  Feature: As an administrator, I want to access the Books List through API connection.



    Scenario: [TC_001] GET Request Success Response for the Books List

      Given "ADMIN" Page User sets "api/booksList" parameters
      Then User sends a get request
      Then Execute a verification for a valid authorization




      Scenario:  [TC_002] GET Request Failed Response for the Books List

        Given "Demet" Page User sets "api/booksList" parameters
        Then User sends a get request
        Then Execute a verification for an invalid authorization


        @dg
        Scenario: dfrgtyuıop

        Given "Demet" Page User sets "api/booksList" parameters
        Then User sends a get request
        Then Execute a verification  for required informations
















