package fr.program.pranction.commands;

import fr.program.pranction.Pranction;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ModtCMD implements CommandExecutor {
    Pranction plugin;

    public ModtCMD(Pranction plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("modt") || command.getName().equalsIgnoreCase("modtool")) {
            if (sender instanceof Player) {
                Player plr = (Player) sender;

                ItemStack stick_kb_1 = new ItemStack(Material.STICK, 1);
                ItemMeta meta_stickk1 = stick_kb_1.getItemMeta();
                meta_stickk1.setDisplayName("KB 1");
                meta_stickk1.addEnchant(Enchantment.KNOCKBACK, 1, true);
                meta_stickk1.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                stick_kb_1.setItemMeta(meta_stickk1);

                ItemStack stick_kb_2 = new ItemStack(Material.STICK, 1);
                ItemMeta meta_stickk2 = stick_kb_2.getItemMeta();
                meta_stickk2.setDisplayName("KB 2");
                meta_stickk2.addEnchant(Enchantment.KNOCKBACK, 2, true);
                meta_stickk2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                stick_kb_2.setItemMeta(meta_stickk2);

                plr.getInventory().clear();
                plr.getInventory().addItem(stick_kb_1);
                plr.getInventory().addItem(stick_kb_2);
                plr.updateInventory();
            }
        }
        return false;
    }
}
