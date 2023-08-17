Feature: [API_US022] As an administrator, I want to access the Alumni List through API connection.

  Scenario: [TC_001]   status code is 200, and the message in the response body should be "Success."

    * "ADMIN" Page User sets "api/alumniList" parameters
    * User sends a get request
    * Execute a verification for a valid authorization




  Scenario: [TC_002]   status code is 403, and the message in the response body should be "Failed".

    * "Gaye" Page User sets "api/alumniList" parameters
    * User sends a get request
    * Execute a verification for an invalid authorization


  Scenario: [TC_003] Verifies the contents of the list data in the response body content

    * "ADMIN" Page User sets "api/alumniId" parameters
    *  Response body content test for alumni List










