package nl.onlyfour.openminetopia.api;

import nl.onlyfour.openminetopia.data.Cache;
import nl.onlyfour.openminetopia.structures.schemas.PlayerCacheObject;
import nl.onlyfour.openminetopia.structures.types.SideJob;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public class MTPlayer {
    private final OfflinePlayer offlinePlayer;
    private boolean hasLoaded;

    public MTPlayer(OfflinePlayer offlinePlayer) {
        this.offlinePlayer = offlinePlayer;
    }

    public MTPlayer(Player player) {
        this.offlinePlayer = player;
    }

    public MTPlayer(UUID uuid) {
        this.offlinePlayer = Bukkit.getOfflinePlayer(uuid);
        this.hasLoaded = false;
    }

    /**
     * This function also contains the functionality to create a player in the database if the player does not exist.
     * If called only with cachePlayer false and allowWelcomeMessages false it will only check if a player exists and
     * create a new database entry if not.
     *
     * @param cachePlayer          Whether to cache the player
     * @param allowWelcomeMessages Whether to send welcome messages
     */
    public void loadPlayer(boolean cachePlayer, boolean allowWelcomeMessages) {
        // Select all the data of the player
        // If the player does not exist, create the player

        // Cache the player if requested

        this.hasLoaded = true;
    }

    public boolean hasLoaded() {
        return this.hasLoaded;
    }

    public double shardCount() {
        PlayerCacheObject obj = Cache.playerFromCache(this.offlinePlayer.getUniqueId());
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

        PlayerCacheObject obj = Cache.playerFromCache(this.offlinePlayer.getUniqueId());
        if (obj != null) {
            // Cache new amount
            obj.shards = newShardCount;
            Cache.cachePlayer(this.offlinePlayer.getUniqueId(), obj);
        }

        // TODO: Write the database
    }

    public int level() {
        PlayerCacheObject obj = Cache.playerFromCache(this.offlinePlayer.getUniqueId());
        if (obj == null) {
            // TODO: Get from database
            return 0;
        } else {
            return obj.level;
        }
    }

    public String currentChatColour() {
        PlayerCacheObject obj = Cache.playerFromCache(this.offlinePlayer.getUniqueId());
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

        PlayerCacheObject obj = Cache.playerFromCache(this.offlinePlayer.getUniqueId());
        if (obj != null) {
            obj.currentChatColour = colour;
            Cache.cachePlayer(this.offlinePlayer.getUniqueId(), obj);
        }
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

    // ======================================
    public String currentNameColour() {
        PlayerCacheObject obj = Cache.playerFromCache(this.offlinePlayer.getUniqueId());
        if (obj == null) {
            // TODO: Get from database
            return "#ffffff";
        } else {
            return obj.currentNameColour;
        }
    }

    public void currentNameColour(String colour) {
        // TODO: Check for validity

        if (!this.nameColours().contains(colour)) {
            return;
        }

        PlayerCacheObject obj = Cache.playerFromCache(this.offlinePlayer.getUniqueId());
        if (obj != null) {
            obj.currentNameColour = colour;
            Cache.cachePlayer(this.offlinePlayer.getUniqueId(), obj);
        }
    }

    public List<String> nameColours() {
        // TODO: Get from database

        // Return empty list for now
        return List.of();
    }

    public void addNameColour(String colour) {
        // TODO: Check for validity
        // TODO: Write to the database
    }

    public void removeNameColour(String colour) {
        // TODO: Check for validity
        // TODO: Write to the database
    }

    public String job() {
        PlayerCacheObject obj = Cache.playerFromCache(this.offlinePlayer.getUniqueId());
        if (obj == null) {
            return "";
        } else {
            return obj.job;
        }
    }

    public void setJob(String job) {
        // TODO: Check for validity

        PlayerCacheObject obj = Cache.playerFromCache(this.offlinePlayer.getUniqueId());
        if (obj != null) {
            obj.job = job;
            Cache.cachePlayer(this.offlinePlayer.getUniqueId(), obj);
        }
    }

    public SideJob sideJob() {
        PlayerCacheObject obj = Cache.playerFromCache(this.offlinePlayer.getUniqueId());
        if (obj == null) {
            // TODO: Get from database
            return SideJob.UNEMPLOYED;
        } else {
            return obj.sideJob;
        }
    }

    public void setSideJob(SideJob sideJob) {
        // TODO: Check for validity

        PlayerCacheObject obj = Cache.playerFromCache(this.offlinePlayer.getUniqueId());
        if (obj != null) {
            obj.sideJob = sideJob;
            Cache.cachePlayer(this.offlinePlayer.getUniqueId(), obj);
        }
    }

    public List<MTBooster> boosters() {
        // TODO: Get from database

        // Return empty list for now
        return List.of();
    }

    public void reset() {
        // TODO: Reset database and cache to default values
    }

}
