Feature:As a user (student), I want to access my daily assignment information with the 'id' through API connection.
@t
  Scenario: [TC_001] When a valid authorization information is used and a GET request is sent to the api/bookIssueList endpoint,
  the expected status code is 200, and the message in the response body should be "Success."

    When "STUDENT" Page User sets "apistudent/dailyAssignmentById" parameters
    Then User sends a post request
    Then Execute a verification for a valid authorization

@t
  Scenario: [TC_002] GET Request Failed Response for the Book Issue List
    Given "Tuba" Page User sets "apistudent/dailyAssignmentById" parameters
    Then User sends a post request
    Then Execute a verification for an invalid authorization
@t
  Scenario:[TC_003] The First Item of the Book Issue List is validated

    Given "STUDENT" Page User sets "apistudent/dailyAssignmentById" parameters
    Then User sends a post request
    And Response body content test for dailyAssignmentListData
