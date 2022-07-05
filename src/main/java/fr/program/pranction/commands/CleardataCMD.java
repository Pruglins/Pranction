package fr.program.pranction.commands;

import fr.program.pranction.Pranction;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CleardataCMD implements CommandExecutor {
    Pranction plugin;
    public CleardataCMD(Pranction plugin) {
        this.plugin = plugin;
    }

    private void data(Player player) {
        plugin.getConfig().set("players." + player.getUniqueId() + ".name", player.getDisplayName());
        plugin.getConfig().set("players." + player.getUniqueId() + ".banned", false);
        plugin.getConfig().set("players." + player.getUniqueId() + ".muted", false);
        plugin.getConfig().set("players." + player.getUniqueId() + ".time_ban", (long) 0);
        plugin.getConfig().set("players." + player.getUniqueId() + ".time_mute", (long) 0);
        plugin.getConfig().set("players." + player.getUniqueId() + ".reason_ban", "N/A");
        plugin.getConfig().set("players." + player.getUniqueId() + ".reason_mute", "N/A");
        plugin.saveConfig();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("cleardata")) {
            if (sender instanceof Player) {
                Player plr = (Player) sender;
                Player target = Bukkit.getPlayer(args[0]);

                if (target != null) {
                    data(target);
                    plr.sendMessage("[" + ChatColor.BOLD + ChatColor.LIGHT_PURPLE + "Pranction" + ChatColor.RESET + ChatColor.WHITE + "] Donnee supprimees !");
                    return true;
                } else {
                    plr.sendMessage("[" + ChatColor.BOLD + ChatColor.LIGHT_PURPLE + "Pranction" + ChatColor.RESET + ChatColor.WHITE + "] Merci de specifier le joueur !");
                    return false;
                }
            }
        }
        return false;
    }
}
