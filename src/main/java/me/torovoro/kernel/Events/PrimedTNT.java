package me.torovoro.kernel.Events;

import me.torovoro.kernel.Kernel;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.Plugin;

public class PrimedTNT implements Listener {

    Plugin plugin = Kernel.getPlugin(Kernel.class);

    @EventHandler
    public void Explode(EntityExplodeEvent event) {

        boolean tnt_explosions = plugin.getConfig().getBoolean("tnt_explosions");

        if(tnt_explosions == true) {
            return;
        }
        event.blockList().clear();
    }
}
