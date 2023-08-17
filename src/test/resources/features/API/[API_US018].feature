Feature: As an administrator, I want to access the Book Issue List through API connection.
  Scenario: [TC_001] When a valid authorization information is used and a GET request is sent to the api/bookIssueList endpoint,
  the expected status code is 200, and the message in the response body should be "Success."

    When "ADMIN" Page User sets "api/bookIssueList" parameters
    Then User sends a get request
    Then Execute a verification for a valid authorization


  Scenario: [TC_002] GET Request Failed Response for the Book Issue List
    Given "Tuba" Page User sets "api/bookIssueList" parameters
    Then User sends a get request
    Then Execute a verification for an invalid authorization

  Scenario:[TC_003] The First Item of the Book Issue List is validated

    Given "ADMIN" Page User sets "api/bookIssueList" parameters
    Then User sends a get request
    And Validate the First Item of the Book Issue  List



