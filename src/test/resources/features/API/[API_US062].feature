Feature: As a user (student), I want to create a new daily assignment record through API connection.

  Scenario: [TC001] When valid authorization information and correct data (subject_group_subject_id,
  title, description, date, remark) are sent in a POST body to the "apistudent/dailyAssignmentAdd"
  endpoint, the response status code should be 200, and the response body's message should be "Success."
    Given "STUDENT" Page User sets "apistudent/dailyAssignmentAdd" parameters
    Then User sends a POST request for daily assignment add
    Then Execute a verification for a valid authorization

    Scenario: [TC002] When invalid authorization information or missing data (subject_group_subject_id,
    title, description, date, remark) are sent in a POST body to the "apistudent/dailyAssignmentAdd" endpoint,
    the response status code should be 403, and the response body's message should be "failed."
      Given "GAYE" Page User sets "apistudent/dailyAssignmentAdd" parameters
      Then User sends a POST request for daily assignment add
      Then Execute a verification for an invalid authorization

      Scenario: [TC003] The API should be verified to ensure that the new daily assignment record is created.
      (This can be confirmed by sending a POST body with the addId to the "apistudent/dailyAssignmentById"
      endpoint to retrieve the created record.)
        Given "STUDENT" Page User sets "apistudent/dailyAssignmentAdd" parameters
        Then User sends a POST request for daily assignment add
        Then Execute a verification for a valid authorization
        Given "STUDENT" Page User sets "apistudent/dailyAssignmentById" parameters
        Then User sends a POST request for daily assignment id
        Then Execute a verification for a valid authorization