package me.torovoro.kernel.Commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Gamemode implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("gamemode")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length < 1) {
                    player.sendMessage("§6§l* §7Usage: §e/gamemode (creative, survival, spectator) (player)");
                    return true;
                }
                if (args.length == 1) {
                    if (args[0].matches("creative|c")) {
                        player.setGameMode(GameMode.CREATIVE);
                        player.sendMessage("§6§l* §7Gamemode §7has been set to §ecreative.");
                        return true;
                    }
                    if (args[0].matches("survival|s")) {
                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage("§6§l* §7Gamemode §7has been set to §esurvival.");
                        return true;
                    }
                    if (args[0].matches("spectator|sp")) {
                        player.setGameMode(GameMode.SPECTATOR);
                        player.sendMessage("§6§l* §7Gamemode §7has been set to §espectator.");
                        return true;
                    }
                }
                if (args.length == 2) {
                    Player p = player.getServer().getPlayer(args[1]);
                    if (p == null) {
                        player.sendMessage("§6§l* §7That player is not online or does not exist.");
                        return true;
                    }
                    if (args[0].matches("creative|c")) {
                        p.setGameMode(GameMode.CREATIVE);
                        player.sendMessage("§6§l* §e" + p.getDisplayName() + "'s §7gamemode §7has been set to §ecreative.");
                        return true;
                    }
                    if (args[0].matches("survival|s")) {
                        p.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage("§6§l* §e" + p.getDisplayName() + "'s §7gamemode §7has been set to §esurvival.");
                        return true;
                    }
                    if (args[0].matches("spectator|sp")) {
                        p.setGameMode(GameMode.SPECTATOR);
                        player.sendMessage("§6§l* §e" + p.getDisplayName() + "'s §7gamemode §7has been set to §espectator.");
                        return true;
                    }
                }
            }
            return true;
        } else if (command.getName().equalsIgnoreCase("gmc")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length < 1) {
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage("§6§l* §7Gamemode §7has been set to §ecreative.");
                } else {
                    Player p = player.getServer().getPlayer(args[0]);
                    if (p == null) {
                        player.sendMessage("§6§l* §7That player is not online or does not exist.");
                        return true;
                    }
                    p.setGameMode(GameMode.CREATIVE);
                    player.sendMessage("§6§l* §e" + p.getDisplayName() + "'s §7gamemode §7has been set to §ecreative.");
                }
                return true;
            }
        } else if (command.getName().equalsIgnoreCase("gms")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length < 1) {
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage("§6§l* §7Gamemode §7has been set to §esurvival.");
                } else {
                    Player p = player.getServer().getPlayer(args[0]);
                    if (p == null) {
                        player.sendMessage("§6§l* §7That player is not online or does not exist.");
                        return true;
                    }
                    p.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage("§6§l* §e" + p.getDisplayName() + "'s §7gamemode §7has been set to §esurvival.");
                }
                return true;
            }
        } else if (command.getName().equalsIgnoreCase("gmsp")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length < 1) {
                    player.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage("§6§l* §7Gamemode §7has been set to §espectator.");
                } else {
                    Player p = player.getServer().getPlayer(args[0]);
                    if (p == null) {
                        player.sendMessage("§6§l* §7That player is not online or does not exist.");
                        return true;
                    }
                    p.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage("§6§l* §e" + p.getDisplayName() + "'s §7gamemode §7has been set to §espectator.");
                }
                return true;
            }
        }
        return true;
    }
}
