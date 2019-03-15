package atm;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Withdraw {

    Menu menu;
    Scene WithdrawScene;
    Stage stage;
    LOGIC logic;

    public Withdraw(Stage stage) {
        this.stage = stage;
    }

    public void drawing() {
        Label withdraw = new Label("Withdraw");
        TextField amount = new TextField();
        Label notification = new Label();
        Button back = new Button("Back");
        Button enter = new Button("Enter");

        GridPane grid = new GridPane();

        grid.add(withdraw, 1, 0);
        grid.add(amount, 1, 1);
        grid.add(back, 3, 0);
        grid.add(enter, 3, 1);
        grid.add(notification, 1, 2);

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menu.setLogic(logic);
                stage.setScene(menu.getMenuScene());
            }
        });
        enter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String quantity = amount.getText();
                int x = logic.Withdraw(quantity);
                if (x == 1) {
                    notification.setText("You do not have  " + quantity);
                } else {
                    notification.setText("You have withdrawn " + quantity);
                }

            }
        });

        WithdrawScene = new Scene(grid, 400, 400);
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Scene getWithdrawScene() {
        return WithdrawScene;
    }

    public Scene getScene() {
        return this.WithdrawScene;
    }

    public void setLogic(LOGIC logic) {
        this.logic = logic;
    }
}
