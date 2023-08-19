Feature: As an administrator, I want to access the Books List through API connection.

  @api
  Scenario: TC_001 PATCH request success response with valid information for alumniUpdate

    Given "ADMIN" Page User sets "api/booksList" parameters
    Then User sends a PATCH request to  alumniUpdate endpoint
    Then Execute a verification for a valid authorization


       @bb
  Scenario:TC_002 PATCH request failed response with invalid information for alumniUpdate

    Given "DGVALID" Page User sets "api/booksList" parameters
    Then User sends a PATCH request to  alumniUpdate endpoint
    Then Execute a verification for an invalid authorization


  @api
  Scenario:Response body (id "1", book_title: "Multiplication and Division Grades 3-4",
  book_no: "78878", isbn_no: "", subject: "", rack_no: "110", publish: "Barbara Bando", author: "Barbara Bando",
  qty: "100", perunitcost: "12.00", postdate: "2022-05-04",
  description: " The duo dump her in a nearby river after a failed attempt to hang her.
  Tonya survives, and the two men are arrested by Sheriff Ozzie Walls.",
  available: "yes", is_active: "no", created_at: "2022-05-02 03:02:39", updated_at": null) olduğu doğrulanmalı.


    Given "ADMIN" Page User sets "api/booksList" parameters
    Then User sends a get request
    *  Then Execute verification for given informations response body lıst
