Feature: US11 As an administrator, I want to update the registered Alumni Events information in the system through API connection.

  Scenario:  TC01 When valid authorization information and correct data (id, title, event_for, session_id, section,
  from_date, to_date, note, event_notification_message, show_onwebsite) are sent in the PATCH body to the api/alumniEventsUpdate endpoint, the expected status
  code is 200, and the message in the response body should be "Success."


    * "ADMIN" Page User sets "api/alumniEventsUpdate" parameters
    * User sends a Patch request to end point with id 5
    * Execute a verification for a valid authorization

  Scenario:  TC02 When invalid authorization information or missing/wrong data (id) are sent in the PATCH body (with title, event_for,
  session_id, section, from_date, to_date, note, event_notification_message, show_onwebsite) to the api/alumniEventsUpdate endpoint,
  the expected status code is 403, and the message in the response body should be "failed."

    * "ADMINGulten" Page User sets "api/alumniEventsUpdate" parameters
    * User sends a Patch request to end point with id 5
    * Execute a verification for an invalid authorization

  @gh
  Scenario: TC03 The updateId information in the response body should be validated to be the same as
  the id information in the PATCH request body sent to the api/alumniEventsUpdate endpoint.
    * "ADMIN" Page User sets "api/alumniEventsUpdate" parameters
    * User sends a Patch request to end point with id 5 and compare id with response id

    Scenario:TC04 The successful update of the Alumni Events record via the API should be validated. (This can be confirmed by using the updateId returned in the response body
    to send a POST body to the api/alumniEventsId endpoint and verify the record is updated.)

      * "ADMIN" Page User sets "api/alumniEventsId" parameters
      * User sends a POST request to alumniEventsId
      * Execute a verification for a valid authorization




