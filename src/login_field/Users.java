package login_field;

import javafx.beans.property.MapProperty;
import javafx.beans.property.SimpleMapProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

import java.util.HashMap;

public final class Users {
    ObservableMap<String, String> users = FXCollections.observableHashMap();
    MapProperty<String, String> user = new SimpleMapProperty(users);

    public boolean signUp(String username, String password) {
        if(users.containsKey(username)){
            return false;
        }
        users.put(username, password);
        return true;
    }

    public boolean[] login(String username, String password) {
        boolean[] validity = {false, false};
        if(users.containsKey(username)) {
            validity[0] = true;
            if(users.get(username) == password) {
                validity[1] = true;
            }
        }
        return validity;
    }
    public ObservableMap<String, String> getUsers() {
        return users;
    }
}
