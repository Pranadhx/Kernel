package me.torovoro.kernel.Events;

import me.torovoro.kernel.Kernel;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

public class TNTRod implements Listener {

    Plugin plugin = Kernel.getPlugin(Kernel.class);

    @EventHandler
    public void RodRightClick(PlayerInteractEvent event) {

        int tnt_explosion_ticks = plugin.getConfig().getInt("tnt_explosion_ticks");

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
        tnt.setFuseTicks(tnt_explosion_ticks);
        // Multiply direction from location by 2 and store as vector
        Vector v = location.getDirection().multiply(2);
        // Apply vector to primed TNT
        tnt.setVelocity(v);
    }
}
