package me.torovoro.kernel.Events;

import me.torovoro.kernel.Utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.scoreboard.*;

public class ScoreboardInitialize implements Listener {

    @EventHandler
    public void Scoreboard(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = manager.getNewScoreboard();

        Objective objective = scoreboard.registerNewObjective("Title", "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(ColorUtils.translateColorCodes("&8&m           &r &#39ff14&lK&#51ff1c&lE&#69ff24&lR&#81ff2c&lN&#99ff34&lE&#b1ff3c&lL &r&8&m           "));

        Score l1 = objective.getScore(ChatColor.GOLD + "Money: $" + ChatColor.GREEN + 1); //create a line for the board
        Score l2 = objective.getScore(""); //blank space
        Score l3 = objective.getScore(ChatColor.DARK_PURPLE + "https://google.com");

        l1.setScore(3);
        l2.setScore(2);
        l3.setScore(1);

        player.setScoreboard(scoreboard);
    }
}
