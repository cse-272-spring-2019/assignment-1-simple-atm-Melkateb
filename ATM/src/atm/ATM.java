package atm;

import javafx.application.Application;
import javafx.stage.Stage;

public class ATM extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    private int balance = 0;
//Connecting scenes

    @Override
    public void start(Stage primaryStage) throws Exception {
        LOGIC logic = new LOGIC();
        primaryStage.setTitle("ATM Machine");
        LoginForm loginForm = new LoginForm(primaryStage);
        Menu menu = new Menu(primaryStage);
        Deposit deposit = new Deposit(primaryStage);
        Withdraw withdraw = new Withdraw(primaryStage);
        CurrentBalance currentBalance = new CurrentBalance(primaryStage);
        History history = new History(primaryStage);

        loginForm.setLogic(logic);
        loginForm.drawing();

        menu.setLogic(logic);
        menu.drawing();

        deposit.setLogic(logic);
        deposit.drawing();

        withdraw.setLogic(logic);
        withdraw.drawing();

        currentBalance.setLogic(logic);
        currentBalance.drawing();

        history.setLogic(logic);
        history.drawing();

        loginForm.setMenu(menu);
        menu.setLoginForm(loginForm);

        menu.setWithdraw(withdraw);
        withdraw.setMenu(menu);

        menu.setDeposit(deposit);
        deposit.setMenu(menu);

        menu.setCurrentBalance(currentBalance);
        currentBalance.setMenu(menu);

        menu.setHistory(history);
        history.setMenu(menu);

        primaryStage.setScene(loginForm.getScene());
        primaryStage.show();
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
