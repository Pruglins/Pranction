package fr.program.pranction.events;

import fr.program.pranction.Pranction;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class SPInteraction {
    public static void init(InventoryClickEvent event, Pranction plugin) {
        Player plr = (Player) event.getWhoClicked();
        ItemStack item = event.getCurrentItem();
        Inventory gui = event.getInventory();

       if (item != null && item.getType() == Material.PLAYER_HEAD && item.hasItemMeta() && item.getItemMeta().hasDisplayName()) {
            NamespacedKey key = new NamespacedKey(plugin, "playerhead-key");
            ItemMeta meta = item.getItemMeta();
            PersistentDataContainer data = meta.getPersistentDataContainer();
            if (data.has(key, PersistentDataType.DOUBLE)) {
                event.setCancelled(true);
            }
        } else if (item != null && item.getType() == Material.DIAMOND_SWORD && item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equalsIgnoreCase("Triche")) {
            NamespacedKey key = new NamespacedKey(plugin, "trichesword-key");
            ItemMeta meta = item.getItemMeta();
            PersistentDataContainer data = meta.getPersistentDataContainer();
            if (data.has(key, PersistentDataType.DOUBLE)) {
                event.setCancelled(true);
            }
        } else if (item != null && item.getType() == Material.PAPER && item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equalsIgnoreCase("Chat")) {
            NamespacedKey key = new NamespacedKey(plugin, "paperchat-key");
            ItemMeta meta = item.getItemMeta();
            PersistentDataContainer data = meta.getPersistentDataContainer();
            if (data.has(key, PersistentDataType.DOUBLE)) {
                event.setCancelled(true);
            }
        } else if (item != null && item.getType() == Material.WHITE_WOOL && item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equalsIgnoreCase("Construction")) {
            NamespacedKey key = new NamespacedKey(plugin, "construction-key");
            ItemMeta meta = item.getItemMeta();
            PersistentDataContainer data = meta.getPersistentDataContainer();
            if (data.has(key, PersistentDataType.DOUBLE)) {
                event.setCancelled(true);
            }
        }
    }
}
