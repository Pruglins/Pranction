package fr.program.pranction;

import fr.program.pranction.init.CommandsManager;
import fr.program.pranction.init.EventsManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Pranction extends JavaPlugin {

    @Override
    public void onLoad() {
        System.out.println("Le plugin se prepare !");
    }

    @Override
    public void onEnable() {
        System.out.println("Le plugin est pret !");

        saveDefaultConfig();

        CommandsManager.init(this);
        getServer().getPluginManager().registerEvents(new EventsManager(this), this);
    }

    @Override
    public void onDisable() {
        System.out.println("Le plugin s'est eteint !");
    }
}
