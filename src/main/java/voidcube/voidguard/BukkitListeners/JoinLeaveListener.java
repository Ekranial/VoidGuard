package voidcube.voidguard.BukkitListeners;

import net.dv8tion.jda.api.entities.Activity;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import static voidcube.voidguard.bot.ReadyListener.jda;

public class JoinLeaveListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerLoginEvent event) {
        jda.getPresence().setActivity(Activity.of(Activity.ActivityType.WATCHING, "за " + (Bukkit.getOnlinePlayers().size() + 1) + " игроками"));
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        jda.getPresence().setActivity(Activity.of(Activity.ActivityType.WATCHING, "за " + (Bukkit.getOnlinePlayers().size() - 1) + " игроками"));
        System.out.println(Bukkit.getOnlinePlayers().size());
    }
}
