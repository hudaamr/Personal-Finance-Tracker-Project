import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FinanceTracker tracker = new FinanceTracker();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Input Transaction");
            System.out.println("2. View Transactions");
            System.out.println("3. View Transactions (Sorted by Amount)");
            System.out.println("4. View Summary");
            System.out.println("5. Get Insights");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    tracker.addTransaction(description, amount, category);
                    break;
                case 2:
                    tracker.viewTransactions();
                    break;
                case 3:
                    tracker.viewTransactionsSortedByAmount();
                    break;
                case 4:
                    tracker.viewSummary();
                    break;
                case 5:
                    tracker.getInsights();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }
}
