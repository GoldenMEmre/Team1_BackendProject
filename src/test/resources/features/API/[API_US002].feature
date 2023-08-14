@sg
Feature: [API_US002] As an administrator, I want to access the Visitor Purpose information of a user with a given ID through API connection.

  Scenario: [TC_001] POST Request Success Response Test for the Visitor PurposeId

    Given "ADMIN" Page User sets "api/visitorsPurposeId" parameters
    Then "Veli Ziyareti", "Veli Ziyareti İçin Gelindi" icin Post request gonderilir.
    Then Execute a verification for a valid authorization

  Scenario: [TC_002] POST Request Failed Response Test for the Visitor PurposeId

    Given "ADMIN" Page User sets "api/visitorsPurposeId" parameters
    Then "Veli Ziyareti", "Veli Ziyareti İçin Gelindi" icin Post request gonderilir.
    Then Execute a verification for a valid authorization

  Scenario: [TC_003] POST Request Success Response Test for the Visitor PurposeId

    Given "ADMIN" Page User sets "api/visitorsPurposeId" parameters
    Then "Veli Ziyareti", "Veli Ziyareti İçin Gelindi" icin Post request gonderilir.
    Then Execute a verification for a valid authorization
