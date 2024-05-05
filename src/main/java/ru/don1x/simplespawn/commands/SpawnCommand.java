package ru.don1x.simplespawn.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.don1x.simplespawn.SimpleSpawn;

import java.util.Objects;

import static ru.don1x.simplespawn.utils.Hex.color;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (player.hasPermission("simplespawn.spawn")) {
                String[] parts = Objects.requireNonNull(SimpleSpawn.getInstance().getConfig().getString("spawn")).split(", ");
                player.teleport(new Location(Bukkit.getWorld(parts[0]), Double.parseDouble(parts[1]), Double.parseDouble(parts[2]), Double.parseDouble(parts[3])));
                player.sendMessage(color(SimpleSpawn.getInstance().getConfig().getString("messages.spawn")));
            }
        }
        return true;
    }
}
