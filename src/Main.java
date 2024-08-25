import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static ArrayList<Transaction> Transactions = new ArrayList<>();

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Input Transaction");
            System.out.println("2. View Transactions");
            System.out.println("3. View Summary");
            System.out.println("4. Get Insights");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    inputTransaction(scanner);
                    break;
                case 2:
                    viewTransactions();
                    break;
                case 3:
//                    viewSummary();
                    break;
                case 4:
//                    getInsights();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);


    }

    public static void inputTransaction(Scanner scanner) {
        Transaction transaction;
        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        transaction = new Transaction(description, amount, category);
        Transactions.add(transaction);
    }

    static void sortTransactionsByAmount(ArrayList<Transaction> Transactions) {
        Transactions.sort(Comparator.comparingDouble(t -> t.amount));
    }

    static void printTransaction(ArrayList<Transaction> Transactions) {
        System.out.printf("%-20s %-10s %-15s%n", "Description", "Amount", "Category");
        System.out.println("------------------------------------------------------");
        for (Transaction transaction : Transactions) {
            System.out.printf("%-20s %-10.2f %-15s%n", transaction.description, transaction.amount, transaction.category);
        }
    }

    static boolean askForSort() {
        System.out.println("Do you want to sort the transactions by amount? (Y/N)");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        return choice.equalsIgnoreCase("Y");
    }


    public static void viewTransactions() {
        printTransaction(Transactions);
        if (askForSort()) {
            sortTransactionsByAmount(Transactions);
            printTransaction(Transactions);
        }


    }
}
