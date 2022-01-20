package dev.glhrrm.glutils.comandos;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoGM3 implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("gm3")) {
                if (args.length == 0) {

                    p.sendMessage("§cSintaxe incorreta. Utilize /gm3 ou /gm3 [jogador].");
                } else
                if (p.hasPermission("glutils.cmd.gmspectator")) {
                    Player target = Bukkit.getPlayer(args[0]);
                    target.setGameMode(GameMode.SPECTATOR);

                    target.sendMessage("§eO modo de jogo do jogador " + p.getName() + "foi atualizado.");
                    target.sendMessage("§eModo: §8Espectador");
                } else {
                    p.sendMessage("§cVocê não tem permissão.");
                }
            } else {
                return false;
            }
        } else {
            sender.sendMessage("§c[glUtils] Você não é um jogador.");
        }
        return false;
    }
}
