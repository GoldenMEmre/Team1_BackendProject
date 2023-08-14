
  Feature: As an administrator, I want to access the Books List through API connection

    Scenario: TC_001 GET request success response with valid information for api booksList

      * "ADMIN" Page User sets "api/booksList" parameters
      * User sends a get request
      * Execute a verification for a valid authorization

    @pp
    Scenario: TC_002 GET request failed response with invalid information for api booksList

      * "INVALID" Page User sets "api/booksList" parameters
      * User sends a get request
      * Execute a verification for an invalid authorization



    Scenario: TC_003 Validates information of data with id=250 in response body content

      * "ADMIN" Page User sets "api/booksList" parameters
      * User sends a get request
      * Verifies that record includes "id", "book_title" , "book_no", "rack_no", "publish" , "author", "qty", "perunitcost", "postdate", "description" "available" , "is_active", "updated_at"










