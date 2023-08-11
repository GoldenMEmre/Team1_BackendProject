Feature: [API_US001] As an administrator, I want to access the Purpose List through an API connection.

  Scenario: [TC_001] GET Request Success Response for the Visitor Purpose List

    Given Api kullanicisi "api/visitorsPurposeList" path parametreleri set eder.
    Then VisitorsList icin Get request gonderilir.
    Then It is validated that the status code is 200 and the response message is Success




