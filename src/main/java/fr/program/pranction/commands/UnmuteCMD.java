package fr.program.pranction.commands;

import fr.program.pranction.Pranction;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UnmuteCMD implements CommandExecutor {
    Pranction plugin;

    public UnmuteCMD(Pranction plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("unmute")) {
            if (sender instanceof Player){
                Player plr = (Player) sender;

                Player target = Bukkit.getPlayer(args[0]);

                if (!plugin.getConfig().contains("players." + target.getUniqueId())) {
                    plugin.getConfig().set("players." + target.getUniqueId() + ".name", target.getDisplayName());
                    plugin.getConfig().set("players." + target.getUniqueId() + ".banned", false);
                    plugin.getConfig().set("players." + target.getUniqueId() + ".reason_ban", "N/A");
                    plugin.getConfig().set("players." + target.getUniqueId() + ".time_ban", 0);
                    plugin.getConfig().set("players." + target.getUniqueId() + ".muted", false);
                    plugin.saveConfig();
                }

                if (!plugin.getConfig().getBoolean("players." + target.getUniqueId() + ".muted")) {
                    plr.sendMessage("[" + ChatColor.BOLD + ChatColor.LIGHT_PURPLE + "Pranction" + ChatColor.RESET + ChatColor.WHITE + "] Le joueur n'est pas reduit au silence !");
                    return false;
                } else {
                    plugin.getConfig().set("players." + target.getUniqueId() + ".muted", false);
                    plugin.saveConfig();
                    plr.sendMessage("[" + ChatColor.BOLD + ChatColor.LIGHT_PURPLE + "Pranction" + ChatColor.RESET + ChatColor.WHITE + "] Le joueur peut des maintenant parler !");
                }
                return true;
            }
        }
        return false;
    }
}
