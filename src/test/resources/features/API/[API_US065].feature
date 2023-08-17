
@sg
  Feature: API_US065 As a user (student), I want to access my Apply Leave information through API connection

    Scenario: TC_001 GET request success response with valid information for Apply Leave List

      * "STUDENT" Page User sets "apistudent/applyLeaveList" parameters
      * User sends a get request
      * Execute a verification for a valid authorization


    Scenario: TC_002 GET request success response with valid information for Apply Leave List

      * "INVALID" Page User sets "apistudent/applyLeaveList" parameters
      * User sends a get request
      * Execute a verification for an invalid authorization


    Scenario: TC_003 GET request success response with valid information for Apply Leave List

      * "STUDENT" Page User sets "apistudent/applyLeaveList" parameters
      * User sends a get request
      * Response body content test for Apply Leave List