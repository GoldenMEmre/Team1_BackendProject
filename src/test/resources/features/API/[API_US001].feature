@API
Feature: [API_US001] As an administrator, I want to access the Purpose List through an API connection.

  Scenario: [TC_001] GET Request Success Response for the Visitor Purpose List

    Given Api kullanicisi "api/visitorsPurposeList" path parametreleri set eder.
    When With "Valid" authorization credentials are sent GET request must status: "200" and message: "Success"

  Scenario: [TC_002] GET Request Failed Response for the Visitor Purpose List

    Given Api kullanicisi "api/visitorsPurposeList" path parametreleri set eder.
    When With "InValid" authorization credentials are sent GET request must status: "403" and message: "failed"


