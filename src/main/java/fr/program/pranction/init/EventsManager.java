package fr.program.pranction.init;

import fr.program.pranction.Pranction;
import fr.program.pranction.events.PlayerChated;
import fr.program.pranction.events.PlayerJoined;
import fr.program.pranction.events.SPInteraction;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventsManager implements Listener {
    Pranction plugin;

    public EventsManager(Pranction plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void PlayerJoin(PlayerJoinEvent event) {
        PlayerJoined.init(event, plugin);
    }


    @EventHandler
    public void PlayerChat(AsyncPlayerChatEvent event) {
        PlayerChated.init(event, plugin);
    }



    // SanctionPlayer Configs :

    @EventHandler
    public void SpInteraction(InventoryClickEvent event) {
        SPInteraction.init(event, plugin);
    }
}
