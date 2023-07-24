package voidcube.voidguard.bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class ReadyListener implements EventListener {
    public static void main()
            throws InterruptedException {
        // Note: It is important to register your ReadyListener before building
        JDA jda = JDABuilder.createDefault("MTEzMzAxMTQwOTg3NDE5NDQ4NA.G3VDQi.4zOEWDVrxjbrUSCGNx2nfQf5VOWviYnPZVSlf0")
                .addEventListeners(new ReadyListener())
                .addEventListeners(new ButtonListener())
                .build();

        // optionally block until JDA is ready
        jda.awaitReady();
    }

    @Override
    public void onEvent(@NotNull GenericEvent event) {
        if (event instanceof ReadyEvent) {
            System.out.println("API is ready!");
        }
    }
}