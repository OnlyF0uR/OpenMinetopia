package nl.onlyfour.openminetopia.data;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.UUID;

public class Cache {
    // ==================================
    public static final HashMap<String, PinRequest> pinInitiationRequests = new HashMap<>();
    public static final HashMap<String, PinRequest> pinRequests = new HashMap<>();
    private static final HashMap<UUID, PlayerCacheObject> cache = new HashMap<>();

    @Nullable
    public static PlayerCacheObject playerFromCache(UUID uuid) {
        return cache.getOrDefault(uuid, null);
    }

    // TODO: Cache, db syncing

    public static void cachePlayer(UUID uuid, PlayerCacheObject playerCacheObject) {
        cache.put(uuid, playerCacheObject);
    }

    public static void writeCache(UUID uuid, boolean removeAfterWrite) {
        if (cache.containsKey(uuid)) {
            // TODO: Update database if exists, otherwise insert new entry
        }
    }
}

