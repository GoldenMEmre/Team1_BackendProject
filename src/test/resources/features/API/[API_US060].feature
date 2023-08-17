Feature:US60 As a user (student), I want to access my Daily Assignment List through API connection.

  @mh
  Scenario: TC01 When a valid authorization is used to send a GET request to the "apistudent/dailyAssignmentList" endpoint,
  the response status code should be 200, and the response message should be "Success."

    * "STUDENT" Page User sets "apistudent/dailyAssignmentList" parameters
    * User sends a get request
    * Execute a verification for a valid authorization

  Scenario: TC02 When invalid authorization is used to send a GET request to the "apistudent/dailyAssignmentList" endpoint,
  the response status code should be 403, and the response message should be "failed."

    * "STUDENTGulten" Page User sets "apistudent/dailyAssignmentList" parameters
    * User sends a get request
    * Execute a verification for an invalid authorization

  Scenario: TC03  The response body should contain a field called "lists," which includes multiple data entries. Each entry should have various fields such as "id," "student_session_id," "subject_group_subject_id," "title," "description," "attachment," "evaluated_by," "date," "evaluation_date," "remark," "created_at," "subject_name," "subject_code," and "subject_code."
  The content of each field should be verified to ensure the correctness of the response data.

    * "STUDENT" Page User sets "apistudent/dailyAssignmentList" parameters
    * Response body content test for dailyAssignmentList