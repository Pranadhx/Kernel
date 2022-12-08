package me.torovoro.kernel.Events.Tools;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class DashSword implements Listener {
    @EventHandler
    public void dashRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if(!event.getAction().isRightClick() | !event.getHand().equals(EquipmentSlot.HAND))
            return;
        if(!event.getItem().getType().equals(Material.IRON_SWORD))
            return;
        if(event.getItem().getItemMeta().getCustomModelData() != 3)
            return;
        player.setVelocity(player.getLocation().getDirection().multiply(2).setY(1));
    }
}
