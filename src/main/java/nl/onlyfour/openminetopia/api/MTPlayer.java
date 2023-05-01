package nl.onlyfour.openminetopia.api;

import nl.onlyfour.openminetopia.data.Cache;
import nl.onlyfour.openminetopia.data.CacheObject;
import nl.onlyfour.openminetopia.data.SideJob;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public class MTPlayer {
    private final OfflinePlayer offlinePlayer;

    public MTPlayer(OfflinePlayer offlinePlayer) {
        this.offlinePlayer = offlinePlayer;
    }

    public MTPlayer(Player player) {
        this.offlinePlayer = player;
    }

    public MTPlayer(UUID uuid) {
        this.offlinePlayer = Bukkit.getOfflinePlayer(uuid);
    }

    public double shardCount() {
        CacheObject obj = Cache.fromCache(this.offlinePlayer.getUniqueId());
        if (obj == null) {
            // TODO: Get from database
            return 0.;
        } else {
            return obj.shards;
        }
    }

    public void sumShards(double shards) {
        double currentShardCount = this.shardCount();
        double newShardCount = currentShardCount + shards;

        CacheObject obj = Cache.fromCache(this.offlinePlayer.getUniqueId());
        if (obj != null) {
            // Cache new amount
            obj.shards = newShardCount;
            Cache.toCache(this.offlinePlayer.getUniqueId(), obj);
        }

        // TODO: Write the database
    }

    public int level() {
        CacheObject obj = Cache.fromCache(this.offlinePlayer.getUniqueId());
        if (obj == null) {
            // TODO: Get from database
            return 0;
        } else {
            return obj.level;
        }
    }

    public String currentChatColour() {
        CacheObject obj = Cache.fromCache(this.offlinePlayer.getUniqueId());
        if (obj == null) {
            // TODO: Get from database
            return "#ffffff";
        } else {
            return obj.currentChatColour;
        }
    }

    public void currentChatColour(String colour) {
        // TODO: Check for validity

        if (!this.chatColours().contains(colour)) {
            return;
        }

        CacheObject obj = Cache.fromCache(this.offlinePlayer.getUniqueId());
        if (obj != null) {
            obj.currentChatColour = colour;
            Cache.toCache(this.offlinePlayer.getUniqueId(), obj);
        }

        // TODO: Write the database
    }

    public List<String> chatColours() {
        // TODO: Get from database

        // Return empty list for now
        return List.of();
    }

    public void addChatColour(String colour) {
        // TODO: Check for validity
        // TODO: Write to the database
    }

    public void removeChatColour(String colour) {
        // TODO: Check for validity
        // TODO: Write to the database
    }

    public String job() {
        CacheObject obj = Cache.fromCache(this.offlinePlayer.getUniqueId());
        if (obj == null) {
            // TODO: Get from database
            return "";
        } else {
            return obj.job;
        }
    }

    public void setJob(String job) {
        // TODO: Check for validity

        CacheObject obj = Cache.fromCache(this.offlinePlayer.getUniqueId());
        if (obj != null) {
            obj.job = job;
            Cache.toCache(this.offlinePlayer.getUniqueId(), obj);
        }

        // TODO: Write the database
    }

    public SideJob sideJob() {
        CacheObject obj = Cache.fromCache(this.offlinePlayer.getUniqueId());
        if (obj == null) {
            // TODO: Get from database
            return SideJob.UNEMPLOYED;
        } else {
            return obj.sideJob;
        }
    }

    public void setSideJob(SideJob sideJob) {
        // TODO: Check for validity

        CacheObject obj = Cache.fromCache(this.offlinePlayer.getUniqueId());
        if (obj != null) {
            obj.sideJob = sideJob;
            Cache.toCache(this.offlinePlayer.getUniqueId(), obj);
        }

        // TODO: Write the database
    }

    public List<Booster> boosters() {
        // TODO: Get from database

        // Return empty list for now
        return List.of();
    }

    public void reset() {
        // TODO: Reset database and cache to default values
    }

}
