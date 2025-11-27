package me.minseok.simplecleaner;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class SimpleCleaner extends JavaPlugin implements CommandExecutor {

    private FileConfiguration messagesConfig;

    @Override
    public void onEnable() {
        // Save default config
        saveDefaultConfig();
        loadLanguage();

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
                    broadcast(getMessage("warning-30s"));
                } else if (timeLeft == 5) {
                    broadcast(getMessage("warning-5s"));
                } else if (timeLeft <= 0) {
                    cleanItems();
                    timeLeft = 300; // Reset timer
                }
                timeLeft--;
            }
        }.runTaskTimer(this, 0L, 20L); // Run every second

        getLogger().info("SimpleCleaner has been enabled!");
    }

    private void loadLanguage() {
        String lang = getConfig().getString("lang", "en");
        String fileName = "messages_" + lang + ".yml";
        File messageFile = new File(getDataFolder(), fileName);

        if (!messageFile.exists()) {
            saveResource(fileName, false);
        }

        messagesConfig = YamlConfiguration.loadConfiguration(messageFile);

        // Load default from JAR if file is empty or missing keys
        InputStream defConfigStream = getResource(fileName);
        if (defConfigStream != null) {
            messagesConfig.setDefaults(YamlConfiguration
                    .loadConfiguration(new InputStreamReader(defConfigStream, StandardCharsets.UTF_8)));
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("cleandrop")) {
            if (!sender.hasPermission("simplecleaner.cleandrop")) {
                sender.sendMessage(getMessage("no-permission"));
                return true;
            }
            cleanItems();
            sender.sendMessage(getMessage("manual-clean"));
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
            String msg = getMessage("clean-complete").replace("%count%", String.valueOf(count));
            broadcast(msg);
        }
    }

    private void broadcast(String message) {
        Bukkit.broadcastMessage(message);
    }

    private String getMessage(String key) {
        String prefix = getConfig().getString("prefix", "&8[&bSimpleCleaner&8] ");
        String msg = messagesConfig.getString(key);
        if (msg == null)
            return "";
        return ChatColor.translateAlternateColorCodes('&', prefix + msg);
    }
}
