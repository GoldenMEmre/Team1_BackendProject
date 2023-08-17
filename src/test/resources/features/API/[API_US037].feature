Feature: As an administrator, I want to be able to delete a Visitors' record from the system through API connection.
@oerd
  Scenario: api/visitorsDelete endpoint'ine gecerli authorization bilgileri ve dogru data (id)
  iceren bir DELETE body gönderildiginde dönen status code'in 200 oldugu ve response body'deki message
  bilgisinin "Success" oldugu dogrulanmali
    Given "ADMIN" Page User sets "api/visitorsAdd" parameters
    Then User sends a POST request to create a visitor
    Then Execute a verification for a valid authorization
    Given "ADMIN" Page User sets "api/visitorsDelete" parameters
    Then User sends a DELETE request
    Then Execute a verification for a valid authorization
  @oerd
    Scenario: api/visitorsDelete endpoint'ine gecersiz authorization bilgileri veya yanlis data (id) iceren
    bir DELETE body gönderildiginde dönen status code'in 403 oldugu ve response body'deki message bilgisinin
    "failed" oldugu dogrulanmalı.
      Given "OGUN" Page User sets "api/visitorsDelete" parameters
      Then User sends a DELETE request
      Then Execute a verification for an invalid authorization
  @oerd
      Scenario: Response body icindeki DeletedId bilgisinin api/visitorsDelete endpoint'ine gönderilen
      DELETE request body icindeki id bilgisi ile ayni oldugu dogrulanmalı.
        Given "ADMIN" Page User sets "api/visitorsAdd" parameters
        Then User sends a POST request to create a visitor
        Then Execute a verification for a valid authorization
        Given "ADMIN" Page User sets "api/visitorsDelete" parameters
        Then User sends a DELETE request and compare the ids in request and response body
  @oerd
        Scenario: API uzerinden silinmek istenen visitor kaydının silindiği, API uzerinden dogrulanmalıdır.
        Bu doğrulama için, response body'de dönen DeletedId ile api/visitorsId endpoint'ine POST body gönderilerek
        kaydın bilgilerini almak mümkündür. Eğer ilgili id bilgisiyle alınan kayıt bulunamıyorsa, kaydın başarılı
        bir şekilde silindiği doğrulanabilir.
          Given "ADMIN" Page User sets "api/visitorsId" parameters
          Then User sends a POST request to check the latest created visitor
          Then Execute a verification for an invalid authorization
