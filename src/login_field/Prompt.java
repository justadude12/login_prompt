package login_field;

import javafx.collections.ObservableMap;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;

public class Prompt {
    protected Pane pane;
    protected TextField usernameField;
    protected TextField passwordField;
    protected PasswordField passwordF;
    protected Label usernameLabel;
    protected Label passwordLabel;
    protected Button show;
    protected Users users;
    protected boolean pwshow;

    protected Prompt(Users users, Pane pane, TextField usernameField, TextField passwordField,
                     Label usernameLabel, Label passwordLabel, double pw, double ph,
                     double tw, double th, double lw, double lh) {
        this.pane = pane;
        this.usernameField = usernameField;
        this.passwordField = passwordField;
        this.usernameLabel = usernameLabel;
        this.passwordLabel = passwordLabel;
        this.users = new Users();
        this.show = new Button();
        this.passwordF = new PasswordField();
        this.pwshow = false;
        setSize(this.pane, pw, ph);
        setSize(this.usernameField, tw, th);
        setSize(this.passwordField, tw, th);
        setSize(this.usernameLabel, lw, lh);
        setSize(this.passwordLabel, lw, lh);
        setSize(this.show, 30, 30);
        pane.getChildren().add(show);
        show.setLayoutX(290);
        show.setLayoutY(70);

        show.setOnMouseClicked(e -> {
            if(pwshow){
                passwordField.setVisible(false);
                passwordF.setVisible(true);
                passwordF.setText(passwordField.getText());
                pwshow = false;
                show.setText("*");
            } else {
                passwordF.setVisible(false);
                passwordField.setVisible(true);
                passwordField.setText(passwordF.getText());
                pwshow = true;
                show.setText("A");
            }
        });
    }

    private void setSize(Region node, double width, double length) {
        node.setMaxSize(width, length);
        node.setMinSize(width, length);
    }

    public void setUsers(Users users, String name, String word) {
        this.users.getUsers().put(name, word);
    }
}
