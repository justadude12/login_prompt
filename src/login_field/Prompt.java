package login_field;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;


public class Prompt {
    protected Pane pane;
    protected TextField usernameField;
    protected PasswordField passwordField;
    protected TextField passwordF;
    protected Label usernameLabel;
    protected Label passwordLabel;
    protected Button show;
    protected Users users;
    protected Button clearUsers;

    protected Prompt(Users users, Pane pane, TextField usernameField, PasswordField passwordField,
                     Label usernameLabel, Label passwordLabel, double pw, double ph,
                     double tw, double th, double lw, double lh) {
        this.pane = pane;
        this.usernameField = usernameField;
        this.passwordField = passwordField;
        this.usernameLabel = usernameLabel;
        this.passwordLabel = passwordLabel;
        this.users = new Users();
        this.show = new Button("*");
        this.passwordF = new TextField();
        this.clearUsers = new Button("del Users");

        setSize(this.pane, pw, ph);
        setSize(this.usernameField, tw, th);
        setSize(this.passwordField, tw, th);
        setSize(this.usernameLabel, lw, lh);
        setSize(this.passwordLabel, lw, lh);
        setSize(this.show, 30, 30);
        setSize(this.passwordF, tw, th);
        setSize(this.clearUsers, 100, 25);
        pane.getChildren().add(show);
        pane.getChildren().add(passwordF);
        pane.getChildren().add(clearUsers);

        show.setLayoutX(290);
        show.setLayoutY(70);
        passwordF.setVisible(false);
        passwordF.setLayoutX(130);
        passwordF.setLayoutY(70);

        show.setOnMousePressed(e -> {
            passwordF.setText(passwordField.getText());
            passwordField.setVisible(false);
            passwordF.setVisible(true);
        });
        show.setOnMouseReleased(e -> {
            passwordF.setVisible(false);
            passwordField.setVisible(true);
        });

        clearUsers.setOnMouseClicked(e -> {
            UserList.deleteUsers();
        });
    }

    private void setSize(Region node, double width, double heigth) {
        node.setMaxSize(width, heigth);
        node.setMinSize(width, heigth);
    }

    public void setUsers(Users users, String name, String word) {
        this.users.getUsers().put(name, word);
    }
}
