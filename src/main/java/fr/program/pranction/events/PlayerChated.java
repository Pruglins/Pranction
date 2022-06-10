package fr.program.pranction.events;

import fr.program.pranction.Pranction;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChated {
    public static void init(AsyncPlayerChatEvent event, Pranction plugin) {
        Player player = event.getPlayer();

        if (plugin.getConfig().getBoolean("players." + player.getUniqueId() + ".muted")) {
            player.sendMessage("[" + ChatColor.BOLD + ChatColor.LIGHT_PURPLE + "Pranction" + ChatColor.RESET + ChatColor.WHITE + "] Vous n'avez pas la permission de parler dans le chat publique !");
            event.setCancelled(true);
        }
    }
}
