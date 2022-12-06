package me.torovoro.kernel.Commands;

import me.torovoro.kernel.Utils.ColorUtils;
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
                    player.sendMessage(ColorUtils.translateColorCodes("&#968863&l* &7Running &#fce9b6&lK&#fde4ae&lE&#fddea7&lR&#fed99f&lN&#fed398&lE&#ffce90&lL &#ccc695v1.0.\n&#968863&l* &7Use &#ccc695/kernel help &7to view all commands."));
                } else {
                    player.sendMessage("");
                }
            }
        }
        return true;
    }
}
