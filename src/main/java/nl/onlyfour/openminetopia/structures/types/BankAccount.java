package nl.onlyfour.openminetopia.structures.types;

public enum BankAccount {
    PERSONAL, // 0
    BUSINESS, // 1
    SAVINGS; // 2

    public int id() {
        return this.ordinal();
    }
}
