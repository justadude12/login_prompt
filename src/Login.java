import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import login_field.LoginPrompt;
import login_field.Users;

public class Login extends Application {
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
        Users memory = new Users();
        LoginPrompt loginPane = new LoginPrompt(memory);
        Scene scene = new Scene(loginPane.pane());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}