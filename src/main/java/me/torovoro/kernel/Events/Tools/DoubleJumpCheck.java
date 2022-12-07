package me.torovoro.kernel.Events.Tools;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class DoubleJumpCheck implements Listener {

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
