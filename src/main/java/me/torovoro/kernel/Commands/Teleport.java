package me.torovoro.kernel.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Teleport implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("tp")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if(args.length < 1) {
                    player.sendMessage("§6§l* §7Usage: §e/tp (player)");
                }
                if(args.length == 1) {
                    Player p = player.getServer().getPlayer(args[0]);
                    if(p == null) {
                        player.sendMessage("§6§l* §7That player is not online or does not exist.");
                    } else {
                        player.teleport(p.getLocation());
                        player.sendMessage("§6§l* §7Teleported to §e" + p.getDisplayName() + ".");
                    }
                    return true;
                }
                if(args.length == 2) {
                    Player player1 = Bukkit.getPlayer(args[0]);
                    Player player2 = Bukkit.getPlayer(args[1]);
                    if(player1 == null || player2 == null) {
                        player.sendMessage("§6§l* §7That player is not online or does not exist.");
                    } else {
                        player1.teleport(player2.getLocation());
                        player.sendMessage("§6§l* §7Teleported §e" + player1.getDisplayName() + " §7to §e" + player2.getDisplayName() + ".");
                    }
                }
            }
        }
        return true;
    }
}
