import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
                    inputTransaction(scanner);
                    break;
                case 2:
                    viewTransactions();
                    break;
                case 3:
                    viewTransactionsSortedByAmount();
                    break;
                case 4:
                    viewSummary();
                    break;
                case 5:
                    getInsights();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    

    }
        public static void inputTransaction(Scanner scanner) {
        System.out.print("Enter description: ");
        descriptions[transactionCount] = scanner.nextLine();
        System.out.print("Enter amount: ");
        amounts[transactionCount] = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter category: ");
        categories[transactionCount] = scanner.nextLine();
        transactionCount++;
    }

    public static void viewTransactions() {
        System.out.println(String.format("%-20s %-10s %-15s", "Description", "Amount", "Category"));
        System.out.println("------------------------------------------------------");
        for (int i = 0; i < transactionCount; i++) {
            System.out.println(String.format("%-20s %-10.2f %-15s", descriptions[i], amounts[i], categories[i]));
        }
    }
}
