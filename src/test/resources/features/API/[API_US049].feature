

  Feature: As an administrator (teacher), I want to access the Questions information of a question with a given ID through API connection.

    @sg
    Scenario: TC_001 POST request success response with valid information for question Details By Id

      * "TEACHER" Page User sets "apiteacher/questionDetailsById" parameters
      * User sends a get request
      #* POST request is sent for questionDetailsById
      #* Execute a verification for a valid authorization

    Scenario: TC_002 POST request failed response with invalid information for question Details By Id

      * "INVALID" Page User sets "apiteacher/questionDetailsById" parameters
      * POST request is sent for questionDetailsById
      * Execute a verification for an invalid authorization

    Scenario: TC_003 Verifies the contents of the list data in the response body content

      * "TEACHER" Page User sets "apiteacher/questionDetailsById" parameters
      * POST request is sent for questionDetailsById
      * Response body content test for questionDetailsById

