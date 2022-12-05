package me.torovoro.kernel;

import me.torovoro.kernel.Commands.Broadcast;
import me.torovoro.kernel.Commands.ClearInventory;
import me.torovoro.kernel.Commands.Gamemode;
import me.torovoro.kernel.Commands.Levels;
import me.torovoro.kernel.Events.PlayerJoinLeave;
import me.torovoro.kernel.Events.TemporaryTestHit;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Kernel extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("Kernel has loaded.");
        getServer().getPluginManager().registerEvents(new PlayerJoinLeave(), this);
        getServer().getPluginManager().registerEvents(new TemporaryTestHit(), this);
        getCommand("broadcast").setExecutor(new Broadcast());
        getCommand("clear").setExecutor(new ClearInventory());
        getCommand("level").setExecutor(new Levels());
        getCommand("gamemode").setExecutor(new Gamemode());
        getCommand("gmc").setExecutor(new Gamemode());
        getCommand("gms").setExecutor(new Gamemode());
        getCommand("gmsp").setExecutor(new Gamemode());

    }


    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Kernel has unloaded.");
    }
}
