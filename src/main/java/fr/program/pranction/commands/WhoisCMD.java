package fr.program.pranction.commands;

import fr.program.pranction.Pranction;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class WhoisCMD implements CommandExecutor {
    Pranction plugin;

    public WhoisCMD(Pranction plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("whois")){
            if (sender instanceof Player) {
                Player plr = (Player) sender;

                Player target = Bukkit.getPlayer(args[0]);

                if (target != null) {
                    String name = target.getDisplayName();
                    UUID uuid = target.getUniqueId();
                    int ping = target.getPing();

                    boolean ban = plugin.getConfig().getBoolean("players." + target.getUniqueId() + ".banned");
                    boolean mute = plugin.getConfig().getBoolean("players." + target.getUniqueId() + ".muted");

                    plr.sendMessage("[" + ChatColor.BOLD + ChatColor.LIGHT_PURPLE + "Pranction" + ChatColor.RESET + ChatColor.WHITE + "] Informations sur le joueur " + name + " ! \n" +
                            ChatColor.WHITE + "- Nom : " + ChatColor.DARK_AQUA + name + "\n" +
                            ChatColor.WHITE + "- UUID : " + ChatColor.DARK_AQUA + uuid + "\n" +
                            ChatColor.WHITE + "- Ping : " + ChatColor.DARK_AQUA + ping + "\n"+
                            ChatColor.WHITE + "- Banni : " + ChatColor.DARK_AQUA + ban + "\n" +
                            ChatColor.WHITE + "- Mute : " + ChatColor.DARK_AQUA + mute + "\n");
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
