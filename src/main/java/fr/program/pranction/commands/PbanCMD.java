package fr.program.pranction.commands;

import fr.program.pranction.Pranction;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PbanCMD implements CommandExecutor {
    Pranction plugin;

    public PbanCMD(Pranction plugin) {this.plugin = plugin;}

    private StringBuilder ArrayToStringRemoveCase(int remove_index, String[] array) {
        StringBuilder bc = new StringBuilder();
        int i = 0;
        for (String part : array) {
            if (i != remove_index) {
                bc.append(part).append(" ");
            }
            i++;
        }
        return bc;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("pban") || command.getName().equalsIgnoreCase("permaban")) {
            if (sender instanceof Player) {
                Player plr = (Player) sender;
                Player target = Bukkit.getPlayer(args[0]);

                if (target == null ) {return false;}

                if (!plugin.getConfig().contains("players." + target.getUniqueId())) {
                    plr.sendMessage("[" + ChatColor.BOLD + ChatColor.LIGHT_PURPLE + "Pranction" + ChatColor.RESET + ChatColor.WHITE + "] Le joueur ne s'est jamais connecte !");
                    return false;
                } else if (plugin.getConfig().getBoolean("players." + target.getUniqueId() + ".banned"))  {
                    plr.sendMessage("[" + ChatColor.BOLD + ChatColor.LIGHT_PURPLE + "Pranction" + ChatColor.RESET + ChatColor.WHITE + "] Le joueur est deja banni(e) !");
                    return false;
                } else {
                    StringBuilder reason_ban = new StringBuilder();
                    StringBuilder bcargs = ArrayToStringRemoveCase(0, args);
                    String[] nargs = bcargs.toString().split(" ");
                    for (String part : nargs) {
                        reason_ban.append(part).append(" ");
                    }
                    plr.sendMessage("[" + ChatColor.BOLD + ChatColor.LIGHT_PURPLE + "Pranction" + ChatColor.RESET + ChatColor.WHITE + "] Le joueur est maintenant banni(e) a vie !");
                    Bukkit.broadcastMessage("[" + ChatColor.BOLD + ChatColor.LIGHT_PURPLE + "Pranction" + ChatColor.RESET + ChatColor.WHITE + "] Le joueur " + target.getDisplayName() + " a ete sanctionne par un moderateur pour : " + reason_ban.toString());
                    plugin.getConfig().set("players." + target.getUniqueId() + ".banned", true);
                    plugin.getConfig().set("players." + target.getUniqueId() + ".reason_ban", reason_ban.toString());
                    plugin.getConfig().set("players." + target.getUniqueId() + ".time_ban", (long) 0);
                    plugin.saveConfig();
                    target.kickPlayer(ChatColor.RESET  + "[" + ChatColor.LIGHT_PURPLE + "Pranction Ban" + ChatColor.RESET + "] \n Raison : " + reason_ban.toString());
                    return true;
                }
            }
        }
        return false;
    }
}
