package nl.onlyfour.openminetopia.api;

import org.bukkit.entity.Player;

import java.util.UUID;

public class Booster {
    private double multiplier;
    private long duration;

    UUID ownerUuid;

    public Booster(double multiplier, long duration) {
        this.multiplier = multiplier;
        this.duration = duration;
    }

    public boolean playerOwned() {
        return this.ownerUuid != null;
    }

    public void setOwner(UUID uuid) {
        this.ownerUuid = uuid;
    }

    public void activate(Player activator) {
        if (this.playerOwned()) {
            if (!activator.getUniqueId().equals(this.ownerUuid)) {
                if (!activator.hasPermission("openminetopia.admin")) {
                    // Not allowed to activate
                    return;
                }
            }

            // Remove the booster from the database
            // Activate the booster
        }

    }

}
