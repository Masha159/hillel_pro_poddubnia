package lesson8;

import java.util.Scanner;

public class Main {

    static double balance;

    public static void main(String[] args) {
        balance = getBalance();
        validateAmount(balance, getAmount());
    }

    /**
     * Method gets current balance
     */
    private static double getBalance() {
        return 1000.00; // Наявні кошти на рахунку
    }

    /**
     * Method prints current balance
     * and gets a purchase amount
     */
    private static double getAmount() {
        System.out.printf("Balance is USD %.2f.%n" +
                "Enter purchase amount, USD: ", balance);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    /**
     * Method of validating available funds
     */
    private static void validateAmount(double balance, double withdrawal) {
        if (withdrawal > balance) {
            try {
                throw new FundsException("Insufficient funds!");
            } catch (FundsException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            balance = getBalance(balance, withdrawal);
            System.out.printf("Funds are OK. Purchase paid." +
                    "%nBalance is USD %.2f", balance);
        }
    }

    /**
     * Method of calculating available funds in the account
     * after the concept of a certain amount of funds
     */
    private static double getBalance(double balance, double withdrawal) {
        return balance - withdrawal;
    }
}
