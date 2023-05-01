package nl.onlyfour.openminetopia.data;

public class CacheObject {
    public double shards;
    public int level;
    public String currentChatColour;
    public String job;
    public SideJob sideJob;

    public CacheObject(double shards, int level, String currentChatColour, String job, SideJob sideJob) {
        this.shards = shards;
        this.level = level;
        this.currentChatColour = currentChatColour;
        this.job = job;
        this.sideJob = sideJob;
    }
}
