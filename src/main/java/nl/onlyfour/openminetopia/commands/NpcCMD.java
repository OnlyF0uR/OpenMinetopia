package nl.onlyfour.openminetopia.commands;

import nl.onlyfour.openminetopia.OpenMinetopia;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class NpcCMD implements CommandExecutor {
    private final OpenMinetopia plugin;

    public NpcCMD(OpenMinetopia plugin) {
        this.plugin = plugin;
    }

    // /mtnpc spawn registration
    // /mtnpc spawn levelcheck
    // /mtnpc spawn drugrun <drug> <name>

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player p)) {
            return true;
        }

        if (args.length != 2) {
            // TODO: Write error message
            return true;
        }

        if (args[0].equalsIgnoreCase("spawn")) {
            if (args[1].equalsIgnoreCase("registration")) {
                // Open registration GUI
            } else if (args[1].equalsIgnoreCase("levelcheck")) {
                // Open levelheck
            }
        }

        return true;
    }
}
