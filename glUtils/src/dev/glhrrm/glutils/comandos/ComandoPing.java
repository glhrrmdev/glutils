package dev.glhrrm.glutils.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;;

public class ComandoPing implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("ping")) {
                sender.sendMessage("§eSua latência atual: §a" + (sender instanceof Player ? ((CraftPlayer) sender).getHandle().ping : 0) + " §ems!");
            }
        } else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[glUtils] Você não é um jogador.");
        }
        return false;
    }
}
