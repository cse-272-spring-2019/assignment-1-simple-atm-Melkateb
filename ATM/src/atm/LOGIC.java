package atm;

import java.util.ArrayList;
import javafx.stage.Stage;

public class LOGIC {

    ATM atm;
    Stage stage;
    String balanceStr;
    int balance;
    ArrayList<String> array = new ArrayList<String>();
    private int i = 0;

    public LOGIC() {
        this.stage = stage;
        atm = new ATM();
        balance = atm.getBalance();
        balanceStr = Integer.toString(atm.getBalance());
    }

    public void deposite(String amount) {
        int Amount = Integer.parseInt(amount);
        balance = balance + Amount;
        atm.setBalance(balance);
        transactions(1, amount);
    }

    public int Withdraw(String amount) {
        int Amount = Integer.parseInt(amount);
        if (balance < Amount) {
            return 1;

        } else {
            balance = balance - Amount;
            atm.setBalance(balance);
            transactions(2, amount);
            return 0;
        }
    }

    public String getCurrentBalance() {
        String amount = Integer.toString(balance);
        transactions(3, amount);
        return amount;
    }

    public String prev() {
        return array.get(--i);
    }

    public String next() {
        return array.get(++i);
    }

    public void transactions(int n, String transaction) {

        switch (n) {
            case 1:
                array.add("deposit " + transaction);
                i++;
                System.out.println(array.get(1));
                break;
            case 2:
                array.add("Withdraw " + transaction);
                i++;
                break;
            case 3:
                array.add("Balance inquiry " + transaction);
                i++;
                break;
        }
        while (i > 4) {
            for (int j = 0; j < i; j++) {
                array.set(j, array.get(j + 1));
            }
        }
    }

    public int getBalance() {
        return balance;
    }

}
