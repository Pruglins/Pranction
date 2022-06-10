package fr.program.pranction.commands;

import fr.program.pranction.Pranction;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MuteCMD implements CommandExecutor {
    Pranction plugin;

    public MuteCMD(Pranction plugin) {
        this.plugin = plugin;
    }

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
        if (command.getName().equalsIgnoreCase("mute")) {
            if (sender instanceof Player){
                Player plr = (Player) sender;

                Player target = Bukkit.getPlayer(args[0]);

                if (!plugin.getConfig().contains("players." + target.getUniqueId())) {
                    plugin.getConfig().set("players." + target.getUniqueId() + ".name", target.getDisplayName());
                    plugin.getConfig().set("players." + target.getUniqueId() + ".banned", false);
                    plugin.getConfig().set("players." + target.getUniqueId() + ".reason_ban", "N/A");
                    plugin.getConfig().set("players." + target.getUniqueId() + ".time_ban", 0);
                    plugin.getConfig().set("players." + target.getUniqueId() + ".muted", true);
                    plugin.saveConfig();
                }

                if (plugin.getConfig().getBoolean("players." + target.getUniqueId() + ".muted")) {
                    plr.sendMessage("[" + ChatColor.BOLD + ChatColor.LIGHT_PURPLE + "Pranction" + ChatColor.RESET + ChatColor.WHITE + "] Le joueur a deja ete reduit au silence !");
                    return false;
                } else {
                    plugin.getConfig().set("players." + target.getUniqueId() + ".muted", true);
                    plugin.saveConfig();
                }

                StringBuilder reason_mute = new StringBuilder();
                StringBuilder bcargs = ArrayToStringRemoveCase(0, args);
                String[] nargs = bcargs.toString().split(" ");
                for (String part : nargs) {
                    reason_mute.append(part).append(" ");
                }

                Bukkit.broadcastMessage("[" + ChatColor.BOLD + ChatColor.LIGHT_PURPLE + "Pranction" + ChatColor.RESET + ChatColor.WHITE + "] Le joueur " + target.getDisplayName() + " a ete sanctionne par un moderateur pour : " + reason_mute.toString());
                return true;
            }
        }
        return false;
    }
}
