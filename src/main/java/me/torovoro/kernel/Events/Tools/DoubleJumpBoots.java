package me.torovoro.kernel.Events.Tools;

import com.jeff_media.armorequipevent.ArmorEquipEvent;
import com.jeff_media.armorequipevent.ArmorType;
import me.torovoro.kernel.Kernel;
import me.torovoro.kernel.Utils.ColorUtils;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
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
                player.sendMessage(ColorUtils.translateColorCodes(equip_doublejump_boots));
            }
        }
        if(event.getNewArmorPiece() == null)
            player.setAllowFlight(false);
    }

    @EventHandler
    public void onDoubleJump(PlayerToggleFlightEvent event) {
        Player player = event.getPlayer();
        if(player.getGameMode() == GameMode.CREATIVE)
            return;
        if(player.getInventory().getBoots().getItemMeta().getCustomModelData() == 3) {
            event.setCancelled(true);
            player.setAllowFlight(false);
            player.setFlying(false);
            player.setVelocity(player.getLocation().getDirection().multiply(1.5).setY(1));
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {

        Player player = event.getPlayer();

        if (player.getGameMode() != GameMode.CREATIVE && player.getLocation().subtract(0.0, 0.5, 0.0).getBlock().getType() != Material.AIR && !player.isFlying() && player.getInventory().getBoots().getItemMeta().getCustomModelData() == 3) {
            player.setAllowFlight(true);
        }
    }
}
