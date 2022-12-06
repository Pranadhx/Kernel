package me.torovoro.kernel.Events;

import me.torovoro.kernel.Utils.ColorUtils;
import org.bukkit.Bukkit;
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
        objective.setDisplayName(ColorUtils.translateColorCodes("&8&m      &r &#fce9b6&lK&#fde4ae&lE&#fddea7&lR&#fed99f&lN&#fed398&lE&#ffce90&lL &r&8&m      "));
        Score l1 = objective.getScore(""); //create a line for the board
        Score l2 = objective.getScore(ColorUtils.translateColorCodes("&6&l• &6Player"));
        Score l3 = objective.getScore(ColorUtils.translateColorCodes("  &e" + player.getDisplayName()));
        Score l4 = objective.getScore(ColorUtils.translateColorCodes("&1"));
        Score l5 = objective.getScore("Welcome to the");
        Score l6 = objective.getScore("production server");
        Score l7 = objective.getScore(ColorUtils.translateColorCodes("of &eKernel!"));
        Score l8 = objective.getScore(ColorUtils.translateColorCodes("&2"));
        Score l9 = objective.getScore("Produced by");
        Score l10 = objective.getScore(ColorUtils.translateColorCodes("&6torovoro"));
        Score l11 = objective.getScore(ColorUtils.translateColorCodes("&3"));
        Score l12 = objective.getScore(ColorUtils.translateColorCodes("&ewww.kernels.live"));

        l1.setScore(12);
        l2.setScore(11);
        l3.setScore(10);
        l4.setScore(9);
        l5.setScore(8);
        l6.setScore(7);
        l7.setScore(6);
        l8.setScore(5);
        l9.setScore(4);
        l10.setScore(3);
        l11.setScore(2);
        l12.setScore(1);

        player.setScoreboard(scoreboard);
    }
}
