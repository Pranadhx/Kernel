package me.torovoro.kernel.Commands;

import me.torovoro.kernel.Utils.ColorUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Fly implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("fly")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if(args.length == 0) {
                    if(player.getAllowFlight()) {
                        player.setAllowFlight(false);
                        player.sendMessage(ColorUtils.translateColorCodes("&#968863&l* &#ccc695Flight &7is now &cdisabled."));
                        return true;
                    } else {
                        player.setAllowFlight(true);
                        player.sendMessage(ColorUtils.translateColorCodes("&#968863&l* &#ccc695Flight &7is now &aenabled."));
                        return true;
                    }
                }
                if(args.length == 1) {
                    Player p = player.getServer().getPlayer(args[0]);
                    if(p == null) {
                        player.sendMessage(ColorUtils.translateColorCodes("&#968863&l* &7That player is not online or does not exist."));
                    } else if(p.getAllowFlight()) {
                        p.setAllowFlight(false);
                        player.sendMessage(ColorUtils.translateColorCodes("&#968863&l* &#ccc695" + p.getDisplayName() + "'s &7flight is now &cdisabled."));
                    } else {
                        p.setAllowFlight(true);
                        player.sendMessage(ColorUtils.translateColorCodes("&#968863&l* &#ccc695" + p.getDisplayName() + "'s &7flight is now &aenabled."));
                    }
                    return true;
                }
            }
        }
        return true;
    }
}
