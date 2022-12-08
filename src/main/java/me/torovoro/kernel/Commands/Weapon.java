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

        String weapon_usage = plugin.getConfig().getString("weapon_usage");
        String obtain_dash = plugin.getConfig().getString("obtain_dash");
        String dash_sword = plugin.getConfig().getString("dash_sword");
        String obtain_tnt = plugin.getConfig().getString("obtain_tnt");
        String tnt_rod = plugin.getConfig().getString("tnt_rod");
        String obtain_doublejump_boots = plugin.getConfig().getString("obtain_doublejump_boots");
        String doublejump_boots = plugin.getConfig().getString("doublejump_boots");
        String obtain_grappling_hook = plugin.getConfig().getString("obtain_grappling_hook");
        String grappling_hook = plugin.getConfig().getString("grappling_hook");

        if(command.getName().equalsIgnoreCase("weapon")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if(args.length < 1) {
                    player.sendMessage(ColorUtils.translateColorCodes(weapon_usage));
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
                        assert obtain_tnt != null;
                        player.sendMessage(ColorUtils.translateColorCodes(obtain_tnt));
                        ItemStack item = new ItemStack(Material.BLAZE_ROD);
                        ItemMeta meta = item.getItemMeta();
                        meta.setDisplayName(ColorUtils.translateColorCodes(tnt_rod));
                        meta.setUnbreakable(true);
                        meta.setCustomModelData(3);
                        List<String> lore = new ArrayList<>();
                        lore.add(ColorUtils.translateColorCodes("&f&oShoot a TNT Gun!"));
                        lore.add("");
                        lore.add(ColorUtils.translateColorCodes("&#fbd333&lL&#f9cc2d&lE&#f6c626&lG&#f4bf20&lE&#f1b81a&lN&#efb113&lD&#ecab0d&lA&#eaa406&lR&#e79d00&lY"));
                        meta.setLore(lore);
                        item.setItemMeta(meta);
                        player.getInventory().addItem(item);
                    }
                    if(args[0].equals("dj")) {
                        player.sendMessage(ColorUtils.translateColorCodes(obtain_doublejump_boots));
                        ItemStack item = new ItemStack(Material.CHAINMAIL_BOOTS);
                        ItemMeta meta = item.getItemMeta();
                        meta.setDisplayName(ColorUtils.translateColorCodes(doublejump_boots));
                        meta.setUnbreakable(true);
                        meta.setCustomModelData(3);
                        List<String> lore = new ArrayList<>();
                        lore.add(ColorUtils.translateColorCodes("&f&oJump like a kangaroo!"));
                        lore.add("");
                        lore.add(ColorUtils.translateColorCodes("&#fbd333&lL&#f9cc2d&lE&#f6c626&lG&#f4bf20&lE&#f1b81a&lN&#efb113&lD&#ecab0d&lA&#eaa406&lR&#e79d00&lY"));
                        meta.setLore(lore);
                        item.setItemMeta(meta);
                        player.getInventory().addItem(item);
                    }
                    if(args[0].equals("grapple")) {
                        player.sendMessage(ColorUtils.translateColorCodes(obtain_grappling_hook));
                        ItemStack item = new ItemStack(Material.FISHING_ROD);
                        ItemMeta meta = item.getItemMeta();
                        meta.setDisplayName(ColorUtils.translateColorCodes(grappling_hook));
                        meta.setUnbreakable(true);
                        meta.setCustomModelData(3);
                        List<String> lore = new ArrayList<>();
                        lore.add(ColorUtils.translateColorCodes("&f&oThrow yourself into the air."));
                        lore.add("");
                        lore.add(ColorUtils.translateColorCodes("&#fbd333&lL&#f9cc2d&lE&#f6c626&lG&#f4bf20&lE&#f1b81a&lN&#efb113&lD&#ecab0d&lA&#eaa406&lR&#e79d00&lY"));
                        meta.setLore(lore);
                        item.setItemMeta(meta);
                        player.getInventory().addItem(item);
                    }
                } else if (args.length > 1) {
                    player.sendMessage(ColorUtils.translateColorCodes(weapon_usage));
                    return true;
                }
            }
            return true;
        }
        return true;
    }
}

