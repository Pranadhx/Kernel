package me.torovoro.kernel.Events.Tools;

import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;

public class TeleportBow implements Listener {

    @EventHandler
    public void enderBowShoot(ProjectileHitEvent event) {

        Projectile projectile = event.getEntity();
        Player player = (Player) projectile.getShooter();
        Location location = projectile.getLocation();
        ItemStack item = player.getInventory().getItemInMainHand();

        if(!(projectile.getShooter() instanceof Player)) {
            return;
        }
        if(!(projectile instanceof Arrow)) {
            return;
        }
        if(item.getItemMeta().getCustomModelData() != 3) {
            return;
        }
        location.setYaw(player.getLocation().getYaw());
        location.setPitch(player.getLocation().getPitch());
        player.teleport(location);
        projectile.remove();
    }
}
