package fr.program.pranction.init;

import fr.program.pranction.Pranction;
import fr.program.pranction.commands.*;

public class CommandsManager {
    public static void init(Pranction plugin) {
        plugin.getCommand("info").setExecutor(new InfoCMD(plugin));
        plugin.getCommand("modt").setExecutor(new ModtCMD(plugin));
        plugin.getCommand("mute").setExecutor(new MuteCMD(plugin));
        plugin.getCommand("unmute").setExecutor(new UnmuteCMD(plugin));
        plugin.getCommand("sp").setExecutor(new SpCMD(plugin));
        plugin.getCommand("pban").setExecutor(new PbanCMD(plugin));
        plugin.getCommand("tempban").setExecutor(new TempbanCMD(plugin));
        plugin.getCommand("cleardata").setExecutor(new CleardataCMD(plugin));
        plugin.getCommand("whois").setExecutor(new WhoisCMD(plugin));
    }
}
