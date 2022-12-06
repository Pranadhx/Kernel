package me.torovoro.kernel.Events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class LaunchPad implements Listener {

    @EventHandler
    public void launchPad(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location blockUnder = player.getLocation();
        blockUnder.setY(blockUnder.getY() - 1);
        if(player.getLocation().getBlock().getType().equals(Material.LIGHT_WEIGHTED_PRESSURE_PLATE) && blockUnder.getBlock().getType().equals(Material.REDSTONE_BLOCK)) {
            player.setVelocity(player.getLocation().getDirection().multiply(3).setY(2));
        }
    }
}
