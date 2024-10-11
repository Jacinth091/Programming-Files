import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<Account> accounts;
    private List<Transaction> transactions;
    public Bank(){
        this.accounts = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    public void createAccount(){


    }

    public void updateAccDetails(){

    }
    public void viewAccDetails(Account userAcc){
        System.out.println("First Name: " + userAcc );
    }

    public void viewAccBalance(){

    }

    public void closeAccount(){

    }

    public void withdraw(){

    }

    public void deposit(){

    }
    public void viewLatestTransaction(){

    }

}
