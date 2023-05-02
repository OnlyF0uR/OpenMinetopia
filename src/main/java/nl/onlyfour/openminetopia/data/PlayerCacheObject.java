package nl.onlyfour.openminetopia.data;

public class PlayerCacheObject {
    public double shards;
    public int level;
    public int reputation;
    public String playtime;
    public int primaryAccountId;
    public String currentChatColour;
    public String currentNameColour;
    public String job;
    public SideJob sideJobId;
    public int gangId;
    public int gangRank;

    public PlayerCacheObject(double shards, int level, int reputation, String playtime, int primaryAccountId, String currentChatColour, String currentNameColour, String job, SideJob sideJobId, int gangId, int gangRank) {
        this.shards = shards;
        this.level = level;
        this.reputation = reputation;
        this.playtime = playtime;
        this.primaryAccountId = primaryAccountId;
        this.currentChatColour = currentChatColour;
        this.currentNameColour = currentNameColour;
        this.job = job;
        this.sideJobId = sideJobId;
        this.gangId = gangId;
        this.gangRank = gangRank;
    }
}
