package org.terradon.soup;

import org.terradon.soup.cmds.SetSpawnCommand;
import org.terradon.soup.cmds.SpawnCommand;
import org.terradon.soup.combattag.listener.CombatTagListener;
import org.terradon.soup.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Soup extends JavaPlugin {

    private static Soup instance;

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("----------------------------");
        getLogger().info("  Soup PvP Plugin Enabled.");
        getLogger().info("----------------------------");
        getConfig().options().copyDefaults();
        this.saveDefaultConfig();
        registerListeners();
        registerCommands();
    }

    public void registerListeners() {
        Bukkit.getServer().getPluginManager().registerEvents(new BasicListener(), this);

        Bukkit.getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new RefillListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new KitListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new CombatTagListener(), this);
    }

    public void registerCommands() {
        getCommand("setspawn").setExecutor(new SetSpawnCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());
    }

    @Override
    public void onDisable() {
    }

    public static Soup getInstance() {
        return instance;
    }
}
