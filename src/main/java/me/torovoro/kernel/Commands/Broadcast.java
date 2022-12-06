package me.torovoro.kernel.Commands;

import me.torovoro.kernel.Utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Broadcast implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("broadcast")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if(args.length < 1) {
                    player.sendMessage("§6§l* §7Usage: §e/broadcast (text)");
                    return true;
                }
                String bc = String.join(" ", args);
                bc = ChatColor.translateAlternateColorCodes('&', bc);
                Bukkit.getServer().broadcastMessage(ColorUtils.translateColorCodes("&#fce9b6&lA&#fde2ad&lL&#fedca3&lE&#fed59a&lR&#ffce90&lT &e| &7" + bc));
                }
            }
        return true;
        }
    }
