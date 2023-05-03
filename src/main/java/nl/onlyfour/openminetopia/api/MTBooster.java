package nl.onlyfour.openminetopia.api;

import nl.onlyfour.openminetopia.structures.types.Booster;
import org.bukkit.entity.Player;

import java.util.UUID;

public class MTBooster {
    public final double multiplier;
    public final long duration;

    public final Booster boosterType;

    public UUID ownerUuid;

    public MTBooster(double multiplier, long duration, Booster boosterType) {
        this.multiplier = multiplier;
        this.duration = duration;
        this.boosterType = boosterType;
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
                if (!activator.hasPermission("openminetopia.admin") || !activator.hasPermission("openminetopia.booster.other")) {
                    // Not allowed to activate
                    return;
                }
            }

            // Remove the booster from the database
            // Activate the booster
        }

    }

}
