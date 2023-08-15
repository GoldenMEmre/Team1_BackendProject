Feature: As an administrator, I want to update the registered Visitors' information in the system through API connection.
  Scenario: [TC001] api/visitorsUpdate endpoint'ine gecerli authorization bilgileri ve dogru datalar
  (id, purpose, name, contact, id_proof, no_of_people, date, in_time, out_time, note) iceren
  bir PATCH body gönderildiginde dönen status code'in 200 oldugu ve response body'deki message
  bilgisinin "Success" oldugu dogrulanmalı.

    Given "ADMIN" Page User sets "api/visitorsUpdate" parameters
    Then User sends a PATCH request to visitorsUpdate endpoint with id 232
    Then Execute a verification for a valid authorization

    Scenario: [TC002] api/visitorsUpdate endpoint'ine gecersiz authorization bilgileri veya eksik/yanlış data
    (id) iceren bir PATCH body (purpose, name, contact, id_proof, no_of_people, date, in_time, out_time, note)
    gönderildiginde dönen status code'in 403 oldugu ve response body'deki message bilgisinin "failed" oldugu dogrulanmalı.

      Given "OGUN" Page User sets "api/visitorsUpdate" parameters
      Then User sends a PATCH request to visitorsUpdate endpoint with id 232
      Then Execute a verification for an invalid authorization

      Scenario: [TC003] Response body icindeki updateId bilgisinin api/visitorsUpdate endpoint'ine gönderilen
      PATCH request body icindeki id bilgisi ile ayni oldugu dogrulanmalı.

        Given "ADMIN" Page User sets "api/visitorsUpdate" parameters
        Then User sends a PATCH request to visitorsUpdate endpoint with id 232 and compare id with response id


       Scenario: [TC004] API uzerinden güncellenmek istenen visitor kaydının güncellendiği,
       API uzerinden dogrulanmalıdır. Bu doğrulama için, response body'de dönen updateId ile api/visitorsId
       endpoint'ine POST body gönderilerek kaydın bilgilerini almak mümkündür. Bu sayede kaydın güncellendiği doğrulanabilir.
         Given "ADMIN" Page User sets "api/visitorsId" parameters
         Then User sends a POST request to visitorsId endpoint
         Then Execute a verification for a valid authorization
