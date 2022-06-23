package login_field;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;

public class Prompt {
    protected Pane pane;
    protected TextField usernameField;
    protected TextField passwordField;
    protected Label usernameLabel;
    protected Label passwordLabel;
    protected Users users;

    protected Prompt(Users users, Pane pane, TextField usernameField, TextField passwordField,
                     Label usernameLabel, Label passwordLabel, double pw, double ph,
                     double tw, double th, double lw, double lh) {
        this.pane = pane;
        this.usernameField = usernameField;
        this.passwordField = passwordField;
        this.usernameLabel = usernameLabel;
        this.passwordLabel = passwordLabel;
        this.users = new Users();
        setSize(this.pane, pw, ph);
        setSize(this.usernameField, tw, th);
        setSize(this.passwordField, tw, th);
        setSize(this.usernameLabel, lw, lh);
        setSize(this.passwordLabel, lw, lh);
    }

    private void setSize(Region node, double width, double length) {
        node.setMaxSize(width, length);
        node.setMinSize(width, length);
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
