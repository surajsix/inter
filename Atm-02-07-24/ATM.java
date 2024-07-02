import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ATM {
    private float balance;
    private Map<Integer, Customer> customerMap;
    private Customer currentCustomer;

    public ATM() {
        balance = 0;
        customerMap = new HashMap<>();
        // Adding some sample customers for demonstration purposes
        customerMap.put(12345, new Customer(12345, 0000));
        customerMap.put(67890, new Customer(67890, 1111));
    }

    public void checkPin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your ATM number:");
        int atmNumber = sc.nextInt();
        
        currentCustomer = customerMap.get(atmNumber);
        
        if (currentCustomer != null) {
            System.out.println("Enter your pin:");
            int enteredPin = sc.nextInt();
            if (enteredPin == currentCustomer.getPin()) {
                menu();
            } else {
                System.out.println("Invalid pin. Try again.");
                checkPin();
            }
        } else {
            System.out.println("Invalid ATM number. Try again.");
            checkPin();
        }
    }

    public void menu() {
        System.out.println("Enter your choice:");
        System.out.println("1. Check A/c balance");
        System.out.println("2. Withdraw money");
        System.out.println("3. Deposit money");
        System.out.println("4. Exit");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                checkBalance();
                break;
            case 2:
                withdraw();
                break;
            case 3:
                deposit();
                break;
            case 4:
                System.out.println("Have a nice day! Visit again...");
                break;
            default:
                System.out.println("Enter a valid choice.");
                menu();
                break;
        }
    }

    public void checkBalance() {
        System.out.println("Balance: " + balance);
        menu();
    }

    public void withdraw() {
        System.out.println("Enter amount to withdraw:");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Money withdrawal successful.");
        }
        menu();
    }

    public void deposit() {
        System.out.println("Enter deposit amount:");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        balance += amount;
        System.out.println("Money deposit successful.");
        menu();
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.checkPin();
    }
}
