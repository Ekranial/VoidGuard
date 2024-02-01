package voidcube.voidguard.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;


public class ReadyListener implements EventListener {

    public static JDA jda = JDABuilder.createDefault("хуй тебе а не токен")
            .addEventListeners(new ReadyListener())
            .addEventListeners(new ButtonListener())
            .addEventListeners(new ModalListener())
            .setChunkingFilter(ChunkingFilter.ALL)
            .setMemberCachePolicy(MemberCachePolicy.ALL)
            .enableIntents(GatewayIntent.GUILD_MEMBERS)
            .build();

    public static void main()
            throws InterruptedException {
        // Note: It is important to register your ReadyListener before building;
        // optionally block until JDA is ready
        jda.awaitReady();
    }

    @Override
    public void onEvent(@NotNull GenericEvent event) {
        if (event instanceof ReadyEvent) {
            System.out.println("API is ready!");

            event.getJDA().getPresence().setActivity(Activity.of(Activity.ActivityType.WATCHING, "за " + Bukkit.getOnlinePlayers().size() + " игроками"));
        }
    }
}
