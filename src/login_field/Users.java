package login_field;

import java.util.HashMap;

public final class Users {
    private static final HashMap<String, String> users = new HashMap<>();

    public static boolean signUp(String username, String password) {
        if(users.containsKey(username)){
            return false;
        }
        users.put(username, password);
        return true;
    }

    public static boolean[] login(String username, String password) {
        boolean[] validity = {false, false};
        if(users.containsKey(username)) {
            validity[0] = true;
            if(users.get(username) == password) {
                validity[1] = true;
            }
        }
        return validity;
    }
    protected HashMap<String, String> getUsers() {
        return users;
    }
}
