package nl.onlyfour.openminetopia.structures.schemas;

public class TransactionResult {
    public final int transactionId;
    public final double newSenderBalance;
    public final double newReceiverBalance;

    public TransactionResult(int transactionId, double newSenderBalance, double newReceiverBalance) {
        this.transactionId = transactionId;
        this.newSenderBalance = newSenderBalance;
        this.newReceiverBalance = newReceiverBalance;
    }
}
