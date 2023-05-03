package nl.onlyfour.openminetopia.structures.types;

public enum Booster {
    MONEY, // 0
    SHARDS; // 1

    public int id() {
        return this.ordinal();
    }
}
