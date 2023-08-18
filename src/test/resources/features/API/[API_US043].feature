@mg
Feature:[API_US043] As an administrator (teacher), I want to access the Homework List through API connection.ction.

  Scenario:[TC_001] GET Request Success Response for the Visitor Purpose List

    Given "TEACHER" Page User sets "apiteacher/homeworkList" parameters
    Then User sends a get request
    Then Execute a verification for a valid authorization

  Scenario:[TC_002] GET Request Failed Response for the Visitor Purpose List

    Given "EMRE" Page User sets "apiteacher/homeworkList" parameters
    Then User sends a get request
    Then Execute a verification for an invalid authorization

  Scenario:[TC_003] The content of the homework lists is validated

    Given "TEACHER" Page User sets "apiteacher/homeworkList" parameters
    Then User sends a get request
    And Validate the content of the homework lists


