import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.MapChangeListener;
import javafx.scene.Scene;
import javafx.stage.Stage;
import login_field.LoginPrompt;
import login_field.SignUpPrompt;
import login_field.Users;

public class Login extends Application {
    private final static String LOGIN = "Login";
    private final static String SIGN_UP = "Sign Up";
    private Users users;

    public static void main(String[] args){
        launch();
    }

    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     *
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages.
     * @throws Exception if something goes wrong
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        users = new Users();
        LoginPrompt loginPane = new LoginPrompt(users);
        SignUpPrompt signUpPane = new SignUpPrompt(users);
        Scene login = new Scene(loginPane.pane());
        Scene signUp = new Scene(signUpPane.pane());
        primaryStage.setScene(login);
        primaryStage.setTitle(LOGIN);
        primaryStage.show();
        loginPane.sign().addListener((o, oV, nV) -> { if(nV && !oV) {
            try {
                primaryStage.close();
            } catch (Exception e) {}
            primaryStage.setScene(signUp);
            primaryStage.setTitle(SIGN_UP);
            primaryStage.show();
        }
        });
        signUpPane.signSign().addListener((o, oV, nV) -> { if(nV && !oV) {
            try {
                primaryStage.close();
            } catch (Exception e) {}
            primaryStage.setScene(login);
            primaryStage.setTitle(LOGIN);
            primaryStage.show();
        }
        });
        users.getUsers().addListener((MapChangeListener<? super String, ? super String>) e -> {
            loginPane.setUsers(users, e.getKey(), e.getValueAdded());
            signUpPane.setUsers(users, e.getKey(), e.getValueAdded());
        });
    }
}
