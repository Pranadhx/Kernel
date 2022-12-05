package me.torovoro.kernel.Events;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinLeave implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if(player.hasPlayedBefore()) {
            event.setJoinMessage("§6§l* §e" + player.getDisplayName() + " §7joined the server. §e§l(NEW)");
        } else {
            event.setJoinMessage("§6§l* §e" + player.getDisplayName() + " §7joined the server.");
        }
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage("§6§l* §e" + player.getDisplayName() + " §7left the server.");
    }
}
