package voidcube.voidguard;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import voidcube.voidguard.BukkitListeners.JoinLeaveListener;
import voidcube.voidguard.bot.ReadyListener;

public final class VoidGuard extends JavaPlugin {

    @Override
    public void onEnable() {
        try {
            ReadyListener.main();

            Bukkit.getPluginManager().registerEvents(new JoinLeaveListener(), this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
