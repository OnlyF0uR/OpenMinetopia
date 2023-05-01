package nl.onlyfour.openminetopia.utils;

import net.kyori.adventure.text.Component;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ItemBuilder {
    private final ItemStack is;

    public ItemBuilder(Material m, int amount) {
        this.is = new ItemStack(m, amount);
    }

    public ItemBuilder(Material m) {
        this(m, 1);
    }

    public ItemBuilder(ItemStack is) {
        this.is = is;
    }

    public ItemBuilder clone() {
        return new ItemBuilder(this.is);
    }

    public ItemBuilder damage(int dam) {
        ItemMeta im = this.is.getItemMeta();
        if (im instanceof Damageable) {
            ((Damageable) im).setDamage(dam);
            this.is.setItemMeta(im);
        }
        return this;
    }

    public ItemBuilder unbreakable(boolean b) {
        ItemMeta im = this.is.getItemMeta();
        im.setUnbreakable(b);
        this.is.setItemMeta(im);
        return this;
    }

    public ItemBuilder name(Component c) {
        ItemMeta im = this.is.getItemMeta();
        im.displayName(c);
        this.is.setItemMeta(im);
        return this;
    }

    public ItemBuilder unsafeEnchantment(Enchantment ench, int level) {
        this.is.addUnsafeEnchantment(ench, level);
        return this;
    }

    public ItemBuilder removeEnchantment(Enchantment ench) {
        this.is.removeEnchantment(ench);
        return this;
    }


    public ItemBuilder skullOwner(OfflinePlayer op) {
        ItemMeta im = this.is.getItemMeta();
        if (im instanceof SkullMeta) {
            ((SkullMeta) im).setOwningPlayer(op);
            this.is.setItemMeta(im);
        }
        return this;
    }

    public ItemBuilder enchant(Enchantment ench, int level) {
        ItemMeta im = is.getItemMeta();
        im.addEnchant(ench, level, true);
        is.setItemMeta(im);
        return this;
    }

    public ItemBuilder enchantments(Map<Enchantment, Integer> enchantments) {
        is.addEnchantments(enchantments);
        return this;
    }

    public ItemBuilder lore(Component... lore) {
        is.lore(Arrays.asList(lore));
        return this;
    }

    public ItemBuilder lore(List<Component> lore) {
        is.lore(lore);
        return this;
    }

    public ItemBuilder removeLoreLine(Component line) {
        List<Component> lore = is.lore();
        if (lore.contains(line)) {
            lore.remove(line);
            is.lore(lore);
        }
        return this;
    }

    public ItemBuilder removeLoreLine(int index) {
        List<Component> lore = is.lore();
        if (index >= 0 && index < lore.size()) {
            lore.remove(index);
            is.lore(lore);
        }
        return this;
    }

    public ItemBuilder loreLine(Component line) {
        List<Component> lore = is.lore();
        lore.add(line);
        is.lore(lore);
        return this;
    }

    public ItemBuilder loreLine(Component line, int i) {
        List<Component> lore = is.lore();
        lore.set(i, line);
        is.lore(lore);
        return this;
    }

    public ItemBuilder leatherArmorColour(Color color) {
        try {
            LeatherArmorMeta im = (LeatherArmorMeta) is.getItemMeta();
            im.setColor(color);
            is.setItemMeta(im);
        } catch (ClassCastException expected) {
        }
        return this;
    }

    public ItemBuilder glow(boolean b) {
        ItemMeta im = is.getItemMeta();

        if (b) {
            is.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 1);
            im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        } else {
            if (is.getEnchantments().containsKey(Enchantment.PROTECTION_PROJECTILE) && im.hasItemFlag(ItemFlag.HIDE_ENCHANTS)) {
                is.removeEnchantment(Enchantment.PROTECTION_PROJECTILE);
                im.removeItemFlags(ItemFlag.HIDE_ENCHANTS);
            }
        }

        is.setItemMeta(im);
        return this;
    }

    public ItemStack itemStack() {
        return is;
    }
}