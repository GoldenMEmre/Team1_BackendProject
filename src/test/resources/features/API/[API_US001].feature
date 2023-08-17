@mg
Feature:[API_US001] As an administrator, I want to access the Visitors Purpose List through an API connection.

  Scenario:[TC_001] GET Request Success Response for the Visitor Purpose List

    Given "ADMIN" Page User sets "api/visitorsPurposeList" parameters
    Then User sends a get request
    Then Execute a verification for a valid authorization

  Scenario:[TC_002] GET Request Failed Response for the Visitor Purpose List

    Given "EMRE" Page User sets "api/visitorsPurposeList" parameters
    Then User sends a get request
    Then Execute a verification for an invalid authorization

  Scenario:[TC_003] The First Item of the Visitor Purpose List is validated

    Given "ADMIN" Page User sets "api/visitorsPurposeList" parameters
    #Then User sends a get request
    And Validate the First Item of the Visitor Purpose List


