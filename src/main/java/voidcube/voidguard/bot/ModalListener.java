package voidcube.voidguard.bot;

import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class ModalListener extends ListenerAdapter {
    @Override
    public void onModalInteraction(@NotNull ModalInteractionEvent event) {
        System.out.println(event.getValues());
        event.reply("Данные отправлены!").setEphemeral(true).queue();
    }
}
