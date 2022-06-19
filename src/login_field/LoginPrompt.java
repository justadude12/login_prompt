package login_field;

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
    private List<Boolean> conditions;
    private ObservableList<Boolean> condition;
    private Label logged;
    private boolean cond;
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
        this.conditions = new ArrayList<>();
        this.condition = FXCollections.observableList(conditions);
        this.logged = new Label();
        cond = false;
        conditions.add(false);
        conditions.add(false);

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
        logged.setMaxSize(50, 20);
        logged.setMinSize(50, 20);
        System.out.println(conditions.size());
        //cond[0] is true if login successful, cond[1] true if you can sign up

        //Adding the attributes to the pane
        pane.getChildren().add(usernameField);
        pane.getChildren().add(passwordField);
        pane.getChildren().add(usernameLabel);
        pane.getChildren().add(passwordLabel);
        pane.getChildren().add(validate);
        pane.getChildren().add(logged);

        //Setting the correct placement for each attribute
        usernameLabel.setLayoutX(20);
        usernameLabel.setLayoutY(20);
        usernameField.setLayoutX(130);
        usernameField.setLayoutY(20);
        passwordLabel.setLayoutX(20);
        passwordLabel.setLayoutY(70);
        passwordField.setLayoutX(130);
        passwordField.setLayoutY(70);
        validate.setLayoutX(125);
        validate.setLayoutY(120);
        logged.setLayoutX(125);
        logged.setLayoutY(150);
        logged.setVisible(false);

        List<Boolean> conditions = new ArrayList();
        condition.addListener((ListChangeListener<? super Boolean>) c -> {
            /**if(conditions.get(0) == true) {
                logged.setText("Success");
            } else {
                if(conditions.get(1) == true) {
                    logged.setText("Sign Up?");
                } else {
                    logged.setText("Wrong combo");
                }
            }
            logged.setVisible(true);
             */
            if(cond){
                logged.setText("Sign Up?");
                logged.setVisible(true);
            }
        });

        //Giving the Login button functionality
        validate.setOnAction(e -> {
            if(Users.login(usernameField.getText(), passwordField.getText())[0]) {
                if(Users.login(usernameField.getText(), passwordField.getText())[1]) {
                    conditions.set(0, true);
                } else {
                    conditions.set(0, false);
                }
                conditions.set(0, false);
            } else {
                //conditions.set(1, true);
                cond = true;
                logged.setText("Sign Up?");
                logged.setVisible(true);
            }
        });

        usernameField.setOnMouseClicked(e -> logged.setVisible(false));
        passwordField.setOnMouseClicked(e -> logged.setVisible(false));
    }

    public Pane pane() {
        return pane;
    }
}
