package fr.program.pranction.events;

import fr.program.pranction.Pranction;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoined {
    public static void init(PlayerJoinEvent event, Pranction plugin) {
        Player player = event.getPlayer();
        player.getInventory().clear();

        if (!plugin.getConfig().contains("players." + player.getUniqueId())) {
            plugin.getConfig().set("players." + player.getUniqueId() + ".name", player.getDisplayName());
            plugin.getConfig().set("players." + player.getUniqueId() + ".banned", false);
            plugin.getConfig().set("players." + player.getUniqueId() + ".reason_ban", "N/A");
            plugin.getConfig().set("players." + player.getUniqueId() + ".time_ban", 0);
            plugin.getConfig().set("players." + player.getUniqueId() + ".muted", false);
            plugin.saveConfig();
        }

        if (plugin.getConfig().getBoolean("players." + player.getUniqueId() + ".banned")) {
            player.kickPlayer("Vous avez ete banni !");
        }
    }
}
