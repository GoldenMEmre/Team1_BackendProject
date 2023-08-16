Feature: US045 As an administrator (teacher), I want to create a new Homework record through API connection.




  Scenario: TC01 When valid authorization and correct data (class_id, section_id, session_id, subject_group_subject_id, subject_id,
  homework_date, submit_date, marks, description, create_date, evaluation_date, document, created_by, evaluated_by) are sent in a POST body to the "apiteacher/homeworkAdd" endpoint,
  the response status code should be 200, and the response body's message should be "Success."

    * "TEACHER" Page User sets "apiteacher/homeworkAdd" parameters
    * User sends a POST request for homeworkAdd
    * Execute a verification for a valid authorization


  Scenario:TC02 When invalid authorization or incorrect/missing data (class_id, section_id, session_id, subject_group_subject_id, subject_id, homework_date, submit_date, marks, description, create_date, evaluation_date, document, created_by, evaluated_by) are sent in a POST body to the "apiteacher/homeworkAdd" endpoint,
  the response status code should be 403, and the response body's message should be "failed."

    * "TEACHERGulten" Page User sets "apiteacher/homeworkAdd" parameters
    * User sends a POST request for homeworkAdd
    * Execute a verification for an invalid authorization




