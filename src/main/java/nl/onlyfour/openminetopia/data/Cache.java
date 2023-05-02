package nl.onlyfour.openminetopia.data;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Cache {
    private static final HashMap<UUID, CacheObject> cache = new HashMap<>();

    @Nullable
    public static CacheObject fromCache(UUID uuid) {
        return cache.getOrDefault(uuid, null);
    }

    public static void toCache(UUID uuid, CacheObject cacheObject) {
        cache.put(uuid, cacheObject);
    }

    public static void writeCache(UUID uuid) {
        if (cache.containsKey(uuid)) {
            // TODO: Update database if exists, otherwise insert new entry
        }
    }

    // ==================================
    public static final HashMap<String, PinRequest> pinInitiationRequests = new HashMap<>();
    public static final HashMap<String, PinRequest> pinRequests = new HashMap<>();
}

