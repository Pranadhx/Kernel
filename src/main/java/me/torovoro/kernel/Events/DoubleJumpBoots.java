package me.torovoro.kernel.Events;

import com.jeff_media.armorequipevent.ArmorEquipEvent;
import com.jeff_media.armorequipevent.ArmorType;
import me.torovoro.kernel.Kernel;
import me.torovoro.kernel.Utils.ColorUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class DoubleJumpBoots implements Listener {

    Plugin plugin = Kernel.getPlugin(Kernel.class);

    @EventHandler
    public void doubleJumpBoots(ArmorEquipEvent event) {

        String equip_doublejump_boots = plugin.getConfig().getString("equip_doublejump_boots");

        Player player = event.getPlayer();
        ItemStack newBoots = event.getNewArmorPiece();

        if(event.getType() != ArmorType.BOOTS) return;

        if(newBoots != null) {
            if(newBoots.getItemMeta().getCustomModelData() == 3) {
                player.setAllowFlight(true);
                player.sendMessage(ColorUtils.translateColorCodes(equip_doublejump_boots));
            }
        }
        if(event.getNewArmorPiece() == null)
            player.setAllowFlight(false);
    }
}
