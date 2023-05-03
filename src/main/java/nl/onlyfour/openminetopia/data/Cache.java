package nl.onlyfour.openminetopia.data;

import nl.onlyfour.openminetopia.structures.PinRequest;
import nl.onlyfour.openminetopia.structures.schemas.PlayerCacheObject;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.UUID;

public class Cache {
    // ==================================
    public static final HashMap<String, PinRequest> pinInitiationRequests = new HashMap<>();
    public static final HashMap<String, PinRequest> pinRequests = new HashMap<>();
    private static final HashMap<UUID, PlayerCacheObject> playerCache = new HashMap<>();

    @Nullable
    public static PlayerCacheObject playerFromCache(UUID uuid) {
        return playerCache.getOrDefault(uuid, null);
    }

    // TODO: Cache, db syncing

    public static void cachePlayer(UUID uuid, PlayerCacheObject playerCacheObject) {
        playerCache.put(uuid, playerCacheObject);
    }

    public static void writeCache(UUID uuid, boolean removeAfterWrite) {
        if (playerCache.containsKey(uuid)) {
            // TODO: Update database if exists, otherwise insert new entry
        }
    }
}

