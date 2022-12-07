package me.torovoro.kernel.Commands;

import me.torovoro.kernel.Kernel;
import me.torovoro.kernel.Utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class Broadcast implements CommandExecutor {

    Plugin plugin = Kernel.getPlugin(Kernel.class);

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        String broadcast_usage = plugin.getConfig().getString("broadcast_usage");

        if(command.getName().equalsIgnoreCase("broadcast")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if(args.length < 1) {
                    assert broadcast_usage != null;
                    player.sendMessage(ColorUtils.translateColorCodes(broadcast_usage));
                    return true;
                }
                String bc = String.join(" ", args);
                bc = ChatColor.translateAlternateColorCodes('&', bc);
                Bukkit.getServer().broadcastMessage(ColorUtils.translateColorCodes("&#fce9b6&lA&#fde2ad&lL&#fedca3&lE&#fed59a&lR&#ffce90&lT &8| &e" + bc));
                }
            }
        return true;
        }
    }
