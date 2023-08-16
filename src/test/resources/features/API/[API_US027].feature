
  Feature: As an administrator, I want to be able to delete an Alumni record from the system through API connection



      @s
    Scenario: TC_004  When valid authorization information and the correct data (id) are sent in a
        DELETE body to the api/alumniDelete endpoint, the expected status code is 200, and the message
        in the response body should be "Success."


      * "ADMIN" Page User sets "api/alumniAdd" parameters
      * To create a new body that contains the valid authorization information and correct data
      *  verification of id in delete request body
