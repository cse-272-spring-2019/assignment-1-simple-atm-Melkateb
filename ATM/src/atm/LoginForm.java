package atm;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginForm {

    Menu menu;
    Scene scene;
    Stage stage;
    LOGIC logic;

    public LoginForm(Stage stage) {
        this.stage = stage;
    }
    // Acount access scene

    public void drawing() {

        Label PinLabel = new Label("Pin ");
        PasswordField PinField = new PasswordField();
        Button submit = new Button("Enter");
        Label validationLabel = new Label();

        GridPane grid = new GridPane();
        grid.add(PinLabel, 0, 1);
        grid.add(PinField, 1, 1);
        grid.add(submit, 1, 2);
        grid.add(validationLabel, 1, 3);

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String Pin = PinField.getText();
                if (Pin.equals("1234")) {
                    menu.setLogic(logic);
                    stage.setScene(menu.getMenuScene());
                } else {
                    validationLabel.setText("Wrong username or password");
                }
            }
        });
        scene = new Scene(grid, 400, 400);
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Scene getScene() {
        return this.scene;
    }

    public void setLogic(LOGIC logic) {
        this.logic = logic;
    }

}
