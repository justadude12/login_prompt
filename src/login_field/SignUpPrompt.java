package login_field;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public final class SignUpPrompt extends Prompt{
    private static final double PANE_WIDTH = 300;
    private static final double PANE_HEIGHT = 170;
    private static final double TEXTFIELD_WIDTH = 150;
    private static final double TEXTFIELD_HEIGHT = 30;
    private static final double LABEL_WIDTH = 100;
    private static final double LABEL_HEIGHT = 30;
    private final Button signUp;
    private BooleanProperty sign;
    private final Label text;

    public SignUpPrompt(Users users) {
        super(users,
                new Pane(),
                new TextField(),
                new TextField(),
                new Label("Username : "),
                new Label("Password : "),
                PANE_WIDTH, PANE_HEIGHT,
                TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT,
                LABEL_WIDTH, LABEL_HEIGHT);
        this.signUp = new Button("Sign Up");
        this.sign = new SimpleBooleanProperty(false);
        this.text = new Label();
        pane.getChildren().add(usernameField);
        pane.getChildren().add(passwordField);
        pane.getChildren().add(usernameLabel);
        pane.getChildren().add(passwordLabel);
        pane.getChildren().add(signUp);
        pane.getChildren().add(text);

        usernameLabel.setLayoutX(20);
        usernameLabel.setLayoutY(20);
        usernameField.setLayoutX(130);
        usernameField.setLayoutY(20);
        passwordLabel.setLayoutX(20);
        passwordLabel.setLayoutY(70);
        passwordField.setLayoutX(130);
        passwordField.setLayoutY(70);
        signUp.setVisible(true);
        signUp.setLayoutX(200);
        signUp.setLayoutY(120);
        text.setVisible(false);
        text.setMaxSize(90, 30);
        text.setMinSize(90, 30);
        text.setLayoutX(20);
        text.setLayoutY(120);

        signUp.setOnMouseClicked(e -> {
            if(!usernameField.getText().isEmpty()) {
                if(!passwordField.getText().isEmpty()) {
                    if(!users.getUsers().containsKey(usernameField.getText())){
                        users.getUsers().put(usernameField.getText(), passwordField.getText());
                        sign.setValue(true);
                    } else {
                        text.setText("User exists");
                        text.setVisible(true);
                        usernameField.setText("");
                        passwordField.setText("");
                    }
                } else {
                    text.setText("Enter Password");
                    text.setVisible(true);
                    usernameField.setText("");
                    passwordField.setText("");
                }
            } else {
                text.setText("Enter username");
                text.setVisible(true);
                usernameField.setText("");
                passwordField.setText("");
            }
        });
    }


    public Pane pane() {
        return this.pane;
    }
    public BooleanProperty signSign() {
        return this.sign;
    }
}
