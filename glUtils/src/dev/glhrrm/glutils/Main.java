package dev.glhrrm.glutils;

import dev.glhrrm.glutils.comandos.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Main instance = this;

        getCommand("ping").setExecutor(new ComandoPing());
        getCommand("gm3").setExecutor(new ComandoGM3());
        getCommand("gm2").setExecutor(new ComandoGM2());
        getCommand("gm0").setExecutor(new ComandoGM0());
        getCommand("gm1").setExecutor(new ComandoGM1());
        getCommand("fly").setExecutor(new ComandoFly());

        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"[glUtils] O plugin foi ativado.");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"[glUtils] O plugin foi desativado.");
    }

    public static Main getInstance() {
        return getInstance();
    }
}
