package atm;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CurrentBalance {

    Menu menu;
    Scene CurrentBalanceScene;
    Stage stage;
    Deposit deposit;
    LOGIC logic;

    public CurrentBalance(Stage stage) {
        this.stage = stage;
    }

    public void drawing() {

        Label currentBalance = new Label("Balance inquiry");
        Label Label = new Label();

        Button showBalance = new Button("Show Balance");
        Button back = new Button("Back");

        GridPane grid = new GridPane();
        grid.add(currentBalance, 0, 0);
        grid.add(Label, 0, 1);
        grid.add(showBalance, 0, 2);
        grid.add(back, 1, 2);

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menu.setLogic(logic);
                stage.setScene(menu.getMenuScene());
            }

        });
        showBalance.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Label.setText("You have " + logic.getCurrentBalance());
            }

        });

        CurrentBalanceScene = new Scene(grid, 400, 400);
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Scene getCurrentBalanceScene() {
        return CurrentBalanceScene;
    }

    public Scene getScene() {
        return this.CurrentBalanceScene;
    }

    public void setLogic(LOGIC logic) {
        this.logic = logic;
    }

}
