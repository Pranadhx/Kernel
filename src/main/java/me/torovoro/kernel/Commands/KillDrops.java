package me.torovoro.kernel.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static org.bukkit.Bukkit.getServer;

public class KillDrops implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("cleardrops")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if(args.length < 1) {
                    World world = getServer().getWorld("world");
                    List<Entity> entList = world.getEntities();

                    int amount = 0;
                    for (Entity current : entList) {
                        if (current instanceof Item) {
                            amount++;
                            current.remove();
                        }
                    }
                    player.sendMessage("§6§l* §7Cleared §e" + amount + " §7drops.");
                } else {
                    player.sendMessage("§6§l* §7Usage: §e/cleardrops");
                }
            }
        }
        return true;
    }
}
