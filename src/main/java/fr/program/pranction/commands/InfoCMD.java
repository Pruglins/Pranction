package fr.program.pranction.commands;

import fr.program.pranction.Pranction;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InfoCMD implements CommandExecutor {
    Pranction plugin;

    public InfoCMD(Pranction plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("info") || command.getName().equalsIgnoreCase("information")) {
            if (sender instanceof Player) {
                Player plr = (Player) sender;

                plr.sendMessage("Bonjour ! Pranction est un plugin qui comporte differentes commandes de moderations afin d'ameliorer leur experience.");
            }
        }
        return false;
    }
}
