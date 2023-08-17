Feature: US13 As an administrator, I want to access the Vehicle List through API connection.

  Scenario:  TC01 When a valid authorization information is used to send a GET request to the api/vehicleList endpoint,
  the expected status code is 200, and the message in the response body should be "Success."

    * "ADMIN" Page User sets "api/vehicleList" parameters
    * User sends a get request
    * Execute a verification for a valid authorization

 Scenario: TC02 When invalid authorization information is used to send a GET request to the api/vehicleList endpoint,
 the expected status code is 403, and the message in the response body should be "failed."

   * "ADMINGulten" Page User sets "api/vehicleList" parameters
   * User sends a get request
   * Execute a verification for an invalid authorization

    Scenario:TC03 The content of the list in the response body should be validated. Specifically, the content of the data with ID
    "1" in the lists should have the following attributes: vehicle_no as "VH1001," vehicle_model as "Volvo Bus," vehicle_photo as "1677502387-149436744063fca7b3a1796!fd.png,"
    manufacture_year as "2017," registration_number as "FVFF-08797865," chasis_number as "45453," max_seating_capacity as "50," driver_name as "Michel,"
    driver_licence as "R534534," driver_contact as "8667777869," note as empty, and created_at as "2023-02-27 07:53:07."

      * "ADMIN" Page User sets "api/vehicleList" parameters
      * Response body content test for vehicle list






