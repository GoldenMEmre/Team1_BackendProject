Feature: [API_US003] As an administrator, I want to create a new visitor purpose record through API connection.

  Scenario: [TC_001] POST Request Success Response for the Visitor Purpose Add

    Given Api kullanicisi "api/visitorsPurposeAdd" path parametreleri set eder.
    Then "Veli Ziyareti", "Veli Ziyareti İçin Gelindi" icin Post request gonderilir.