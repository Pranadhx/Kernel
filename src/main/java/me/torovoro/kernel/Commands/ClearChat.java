package me.torovoro.kernel.Commands;

import me.torovoro.kernel.Kernel;
import me.torovoro.kernel.Utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class ClearChat implements CommandExecutor {

    Plugin plugin = Kernel.getPlugin(Kernel.class);

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("clearchat")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                for(int i = 0; i < 200; i++) {
                    Bukkit.broadcastMessage("");
                }
                String clearchat_message = plugin.getConfig().getString("clearchat_message").replace("{player}", player.getDisplayName());
                Bukkit.broadcastMessage(ColorUtils.translateColorCodes(clearchat_message));
            }
        }
        return true;
    }
}
