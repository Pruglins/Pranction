package fr.program.pranction.commands;

import fr.program.pranction.Pranction;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.Arrays;

public class SpCMD implements CommandExecutor {
    Pranction plugin;

    public SpCMD(Pranction plugin) {
        this.plugin = plugin;
    }

    private ItemStack createItem(Material material, int quantity, String name) {
        ItemStack item = new ItemStack(material, quantity);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("sp") || command.getName().equalsIgnoreCase("sanctionplayer")) {
            if (sender instanceof Player) {
                Player plr = (Player) sender;

                Player target = Bukkit.getPlayer(args[0]);

                Inventory GUI_SP = Bukkit.createInventory(null, 54, "SP : " + target.getDisplayName());

                NamespacedKey key_playerhead = new NamespacedKey(plugin, "playerhead-key");
                ItemStack head_player = createItem(Material.PLAYER_HEAD, 1, target.getDisplayName());
                ItemMeta head_player_meta = head_player.getItemMeta();
                head_player_meta.setLore(Arrays.asList(
                        ChatColor.GREEN + "Information(s) sur le joueur " + target.getDisplayName(),
                        "Reduit au silence : " + plugin.getConfig().getBoolean("players." + target.getUniqueId() + ".muted")
                ));
                head_player_meta.getPersistentDataContainer().set(key_playerhead, PersistentDataType.DOUBLE, Math.PI);
                head_player.setItemMeta(head_player_meta);
                GUI_SP.setItem(0, head_player);

                NamespacedKey key_trichesword = new NamespacedKey(plugin, "trichesword-key");
                ItemStack triche_sword = createItem(Material.DIAMOND_SWORD, 1, "Triche");
                ItemMeta triche_sword_meta = triche_sword.getItemMeta();
                triche_sword_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                triche_sword_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                triche_sword_meta.addEnchant(Enchantment.DAMAGE_ALL, 5, false);
                triche_sword_meta.getPersistentDataContainer().set(key_trichesword, PersistentDataType.DOUBLE, Math.PI);
                triche_sword.setItemMeta(triche_sword_meta);
                GUI_SP.setItem(1, triche_sword);

                NamespacedKey key_paperchat = new NamespacedKey(plugin, "paperchat-key");
                ItemStack paper_chat = createItem(Material.PAPER, 1, "Chat");
                ItemMeta paper_chat_meta = paper_chat.getItemMeta();
                paper_chat_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                paper_chat_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                paper_chat_meta.addEnchant(Enchantment.ARROW_FIRE, 1, false);
                paper_chat_meta.getPersistentDataContainer().set(key_paperchat, PersistentDataType.DOUBLE, Math.PI);
                paper_chat.setItemMeta(paper_chat_meta);
                GUI_SP.setItem(2, paper_chat);

                NamespacedKey key_construction = new NamespacedKey(plugin, "construction-key");
                ItemStack construction = createItem(Material.WHITE_WOOL, 1, "Construction");
                ItemMeta construction_meta = construction.getItemMeta();
                construction_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                construction_meta.addEnchant(Enchantment.KNOCKBACK, 2, false);
                construction_meta.getPersistentDataContainer().set(key_construction, PersistentDataType.DOUBLE, Math.PI);
                construction.setItemMeta(construction_meta);
                GUI_SP.setItem(3, construction);

                plr.openInventory(GUI_SP);
            }
        }
        return false;
    }
}
