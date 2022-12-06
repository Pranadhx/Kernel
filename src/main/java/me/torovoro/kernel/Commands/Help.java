package me.torovoro.kernel.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Help implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("kernel")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if(args.length < 1) {
                    player.sendMessage("§6§l* §7Running §e§lKERNEL §ev1.0.\n§6§l* §7Use §e/kernel help §7to view all commands.");
                } else {
                    player.sendMessage("help menu");
                }
            }
        }
        return true;
    }
}
