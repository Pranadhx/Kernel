package me.torovoro.kernel.Commands;

import me.torovoro.kernel.Kernel;
import me.torovoro.kernel.Utils.ColorUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class Help implements CommandExecutor {

    Plugin plugin = Kernel.getPlugin(Kernel.class);

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("kernel")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if(args.length < 1) {
                    player.sendMessage(ColorUtils.translateColorCodes("&#968863&l* &7Running &#fce9b6&lK&#fde4ae&lE&#fddea7&lR&#fed99f&lN&#fed398&lE&#ffce90&lL &#ccc695v1.0.\n&#968863&l* &7Use &#fce9b6/kernel help &7to view all commands.\n&#968863&l* &7To reload the console, use &#fce9b6/kernel reload."));
                } else if(args[0].equals("reload")) {
                    plugin.reloadConfig();
                    player.sendMessage(ColorUtils.translateColorCodes("&#968863&l* &#fce9b6Config &7has been &#fce9b6reloaded!"));
                } else {
                    player.sendMessage(ColorUtils.translateColorCodes("&8&m                                                                        "));
                    player.sendMessage(ColorUtils.translateColorCodes("&a                           &#c6b78f&lC&#c3b28a&lO&#c0ae86&lM&#bda981&lM&#baa57d&lA&#b7a078&lN&#b49c74&lD&#b1976f&lS &#ae936b&lL&#ab8e66&lI&#a88a62&lS&#a5855d&lT"));
                    player.sendMessage(ColorUtils.translateColorCodes("&#968863&l* &#fce9b6/broadcast (message) &8- &7Send a message to all players on the server."));
                    player.sendMessage(ColorUtils.translateColorCodes("&#968863&l* &#fce9b6/level &8- &7View all commands related to levels."));
                    player.sendMessage(ColorUtils.translateColorCodes("&#968863&l* &#fce9b6/clear | /ci (player) &8- &7Clear your inventory."));
                    player.sendMessage(ColorUtils.translateColorCodes("&#968863&l* &#fce9b6/cleardrops &8- &7Clear all dropped entities."));
                    player.sendMessage(ColorUtils.translateColorCodes("&#968863&l* &#fce9b6/clearchat &8- &7Clear the chat."));
                    player.sendMessage(ColorUtils.translateColorCodes("&#968863&l* &#fce9b6/fly (player) &8- &7Disable/enable flight mode."));
                    player.sendMessage(ColorUtils.translateColorCodes("&#968863&l* &#fce9b6/gm(c|s|sp) | /gamemode &8- &7View commands related to gamemode."));
                    player.sendMessage(ColorUtils.translateColorCodes("&#968863&l* &#fce9b6/kick (player) &8- &7Kick a player from the server."));
                    player.sendMessage(ColorUtils.translateColorCodes("&#968863&l* &#fce9b6/tp (player) [player] &8- &7Teleport to another player."));
                    player.sendMessage(ColorUtils.translateColorCodes("&#968863&l* &#fce9b6/vanish [player] &8- &7Toggle visbility."));
                    player.sendMessage(ColorUtils.translateColorCodes("&8&m                                                                        "));
                }
            }
        }
        return true;
    }
}
