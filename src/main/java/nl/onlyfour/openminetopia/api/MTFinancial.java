package nl.onlyfour.openminetopia.api;

import nl.onlyfour.openminetopia.structures.schemas.TransactionResult;

import java.util.UUID;

public class MTFinancial {
    public static void createBankAccount(String name, String displayName) {
        // Create a bank account
    }

    public static void deleteBankAccount(int bankAccountId) {
        // Delete a bank account
    }

    public static void addToAccount(int bankAccountId, UUID uuid) {
        // Add a player to a bank account
    }

    public static void removeFromAccount(int bankAccountId, UUID uuid) {
        // Remove a player from a bank account
    }

    public static TransactionResult createTransaction(UUID sender, int senderAccountId, int receiverAccountId, double amount, String reason) {
        // Check if the sender is allowed to send money from the bank account
        // Check if the sender account has enough money to fulfill the transfer
        // Update the balances
        // Create a transaction
        return new TransactionResult(0, 1, 1);
    }

    public static void undoTransaction(int transactionId) {
        // Undo a transaction (update the balances again)
    }

}
