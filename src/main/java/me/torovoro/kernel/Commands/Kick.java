package me.torovoro.kernel.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Kick implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("kick")) {
            if (sender instanceof Player) {
                if(args.length < 1) {
                    Player player = (Player) sender;
                    player.sendMessage("§6§l* §7Usage: §e/kick (player)");
                    return true;
                }
                if(args.length == 1) {
                    Player player = (Player) sender;
                    Player p = player.getServer().getPlayer(args[0]);
                    if(p == null) {
                        player.sendMessage("§6§l* §7That player is not online or does not exist.");
                    } else {
                        p.kickPlayer("You have been kicked!");
                        player.sendMessage("§6§l* §e" + args[0] + " §7has been §ekicked.");
                    }
                    return true;
                }
                if(args.length > 1) {
                    Player player = (Player) sender;
                    player.sendMessage("§6§l* §7Usage: §e/kick (player)");
                }
            }
        }
        return true;
    }
}
