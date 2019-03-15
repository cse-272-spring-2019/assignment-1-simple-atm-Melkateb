package atm;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class History {

    Menu menu;
    Scene HistoryScene;
    Stage stage;
    LOGIC logic;
    int j = 0;

    public History(Stage stage) {
        this.stage = stage;
    }

    public void drawing() {
        Label History = new Label("Transactions");
        Label amount = new Label();
        Button previous = new Button("Previous");
        Button next = new Button("next");
        Button back = new Button("Back");

        GridPane grid = new GridPane();

        grid.add(History, 0, 0);
        grid.add(amount, 0, 1);
        grid.add(previous, 0, 2);
        grid.add(next, 1, 2);
        grid.add(back, 0, 3);

        previous.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int j = logic.array.size() - 1;
                amount.setText(logic.prev());
            }
        });
        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int j = logic.array.size() - 1;
                amount.setText(logic.next());
            }
        });
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menu.setLogic(logic);
                stage.setScene(menu.getMenuScene());
            }
        });
        HistoryScene = new Scene(grid, 400, 400);
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Scene getHistoryScene() {
        return HistoryScene;
    }

    public Scene getScene() {
        return this.HistoryScene;
    }

    public void setLogic(LOGIC logic) {
        this.logic = logic;
    }
}
