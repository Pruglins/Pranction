package fr.program.pranction.events;

import fr.program.pranction.Pranction;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

public class PlayerChated {

    private static boolean isMuteTimerOver(Player player, Pranction plugin) {
        Instant now = Instant.now();
        long banEndTimestamp = plugin.getConfig().getLong("players." + player.getUniqueId() + ".time_mute");
        Instant banEnd = Instant.ofEpochMilli(banEndTimestamp);
        return now.isAfter(banEnd);
    }

    public static void init(AsyncPlayerChatEvent event, Pranction plugin) {
        Player player = event.getPlayer();
        if (plugin.getConfig().getBoolean("players." + player.getUniqueId() + ".muted")) {
            String reason_mute = plugin.getConfig().getString("players." + player.getUniqueId() + ".reason_mute");
            String s = "[" + ChatColor.BOLD + ChatColor.LIGHT_PURPLE + "Pranction" + ChatColor.RESET + ChatColor.WHITE + "] Vous n'avez pas la permission de parler dans le chat publique ! Raison : " + reason_mute.toString();
            System.out.println("Temps : " + plugin.getConfig().getLong("players." + player.getUniqueId() + ".time_mute"));
            if (plugin.getConfig().getLong("players." + player.getUniqueId() + ".time_mute") == (long) 0 ) {
                long time_mute_config = plugin.getConfig().getLong("players." + player.getUniqueId() + ".time_mute");
                Timestamp ts = new Timestamp(time_mute_config);
                Date time_mute = new Date(ts.getTime());

                player.sendMessage(s);
                event.setCancelled(true);
            } else {
                boolean mute_over = isMuteTimerOver(player, plugin);
                System.out.println("Mute Finis : " + mute_over);
                if (mute_over) {
                    plugin.getConfig().set("players." + player.getUniqueId() + ".muted", false);
                    plugin.getConfig().set("players." + player.getUniqueId() + ".reason_mute", "N/A");
                    plugin.getConfig().set("players." + player.getUniqueId() + ".time_mute", (long) 0);
                    plugin.saveConfig();
                } else {
                    player.sendMessage(s);
                    event.setCancelled(true);
                }
            }
        }
    }
}
