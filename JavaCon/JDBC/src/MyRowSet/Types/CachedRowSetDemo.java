package MyRowSet.Types;

/**
 * Created by Saurabh on 11/28/2015. CachedRowSet also extends rowset interface and is a disconnected rowset. It acts as
 * a container for database records and caches them in memory.In a sense we may think of it as a subject of actual
 * record maintained in memory. This reminds us somewhat of the concept of "View" we can we create from actual table
 * through SQL.
 * <p>
 * Being disconnected, cachedRowSet is more lightweight.
 * <p>
 * This connection is established for a brief period of time only when certain changes is needed to be reflected on
 * cached data and ultimately propagated back to the actual database. However, this does not mean it lacks capability of
 * jdbcrowset; on the contrary it is equipped with additional capability of caching.
 * <p>
 * On the downside, connection has to be established every time to reflect any changes, performance may be slower than
 * jdbcrowset but on the upside it is lightweight and we can get a better efficiency when working with large amount of
 * data
 */
public class CachedRowSetDemo {
}
