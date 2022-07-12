package fr.program.pranction.commands;

import fr.program.pranction.Pranction;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UnbanCMD implements CommandExecutor {

    Pranction plugin;
    public UnbanCMD(Pranction plugin) { this.plugin = plugin; }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("unban")) {
            if (sender instanceof Player) {
                Player plr = (Player) sender;

                Player target = Bukkit.getPlayer(args[0]);

                if (target == null) {return false;}

                if (plugin.getConfig().getBoolean("players." + target.getUniqueId() + ".banned")) {

                    plugin.getConfig().set("players." + target.getUniqueId() + ".banned", false);
                    plugin.getConfig().set("players." + target.getUniqueId() + ".reason_ban", "N/A");
                    plugin.getConfig().set("players." + target.getUniqueId() + ".time_ban", (long) 0 );
                    plugin.saveConfig();
                    plr.sendMessage("[" + ChatColor.BOLD + ChatColor.LIGHT_PURPLE + "Pranction" + ChatColor.RESET + ChatColor.WHITE + "] Le joueur n'est plus banni(e) !");

                    return true;
                } else {
                    plr.sendMessage("[" + ChatColor.BOLD + ChatColor.LIGHT_PURPLE + "Pranction" + ChatColor.RESET + ChatColor.WHITE + "] Le joueur n'est pas banni(e) !");
                    return false;
                }
            }
        }
        return false;
    }
}
