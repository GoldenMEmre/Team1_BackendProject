Feature: As an administrator (teacher), I want to access the Homework information of a homework with a given ID through API connection.

  Scenario: [TC001] When a valid authorization and correct data (id) are sent in a POST body to the "apiteacher/homeworkbyId"
  endpoint, the response status code should be 200, and the response body's message should be "Success."
    Given "TEACHER" Page User sets "apiteacher/homeworkbyId" parameters
    Then User sends a POST request to homeworkById page
    Then Execute a verification for a valid authorization

    Scenario: [TC002] When invalid authorization or invalid data (id) is sent in a POST body to the "apiteacher/homeworkbyId"
    endpoint, the response status code should be 403, and the response body's message should be "failed."
      Given "TIMUR" Page User sets "apiteacher/homeworkbyId" parameters
      Then User sends a POST request to homeworkById page
      Then Execute a verification for an invalid authorization

      Scenario: [TC003] The content of the "list" data in the response body should be verified to match the specified data.
        Given "TEACHER" Page User sets "apiteacher/homeworkbyId" parameters
        Then User sends a POST request to homeworkById page
        Then Validate the informations in response body