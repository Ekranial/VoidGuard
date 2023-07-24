package voidcube.voidguard;

import org.bukkit.plugin.java.JavaPlugin;
import voidcube.voidguard.bot.ReadyListener;

public final class VoidGuard extends JavaPlugin {

    @Override
    public void onEnable() {
        try {
            ReadyListener.main();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
