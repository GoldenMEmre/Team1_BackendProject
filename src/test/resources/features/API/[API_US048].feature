
  Feature: As an administrator (teacher), I want to access the Questions List through API connection.
         @DN
    Scenario: TC_001 GET request success response with valid information for a api teacher/questionList


           * "TEACHER" Page User sets "apiteacher/questionList" parameters
           * User sends a get request
           * Execute a verification for a valid authorization

    Scenario: TC_002 GET request failed response with invalid information for api teacher/questionList

     * "DGVALID" Page User sets "apiteacher/questionList" parameters
      * User sends a get request
     * Execute a verification for an invalid authorization


    Scenario: TC_003 Validates information of data with id=70 in response body content

      * "TEACHER" Page User sets "apiteacher/questionList" parameters
      * User sends a get request
      * Response body content test for teacherquestionList



