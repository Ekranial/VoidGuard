package voidcube.voidguard.bot;

import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;


public class ButtonListener extends ListenerAdapter {
    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {
        if(event.getButton().getId().equals("agree-rules")) {
            event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("1132743398609129614")).queue();
        }
    }
}
