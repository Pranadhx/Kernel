package me.torovoro.kernel.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ClearInventory implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("clear")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if(args.length < 1) {
                    player.getInventory().clear();
                    player.sendMessage("§6§l* §7Your §einventory §7has been §ecleared.");
                    return true;
                }
                if(args.length == 1) {
                    Player p = player.getServer().getPlayer(args[0]);
                    if(p == null) {
                        player.sendMessage("§6§l* §7That player is not online or does not exist.");
                    }
                    p.getInventory().clear();
                    p.updateInventory();
                    player.sendMessage("§6§l* §e" + p.getDisplayName() + "'s §7inventory §7has been §ecleared.");
                }
                if(args.length > 1) {
                    player.sendMessage("§6§l* §7Usage: §e/clear (player)");
                }
            }
        }
        return true;
    }
}