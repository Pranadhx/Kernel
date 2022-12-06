package me.torovoro.kernel.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Weapon implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("weapon")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if(args.length < 1) {
                    player.sendMessage("§6§l* §7Usage: §e/weapon (weapon)");
                    return true;
                } else if (args.length == 1) {
                    if(args[0].equals("dash")) {
                        player.getActiveItem();
                    }
            }
        }
        return true;
    }
        return false;
    }
}

