import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

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
