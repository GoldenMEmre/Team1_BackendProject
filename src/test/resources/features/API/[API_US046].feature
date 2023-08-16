Feature: As an administrator (teacher), I want to update the registered Homework information in the system through API connection.

  Scenario:
    When "TEACHER" Page User sets "apiteacher/homeworkUpdate" parameters
    Then User send a patch request to homework update  with id 423
    Then Execute a verification for a valid authorization


  Scenario: [TC_002] PATCH Request Failed Response for the Homework
    Given "Tuba" Page User sets "apiteacher/homeworkUpdate" parameters
    Then User send a patch request to homework update  with id 423
    Then Execute a verification for an invalid authorization

  Scenario: [TC_003]The "updateId" field in the response body should match the "id" field sent in the PATCH
    request body to the "apiteacher/homeworkUpdate" endpoint.
      When "TEACHER" Page User sets "apiteacher/homeworkUpdate" parameters
      Then User send a patch request to homework update  with id 423 and compare id with response id

  Scenario: [TC_004]The successful update of the homework record can be verified through the API
    When "TEACHER" Page User sets "apiteacher/homeworkbyId" parameters
    Then User send a post request to homeworkbyId
    Then Execute a verification for a valid authorization
