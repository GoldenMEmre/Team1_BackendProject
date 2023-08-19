 Feature: Query_15;
@db
Scenario: List the books from the books table where the quantity (qty) value is between 100 and 500.
  * Dataabase connection established.
  * qty value query is prepared
  * A query is sent to the author data from the book table and the qty results are validated.
  * Database connection is closed