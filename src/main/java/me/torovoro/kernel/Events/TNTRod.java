package me.torovoro.kernel.Events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.util.Vector;

public class TNTRod implements Listener {
    @EventHandler
    public void RodRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if(!event.getAction().isRightClick() | !event.getHand().equals(EquipmentSlot.HAND))
            return;
        if(!event.getItem().getType().equals(Material.LIGHTNING_ROD))
            return;
        if(event.getItem().getItemMeta().getCustomModelData() != 3)
            return;
        // Grab player's head location and place a primed TNT
        Location location = player.getEyeLocation();
        TNTPrimed tnt = player.getWorld().spawn(location, TNTPrimed.class);
        // Multiply direction from location by 2 and store as vector
        Vector v = location.getDirection().multiply(2);
        // Apply vector to primed TNT
        tnt.setVelocity(v);
    }
}
