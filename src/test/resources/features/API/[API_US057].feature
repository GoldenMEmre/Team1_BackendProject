
Feature:[API_US057] As a user (student), I want to access my Student Information Details through API connection.

  Scenario:[TC_001] GET Request Success Response for the getStudent Class

    Given "STUDENT" Page User sets "apistudent/getStudentClass" parameters
    Then User sends a get request
    Then Execute a verification for a valid authorization

  Scenario:[TC_002] GET Request Failed Response for the getStudent Class

    Given "EMRE" Page User sets "apistudent/getStudentClass" parameters
    Then User sends a get request
    Then Execute a verification for an invalid authorization

  Scenario:[TC_003] The content of the student information details lists is validated

    Given "STUDENT" Page User sets "apistudent/studentInformationDetails" parameters
    Then User sends a get request
    And Validate the content of the student information details lists
