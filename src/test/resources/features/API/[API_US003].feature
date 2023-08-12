Feature: [API_US003] As an administrator, I want to create a new visitor purpose record through API connection.
  @API
  Scenario: [TC_001] POST Request Success Response for the Visitor Purpose Add

    Given "ADMIN" Page User sets "api/visitorsPurposeList" parameters
    Then "Veli Ziyareti", "Veli Ziyareti İçin Gelindi" icin Post request gonderilir.
    Then Execute a verification for a valid authorization