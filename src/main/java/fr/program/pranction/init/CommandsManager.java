package fr.program.pranction.init;

import fr.program.pranction.Pranction;
import fr.program.pranction.commands.InfoCMD;
import fr.program.pranction.commands.ModtCMD;
import fr.program.pranction.commands.MuteCMD;

public class CommandsManager {
    public static void init(Pranction plugin) {
        plugin.getCommand("info").setExecutor(new InfoCMD(plugin));
        plugin.getCommand("modt").setExecutor(new ModtCMD(plugin));
        plugin.getCommand("mute").setExecutor(new MuteCMD(plugin));
    }
}
