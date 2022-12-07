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

public class ClearInventory implements CommandExecutor {

    Plugin plugin = Kernel.getPlugin(Kernel.class);

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        String clear_self = plugin.getConfig().getString("clear_self");
        String player_not_exist = plugin.getConfig().getString("player_not_exist");

        if(command.getName().equalsIgnoreCase("clear")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if(args.length < 1) {
                    player.getInventory().clear();
                    assert clear_self != null;
                    player.sendMessage(ColorUtils.translateColorCodes(clear_self));
                    return true;
                }
                if(args.length == 1) {
                    Player p = Bukkit.getPlayer(args[0]);
                    if(p == null) {
                        assert player_not_exist != null;
                        player.sendMessage(ColorUtils.translateColorCodes(player_not_exist));
                    } else {
                        p.getInventory().clear();
                        p.updateInventory();
                        String clear_other = plugin.getConfig().getString("clear_other").replace("{player}", p.getDisplayName());
                        player.sendMessage(ColorUtils.translateColorCodes(clear_other));
                        return true;
                    }
                }
                if(args.length > 1) {
                    player.sendMessage("§6§l* §7Usage: §e/clear (player)");
                }
            }
        }
        return true;
    }
}