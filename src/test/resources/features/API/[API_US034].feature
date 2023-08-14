

  Feature: API_US034 As an administrator, I want to access the Visitor information of a visitor with a given ID through API connection.

    Scenario: TC_001 POST request success response with valid information for visitor Id

      * "ADMIN" Page User sets "api/visitorsId" parameters
      * POST request is sent for visitorId
      * Execute a verification for a valid authorization


    Scenario: TC_002 POST request failed response with invalid information for visitor Id

      * "INVALID" Page User sets "api/visitorsId" parameters
      * POST request is sent for visitorId
      * Execute a verification for an invalid authorization


    Scenario: TC_003 Verifies the contents of the list data in the response body content

      * "ADMIN" Page User sets "api/visitorsId" parameters
      * POST request is sent for visitorId
      * Response body content test for visitor Id