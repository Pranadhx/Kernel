package me.torovoro.kernel.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;
import java.util.UUID;

public class TemporaryTestHit implements Listener {

    // key = uuid of player
    // long = epoch time of when player last punched
    private final HashMap<UUID, Long> cooldown;

    public TemporaryTestHit() {
        this.cooldown = new HashMap<>();
    }
    @EventHandler
    public void onPunch(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (!this.cooldown.containsKey(player.getUniqueId())) {
            this.cooldown.put(player.getUniqueId(), System.currentTimeMillis());
            player.sendMessage("§6§l* §7You §einteracted §7with a button/lever.");
        } else {
            // difference in milliseconds
            long timeElapsed = System.currentTimeMillis() - cooldown.get(player.getUniqueId());
            if (timeElapsed >= 1000) {
                this.cooldown.put(player.getUniqueId(), System.currentTimeMillis());
                player.sendMessage("§6§l* §7You §einteracted §7with a button.");
            } else {
                player.sendMessage("Wait to interact again in " + (1000 - timeElapsed) + " milliseconds.");
            }
        }
    }
}
