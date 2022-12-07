package me.torovoro.kernel.Commands;

import me.torovoro.kernel.Kernel;
import me.torovoro.kernel.Utils.ColorUtils;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Weapon implements CommandExecutor {

    Plugin plugin = Kernel.getPlugin(Kernel.class);

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        String obtain_dash = plugin.getConfig().getString("obtain_dash");
        String dash_sword = plugin.getConfig().getString("dash_sword");
        String obtain_tnt = plugin.getConfig().getString("obtain_tnt");
        String tnt_rod = plugin.getConfig().getString("tnt_rod");

        if(command.getName().equalsIgnoreCase("weapon")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if(args.length < 1) {
                    player.sendMessage("§6§l* §7Usage: §e/weapon (weapon)");
                    return true;
                } else if (args.length == 1) {
                    if(args[0].equals("dash")) {
                        assert obtain_dash != null;
                        player.sendMessage(ColorUtils.translateColorCodes(obtain_dash));
                        ItemStack item = new ItemStack(Material.IRON_SWORD);
                        ItemMeta meta = item.getItemMeta();
                        meta.setDisplayName(ColorUtils.translateColorCodes(dash_sword));
                        meta.setUnbreakable(true);
                        meta.setCustomModelData(3);
                        List<String> lore = new ArrayList<>();
                        lore.add(ColorUtils.translateColorCodes("&f&oDash in the wind!"));
                        lore.add("");
                        lore.add(ColorUtils.translateColorCodes("&#fbd333&lL&#f9cc2d&lE&#f6c626&lG&#f4bf20&lE&#f1b81a&lN&#efb113&lD&#ecab0d&lA&#eaa406&lR&#e79d00&lY"));
                        meta.setLore(lore);
                        item.setItemMeta(meta);
                        player.getInventory().addItem(item);
                    }
                    if(args[0].equals("tnt")) {
                        player.sendMessage(ColorUtils.translateColorCodes(obtain_tnt));
                        ItemStack item = new ItemStack(Material.LIGHTNING_ROD);
                        ItemMeta meta = item.getItemMeta();
                        meta.setDisplayName(ColorUtils.translateColorCodes(tnt_rod));
                        meta.setUnbreakable(true);
                        meta.setCustomModelData(3);
                        List<String> lore = new ArrayList<>();
                        lore.add(ColorUtils.translateColorCodes("&f&oThrow a primed TNT!"));
                        lore.add("");
                        lore.add(ColorUtils.translateColorCodes("&#fbd333&lL&#f9cc2d&lE&#f6c626&lG&#f4bf20&lE&#f1b81a&lN&#efb113&lD&#ecab0d&lA&#eaa406&lR&#e79d00&lY"));
                        meta.setLore(lore);
                        item.setItemMeta(meta);
                        player.getInventory().addItem(item);
                    }
            }
        }
        return true;
    }
        return false;
    }
}

