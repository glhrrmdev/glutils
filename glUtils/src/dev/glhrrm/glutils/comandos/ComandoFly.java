package dev.glhrrm.glutils.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoFly implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("glutils.cmd.fly")) {

                if (p.getAllowFlight() == true) {
                    p.setAllowFlight(false);

                    p.sendMessage("");
                    p.sendMessage("§eVocê §cdesativou §eo modo voar com sucesso.");
                    p.sendMessage("");

                    for (Player player : Bukkit.getOnlinePlayers()) {
                        if (player.hasPermission("glutils.admin")) {
                            player.sendMessage("§4§l[ADMIN] §fO player " + p.getName() + " desativou o modo voar.");
                        }
                    }
                } else {
                    p.setAllowFlight(true);

                    p.sendMessage("");
                    p.sendMessage("§eVocê §aativou §eo modo de voar com sucesso.");
                    p.sendMessage("");

                    for (Player player : Bukkit.getOnlinePlayers()) {
                        if (player.hasPermission("glutils.admin")) {
                            player.sendMessage("§4§l[ADMIN] §fO player " + p.getName() + " ativou o modo voar.");
                        }
                    }
                }
            } else {
                p.sendMessage("");
                p.sendMessage("§eVocê não tem permissão.");
                p.sendMessage("§bAdquira VIP e obtenha diversas vantagens como esta.");
                p.sendMessage("");
            }
        } else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[glUtils] Você não é um jogador.");
        }
        return false;
    }
}
