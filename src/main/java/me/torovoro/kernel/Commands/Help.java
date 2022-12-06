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
                    player.sendMessage(ColorUtils.translateColorCodes("&6&l* &7Running &#fce9b6&lK&#fde4ae&lE&#fddea7&lR&#fed99f&lN&#fed398&lE&#ffce90&lL &ev1.0.\n&6&l* &7Use &e/kernel help &7to view all commands."));
                } else {
                    player.sendMessage(ColorUtils.translateColorCodes("&#48ad00&l* &#585858Running &#39ff14&lK&#51ff1c&lE&#69ff24&lR&#81ff2c&lN&#99ff34&lE&#b1ff3c&lL &#39FF14v1.0.\n&#48ad00&l* &#585858Use &#39FF14/kernel help &#585858to view all commands."));
                }
            }
        }
        return true;
    }
}
