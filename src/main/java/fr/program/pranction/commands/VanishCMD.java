package fr.program.pranction.commands;

import fr.program.pranction.Pranction;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VanishCMD implements CommandExecutor {

    Pranction plugin;
    public VanishCMD(Pranction plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("vanish")) {
            if (sender instanceof Player) {
                Player plr = (Player) sender;

                String mode = args[0];
                System.out.println(mode);
                if (mode.equalsIgnoreCase("on")) {
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        p.hidePlayer(plugin, plr);
                    }
                    plr.sendMessage("[" + ChatColor.BOLD + ChatColor.LIGHT_PURPLE + "Pranction" + ChatColor.RESET + ChatColor.WHITE + "] Vous êtes invisible.");
                    return true;
                } else if (mode.equalsIgnoreCase("off")) {
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        p.showPlayer(plugin, plr);
                    }
                    plr.sendMessage("[" + ChatColor.BOLD + ChatColor.LIGHT_PURPLE + "Pranction" + ChatColor.RESET + ChatColor.WHITE + "] Vous n'êtes plus invisible.");
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
