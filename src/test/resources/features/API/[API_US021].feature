Feature: As an administrator, I want to be able to delete a Book Issue record from the system through API connection.
@api
  Scenario: [TC001] When valid authorization information and correct data (id) are sent in a DELETE body to the
  api/bookIssueDelete endpoint, the expected status code is 200, and the message in the response body should be "Success."
    Given "ADMIN" Page User sets "api/bookIssueAdd" parameters
    Then User sends a POST request to create a book record
    Then Execute a verification for a valid authorization
    Given "ADMIN" Page User sets "api/bookIssueDelete" parameters
    Then User sends a DELETE request
    Then Execute a verification for a valid authorization
@api
    Scenario: [TC002] When invalid authorization information or incorrect data (id) is sent in a DELETE body to
    the api/bookIssueDelete endpoint, the expected status code is 403, and the message in the response body should be "failed."
      Given "GAYE" Page User sets "api/bookIssueDelete" parameters
      Then User sends a DELETE request
      Then Execute a verification for an invalid authorization
@api
      Scenario: [TC003] The value of the DeletedId in the response body should be the same as the id sent in
      the DELETE request body to the api/bookIssueDelete endpoint.
        Given "ADMIN" Page User sets "api/bookIssueAdd" parameters
        Then User sends a POST request to create a book record
        Then Execute a verification for a valid authorization
        Given "ADMIN" Page User sets "api/bookIssueDelete" parameters
        Then User sends a DELETE request for a Book Issue and compare the ids in request and response body
@api
        Scenario: [TC004] The API should be verified to ensure that the desired book issue record is deleted.
        (This can be confirmed by sending the POST body with the received DeletedId to the api/bookIssueId endpoint.)

          Given "ADMIN" Page User sets "api/bookIssueId" parameters
          Then User sends a POST request to check the latest created visitor
          Then Execute a verification for an invalid authorization