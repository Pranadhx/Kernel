package me.torovoro.kernel.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;

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
    public void onPunch(PlayerBucketEmptyEvent event) {
        Player player = event.getPlayer();
        if (!this.cooldown.containsKey(player.getUniqueId())) {
            this.cooldown.put(player.getUniqueId(), System.currentTimeMillis());
            player.sendMessage("§6§l* §7You emptied a §ebucket.");
        } else {
            // difference in milliseconds
            long timeElapsed = System.currentTimeMillis() - cooldown.get(player.getUniqueId());
            if (timeElapsed >= 1000) {
                this.cooldown.put(player.getUniqueId(), System.currentTimeMillis());
                player.sendMessage("§6§l* §7You emptied a §ebucket.");
            } else {
                event.setCancelled(true);
                player.sendMessage("§6§l* §eWait to empty a bucket again in " + (1000 - timeElapsed) + " milliseconds.");
            }
        }
    }
}
