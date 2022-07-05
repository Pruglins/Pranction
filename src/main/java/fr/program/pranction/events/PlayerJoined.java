package fr.program.pranction.events;

import fr.program.pranction.Pranction;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

public class PlayerJoined {

    private static boolean isBanTimeOver(Player player, Pranction plugin) {
        Instant now = Instant.now();
        long banEndTimestamp = plugin.getConfig().getLong("players." + player.getUniqueId() + ".time_ban");
        Instant banEnd = Instant.ofEpochMilli(banEndTimestamp);
        return now.isAfter(banEnd);
    }

    public static void init(PlayerJoinEvent event, Pranction plugin) {
        Player player = event.getPlayer();
        player.getInventory().clear();

        if (!plugin.getConfig().contains("players." + player.getUniqueId())) {
            plugin.getConfig().set("players." + player.getUniqueId() + ".name", player.getDisplayName());
            plugin.getConfig().set("players." + player.getUniqueId() + ".banned", false);
            plugin.getConfig().set("players." + player.getUniqueId() + ".muted", false);
            plugin.getConfig().set("players." + player.getUniqueId() + ".time_ban", (long) 0);
            plugin.getConfig().set("players." + player.getUniqueId() + ".time_mute", (long) 0);
            plugin.getConfig().set("players." + player.getUniqueId() + ".reason_ban", "N/A");
            plugin.getConfig().set("players." + player.getUniqueId() + ".reason_mute", "N/A");
            plugin.saveConfig();
        }

        if (plugin.getConfig().getBoolean("players." + player.getUniqueId() + ".banned")) {
            String reason_ban = plugin.getConfig().getString("players." + player.getUniqueId() + ".reason_ban");
            long time_ban_config = plugin.getConfig().getLong("players." + player.getUniqueId() + ".time_ban");
            Timestamp ts = new Timestamp(time_ban_config);
            Date time_ban = new Date(ts.getTime());
            if (plugin.getConfig().getInt("players." + player.getUniqueId() + ".time_ban") == (long) 0) {
                player.kickPlayer(ChatColor.RESET  + "[" + ChatColor.LIGHT_PURPLE + "Pranction Ban" + ChatColor.RESET + "]" +
                        " \n Raison : " + reason_ban.toString() +
                        " \n Duree/Prend fin : " + ChatColor.BOLD + "Permanante");
            } else {
                boolean ban_over = isBanTimeOver(player, plugin);
                if (ban_over) {
                    plugin.getConfig().set("players." + player.getUniqueId() + ".banned", false);
                    plugin.getConfig().set("players." + player.getUniqueId() + ".reason_ban", "N/A");
                    plugin.getConfig().set("players." + player.getUniqueId() + ".time_ban", (long) 0);
                    plugin.saveConfig();
                } else {
                    player.kickPlayer(ChatColor.RESET  + "[" + ChatColor.LIGHT_PURPLE + "Pranction Ban" + ChatColor.RESET + "] " +
                            " \n Raison : " + reason_ban.toString() +
                            " \n Duree/Prend fin : " + ChatColor.BOLD + time_ban.toString());
                }
            }
        }
    }
}
