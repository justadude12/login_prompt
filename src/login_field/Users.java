package login_field;

import javafx.beans.property.MapProperty;
import javafx.beans.property.SimpleMapProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

public final class Users {
    ObservableMap<String, String> users = FXCollections.observableHashMap();
    MapProperty<String, String> user = new SimpleMapProperty(users);

    public ObservableMap<String, String> getUsers() {
        return users;
    }
}
