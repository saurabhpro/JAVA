package Ch09_Scalability_and_Memory_Limits.Q9_02_Social_Network;

import java.util.HashMap;

class Machine {
    private final HashMap<Integer, Person> persons = new HashMap<>();
    public int machineID;

    public Person getPersonWithID(int personID) {
        return persons.get(personID);
    }
}
