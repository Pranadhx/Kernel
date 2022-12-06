package me.torovoro.kernel.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Vanish implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("vanish")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if(args.length < 1) {
                    if(player.isInvisible()) {
                        player.setInvisible(false);
                        player.sendMessage("§6§l* §eVisibility §7is now §cdisabled.");
                        return true;
                    } else {
                        player.setInvisible(true);
                        player.sendMessage("§6§l* §eVisbility §7is now §aenabled.");
                        return true;
                    }
                }
                if(args.length == 1) {
                    Player p = player.getServer().getPlayer(args[0]);
                    if(p == null) {
                        player.sendMessage("§6§l* §7That player is not online or does not exist.");
                    } else if(p.isInvisible()) {
                        p.setInvisible(false);
                        p.sendMessage("§6§l* §eVisbility §7is now §cdisabled.");
                    } else {
                        p.setInvisible(true);
                        p.sendMessage("§6§l* §eVisbility §7is now §aenabled.");
                    }
                    return true;
                }
                if(args.length > 1) {
                    player.sendMessage("§6§l* §7Usage: §e/vanish (player)");
                }
            }
        }
        return true;
    }
}
