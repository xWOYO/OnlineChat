package GUI.WelcomeWindow;


import Connection.Client;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


public class WelcomeWindowController {

    Client client;

    @FXML
    private TextField roomNameTextField;

    @FXML
    private Button roomNameButton;

    EventHandler<MouseEvent> textEnteredByButton = e -> {
        try {
            client.chooseRoomName(roomNameTextField.getText());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        roomNameTextField.setText("");

    };

    EventHandler<KeyEvent> textEnteredByEnter = e -> {
        if ((e.getCode() == KeyCode.ENTER)) {
            try {
                client.chooseRoomName(roomNameTextField.getText());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            roomNameTextField.setText("");
        }
    };


    @FXML
    void initialize() {
        roomNameTextField.addEventHandler(KeyEvent.KEY_PRESSED, textEnteredByEnter);
        roomNameButton.addEventHandler(MouseEvent.MOUSE_CLICKED, textEnteredByButton);
        client = WelcomeWindow.getClientInstance();
        System.out.println("initialized");
    }

}
