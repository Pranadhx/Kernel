package me.torovoro.kernel.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Levels implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("level")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    player.sendMessage("§8§m                                                     ");
                    player.sendMessage("§6§l* §e/level view (player) §8- §7View yours or another player's level.");
                    player.sendMessage("§6§l* §e/level add (amount) (player) §8- §7Add exp levels to your existing amount.");
                    player.sendMessage("§6§l* §e/level set (amount) (player) §8- §7Set exp levels to a certain value.");
                    player.sendMessage("§8§m                                                     ");
                    return true;
                }
                if (args.length == 1) {
                    args1(sender, args);
                }
                if (args.length > 1) {
                    args1(sender, args);
                }
                return true;
            }
        }
        return true;
    }

    private void args1(CommandSender sender, String[] args) {
        switch (args[0]) {
            case "view":
                if(args.length > 1) {
                    Player player = (Player) sender;
                    Player p = player.getServer().getPlayer(args[1]);
                    if(p == null) {
                        player.sendMessage("§6§l* §7That player is not online or does not exist.");
                    } else {
                        int exp = p.getLevel();
                        player.sendMessage("§6§l* §e" + args[1] + "'s §7level is §e" + exp + ".");
                    }
                    break;
                } else {
                    Player player = (Player) sender;
                    player.sendMessage("§6§l* §e§7Your §elevel §7is §e" + player.getLevel() + ".");
                    break;
                }
            case "add":
                if(args.length > 2) {
                    Player player = (Player) sender;
                    Player p = player.getServer().getPlayer(args[2]);
                    if(p == null) {
                        player.sendMessage("§6§l* §7That player is not online or does not exist.");
                    } else {
                        int exp = p.getLevel();
                        int newExp = exp + Integer.parseInt(args[1]);
                        p.setLevel(newExp);
                        player.sendMessage("§6§l* §e" + args[2] + "'s §7level is now §e" + newExp + ".");
                    }
                    break;
                } else if(args.length == 2) {
                    Player player = (Player) sender;
                    player.sendMessage("§6§l* §7Usage: §e/level add (amount) (player)");
                    break;
                }
        }
    }
}







                /*if(args.length > 1) {
                    if(args[0].equals("view")) {
                        if(args[1].equals("")) {
                            player.sendMessage("§6§l* §e §7Your §elevel is §e" + player.getLevel() + ".");
                        } else {
                            Player p = player.getServer().getPlayer(args[1]);
                            if(p == null) {
                                player.sendMessage("§6§l* §7That player is not online or does not exist.");
                            } else {
                                int exp = p.getLevel();
                                player.sendMessage("§6§l* §e" + args[1] + "'s §7level is §e" + exp + ".");
                            }
                        }
                    } else if(args[0].equals("add")) {
                        if(args[1].equals("")) {
                            player.sendMessage("§8§l* §7Usage: §e/level add (amount) (player)");
                        } else {
                            if(args[2].equals("")) {
                                player.sendMessage("§8§l* §7Usage: §e/level add (amount) (player)");
                            } else {
                                Player p = player.getServer().getPlayer(args[3]);
                                if (p == null) {
                                    player.sendMessage("§6§l* §7That player is not online or does not exist.");
                                } else {
                                    int exp = p.getLevel();
                                    int addExp = Integer.parseInt(args[2]);
                                    int newExp = exp + addExp;
                                    player.sendMessage("§6§l* §e" + args[3] + "'s §7level is now §e" + newExp + ".");
                                }
                            }
                        }
                    }
                }*/