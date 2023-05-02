package nl.onlyfour.openminetopia;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import nl.onlyfour.openminetopia.commands.PinCMD;
import nl.onlyfour.openminetopia.data.Database;
import nl.onlyfour.openminetopia.data.Economy;
import nl.onlyfour.openminetopia.listeners.ATMListener;
import nl.onlyfour.openminetopia.listeners.PinListener;
import nl.onlyfour.openminetopia.listeners.PlayerChatListener;
import nl.onlyfour.openminetopia.listeners.PlayerTrafficListener;
import nl.onlyfour.openminetopia.utils.FileManager;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;

public class OpenMinetopia extends JavaPlugin {
    public FileManager fileManager = new FileManager(this);
    public Database database;

    @Override
    public void onEnable() {
        // Vault setup
        if (!Economy.setupEconomy()) {
            this.getLogger().severe("Vault not found, disabling plugin.");
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }

        // Configuration management
        this.fileManager.getConfig("Config.yml").setDefaults(true);
        this.fileManager.getConfig("Lang.yml").setDefaults(true);

        YamlConfiguration cfg = fileManager.getConfig("Config.yml").get();
        this.database = new Database(
                cfg.getString("Database.Url"),
                cfg.getString("Database.Username"),
                cfg.getString("Database.Password"));

        // Register events
        this.getServer().getPluginManager().registerEvents(new ATMListener(this), this);
        this.getServer().getPluginManager().registerEvents(new PinListener(this), this);
        this.getServer().getPluginManager().registerEvents(new PlayerChatListener(this), this);
        this.getServer().getPluginManager().registerEvents(new PlayerTrafficListener(this), this);

        // Register commands
        this.getCommand("pin").setExecutor(new PinCMD(this));
    }

    @Override
    public void onDisable() {
        try {
            this.database.closeSource();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @NotNull
    public Component getMessage(String path) {
        if (!this.fileManager.getConfig("Lang.yml").get().contains(path)) {
            return Component.text("Message not found: " + path);
        } else {
            return buildColourComponent(this.fileManager.getConfig("Lang.yml").get().getString(path));
        }
    }

    @NotNull
    public Component buildColourComponent(String plaintext) {
        // --#fffff--Hello --#11111--World!
        if (!plaintext.contains("--")) {
            return Component.text(plaintext);
        }

        Component result = Component.text("");

        String[] ptArray = plaintext.split("--");
        String activeColour = null;
        for (String pt : ptArray) {
            if (pt.length() == 7 && pt.contains("#")) {
                activeColour = pt;
            } else {
                if (activeColour == null) {
                    result = result.append(Component.text(pt).decoration(TextDecoration.ITALIC, false));
                } else {
                    result = result.append(Component.text(pt).color(TextColor.fromHexString(activeColour)));
                }
            }
        }

        return result;
    }

}
