# Personal Finance Tracker

## Introduction
The **Personal Finance Tracker** is a command-line application designed to assist users in managing their financial transactions. It provides functionalities to input transactions, view and sort them, and analyze financial data. This project aims to help users gain insights into their spending habits and maintain a clear overview of their financial status.

## System Overview
The system provides the following key features:
- **Input Transactions**: Record details of new financial transactions.
- **View Transactions**: Display a list of all transactions with optional sorting.
- **View Summary**: Show a financial summary including total income, expenses, and balance.
- **Get Insights**: Offer insights into spending habits by category.

## Features and Functionality

### 1. Input Transactions
- **Purpose**: To add new financial transactions into the system.
- **Process**:
  - **Description**: Enter a brief description of the transaction (e.g., "Lunch", "Electric Bill").
  - **Amount**: Input the monetary value of the transaction. Positive values are recorded as income, while negative values represent expenses.
  - **Category**: Specify a category for the transaction (e.g., Food, Entertainment, Bills).
- **Details**:
  - Each transaction is recorded with its description, amount, and category.
  - Transactions are stored in a list and indexed by their order of entry.

### 2. View Transactions
- **Purpose**: To display a list of all recorded transactions.
- **Features**:
  - **Display**: Shows transactions in a tabular format with columns for Description, Amount, and Category.
  - **Sorting**: Provides an option to sort transactions by amount.
- **Process**:
  - Transactions are presented with clear formatting for easy readability.
  - Sorting functionality helps users quickly identify high or low-value transactions.

### 3. View Summary
- **Purpose**: To provide a summary of financial transactions.
- **Features**:
  - **Total Income**: Sum of all positive transaction amounts.
  - **Total Expenses**: Sum of all negative transaction amounts.
  - **Balance**: The net balance, calculated as Total Income minus Total Expenses.
- **Process**:
  - Calculates the total income and expenses by iterating through all transactions.
  - Displays the summary in a straightforward format for quick assessment of financial status.

### 4. Get Insights
- **Purpose**: To analyze and provide insights into spending habits by category.
- **Features**:
  - **Total Expenses**: Displays the overall amount spent across all transactions.
  - **Category Analysis**: Breaks down expenses by category and shows each category's contribution to the total expenses.
- **Process**:
  - Aggregates expenses by category to determine how much has been spent in each category.
  - Calculates and displays the percentage of total expenses attributed to each category, helping users understand their spending patterns.

## How to Use

### Using the Menu:
- **Input Transactions**: Select this option to record a new transaction. Follow prompts to enter the description, amount, and category.
- **View Transactions**: Choose this option to view all transactions. You can also sort transactions by amount.
- **View Summary**: Select this to view the summary of total income, expenses, and balance.
- **Get Insights**: Choose this option to get detailed insights into spending by category.
- **Exit**: Select this option to close the application.

### Example Workflow:
1. **Input**: Add a transaction by providing a description like "Groceries", an amount such as "-30.00", and a category like "Food".
2. **View Transactions**: Display all entered transactions and choose to sort by amount if desired.
3. **Summary**: Check the total income, total expenses, and balance.
4. **Insights**: Review spending by category to understand where most of the money is going.

## Troubleshooting
- **Invalid Inputs**: Ensure all inputs are correctly formatted. For example, amounts should be numerical values, and descriptions and categories should be properly spelled.
- **Sorting Issues**: If sorting does not work as expected, check that the sorting logic is correctly implemented and applied.

## Future Enhancements
- Add a graphical user interface (GUI) for better user interaction.
- Implement data persistence using file storage or a database.
- Add support for multiple users.


