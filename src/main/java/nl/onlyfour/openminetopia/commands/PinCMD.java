package nl.onlyfour.openminetopia.commands;

import nl.onlyfour.openminetopia.OpenMinetopia;
import nl.onlyfour.openminetopia.structures.PinRequest;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PinCMD implements CommandExecutor {
    private final OpenMinetopia plugin;

    public PinCMD(OpenMinetopia plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player requester)) {
            return true;
        }

        if (args.length != 2) {
            // TODO: Write error message
            return true;
        }

        // TODO: Check if the player is allowed to create a pin request

        // Parse the player argument
        Player payer = Bukkit.getPlayer(args[0]);
        if (payer == null || !payer.isOnline()) {
            // TODO: Write error message
            return true;
        }

        // Parse the amount argument
        double amount;
        try {
            amount = Double.parseDouble(args[1]);
        } catch (NumberFormatException e) {
            // TODO: Write error message
            return true;
        }

        // TODO: Get the plot account name (which is the name of the current plot)
        String accountName = "";

        new PinRequest(payer, requester, accountName, amount);
        requester.sendMessage(plugin.getMessage("Finance.Pin.RequestCreationStarted"));

        return true;
    }
}
