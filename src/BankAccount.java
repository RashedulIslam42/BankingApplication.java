import java.util.Scanner;

public class BankAccount {
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    BankAccount(String cname, String cid) {
        customerName = cname;
        customerID = cid;
    }

    public void passcheck() {
        String username, pass;
        Scanner data = new Scanner(System.in);
        System.out.println("Enter Username:");
        username = data.next();
        System.out.println("Enter Password:");
        pass = data.next();
        if (username.equals("Admin") && pass.equals("12345")) {
            showMenu();
        } else
            System.out.println("Wrong Username or Password");
    }

    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getpreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Depositrd: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("withdrawn: " + Math.abs(previousTransaction));

        } else {
            System.out.println("No transaction occured");
        }
    }

    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("welcome " + customerName);
        System.out.println("Your ID is " + customerID);
        System.out.println("\n");
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous transaction");
        System.out.println("E. Exit");
        do {
            System.out.println("====================");
            System.out.println("Enter an option");
            System.out.println("====================");
            option = scanner.next().charAt(0);
            System.out.println("\n");
            switch (option) {
                case 'A':
                    System.out.println("--------------------");
                    System.out.println("Balance = " + balance);
                    System.out.println("--------------------");
                    System.out.println("\n");
                    break;

                case 'B':
                    System.out.println("--------------------");
                    System.out.println("Enteran amount to deposit:");
                    System.out.println("--------------------");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;

                case 'C':
                    System.out.println("--------------------");
                    System.out.println("Enteran amount to withdraw:");
                    System.out.println("--------------------");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                    break;

                case 'D':
                    System.out.println("--------------------");
                    getpreviousTransaction();
                    System.out.println("--------------------");
                    System.out.println("\n");
                    break;

                case 'E':
                    System.out.println("********************");
                    break;

                default:
                    System.out.println("Invalid Option!!.please enter again");
                    break;

            }

        }
        while (option != 'E');
        System.out.println("ThankYou for using our services");
    }
}
