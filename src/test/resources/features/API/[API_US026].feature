
  Feature: As an administrator, I want to update the registered Alumni information in the system through API connection


    Scenario: TC_001 PATCH request success response with valid information for alumniUpdate

      Given "ADMIN" Page User sets "api/alumniUpdate" parameters
      Then User sends a PATCH request to  alumniUpdate endpoint
      Then Execute a verification for a valid authorization



     Scenario:TC_002 PATCH request failed response with invalid information for alumniUpdate

          Given "DGVALID" Page User sets "api/alumniUpdate" parameters
          Then User sends a PATCH request to  alumniUpdate endpoint
          Then Execute a verification for an invalid authorization


       Scenario: TC_003 The updateId  in the response body should be the same as the updateId in the request body.

         Given "ADMIN" Page User sets "api/alumniUpdate" parameters
         Then  Expected data is created, and the equality of the ID information is verified.
         Then Execute a verification for a valid authorization


         Scenario: TC_004 The API should successfully update the desired Alumni record, and this can be verified
         by sending the updateId from the response body to the
         api/alumniId endpoint in a POST body to retrieve the updated Alumni record.

           Given "ADMIN" Page User sets "api/alumniUpdate" parameters
           Then User sends a PATCH request to  alumniUpdate endpoint
           Then Response body content test for api alumniUpdate




