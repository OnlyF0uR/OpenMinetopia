package nl.onlyfour.openminetopia.listeners;

import net.kyori.adventure.text.TextReplacementConfig;
import nl.onlyfour.openminetopia.OpenMinetopia;
import nl.onlyfour.openminetopia.api.MTPlayer;
import nl.onlyfour.openminetopia.data.Cache;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public record PlayerTrafficListener(OpenMinetopia plugin) implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent e) {
        MTPlayer mtP = new MTPlayer(e.getPlayer());
        mtP.loadPlayer(true, true);

        // Freeze the player until loaded
        while (!mtP.hasLoaded()) {
            e.getPlayer().teleport(e.getPlayer().getLocation());
        }

        e.joinMessage(plugin.getMessage("Traffic.Join").replaceText(TextReplacementConfig.builder().matchLiteral("%player%").replacement(e.getPlayer().getName()).build()));
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerQuit(PlayerQuitEvent e) {
        Cache.writeCache(e.getPlayer().getUniqueId(), true);
        e.quitMessage(plugin.getMessage("Traffic.Quit").replaceText(TextReplacementConfig.builder().matchLiteral("%player%").replacement(e.getPlayer().getName()).build()));
    }

}
