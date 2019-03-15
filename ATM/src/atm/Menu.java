package atm;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Menu {

    LoginForm loginForm;
    Scene MenuScene;
    Deposit deposit;
    Withdraw withdraw;
    Stage stage;
    LOGIC logic;
    History history;
    CurrentBalance currentBalance;
// Main menu

    public Menu(Stage stage) {
        this.stage = stage;
    }

    public void drawing() {
        Label welcome = new Label("Welcome");
        Label choices = new Label("Choose one of the following operations");
        Button Deposit = new Button("Deposit");
        Button Withdraw = new Button("Withdraw");
        Button CurrentBalance = new Button("Get current balance");
        Button History = new Button("History");
        Button back = new Button("Back");
        GridPane grid = new GridPane();
        grid.add(welcome, 0, 0);
        grid.add(choices, 0, 1);
        grid.add(Deposit, 0, 2);
        grid.add(Withdraw, 0, 3);
        grid.add(CurrentBalance, 0, 4);
        grid.add(History, 0, 5);
        grid.add(back, 0, 6);
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(loginForm.getScene());
            }
        });
        Deposit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                deposit.setLogic(logic);
                stage.setScene(deposit.getDepositeScene());
            }
        });
        Withdraw.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                withdraw.setLogic(logic);
                stage.setScene(withdraw.getWithdrawScene());
            }
        });
        CurrentBalance.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                currentBalance.setLogic(logic);
                stage.setScene(currentBalance.getCurrentBalanceScene());
            }
        });
        History.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                history.setLogic(logic);
                stage.setScene(history.getHistoryScene());
            }
        });
        MenuScene = new Scene(grid, 400, 400);
    }

    public Scene getMenuScene() {
        return MenuScene;
    }

    public void setLoginForm(LoginForm loginForm) {
        this.loginForm = loginForm;
    }

    public void setDeposit(Deposit deposit) {
        this.deposit = deposit;
    }

    public void setWithdraw(Withdraw withdraw) {
        this.withdraw = withdraw;
    }

    public void setCurrentBalance(CurrentBalance currentBalance) {
        this.currentBalance = currentBalance;
    }

    public void setHistory(History history) {
        this.history = history;
    }

    public void setLogic(LOGIC logic) {
        this.logic = logic;
    }

}
