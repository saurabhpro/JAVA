package ooad;

import java.util.List;

/**
 * Since Organization has Person as employees, the relationship between them is Aggregation.
 * HAS-A
 */
public class OrganizationWithAggregatedPerson {
    //non final - we can have employees or we don't Its ok
    private List<Person> employees;
}

class Person {
    private String name;
}

