package nl.onlyfour.openminetopia.listeners;

import net.kyori.adventure.text.TextReplacementConfig;
import nl.onlyfour.openminetopia.OpenMinetopia;
import nl.onlyfour.openminetopia.data.Cache;
import nl.onlyfour.openminetopia.data.PinRequest;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public record PinListener(OpenMinetopia plugin) implements Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    public void onInteract(PlayerInteractEvent e) {
        if (e.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        Block b = e.getClickedBlock();
        if (b == null) {
            return;
        }

        Material rM = Material.matchMaterial(plugin.fileManager.getConfig("Config.yml").get().getString("Finance.PinBlock"));
        if (b.getType().equals(rM)) {
            Player p = e.getPlayer();
            Location l = b.getLocation();
            if (Cache.pinInitiationRequests.containsKey(p.getName())) {
                // Get the pin request
                PinRequest pr = Cache.pinInitiationRequests.get(p.getName());
                pr.awaitingPayment(l);

                p.sendMessage(plugin.getMessage("Finance.Pin.RequestCreated"));
            } else if (Cache.pinRequests.containsKey(p.getName())) {
                // Pin payment
                PinRequest pr = Cache.pinRequests.get(p.getName());
                if (pr.tryPaying(p)) {
                    p.sendMessage(
                            plugin.getMessage("Finance.Pin.RequestPaid")
                                    .replaceText(TextReplacementConfig.builder().matchLiteral("%amount%").replacement(String.valueOf(pr.amount)).build())
                    );
                    pr.requester.sendMessage(
                            plugin.getMessage("Finance.Pin.RequestSatisfied")
                                    .replaceText(TextReplacementConfig.builder().matchLiteral("%player%").replacement(p.getName()).build())
                                    .replaceText(TextReplacementConfig.builder().matchLiteral("%amount%").replacement(String.valueOf(pr.amount)).build())
                    );
                } else {
                    p.sendMessage(plugin.getMessage("Finance.Pin.CannotAfford"));
                    pr.requester.sendMessage(
                            plugin.getMessage("Finance.Pin.PayerCannotAfford")
                                    .replaceText(TextReplacementConfig.builder().matchLiteral("%player%").replacement(p.getName()).build()));
                }
            }
        }
    }
}
