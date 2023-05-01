package nl.onlyfour.openminetopia.data;

import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;

import static org.bukkit.Bukkit.getServer;

public class Economy {
    private static Economy econ = null;

    public static boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = Bukkit.getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }

        econ = rsp.getProvider();
        return true;
    }

    public static Economy getEconomy() {
        return econ;
    }
}
