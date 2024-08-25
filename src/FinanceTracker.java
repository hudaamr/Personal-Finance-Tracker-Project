import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class FinanceTracker {
    private List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(String description, double amount, String category) {
        transactions.add(new Transaction(description, amount, category));
    }

    public void viewTransactions() {
        System.out.println(String.format("%-20s %-10s %-15s", "Description", "Amount", "Category"));
        System.out.println("------------------------------------------------------");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public void viewTransactionsSortedByAmount() {
        transactions.sort(Comparator.comparingDouble(Transaction::getAmount));
        viewTransactions();
    }

    public void viewSummary() {
        double totalIncome = transactions.stream()
                .filter(t -> t.getAmount() > 0)
                .mapToDouble(Transaction::getAmount)
                .sum();

        double totalExpenses = transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .mapToDouble(Transaction::getAmount)
                .sum();

        double balance = totalIncome + totalExpenses;

        System.out.println("Summary:");
        System.out.println("Total Income: $" + totalIncome);
        System.out.println("Total Expenses: $" + totalExpenses);
        System.out.println("Balance: $" + balance);
    }

    public void getInsights() {
        System.out.println("Spending Insights by Category:");
        transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .map(Transaction::getCategory)
                .distinct()
                .forEach(category -> {
                    double totalCategoryExpenses = transactions.stream()
                            .filter(t -> t.getCategory().equals(category))
                            .mapToDouble(Transaction::getAmount)
                            .sum();
                    double percentage = (totalCategoryExpenses / transactions.stream()
                            .filter(t -> t.getAmount() < 0)
                            .mapToDouble(Transaction::getAmount)
                            .sum()) * 100;
                    System.out.println(category + ": $" + totalCategoryExpenses + " (" + String.format("%.2f", percentage) + "%)");
                });
    }
}
