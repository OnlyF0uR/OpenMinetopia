package nl.onlyfour.openminetopia.structures.types;

public enum SideJob {
    UNEMPLOYED, // 0
    MINER, // 1
    FARMER, // 2
    FISHERMAN, // 3
    WOODCUTTER; // 4

    public int id() {
        return this.ordinal();
    }
}
