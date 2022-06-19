package login_field;

import javafx.beans.value.ObservableBooleanValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class LoginPrompt {
    //Constants for the class
    private static final double L_WIDTH = 300;
    private static final double L_HEIGHT = 170;
    //Attributes of the login prompt
    private final Pane pane;
    private final TextField usernameField;
    private final TextField passwordField;
    private final Label usernameLabel;
    private final Label passwordLabel;
    private final Button validate;
    private final HashMap<String, String> cacheUsers;
    private final Label logged;
    private final Button signIn;
    private boolean sign;

    /**
     * Public constructor for the login prompt, that is
     * never used, except for automatically in the call plane,
     * or when logging out
     */
    public LoginPrompt(Users users) {
        //Initialising all the attributes
        this.pane = new Pane();
        this.usernameField = new TextField();
        this.passwordField = new TextField();
        this.usernameLabel = new Label("Username : ");
        this.passwordLabel = new Label("Password : ");
        this.validate = new Button("Login");
        this.cacheUsers = users.getUsers();
        this.logged = new Label();
        this.signIn = new Button("Sign Up?");
        this.sign = false;

        //Setting the size for the attributes
        pane.setMaxSize(L_WIDTH, L_HEIGHT);
        pane.setMinSize(L_WIDTH, L_HEIGHT);
        usernameField.setMinSize(150, 30);
        usernameField.setMaxSize(150, 30);
        passwordField.setMinSize(150, 30);
        passwordField.setMaxSize(150, 30);
        usernameLabel.setMinSize(100, 30);
        usernameLabel.setMaxSize(100, 30);
        passwordLabel.setMinSize(100, 30);
        passwordLabel.setMaxSize(100, 30);
        validate.setMaxSize(50, 30);
        validate.setMinSize(50, 30);
        logged.setMaxSize(90, 30);
        logged.setMinSize(90, 30);
        signIn.setMaxSize(90, 30);
        signIn.setMinSize(90, 30);
        //cond[0] is true if login successful, cond[1] true if you can sign up

        //Adding the attributes to the pane
        pane.getChildren().add(usernameField);
        pane.getChildren().add(passwordField);
        pane.getChildren().add(usernameLabel);
        pane.getChildren().add(passwordLabel);
        pane.getChildren().add(validate);
        pane.getChildren().add(logged);
        pane.getChildren().add(signIn);

        //Setting the correct placement for each attribute
        usernameLabel.setLayoutX(20);
        usernameLabel.setLayoutY(20);
        usernameField.setLayoutX(130);
        usernameField.setLayoutY(20);
        passwordLabel.setLayoutX(20);
        passwordLabel.setLayoutY(70);
        passwordField.setLayoutX(130);
        passwordField.setLayoutY(70);
        validate.setLayoutX(200);
        validate.setLayoutY(120);
        logged.setLayoutX(20);
        logged.setLayoutY(120);
        signIn.setLayoutX(20);
        signIn.setLayoutY(120);
        logged.setVisible(false);
        signIn.setVisible(false);

        //Giving the Login button functionality
        validate.setOnAction(e -> {
            if(Users.login(usernameField.getText(), passwordField.getText())[0]) {
                if(Users.login(usernameField.getText(), passwordField.getText())[1]) {
                    logged.setText("Success!");
                    logged.setVisible(true);
                } else {
                    logged.setText("Wrong Combination");
                    logged.setVisible(true);
                }
            } else {
                signIn.setVisible(true);
            }
        });

        usernameField.setOnMouseClicked(e -> {
            logged.setVisible(false);
            signIn.setVisible(false);
            sign = false;
        });
        passwordField.setOnMouseClicked(e -> {
            logged.setVisible(false);
            signIn.setVisible(false);
            sign = false;
        });

        signIn.setOnAction(e -> sign = true);
    }

    public Pane pane() {
        return pane;
    }
}
