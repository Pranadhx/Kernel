package me.torovoro.kernel;

import me.torovoro.kernel.Commands.*;
import me.torovoro.kernel.Events.*;
import me.torovoro.kernel.Events.Tools.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import com.jeff_media.armorequipevent.ArmorEquipEvent;

public final class Kernel extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new PlayerJoinLeave(), this);
        getServer().getPluginManager().registerEvents(new TemporaryTestHit(), this);
        getServer().getPluginManager().registerEvents(new LaunchPad(), this);
        getServer().getPluginManager().registerEvents(new ScoreboardInitialize(), this);
        getServer().getPluginManager().registerEvents(new DashSword(), this);
        getServer().getPluginManager().registerEvents(new TNTRod(), this);
        getServer().getPluginManager().registerEvents(new DoubleJumpCheck(), this);
        getServer().getPluginManager().registerEvents(new DoubleJumpBoots(), this);
        getCommand("broadcast").setExecutor(new Broadcast());
        getCommand("clear").setExecutor(new ClearInventory());
        getCommand("level").setExecutor(new Levels());
        getCommand("gamemode").setExecutor(new Gamemode());
        getCommand("gmc").setExecutor(new Gamemode());
        getCommand("gms").setExecutor(new Gamemode());
        getCommand("gmsp").setExecutor(new Gamemode());
        getCommand("fly").setExecutor(new Fly());
        getCommand("vanish").setExecutor(new Vanish());
        getCommand("kick").setExecutor(new Kick());
        getCommand("cleardrops").setExecutor(new KillDrops());
        getCommand("tp").setExecutor(new Teleport());
        getCommand("kernel").setExecutor(new Help());
        getCommand("clearchat").setExecutor(new ClearChat());
        getCommand("weapon").setExecutor(new Weapon());
        ArmorEquipEvent.registerListener(this);
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Kernel has unloaded.");
    }

}
