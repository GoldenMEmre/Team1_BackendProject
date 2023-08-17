Feature: US045 As an administrator (teacher), I want to create a new Homework record through API connection.




  Scenario: TC01 When valid authorization and correct data (class_id, section_id, session_id, subject_group_subject_id, subject_id,
  homework_date, submit_date, marks, description, create_date, evaluation_date, document, created_by, evaluated_by) are sent in a POST body to the "apiteacher/homeworkAdd" endpoint,
  the response status code should be 200, and the response body's message should be "Success."

    * "TEACHER" Page User sets "apiteacher/homeworkAdd" parameters
    * User sends a POST request for homeworkAdd
    * Execute a verification for a valid authorization


  Scenario:TC02 When invalid authorization or incorrect/missing data (class_id, section_id, session_id, subject_group_subject_id, subject_id, homework_date, submit_date, marks, description, create_date, evaluation_date, document, created_by, evaluated_by) are sent in a POST body to the "apiteacher/homeworkAdd" endpoint,
  the response status code should be 403, and the response body's message should be "failed."

  Scenario: TC03 The successful creation of a new homework record can be verified through the API. The response body should contain an "addId" field, and this ID can be used to
  verify the newly created record by sending a POST body to the "apiteacher/homeworkbyId" endpoint.

    * "TEACHER" Page User sets "apiteacher/homeworkbyId" parameters
    * User sends a POST request for homeworkbyId
    * Validate ID 5 in request body and response body




