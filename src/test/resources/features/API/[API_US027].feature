
  Feature: As an administrator, I want to be able to delete an Alumni record from the system through API connection

      @oo
      Scenario:TC_001 When valid authorization information and the correct data (id) are sent in a DELETE body to the api/alumniDelete endpoint,
    the expected status code is 200, and the message in the response body should be "Success."

        Given "ADMIN" Page User sets "api/alumniAdd" parameters
        Then  user send a post request alumni delete
        Then Execute a verification for a valid authorization
        Given "ADMIN" Page User sets "api/alumniDelete" parameters
        Then  user send a delete request to alumni  delete
        Then Execute a verification for a valid authorization


    Scenario: TC_002 When invalid authorization information or incorrect data (id) is sent in a DELETE body to the api/alumniDelete endpoint,
      the expected status code is 403, and the message in the response body should be "failed."
      Given "INVALIDADMIN" Page User sets "api/alumniDelete" parameters
      Then  user send a delete request to alumni  delete
      Then Execute a verification for an invalid authorization



    Scenario:TC_003 The DeletedId in the response body should match the id sent in the DELETE
       request body to the api/alumniDelete endpoint.

      Given "ADMIN" Page User sets "api/alumniAdd" parameters
      Then  user send a post request alumni delete
      Then Execute a verification for a valid authorization
      Given "ADMIN" Page User sets "api/alumniDelete" parameters
      Then  user send a delete request to alumni  delete
      Then validate deleted id in requestbody and response body


    Scenario: TC_004  When valid authorization information and the correct data (id) are sent in a
        DELETE body to the api/alumniDelete endpoint, the expected status code is 200, and the message
        in the response body should be "Success."

      Given "ADMIN" Page User sets "api/alumniAdd" parameters
      Then  user send a post request alumni id
      Then Execute a verification for a valid authorization