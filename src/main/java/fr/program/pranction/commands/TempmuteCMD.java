package fr.program.pranction.commands;

import fr.program.pranction.Pranction;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Calendar;
import java.util.Date;

public class TempmuteCMD implements CommandExecutor {

    Pranction plugin;

    public TempmuteCMD(Pranction plugin) {
        this.plugin = plugin;
    }

    private static Date ajouterJour(Date date, int nbJour) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, nbJour);
        return cal.getTime();
    }

    private static Date ajouterSecondes(Date date, int sec) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.SECOND, sec);
        return cal.getTime();
    }

    private static Date ajouterHeures(Date date, int heures) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, heures);
        return cal.getTime();
    }

    private static Date ajouterMois(Date date, int m) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, m);
        return cal.getTime();
    }
    private static Date ajouterYear(Date date, int year) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, year);
        return cal.getTime();
    }

    private StringBuilder ArrayToStringRemoveCase(int remove_index, String[] array) {
        StringBuilder bc = new StringBuilder();
        int i = 0;
        for (String part : array) {
            if (i != remove_index) {
                bc.append(part).append(" ");
            }
            i++;
        }
        return bc;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("tempmute")) {
            Player plr = (Player) sender;

            Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {return false;}

            if (args.length >= 3) {
                String arg = args[1];

                if (arg == null) {return false;}

                String[] time_day = arg.split("");

                if (time_day.length == 2) {
                    String nb = time_day[0];
                    String type = time_day[1];
                    int number;
                    try {
                        number = Integer.parseInt(nb);
                    } catch(Exception e) {
                        plr.sendMessage("[" + ChatColor.BOLD + ChatColor.LIGHT_PURPLE + "Pranction" + ChatColor.RESET + ChatColor.WHITE + "] Vous devez donner un chifre");
                        System.out.println(e);
                        return false;
                    }

                    if (number != 0) {
                        if (!plugin.getConfig().contains("players." + target.getUniqueId())) {
                            plr.sendMessage("[" + ChatColor.BOLD + ChatColor.LIGHT_PURPLE + "Pranction" + ChatColor.RESET + ChatColor.WHITE + "] Le joueur ne s'est jamais connecte !");
                            return false;
                        } else if (plugin.getConfig().getBoolean("players." + target.getUniqueId() + ".muted"))  {
                            plr.sendMessage("[" + ChatColor.BOLD + ChatColor.LIGHT_PURPLE + "Pranction" + ChatColor.RESET + ChatColor.WHITE + "] Le joueur est deja reduit au silence !");
                            return false;
                        } else {
                            // Sucess

                            StringBuilder reason_mute = new StringBuilder();

                            StringBuilder bcargs = ArrayToStringRemoveCase(0, args);
                            String[] nargs = bcargs.toString().split(" ");
                            StringBuilder bcargs2 = ArrayToStringRemoveCase(0, nargs);
                            String[] nargs2 = bcargs2.toString().split(" ");
                            for (String part : nargs2) {
                                reason_mute.append(part).append(" ");
                            }

                            Date date = new Date();
                            Date time;

                            if (type.equalsIgnoreCase("d")) {
                                time = ajouterJour(date, number);
                            } else if (type.equalsIgnoreCase("m")) {
                                time = ajouterMois(date, number);
                            } else if (type.equalsIgnoreCase("y")) {
                                time = ajouterYear(date, number);
                            } else if (type.equalsIgnoreCase("h")) {
                                time = ajouterHeures(date, number);
                            } else if (type.equalsIgnoreCase("s")) {
                                time = ajouterSecondes(date, number);
                            } else {
                                plr.sendMessage("[" + ChatColor.BOLD + ChatColor.LIGHT_PURPLE + "Pranction" + ChatColor.RESET + ChatColor.WHITE + "] Vous pouvez bannir en jour (avec 'd'), en mois (avec 'm'), en annee (avec 'y')  ou en secondes (avec 's') !");
                                return false;
                            }

                            plr.sendMessage("[" + ChatColor.BOLD + ChatColor.LIGHT_PURPLE + "Pranction" + ChatColor.RESET + ChatColor.WHITE + "] Le joueur s'est fait reduire au silence temporairement !");
                            Bukkit.broadcastMessage("[" + ChatColor.BOLD + ChatColor.LIGHT_PURPLE + "Pranction" + ChatColor.RESET + ChatColor.WHITE + "] Le joueur " + target.getDisplayName() + " a ete sanctionne par un moderateur pour : " + reason_mute.toString());

                            plugin.getConfig().set("players." + target.getUniqueId() + ".muted", true);
                            plugin.getConfig().set("players." + target.getUniqueId() + ".reason_mute", reason_mute.toString());
                            plugin.getConfig().set("players." + target.getUniqueId() + ".time_mute", time.getTime());
                            plugin.saveConfig();

                            return true;
                        }
                    } else {
                        plr.sendMessage("[" + ChatColor.BOLD + ChatColor.LIGHT_PURPLE + "Pranction" + ChatColor.RESET + ChatColor.WHITE + "] Merci de mute au minimum 1 seconde !");
                        return false;
                    }
                } else {
                    plr.sendMessage("[" + ChatColor.BOLD + ChatColor.LIGHT_PURPLE + "Pranction" + ChatColor.RESET + ChatColor.WHITE + "] Merci de donner les arguments necessaires (le nombre et le format).");
                    return false;
                }
            } else {
                plr.sendMessage("[" + ChatColor.BOLD + ChatColor.LIGHT_PURPLE + "Pranction" + ChatColor.RESET + ChatColor.WHITE + "] Merci de donner les arguments necessaires (le nombre, le format puis la raison).");
                return false;
            }
        }
        return false;
    }
}
