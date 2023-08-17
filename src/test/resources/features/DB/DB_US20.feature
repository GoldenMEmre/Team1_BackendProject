
Feature: DB_US20 Display the name information of the highest expense in the expenses table.

  Scenario: TC_001 Prints the name of the highest expense in the expenses table

    * Database connection established
    * Query20  is prepared
    * The query is sent to the Expenses table and the results are validated
    * Database connection established