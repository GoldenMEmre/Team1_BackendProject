Feature: As an administrator (teacher), I want to be able to delete a Homework record from the system through API connection.

  Scenario: [TC001] When valid authorization and correct data (id) are sent in a DELETE body
  to the "apiteacher/homeworkDelete" endpoint, the response status code should be 200, and the response
  body's message should be "Success."
    Given "TEACHER" Page User sets "apiteacher/homeworkAdd" parameters
    Then User sends a POST request to create a homework record
    Then Execute a verification for a valid authorization
    Given "TEACHER" Page User sets "apiteacher/homeworkDelete" parameters
    Then User sends a DELETE request
    Then Execute a verification for a valid authorization

    Scenario: [TC002] When invalid authorization or incorrect data (id) are sent in a DELETE body to the
    "apiteacher/homeworkDelete" endpoint, the response status code should be 403, and the response body's message
    should be "failed."
      Given "GAYE" Page User sets "apiteacher/homeworkDelete" parameters
      Then User sends a DELETE request
      Then Execute a verification for an invalid authorization

      Scenario: [TC003]The "DeletedId" field in the response body should match the "id" field sent
      in the DELETE request body to the "apiteacher/homeworkDelete" endpoint.
        Given "TEACHER" Page User sets "apiteacher/homeworkAdd" parameters
        Then User sends a POST request to create a homework record
        Then Execute a verification for a valid authorization
        Given "TEACHER" Page User sets "apiteacher/homeworkDelete" parameters
        Then User sends a DELETE request for a Book Issue and compare the ids in request and response body

        Scenario: [TC004] The successful deletion of the alumni homework record can be verified through the API.
        The response body should contain a "DeletedId" field, and this ID can be used to verify that the record
        was deleted by sending a POST body to the "apiteacher/homeworkbyId" endpoint.
          Given "TEACHER" Page User sets "apiteacher/homeworkbyId" parameters
          Then User sends a POST request to check the latest created visitor
          Then Execute a verification for an invalid authorization