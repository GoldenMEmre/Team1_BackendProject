Feature: As a user (student), I want to access my Student Class information through API connection.
  @og
  Scenario: [TC001] When a valid authorization is used to send a GET request to the "apistudent/getStudentClass" endpoint,
  the response status code should be 200, and the response message should be "Success."
    Given "STUDENT" Page User sets "apistudent/getStudentClass" parameters
    Then User sends a get request
    Then Execute a verification for a valid authorization
  @og
    Scenario: [TC002] When invalid authorization is used to send a GET request to the "apistudent/getStudentClass" endpoint,
    the response status code should be 403, and the response message should be "failed."
      Given "OGUN" Page User sets "apistudent/getStudentClass" parameters
      Then User sends a get request
      Then Execute a verification for an invalid authorization
  @api
      Scenario: [TC003] The response body should contain required fields
        Given "STUDENT" Page User sets "apistudent/getStudentClass" parameters
        Then User sends a get request
        Then Validate the content of the getStudentClass Response Body