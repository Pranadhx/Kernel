package me.torovoro.kernel.Events;

import io.papermc.paper.event.player.PlayerArmSwingEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class TemporaryTestHit implements Listener {

    @EventHandler
    public void onPunch(PlayerArmSwingEvent event) {
        Player player = event.getPlayer();
        player.sendMessage("§6§l* §7You §eswing §7your arm.");
    }
}
