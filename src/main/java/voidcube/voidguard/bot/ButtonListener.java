package voidcube.voidguard.bot;

import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import net.dv8tion.jda.api.interactions.modals.Modal;
import org.jetbrains.annotations.NotNull;


public class ButtonListener extends ListenerAdapter {
    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {
        if (event.getButton().getId().equals("agree-rules")) {
            event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("1132743398609129614")).queue();
        } else if (event.getButton().getId().equals("pass")) {
            System.out.println("detected");
            event.replyModal(
                    Modal.create("pass-form", "Данные игрока")
                            .addActionRow(TextInput.create("age", "Возраст", TextInputStyle.SHORT).setRequired(true).build())
                            .addActionRow(TextInput.create("real-name", "Настоящее имя", TextInputStyle.SHORT).setRequired(true).build())
                            .addActionRow(TextInput.create("nick", "Игровой ник", TextInputStyle.SHORT).setRequired(true).build())
                            .addActionRow(TextInput.create("know", "Откуда узнали про сервер", TextInputStyle.PARAGRAPH).setRequired(true).build()).build()
            ).queue();
        }
    }
}
