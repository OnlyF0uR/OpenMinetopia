package nl.onlyfour.openminetopia.listeners;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import nl.onlyfour.openminetopia.OpenMinetopia;
import nl.onlyfour.openminetopia.data.Cache;
import nl.onlyfour.openminetopia.data.PlayerCacheObject;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public record PlayerChatListener(OpenMinetopia plugin) implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerChat(AsyncChatEvent e) {
        PlayerCacheObject pco = Cache.playerFromCache(e.getPlayer().getUniqueId());
        Component newMessage = plugin.buildColourComponent(
                plugin.fileManager.getConfig("Config.yml").get().getString("Chat.Format")
                        .replaceAll("%job%", pco.job)
                        .replaceAll("%player%", "--" + pco.currentNameColour + "--" + e.getPlayer().getName())
                        .replaceAll("%level%", String.valueOf(pco.level))
        );

        newMessage = newMessage.append(e.message().color(TextColor.fromHexString(pco.currentChatColour)));
        if (plugin.fileManager.getConfig("Config.yml").get().getDouble("Chat.Range") > 0) {
            e.setCancelled(true);

            for (Player p : plugin.getServer().getOnlinePlayers()) {
                if (p.getLocation().distance(e.getPlayer().getLocation()) <= plugin.fileManager.getConfig("Config.yml").get().getDouble("Chat.Range")) {
                    p.sendMessage(newMessage);
                }
            }
        } else {
            e.message(newMessage);
        }
    }

}
