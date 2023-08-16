

  Feature: API_US049 As an administrator (teacher), I want to access the Questions information of a question with a given ID through API connection.

    Scenario: TC_001 POST request success response with valid information for question Details By Id

      * "TEACHER" Page User sets "apiteacher/questionDetailsById" parameters
      * POST request is sent for questionDetailsById
      * Execute a verification for a valid authorization

