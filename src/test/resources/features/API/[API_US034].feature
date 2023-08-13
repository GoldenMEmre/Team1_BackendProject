

  Feature: API_US034 As an administrator, I want to access the Visitor information of a visitor with a given ID through API connection.

    Scenario: TC_001 POST request success response with valid information for visitor

      * "ADMIN" Page User sets "api/visitorsId" parameters
      * POST request is sent for visitorId
      * Execute a verification for a valid authorization


    Scenario:

      * "INVALID" Page User sets "api/visitorsId" parameters
      * POST request is sent for visitorId
      * Execute a verification for an invalid authorization


    Scenario:

      * "ADMIN" Page User sets "api/visitorsId" parameters
      * POST request is sent for visitorId
      * Response body content test for visitor Id