package com.github.elic0de.quitclean;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

public final class QuitClean extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onQuit(PlayerQuitEvent event) {
        final Player player = event.getPlayer();
        final PlayerInventory inv = player.getInventory();
        final ItemStack[] AIR = {
                new ItemStack(Material.AIR),
                new ItemStack(Material.AIR),
                new ItemStack(Material.AIR),
                new ItemStack(Material.AIR),
        };
        if (player.hasPermission("quitclean.clear.bypass")) return;
        inv.setArmorContents(AIR);
        inv.clear();
    }
}
