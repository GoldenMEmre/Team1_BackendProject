
Feature: [API_US001] As an administrator, I want to access the Purpose List through an API connection.

  Scenario: [TC_001] GET Request Success Response for the Visitor Purpose List

    Given "ADMIN" Page User sets "api/visitorsPurposeList" parameters
    Then User sends a get request
    Then Execute a verification for a valid authorization

  Scenario: [TC_002] GET Request Failed Response for the Visitor Purpose List

    Given "EMRE" Page User sets "api/visitorsPurposeList" parameters
    Then User sends a get request
    Then Execute a verification for an invalid authorization


