package dev.glhrrm.glutils.comandos;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoGM1 implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("gm1")) {
                if (args.length == 0) {

                    p.sendMessage("§cSintaxe incorreta. Utilize /gm1 ou /gm1 [jogador].");
                } else
                    if (p.hasPermission("glutils.cmd.gmcreativo")) {
                        Player target = Bukkit.getPlayer(args[0]);
                        target.setGameMode(GameMode.CREATIVE);

                        target.sendMessage("§eO modo de jogo do jogador " + p.getName() + "foi atualizado.");
                        target.sendMessage("§eModo: §aCreativo");
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
