

Feature: API_US033 As an administrator, I want to access the Visitor List through API connection.


  Scenario: TC_001 GET request success response with valid information for visitor list

    * "ADMIN" Page User sets "api/visitorsList" parameters
    * User sends a get request
    * Execute a verification for a valid authorization

  @sg
  Scenario: TC_002 GET request failed response with invalid information for visitor list

    * "INVALID" Page User sets "api/visitorsList" parameters
    * User sends a get request
    * Execute a verification for an invalid authorization


  Scenario: TC_003 Validates information of data with id=250 in response body content

    * "ADMIN" Page User sets "api/visitorsList" parameters
    * User sends a get request
    * Response body content test for visitor list