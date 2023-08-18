Feature: US014 As an administrator, I want to access the Vehicle information of a vehicle with a given ID through API connection.

Scenario: TC01 When valid authorization information and correct data (id) are sent in the POST body to the api/vehicleId endpoint,
    the expected status code is 200, and the message in the response body should be "Success."

   * "ADMIN" Page User sets "api/vehicleId" parameters
   * User sends a POST request to vehicleId
   * Execute a verification for a valid authorization

  Scenario: TC02 invalid authorization information or invalid data (id) are sent in the POST body to the api/vehicleId endpoint,
   the expected status code is 403, and the message in the response body should be "failed."

    * "ADMINGulten" Page User sets "api/vehicleId" parameters
    * User sends a POST request to vehicleId
    * Execute a verification for an invalid authorization

    Scenario: TC03 The content of the list in the response body should be validated. Specifically, the data in the response body should include the following attributes: id, vehicle_no, vehicle_model, vehicle_photo, manufacture_year, registration_number,
    chasis_number, max_seating_capacity, driver_name, driver_licence, driver_contact, note, created_at.

      * "ADMIN" Page User sets "api/vehicleId" parameters
      * User sends a POST request to vehicleId
      * Response body content test for vehicleId



