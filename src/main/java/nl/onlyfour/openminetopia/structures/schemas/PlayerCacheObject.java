package nl.onlyfour.openminetopia.structures.schemas;

import nl.onlyfour.openminetopia.structures.types.SideJob;

public class PlayerCacheObject {
    public double shards; // Need for scoreboard
    public int level; // Need for chat
    public String playtime; // Need for incrementing time
    public String currentChatColour; // Need for chat
    public String currentNameColour; // Need for chat
    public String job; // Need for chat
    public SideJob sideJob; // Need for performing sidejob-activities (access)
    public int reputation; // Need for performing criminal activities (access)
    public int gangId; // Need for performing gang activities (access)
    public int gangRank; // Need for performing gang activities (access)

    public PlayerCacheObject(double shards, int level, int reputation, String playtime, String currentChatColour, String currentNameColour, String job, SideJob sideJob, int gangId, int gangRank) {
        this.shards = shards;
        this.level = level;
        this.reputation = reputation;
        this.playtime = playtime; // TODO: Convert playtime into milliseconds
        this.currentChatColour = currentChatColour;
        this.currentNameColour = currentNameColour;
        this.job = job;
        this.sideJob = sideJob;
        this.gangId = gangId;
        this.gangRank = gangRank;
    }
}
