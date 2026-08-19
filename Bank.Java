class Bank {
    String bankName;
    int userId;
    String userName;
    long accountNumber;
    String accountType;
    double balance;


    Bank(String bankName,
            int userId,
            String userName,
            long accountNumber,
            String accountType,
            double balance) {
        this.bankName = bankName;
        this.userId = userId;
        this.userName = userName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }


    void displayBankDetails() {
        System.out.println("Bank Name : " + bankName);
    }


    void displayUserDetails() {
        System.out.println("User Id : " + userId);
        System.out.println("User Name : " + userName);
    }


    void displayAccountDetails() { // Display the account number, account type, and current balance.
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account type : " + accountType);
        System.out.println("Current Balance : " + balance);
    }


    String createAccountSummary() {
        // bank name, user name, account number, account type, and balance.
        return "Bank Name : " + bankName
                + "\nUser name : " + userName
                + "\nAccount number : " + accountNumber
                + "\nAccount type : " + accountType
                + "\nBalance : " + balance;
    }


    boolean hasMinimumBalance(double minimumBalance){
        boolean res = false;
        if(balance >= minimumBalance){
            res = true;
        }
        return res;
    }



}

public boolean deposit(double amount) {
        if (amount > 0) {
            openingBalance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && openingBalance >= amount) {
            openingBalance -= amount;
            return true;
        }
        return false;
    }

    public double checkBalance() {
        return openingBalance;
    }
} 