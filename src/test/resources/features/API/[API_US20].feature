Feature: As an administrator, I want to create a new Book Issue record through API connection.

  Scenario: [TC_001] When a valid authorization information and correct data (id) are sent in a POST body to the api/bookIssueId endpoint,
  the expected status code is 200,and the message in the response body should be "Success."

    When "ADMIN" Page User sets "api/bookIssueAdd" parameters
    Then User sends a get POST request to bookIssueId
    Then Execute a verification for a valid authorization


  Scenario: [TC_002] POST Request Failed Response for the Book Issue ID
    Given "Tuba" Page User sets "api/bookIssueAdd" parameters
    Then User sends a get POST request to bookIssueId
    Then Execute a verification for an invalid authorization

  Scenario:[TC_003] The First Item of the Book Issue List is validated

    Given "ADMIN" Page User sets "api/bookIssueAdd" parameters
    Then User sends a get request
    And Validate the First Item of the Book Issue Post
