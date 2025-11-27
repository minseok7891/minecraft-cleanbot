package me.minseok.simplecleaner;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class SimpleCleaner extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        // Register command
        if (getCommand("cleandrop") != null) {
            getCommand("cleandrop").setExecutor(this);
        }

        // Schedule the auto-clean task (every 5 minutes = 6000 ticks)
        new BukkitRunnable() {
            int timeLeft = 300; // 5 minutes in seconds

            @Override
            public void run() {
                if (timeLeft == 30) {
                    broadcast(ChatColor.RED + "[청소] " + ChatColor.YELLOW + "30초 뒤에 바닥에 떨어진 아이템이 삭제됩니다!");
                } else if (timeLeft == 5) {
                    broadcast(ChatColor.RED + "[청소] " + ChatColor.YELLOW + "5초 뒤에 아이템이 삭제됩니다!");
                } else if (timeLeft <= 0) {
                    cleanItems();
                    timeLeft = 300; // Reset timer
                }
                timeLeft--;
            }
        }.runTaskTimer(this, 0L, 20L); // Run every second

        getLogger().info("SimpleCleaner has been enabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("cleandrop")) {
            if (!sender.hasPermission("simplecleaner.cleandrop")) {
                sender.sendMessage(ChatColor.RED + "권한이 없습니다.");
                return true;
            }
            cleanItems();
            sender.sendMessage(ChatColor.GREEN + "강제로 아이템을 청소했습니다.");
            return true;
        }
        return false;
    }

    private void cleanItems() {
        int count = 0;
        for (World world : Bukkit.getWorlds()) {
            List<Entity> entities = world.getEntities();
            for (Entity entity : entities) {
                if (entity instanceof Item) {
                    entity.remove();
                    count++;
                }
            }
        }
        if (count > 0) {
            broadcast(ChatColor.RED + "[청소] " + ChatColor.GREEN + "바닥에 떨어진 아이템 " + ChatColor.YELLOW + count
                    + ChatColor.GREEN + "개를 삭제했습니다.");
        }
    }

    private void broadcast(String message) {
        Bukkit.broadcastMessage(message);
    }
}
