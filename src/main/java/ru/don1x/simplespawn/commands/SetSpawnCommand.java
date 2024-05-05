package ru.don1x.simplespawn.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.don1x.simplespawn.SimpleSpawn;

import java.util.Objects;

import static ru.don1x.simplespawn.utils.Hex.color;

public class SetSpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (player.hasPermission("simplespawn.setspawn")) {
                Location loc = player.getLocation();
                SimpleSpawn.getInstance().getConfig().set("spawn", Objects.requireNonNull(loc.getWorld()).getName() + ", " + loc.getX() + ", " + loc.getY() + ", " + loc.getZ());
                SimpleSpawn.getInstance().saveConfig();
                player.sendMessage(color(SimpleSpawn.getInstance().getConfig().getString("messages.setspawn")));
            }
        }
        return true;
    }
}
