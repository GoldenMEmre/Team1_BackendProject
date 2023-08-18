Feature: [DB_US03] Verify that the email of the student in the students table with firstname Brian and lastname Kohlar is brain@gmail.com.
  @db
  Scenario: [TC_001] Verify that the email of the student in the students table with firstname Brian and lastname Kohlar is brain@gmail.com.

    * Dataabase connection established.
    * Query03 is being prepared
    * The query is sent to students table and results are validated
    * Database connection is closed