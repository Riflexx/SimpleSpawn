package ru.don1x.simplespawn.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import ru.don1x.simplespawn.SimpleSpawn;

import java.util.Objects;

public class Listeners implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (SimpleSpawn.getInstance().getConfig().getBoolean("settings.tpOnJoin")) {
            String[] parts = Objects.requireNonNull(SimpleSpawn.getInstance().getConfig().getString("spawn")).split(", ");
            player.teleport(new Location(Bukkit.getWorld(parts[0]), Double.parseDouble(parts[1]), Double.parseDouble(parts[2]), Double.parseDouble(parts[3])));
        }
    }
}
