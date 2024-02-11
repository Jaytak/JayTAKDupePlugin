package io.jaytak.jaytakdupeplugin;
import java.util.Objects;
import org.bukkit.plugin.java.JavaPlugin;

public final class JayTAKDupePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        super.onEnable();
        Objects.requireNonNull(getCommand("jdupe")).setExecutor(new Dupe());
        this.getLogger().info("JayTAK Dupe Plugin Loaded.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        super.onDisable();
        this.getLogger().info("JayTAK Dupe Plugin Exiting.");
    }
}
