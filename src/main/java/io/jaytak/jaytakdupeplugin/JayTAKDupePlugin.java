package io.jaytak.jaytakdupeplugin;
import java.util.Objects;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings({"unused"})
public final class JayTAKDupePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        super.onEnable();

        int pluginId = 21106;
        metrics metrics = new metrics(this, pluginId);

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
