
  Feature: API_US035 As an administrator, I want to create a new Visitor record through API connection.

    Scenario: TC_001 POST request success response with valid information for visitor Add

      * "ADMIN" Page User sets "api/visitorsAdd" parameters
      * POST request is sent for visitorAdd
      * Execute a verification for a valid authorization

    Scenario: TC_002 POST request failed response with invalid information for visitor Add

      * "INVALID" Page User sets "api/visitorsAdd" parameters
      * POST request is sent for visitorAdd
      * Execute a verification for an invalid authorization



    Scenario: TC_003 It is verified that a new visitor has been added

      * "ADMIN" Page User sets "api/visitorsAdd" parameters
      * POST request is sent for visitorAdd
      * Response body content test for visitor Add