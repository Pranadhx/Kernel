package me.torovoro.kernel.Events.Tools;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class GrapplingHook implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void grapplingHookCheck(PlayerFishEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        if(event.getState() == PlayerFishEvent.State.REEL_IN || event.getState() == PlayerFishEvent.State.IN_GROUND) {
            if(item.getItemMeta().getCustomModelData() != 3) {
                return;
            }
            Location loc1 = player.getLocation();
            Location loc2 = event.getHook().getLocation();

            Vector v = new Vector(loc2.getX() - loc1.getX(), 1, loc2.getZ() - loc1.getZ());
            player.setVelocity(v);
            }
        }
    }
