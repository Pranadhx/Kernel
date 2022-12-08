package me.torovoro.kernel.Events.Tools;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExpBottleEvent;

public class EXPBottleBreak implements Listener {
    @EventHandler
    public void expBottleBreak(ExpBottleEvent event) {

        Location location = event.getEntity().getLocation();
        Player player = (Player) event.getEntity().getShooter();

        location.createExplosion(2);
        event.setExperience(0);
    }
}
