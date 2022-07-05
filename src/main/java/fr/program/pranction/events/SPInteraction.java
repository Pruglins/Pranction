package fr.program.pranction.events;

import fr.program.pranction.Pranction;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.TileState;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class SPInteraction {
    private static ItemStack createItem(Material material, int quantity, String name) {
        ItemStack item = new ItemStack(material, quantity);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return item;
    }

    private static ItemStack addEnch(Enchantment enchantment, int level, ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        meta.addEnchant(enchantment, level, true);
        item.setItemMeta(meta);
        return item;
    }

    private static void clearGUI(Inventory gui) {
        gui.setItem(18, null);
        gui.setItem(19, null);
        gui.setItem(20, null);
        gui.setItem(21, null);
        gui.setItem(22, null);
        gui.setItem(23, null);
        gui.setItem(24, null);
        gui.setItem(25, null);
        gui.setItem(26, null);
    }

    public static void init(InventoryClickEvent event, Pranction plugin) {
        Player author = (Player) event.getWhoClicked();
        ItemStack item = event.getCurrentItem();
        ItemMeta meta = item.getItemMeta();
        Inventory gui = event.getInventory();

        ItemStack player_head;

        if (item != null && item.hasItemMeta()) {
            NamespacedKey key_playerhead = new NamespacedKey(plugin, "playerhead-key");
            PersistentDataContainer data = meta.getPersistentDataContainer();
            if (data.has(key_playerhead, PersistentDataType.DOUBLE)) {
                player_head = gui.getItem(0);
                Player target = Bukkit.getPlayer(player_head.getItemMeta().getDisplayName());
            }
        }

        if (item != null && item.hasItemMeta() && item.getItemMeta().hasDisplayName()) {
            // Items secondaires  pour la Triche :
            NamespacedKey key_trichesword_killaura = new NamespacedKey(plugin, "trichesword-killaura-key");
            NamespacedKey key_trichesword_forcefield = new NamespacedKey(plugin, "trichesword-forcefield-key");
            NamespacedKey key_trichesword_kbreducer = new NamespacedKey(plugin, "trichesword-kbreducer-key");
            NamespacedKey key_trichesword_antikb = new NamespacedKey(plugin, "trichesword-antikb-key");
            NamespacedKey key_trichesword_fly = new NamespacedKey(plugin, "trichesword-fly-key");
            NamespacedKey key_trichesword_glide = new NamespacedKey(plugin, "trichesword-glide-key");
            NamespacedKey key_trichesword_cpsclickgauche = new NamespacedKey(plugin, "trichesword-cps_clickgauche-key");
            NamespacedKey key_trichesword_cpsclickdroit = new NamespacedKey(plugin, "trichesword-cps_clickdroit-key");
            NamespacedKey key_trichesword_autre = new NamespacedKey(plugin, "trichesword-cps_autre-key");

            // Items secondaires pour le Chat :

            NamespacedKey key_chat_insultes = new NamespacedKey(plugin, "chat-insultes-key");
            NamespacedKey key_chat_provocations = new NamespacedKey(plugin, "chat-provocations-key");
            NamespacedKey key_chat_menaces = new NamespacedKey(plugin, "chat-menaces-key");
            NamespacedKey key_chat_macro = new NamespacedKey(plugin, "chat-macro-key");
            NamespacedKey key_chat_discrimination = new NamespacedKey(plugin, "chat-discrimination-key");
            NamespacedKey key_chat_vantardise = new NamespacedKey(plugin, "chat-vantardise-key");

            // Items secondaires pour le Gameplay :

            NamespacedKey key_gameplay_aliencejeusolo = new NamespacedKey(plugin, "gameplay-aliencejeusolo-key");
            NamespacedKey key_gameplay_alienceteam = new NamespacedKey(plugin, "gameplay-alienceteam-key");
            NamespacedKey key_gameplay_skin = new NamespacedKey(plugin, "gameplay-skin-key");
            NamespacedKey key_gameplay_build = new NamespacedKey(plugin, "gameplay-construction-key");
            NamespacedKey key_gameplay_antijeu = new NamespacedKey(plugin, "gameplay-antijeu-key");

            meta = item.getItemMeta();
            PersistentDataContainer data = meta.getPersistentDataContainer();
            if (data.has(key_trichesword_killaura, PersistentDataType.DOUBLE)) {
                event.setCancelled(true);
            } else if (data.has(key_trichesword_forcefield, PersistentDataType.DOUBLE)) {
                event.setCancelled(true);
            } else if (data.has(key_trichesword_kbreducer, PersistentDataType.DOUBLE)) {
                event.setCancelled(true);
            } else if (data.has(key_trichesword_antikb, PersistentDataType.DOUBLE)) {
                event.setCancelled(true);
            } else if (data.has(key_trichesword_fly, PersistentDataType.DOUBLE)) {
                event.setCancelled(true);
            } else if (data.has(key_trichesword_glide, PersistentDataType.DOUBLE)) {
                event.setCancelled(true);
            } else if (data.has(key_trichesword_cpsclickgauche, PersistentDataType.DOUBLE)) {
                event.setCancelled(true);
            } else if (data.has(key_trichesword_cpsclickdroit, PersistentDataType.DOUBLE)) {
                event.setCancelled(true);
            } else if (data.has(key_trichesword_autre, PersistentDataType.DOUBLE)) {
                event.setCancelled(true);
            } else if (data.has(key_chat_insultes, PersistentDataType.DOUBLE)) {
                event.setCancelled(true);
            } else if (data.has(key_chat_provocations, PersistentDataType.DOUBLE)) {
                event.setCancelled(true);
            } else if (data.has(key_chat_menaces, PersistentDataType.DOUBLE)) {
                event.setCancelled(true);
            } else if (data.has(key_chat_macro, PersistentDataType.DOUBLE)) {
                event.setCancelled(true);
            } else if (data.has(key_chat_discrimination, PersistentDataType.DOUBLE)) {
                event.setCancelled(true);
            } else if (data.has(key_gameplay_aliencejeusolo, PersistentDataType.DOUBLE)) {
                event.setCancelled(true);
            }  else if (data.has(key_gameplay_alienceteam, PersistentDataType.DOUBLE)) {
                event.setCancelled(true);
            } else if (data.has(key_gameplay_skin, PersistentDataType.DOUBLE)) {
                event.setCancelled(true);
            } else if (data.has(key_gameplay_build, PersistentDataType.DOUBLE)) {
                event.setCancelled(true);
            } else if (data.has(key_gameplay_antijeu, PersistentDataType.DOUBLE)) {
                event.setCancelled(true);
            }
        }

        // Items principaux de la commande SP :

       if (item != null && item.getType() == Material.PLAYER_HEAD && item.hasItemMeta() && item.getItemMeta().hasDisplayName()) {
            clearGUI(gui);
            NamespacedKey key = new NamespacedKey(plugin, "playerhead-key");
            meta = item.getItemMeta();
           PersistentDataContainer data = meta.getPersistentDataContainer();
            if (data.has(key, PersistentDataType.DOUBLE)) {
                event.setCancelled(true);
            }
        } else if (item != null && item.getType() == Material.DIAMOND_SWORD && item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equalsIgnoreCase("Triche")) {
            clearGUI(gui);
            NamespacedKey key = new NamespacedKey(plugin, "trichesword-key"); // Triche(s)
            meta = item.getItemMeta();
           PersistentDataContainer data = meta.getPersistentDataContainer();
            if (data.has(key, PersistentDataType.DOUBLE)) {
                NamespacedKey key_trichesword_killaura = new NamespacedKey(plugin, "trichesword-killaura-key");
                ItemStack killaura_sword = createItem(Material.STONE_SWORD, 1, ChatColor.GOLD + "Kill Aura");
                ItemMeta mkillaura_sword = killaura_sword.getItemMeta();
                mkillaura_sword.getPersistentDataContainer().set(key_trichesword_killaura, PersistentDataType.DOUBLE, Math.PI);
                killaura_sword.setItemMeta(mkillaura_sword);
                gui.setItem(18, killaura_sword);

                NamespacedKey key_trichesword_forcefield = new NamespacedKey(plugin, "trichesword-forcefield-key");
                ItemStack forcefield_sword = createItem(Material.IRON_SWORD, 1, ChatColor.GOLD + "Force Field");
                ItemMeta mforcefield_sword = forcefield_sword.getItemMeta();
                mforcefield_sword.getPersistentDataContainer().set(key_trichesword_forcefield, PersistentDataType.DOUBLE, Math.PI);
                forcefield_sword.setItemMeta(mforcefield_sword);
                gui.setItem(19, forcefield_sword);

                NamespacedKey key_trichesword_kbreducer = new NamespacedKey(plugin, "trichesword-kbreducer-key");
                ItemStack kb_reducer = createItem(Material.COBWEB, 1, ChatColor.GOLD + "KB Reducer");
                ItemMeta mkb_reducer = kb_reducer.getItemMeta();
                mkb_reducer.getPersistentDataContainer().set(key_trichesword_kbreducer, PersistentDataType.DOUBLE, Math.PI);
                kb_reducer.setItemMeta(mkb_reducer);
                gui.setItem(20, kb_reducer);

                NamespacedKey key_trichesword_antikb = new NamespacedKey(plugin, "trichesword-antikb-key");
                ItemStack antikb = createItem(Material.COBWEB, 1, ChatColor.GOLD + "Anti KB");
                antikb = addEnch(Enchantment.ARROW_DAMAGE, 1, antikb);
                ItemMeta mantikb = antikb.getItemMeta();
                mantikb.getPersistentDataContainer().set(key_trichesword_antikb, PersistentDataType.DOUBLE, Math.PI);
                antikb.setItemMeta(mantikb);
                gui.setItem(21, antikb);

                NamespacedKey key_trichesword_fly = new NamespacedKey(plugin, "trichesword-fly-key");
                ItemStack fly = createItem(Material.FEATHER, 1, ChatColor.GOLD + "Fly");
                ItemMeta mfly = fly.getItemMeta();
                mfly.getPersistentDataContainer().set(key_trichesword_fly, PersistentDataType.DOUBLE, Math.PI);
                fly.setItemMeta(mfly);
                gui.setItem(22, fly);

                NamespacedKey key_trichesword_glide = new NamespacedKey(plugin, "trichesword-glide-key");
                ItemStack glide = createItem(Material.STRING, 1, ChatColor.GOLD + "Glide");
                ItemMeta mglide = glide.getItemMeta();
                mglide.getPersistentDataContainer().set(key_trichesword_glide, PersistentDataType.DOUBLE, Math.PI);
                glide.setItemMeta(mglide);
                gui.setItem(23, glide);

                NamespacedKey key_trichesword_cpsclickgauche = new NamespacedKey(plugin, "trichesword-cps_clickgauche-key");
                ItemStack cps_clickgauche = createItem(Material.WOODEN_AXE, 1, ChatColor.GOLD + "CPS Clic Gauche");
                ItemMeta mcps_clickgauche = cps_clickgauche.getItemMeta();
                mcps_clickgauche.getPersistentDataContainer().set(key_trichesword_cpsclickgauche, PersistentDataType.DOUBLE, Math.PI);
                cps_clickgauche.setItemMeta(mcps_clickgauche);
                gui.setItem(24, cps_clickgauche);

                NamespacedKey key_trichesword_cpsclickdroit = new NamespacedKey(plugin, "trichesword-cps_clickdroit-key");
                ItemStack cps_clickdroit = createItem(Material.GOLDEN_AXE, 1, ChatColor.GOLD + "CPS Clic Droit");
                ItemMeta mcps_clickdroit = cps_clickdroit.getItemMeta();
                mcps_clickdroit.getPersistentDataContainer().set(key_trichesword_cpsclickdroit, PersistentDataType.DOUBLE, Math.PI);
                cps_clickdroit.setItemMeta(mcps_clickdroit);
                gui.setItem(25, cps_clickdroit);

                NamespacedKey key_trichesword_autre = new NamespacedKey(plugin, "trichesword-cps_autre-key");
                ItemStack autre = createItem(Material.BEDROCK, 1, ChatColor.GOLD + "Autre");
                ItemMeta mautre = autre.getItemMeta();
                mautre.getPersistentDataContainer().set(key_trichesword_autre, PersistentDataType.DOUBLE, Math.PI);
                autre.setItemMeta(mautre);
                gui.setItem(26, autre);

                event.setCancelled(true);
            }
        } else if (item != null && item.getType() == Material.PAPER && item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equalsIgnoreCase("Chat")) {
            clearGUI(gui);
            NamespacedKey key = new NamespacedKey(plugin, "paperchat-key"); // Chat
            meta = item.getItemMeta();
            PersistentDataContainer data = meta.getPersistentDataContainer();
            if (data.has(key, PersistentDataType.DOUBLE)) {
                NamespacedKey key_chat_insultes = new NamespacedKey(plugin, "chat-insultes-key");
                ItemStack insultes = createItem(Material.COAL, 1, ChatColor.GOLD + "Insulte(s)");
                ItemMeta minsultes = insultes.getItemMeta();
                minsultes.getPersistentDataContainer().set(key_chat_insultes, PersistentDataType.DOUBLE, Math.PI);
                insultes.setItemMeta(minsultes);
                gui.setItem(18, insultes);

                NamespacedKey key_chat_provocations = new NamespacedKey(plugin, "chat-provocations-key");
                ItemStack provoc = createItem(Material.SNOWBALL, 1, ChatColor.GOLD + "Provocation(s)");
                ItemMeta mprovoc = provoc.getItemMeta();
                mprovoc.getPersistentDataContainer().set(key_chat_provocations, PersistentDataType.DOUBLE, Math.PI);
                provoc.setItemMeta(mprovoc);
                gui.setItem(19, provoc);

                NamespacedKey key_chat_menaces = new NamespacedKey(plugin, "chat-menaces-key");
                ItemStack menaces = createItem(Material.ENDER_EYE, 1, ChatColor.GOLD + "Menaces(s)");
                ItemMeta mmenaces = menaces.getItemMeta();
                mmenaces.getPersistentDataContainer().set(key_chat_menaces, PersistentDataType.DOUBLE, Math.PI);
                menaces.setItemMeta(mmenaces);
                gui.setItem(20, menaces);

                NamespacedKey key_chat_macro = new NamespacedKey(plugin, "chat-macro-key");
                ItemStack macro = createItem(Material.SHEARS, 1, ChatColor.GOLD + "Macro(s)");
                ItemMeta mmacro = macro.getItemMeta();
                mmacro.getPersistentDataContainer().set(key_chat_macro, PersistentDataType.DOUBLE, Math.PI);
                macro.setItemMeta(mmacro);
                gui.setItem(21, macro);

                NamespacedKey key_chat_discrimination = new NamespacedKey(plugin, "chat-discrimination-key");
                ItemStack discrim = createItem(Material.CLOCK, 1, ChatColor.GOLD + "Propos discriminatoire(s)");
                ItemMeta mdiscrim = discrim.getItemMeta();
                mdiscrim.getPersistentDataContainer().set(key_chat_discrimination, PersistentDataType.DOUBLE, Math.PI);
                discrim.setItemMeta(mdiscrim);
                gui.setItem(22, discrim);

                NamespacedKey key_chat_vantardise = new NamespacedKey(plugin, "chat-vantardise-key");
                ItemStack vant = createItem(Material.SPIDER_EYE, 1, ChatColor.GOLD + "Vantardise(s)");
                ItemMeta mvant = vant.getItemMeta();
                mvant.getPersistentDataContainer().set(key_chat_vantardise, PersistentDataType.DOUBLE, Math.PI);
                vant.setItemMeta(mvant);
                gui.setItem(23, vant);

                event.setCancelled(true);
            }
        } else if (item != null && item.getType() == Material.WHITE_WOOL && item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equalsIgnoreCase("Gameplay")) {
            clearGUI(gui);
            NamespacedKey key = new NamespacedKey(plugin, "gameplay-key"); // Gameplay
            meta = item.getItemMeta();
           PersistentDataContainer data = meta.getPersistentDataContainer();
            if (data.has(key, PersistentDataType.DOUBLE)) {
                NamespacedKey key_gameplay_aliencejeusolo = new NamespacedKey(plugin, "gameplay-aliencejeusolo-key");
                ItemStack aliencejeusolo = createItem(Material.LEATHER_CHESTPLATE, 1, ChatColor.GOLD + "Alience en jeu Solo");
                ItemMeta maliencejeusolo = aliencejeusolo.getItemMeta();
                maliencejeusolo.getPersistentDataContainer().set(key_gameplay_aliencejeusolo, PersistentDataType.DOUBLE, Math.PI);
                aliencejeusolo.setItemMeta(maliencejeusolo);
                gui.setItem(18, aliencejeusolo);

                NamespacedKey key_gameplay_alienceteam = new NamespacedKey(plugin, "gameplay-alienceteam-key");
                ItemStack alienceteam = createItem(Material.CHAINMAIL_CHESTPLATE, 1, ChatColor.GOLD + "Alience en equipe");
                ItemMeta malienceteam = alienceteam.getItemMeta();
                malienceteam.getPersistentDataContainer().set(key_gameplay_alienceteam, PersistentDataType.DOUBLE, Math.PI);
                alienceteam.setItemMeta(malienceteam);
                gui.setItem(19, alienceteam);

                NamespacedKey key_gameplay_skin = new NamespacedKey(plugin, "gameplay-skin-key");
                ItemStack skin = createItem(Material.CREEPER_HEAD, 1, ChatColor.GOLD + "Skin Incorrect");
                ItemMeta mskin = skin.getItemMeta();
                mskin.getPersistentDataContainer().set(key_gameplay_skin, PersistentDataType.DOUBLE, Math.PI);
                skin.setItemMeta(mskin);
                gui.setItem(20, skin);

                NamespacedKey key_gameplay_build = new NamespacedKey(plugin, "gameplay-construction-key");
                ItemStack build = createItem(Material.DIRT, 1, ChatColor.GOLD + "Construction Incorrect");
                ItemMeta mbuild = build.getItemMeta();
                mbuild.getPersistentDataContainer().set(key_gameplay_build, PersistentDataType.DOUBLE, Math.PI);
                build.setItemMeta(mbuild);
                gui.setItem(21, build);

                NamespacedKey key_gameplay_antijeu = new NamespacedKey(plugin, "gameplay-antijeu-key");
                ItemStack antijeu = createItem(Material.FLINT_AND_STEEL, 1, ChatColor.GOLD + "Anti-Jeu");
                ItemMeta mantijeu = antijeu.getItemMeta();
                mantijeu.getPersistentDataContainer().set(key_gameplay_antijeu, PersistentDataType.DOUBLE, Math.PI);
                antijeu.setItemMeta(mantijeu);
                gui.setItem(22, antijeu);

                event.setCancelled(true);
            }
        }
    }
}
