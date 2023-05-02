package nl.onlyfour.openminetopia.api;

import java.util.UUID;

public class MTBankAccount {
    public final String accountName;
    public final String accountDisplayName;
    public final int bankId;

    public UUID ownerUuid;
    public double balance;

    public MTBankAccount(String accountName, String accountDisplayName, int bankId) {
        this.accountName = accountName;
        this.accountDisplayName = accountDisplayName;
        this.bankId = bankId;
    }

    public void owner(UUID uuid) {
        this.ownerUuid = uuid;
    }

    public void subBalance(double amount) {
        this.balance -= amount;
    }

    public void save() {
        // TODO: Save to the database
    }

    public static MTBankAccount fromDatabase(String accountName) {
        // TODO: This
        return null;
    }
}
