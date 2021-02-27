package GUI.WelcomeWindow;

import Connection.Client;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class WelcomeWindow extends Application {

    FXMLLoader loader = new FXMLLoader();

    private static Client clientInstance;

    public static Client getClientInstance() {

        return clientInstance;
    }

    @Override
    public void start(Stage stage) throws Exception {

        loader.setLocation(this.getClass().getResource("WelcomeWindow.fxml"));
        Pane pane = loader.load();

        stage.setScene(new Scene(pane));
        stage.show();
    }

    public static void displayApplication(String[] args, Client client) {

        clientInstance = client;
        launch(args);
    }
}
