@mg
Feature: [API_US003] As an administrator, I want to create a new visitor purpose record through API connection.

  Scenario: [TC_001] POST Request Success Response for the Visitor Purpose Add

    Given "ADMIN" Page User sets "api/visitorsPurposeAdd" parameters
    Then "Veli Ziyareti", "Veli Ziyareti İçin Gelindi" icin Post request gonderilir.
    Then Execute a verification for a valid authorization

  Scenario: [TC_002] POST Request Failed Response for the Visitor Purpose Add

    Given "EMRE" Page User sets "api/visitorsPurposeAdd" parameters
    Then "Veli Ziyareti", "Veli Ziyareti İçin Gelindi" icin Post request gonderilir.
    Then Execute a verification for an invalid authorization

  Scenario:[TC_003] The First Item of the Visitor Purpose List is validated

    Given "ADMIN" Page User sets "api/visitorsPurposeAdd" parameters
    Then "Veli Ziyareti", "Veli Ziyareti İçin Gelindi" icin Post request gonderilir.
    And Validate the new visitors purposeId