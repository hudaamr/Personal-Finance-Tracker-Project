import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;


public class Main {
    static ArrayList<Transaction> Transactions = new ArrayList<>();
    static double TotalIncome;
    static double TotalExpenses;


    public static void main(String[] args) {
        openFinanceTracker();
    }

    public static void showMenu() {
        System.out.println("Menu:\n1. Input Transaction\n2. View Transactions\n3. View Summary\n4. Get Insights\n5. Exit");

    }

    public static int chooseOption() {
        System.out.print("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public static void processChoice(int choice) {

        switch (choice) {
            case 1 -> inputTransaction();
            case 2 -> viewTransactions();
            case 3 -> viewSummary();
            case 4 -> getInsights();
            case 5 -> {
                System.out.println("Exiting...");
                exit(0);
            }
            default -> System.out.println("Invalid choice. Please try again.");
        }

    }

    public static void openFinanceTracker() {
        do {
            showMenu();
            int choice = chooseOption();
            processChoice(choice);
        } while (true);
    }

    private static void getInsights() {
        List<String> categories = new ArrayList<>();
        System.out.println("\nTotal Expenses: " + Math.abs(TotalExpenses));

        for (Transaction transaction : Transactions) {
            String category = transaction.category;

            // Skip income categories and already processed categories
            if (!categories.contains(category) && transaction.amount<0) {
                double totalForCategory = 0.0;

                for (Transaction t : Transactions) {
                    if (t.category.equals(category)) {
                        totalForCategory += Math.abs(t.amount);
                    }
                }

                categories.add(category);

                double percentage = calculatePercentage(totalForCategory);

                System.out.println("Category " + category + " - Spent: " + totalForCategory + " (" + String.format("%.4f", percentage) + "% of total)");
            }
        }
        System.out.println();
    }

    public static double calculatePercentage(double amount) {
        return  Math.abs(TotalExpenses) == 0 ? 0 : (amount / Math.abs(TotalExpenses)) * 100;
    }




    public static void checkTransactionType(Transaction transaction) {
        if (transaction.amount > 0) {
            TotalIncome += transaction.amount;
        } else {
            TotalExpenses += transaction.amount;
        }
    }

    public static double getBalance() {
        return TotalIncome + TotalExpenses;
    }

    public static void viewSummary() {
        System.out.println("Total Income: $" + TotalIncome);
        System.out.println("Total Expenses: $" + TotalExpenses);
        System.out.println("Balance: $" + getBalance());
    }


    public static void inputTransaction() {
        Scanner scanner = new Scanner(System.in);
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
        checkTransactionType(transaction);
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
        char choice;
        do {
            System.out.print("Do you want to sort transactions by amount? (Y/N): ");
            choice = Character.toUpperCase(new Scanner(System.in).next().charAt(0));
        } while (!Character.isLetter(choice) || (choice != 'Y' && choice != 'N'));

        return choice == 'Y';
    }


    public static void viewTransactions() {
        printTransaction(Transactions);
        if (askForSort()) {
            sortTransactionsByAmount(Transactions);
            printTransaction(Transactions);
        }


    }
}
