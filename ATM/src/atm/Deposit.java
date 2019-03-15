package atm;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Deposit {

    Menu menu;
    Scene DepositeScene;
    Stage stage;
    LOGIC logic;

    public Deposit(Stage stage) {
        this.stage = stage;
    }

    public void drawing() {
        Label deposite = new Label("Deposit");
        TextField amount = new TextField();
        Label notification = new Label();
        Button back = new Button("Back");
        Button enter = new Button("Enter");

        GridPane grid = new GridPane();

        grid.add(deposite, 1, 0);
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
                notification.setText("You have added " + quantity);
                logic.deposite(quantity);
            }
        });

        DepositeScene = new Scene(grid, 400, 400);
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Scene getDepositeScene() {
        return DepositeScene;
    }

    public Scene getScene() {
        return this.DepositeScene;
    }

    public void setLogic(LOGIC logic) {
        this.logic = logic;
    }
}
