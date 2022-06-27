package login_field;

import javafx.beans.property.MapProperty;
import javafx.beans.property.SimpleMapProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

import java.io.File;
import java.util.Scanner;

public final class Users {
    ObservableMap<String, String> users = FXCollections.observableHashMap();
    MapProperty<String, String> user = new SimpleMapProperty(users);

    public Users() {
        UserList.createUserFile();
        try {
            Scanner reader = new Scanner(UserList.createUserFile());
            int i = 0;
            String name = "";
            String word = "";
            while(reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
                if(i % 2 == 0) {
                    name = data;
                } else {
                    word = data;
                    users.put(name, word);
                }
            }
        } catch (Exception e) {

        }
    }
    public ObservableMap<String, String> getUsers() {
        return users;
    }
}
