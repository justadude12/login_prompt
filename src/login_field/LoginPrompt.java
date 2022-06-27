package login_field;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

import java.util.Objects;

public final class LoginPrompt extends Prompt{
    //Constants for the class
    private static final double PANE_WIDTH = 320;
    private static final double PANE_HEIGHT = 170;
    private static final double TEXTFIELD_WIDTH = 150;
    private static final double TEXTFIELD_HEIGHT = 30;
    private static final double LABEL_WIDTH = 100;
    private static final double LABEL_HEIGHT = 30;
    //Attributes of the login prompt
    private final Button validate;
    private final Label logged;
    private final Button signIn;
    private final BooleanProperty sign;

    /**
     * Public constructor for the login prompt, that is
     * never used, except for automatically in the call plane,
     * or when logging out
     */
    public LoginPrompt(Users users) {
        //Initialising all the attributes
        super(users,
                new Pane(),
                new TextField(),
                new PasswordField(),
                new Label("Username : "),
                new Label("Password : "),
                PANE_WIDTH, PANE_HEIGHT,
                TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT,
                LABEL_WIDTH, LABEL_HEIGHT);
        this.validate = new Button("Login");
        this.logged = new Label();
        this.signIn = new Button("Sign Up?");
        this.sign = new SimpleBooleanProperty(false);

        //Setting the size for the attributes
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
        signIn.setLayoutX(200);
        signIn.setLayoutY(120);
        logged.setVisible(false);
        signIn.setVisible(false);

        //Giving the Login button functionality
        validate.setOnMouseClicked(e -> {
            if (users.getUsers().containsKey(usernameField.getText())) {
                if (Objects.equals(users.getUsers().get(usernameField.getText()), passwordField.getText())) {
                    logged.setText("Success!");
                } else {
                    logged.setText("Wrong Password");
                    validate.setVisible(false);
                    signIn.setVisible(true);
                }
            } else {
                logged.setText("No such user");
                validate.setVisible(false);
                signIn.setVisible(true);
            }
            logged.setVisible(true);
        });


        usernameField.setOnMouseClicked(e -> {
            logged.setVisible(false);
            signIn.setVisible(false);
            validate.setVisible(true);
            usernameField.setText("");
        });
        passwordField.setOnMouseClicked(e -> {
            logged.setVisible(false);
            signIn.setVisible(false);
            validate.setVisible(true);
            passwordField.setText("");
        });

        signIn.setOnMouseClicked(e -> {
            sign.setValue(true);
            signIn.setVisible(false);
            validate.setVisible(true);
            logged.setVisible(false);
            usernameField.setText("");
            passwordField.setText("");
        });
        usernameField.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER) {
                if (users.getUsers().containsKey(usernameField.getText())) {
                    if (Objects.equals(users.getUsers().get(usernameField.getText()), passwordField.getText())) {
                        logged.setText("Success!");
                    } else {
                        logged.setText("Wrong Password");
                        validate.setVisible(false);
                        signIn.setVisible(true);
                    }
                } else {
                    logged.setText("No such user");
                    validate.setVisible(false);
                    signIn.setVisible(true);
                }
                logged.setVisible(true);
            }
        });
        passwordField.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER) {
                if (users.getUsers().containsKey(usernameField.getText())) {
                    if (Objects.equals(users.getUsers().get(usernameField.getText()), passwordField.getText())) {
                        logged.setText("Success!");
                    } else {
                        logged.setText("Wrong Password");
                        validate.setVisible(false);
                        signIn.setVisible(true);
                    }
                } else {
                    logged.setText("No such user");
                    validate.setVisible(false);
                    signIn.setVisible(true);
                }
                logged.setVisible(true);
            }
        });
    }

    public Pane pane() {
        return pane;
    }
    public BooleanProperty sign() {
        return this.sign;
    }
}
