import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
                    getInsights();
                    break;
                case 5:
                    System.out.println("Exiting...");

                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);


    }

    private static void getInsights() {
            List<String> categories = new ArrayList<>();

        for (Transaction transaction : Transactions) {
                String category = transaction.category;

                // if category not found in the list
                // calc the total amount for this category
                // then add it to the list of categories
                if (!categories.contains(category)) {
                    double totalForCategory = 0.0;

                    for (Transaction t : Transactions) {
                        if (t.category.equals(category)) {
                            totalForCategory += t.amount;
                        }
                    }

                    categories.add(category);

                    double percentage = calculatePercentage(totalForCategory);

                    System.out.println("------------------------------------------------------");
                    System.out.println("Category " + category + ": $" + totalForCategory + " (" + String.format("%.2f", percentage) + "%)");
                }
            }
        System.out.println("Overall amount spent across all transactions: $"+calculateTotalExpenses());
        System.out.println("------------------------------------------------------");


    }

        public static double calculateTotalExpenses(){
            double total = 0.0;
            for (Transaction t : Transactions) {
                total += t.amount;
            }
            return total;
        }

        public static double calculatePercentage(double amount) {
            double totalExpenses = calculateTotalExpenses();
            return totalExpenses == 0 ? 0 : (amount / totalExpenses) * 100;
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
       char choice;
       do {
           System.out.print("Do you want to sort transactions by amount? (Y/N): ");
           choice = Character.toUpperCase(new Scanner(System.in).next().charAt(0));
       } while (!Character.isLetter(choice) || (choice!='Y' && choice!= 'N'));

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
