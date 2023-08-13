Feature: As an administrator, I want to access the Alumni Events List through API connection.

  Scenario: [TC_001] When a valid authorization information is sent with a GET request to the api/alumniEventsList endpoint,
  the expected status code is 200, and the message in the response body should be "Success."
    Given "ADMIN" Page User sets "api/alumniEventsList" parameters
    Then User sends a get request
    Then Execute a verification for a valid authorization

   Scenario: [TC_002] When invalid authorization information is sent with a GET request to the api/alumniEventsList endpoint,
    the expected status code is 403, and the message in the response body should be "failed."
      Given "OGUN" Page User sets "api/alumniEventsList" parameters
      Then User sends a get request
      Then Execute a verification for an invalid authorization

     Scenario: [TC_003] The content of the lists in the response body should be validated to contain data with ID "2,"
     where the title is "Reunion For 2020-21 Batch," event_for is "class," session_id is "15," class_id is "1,"
     section is "["1","2","3"]", from_date is "2021-03-07 00:00:00," to_date is "2021-03-10 00:00:00," note is empty,
     photo is empty, is_active is "0," event_notification_message is empty, show_onwebsite is "0," and
     created_at is "2021-03-23 02:53:47."



