package nl.onlyfour.openminetopia.listeners;

import nl.onlyfour.openminetopia.OpenMinetopia;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public record ATMListener(OpenMinetopia plugin) implements Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    public void onInteract(PlayerInteractEvent e) {
        if (e.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        Block b = e.getClickedBlock();
        if (b == null) {
            return;
        }

        Material rM = Material.matchMaterial(plugin.fileManager.getConfig("Config.yml").get().getString("Finance.ATMBlock"));
        if (b.getType().equals(rM)) {
            Inventory inv = plugin.getServer().createInventory(null, 27, plugin.getMessage("Finance.ATM.Title"));

            // TODO: Populate inventory

            e.getPlayer().openInventory(inv);
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getView().title() != plugin.getMessage("Finance.ATM.Title")) {
            return;
        }

        e.setCancelled(true);

        if (e.isLeftClick()) {
            // TODO: ...
        }
    }

}
