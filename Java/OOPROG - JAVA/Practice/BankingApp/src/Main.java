import java.util.Scanner;
public class Main {
    static Bank bank = new Bank();
    public static void main(String[] args) {

        /*Account acc1 = new Account("Josh", "n/a", "Gomez", "098341-kua", "Single",
                "M", "21", "March 21, 2003", "Filipino", "098792133",
                "joshgomexgwapo@gmail.com", "Sitio Atay, Tisa Cebu City", 14562.238);
        System.out.println(acc1.getFirstName());*/

        String[] options = {"Create an Account", "Update Account Details", "View Account Details", "View Account Balance",
        "Close an Account", "Withdraw Funds", "Deposit Funds", "Transfer Funds", "View Latest Transaction", "Exit Application"};




        System.out.printf("\n%30s\n", "Banking Application");
        displayMenu(options, options[options.length -1]);



    }

    public static void displayMenu(String[] opt, String exitKey){

        System.out.printf("\nEnter # (1 - %d) to continue, 0 to EXIT. \n", (opt.length -1));
        int arrayLength = opt.length;
        for(int i = 0; i<arrayLength; i++) {
            if(opt[i].equals(exitKey)){ // checks if the current iteration of the menu is "Exit" String
                System.out.println();
                System.out.printf("%-1d. %s.\n", 0, opt[i]); // it will display 0, an indication to exit
            }
            else{// if the current iteration of the menu is not "Exit" String
                System.out.printf("%-1d. %s.\n", (i+1), opt[i]);
            }
        }


    }

}
