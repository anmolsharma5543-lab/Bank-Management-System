import java.util.Scanner;

public class BankApplication {
    public static void main(String[] args) {
        // Create a Scanner object to receive bank and account information dynamically
        Scanner scanner = new Scanner(System.in);

        // Receive and store the account information in local variables
        System.out.print("Enter bank name: ");
        String bankName = scanner.nextLine();

        System.out.print("Enter user ID: ");
        int userId = scanner.nextInt();
        
        // Consume the pending newline after reading the numeric value (User ID)
        scanner.nextLine();

        System.out.print("Enter user name: ");
        String userName = scanner.nextLine();

        System.out.print("Enter account number: ");
        long accountNumber = scanner.nextLong();

        // Consume the pending newline after reading the numeric value (Account number)
        scanner.nextLine();

        System.out.print("Enter account type: ");
        String accountType = scanner.nextLine();

        System.out.print("Opening balance: ");
        double openingBalance = scanner.nextDouble();

        // Create the Bank object and pass the values to the parameterized constructor
        Bank bank = new Bank(bankName, userId, userName, accountNumber, accountType, openingBalance);

        // Display the Bank Details
        int choice;
        // Apply do-while loop to display the menu repeatedly
        do {
            System.out.println("\n--- Bank Management System ---");
            System.out.println("1. Display Complete Details");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Withdraw Amount");
            System.out.println("4. Check Balance");
            System.out.println("5. Display Account Summary");
            System.out.println("6. Check Minimum Balance");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();

            // Apply switch statement
            switch (choice) {
                case 1:
                    bank.displayBankDetails();
                    bank.displayUserDetails();
                    bank.displayAccountDetails();
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    boolean isDepositSuccessful = bank.deposit(depositAmount);
                    if (isDepositSuccessful) {
                        System.out.println("Deposit succeeded.");
                        System.out.println("Updated balance: " + bank.checkBalance());
                    } else {
                        System.out.println("Deposit failed.");
                    }
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    boolean isWithdrawSuccessful = bank.withdraw(withdrawAmount);
                    if (isWithdrawSuccessful) {
                        System.out.println("Withdrawal succeeded.");
                        System.out.println("Updated balance: " + bank.checkBalance());
                    } else {
                        System.out.println("Withdrawal failed.");
                    }
                    break;

                case 4:
                    double currentBalance = bank.checkBalance();
                    System.out.println("Current Balance: " + currentBalance);
                    break;

                case 5:
                    String summary = bank.createAccountSummary();
                    System.out.println(summary);
                    break;

                case 6:
                    System.out.print("Enter minimum balance amount: ");
                    double minBalance = scanner.nextDouble();
                    boolean minBalanceMaintained = bank.hasMinimumBalance(minBalance);
                    if (minBalanceMaintained) {
                        System.out.println("The minimum balance is maintained.");
                    } else {
                        System.out.println("The minimum balance is NOT maintained.");
                    }
                    break;

                case 0:
                    System.out.println("Exiting application. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Please choose between 0 and 6.");
            }
        } while (choice != 0);

        scanner.close();
    }
}