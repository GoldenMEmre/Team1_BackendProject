
  Feature: As a user (student), I want to update my registered daily assignment information in the system through API connection

    Scenario: TC_001 POST request success response with valid information for a api student dailyAssignmentUpdate

      * "STUDENT" Page User sets "apistudent/dailyAssignmentUpdate" parameters
      *  PATCH request is sent for apistudentdailyAssignmentUpdate
      * Execute a verification for a valid authorization




      @ab
    Scenario: TC_002 POST request failed response with invalid information for  api student dailyAssignmentUpdate

      * "STUDENT" Page User sets "apistudent/dailyAssignmentUpdate" parameters
      *  PATCH request is sent for apistudentdailyAssignmentUpdate
      *  Execute a verification for an invalid authorization

