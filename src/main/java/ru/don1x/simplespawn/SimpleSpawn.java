package ru.don1x.simplespawn;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import ru.don1x.simplespawn.commands.SetSpawnCommand;
import ru.don1x.simplespawn.commands.SpawnCommand;
import ru.don1x.simplespawn.listeners.Listeners;

import java.util.Objects;

public final class SimpleSpawn extends JavaPlugin {
    private static SimpleSpawn instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(new Listeners(), this);
        Objects.requireNonNull(getCommand("setspawn")).setExecutor(new SetSpawnCommand());
        Objects.requireNonNull(getCommand("spawn")).setExecutor(new SpawnCommand());
    }

    @Override
    public void onDisable() {

    }

    public static SimpleSpawn getInstance() {return instance;}
}
