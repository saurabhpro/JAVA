- Driver: Knows how to get a connection to the database
- Connection: Knows how to communicate with the database
- Statement: Knows how to run the SQL
- ResultSet: Knows what was returned by a SELECT query

- The first parameter is the ResultSet type. The second parameter is the ResultSet concurrency mode.
  		
- When a Statement is requested with an unsupported mode, the JDBC driver will downgrade the request to one that is supported.
   
- By default, a Statement is not scrollable. The first call to previous() throws a SQLException because the ResultSet type is TYPE_FORWARD_ONLY.
