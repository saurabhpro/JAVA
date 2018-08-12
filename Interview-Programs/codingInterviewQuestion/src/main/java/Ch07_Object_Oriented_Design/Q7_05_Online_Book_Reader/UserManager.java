package Ch07_Object_Oriented_Design.Q7_05_Online_Book_Reader;

import Ch07_Object_Oriented_Design.Q7_05_Online_Book_Reader.model.User;

import java.util.HashMap;

public class UserManager {
    private HashMap<Integer, User> users;

    public User addUser(int id, String details, int accountType) {
        User user = new User(id, details, accountType);
        users.putIfAbsent(id, user);
        return user;
    }

    public boolean remove(User u) {
        return remove(u.getID());
    }

    private boolean remove(int id) {
        return users.entrySet().removeIf(users -> users.getKey() == id);
    }

    public User find(int id) {
        return users.get(id);
    }
}
