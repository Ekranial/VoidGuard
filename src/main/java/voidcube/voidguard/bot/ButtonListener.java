package voidcube.voidguard.bot;

import com.google.gson.JsonIOException;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import net.dv8tion.jda.api.interactions.modals.Modal;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;


public class ButtonListener extends ListenerAdapter {
    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {
        if (event.getButton().getId().equals("agree-rules")) {
            event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("1132743398609129614")).queue();
        } else if (event.getButton().getId().equals("pass")) {
            event.replyModal(
                    Modal.create("pass-form", "Данные игрока")
                            .addActionRow(TextInput.create("age", "Возраст", TextInputStyle.SHORT).setRequired(true).build())
                            .addActionRow(TextInput.create("real-name", "Настоящее имя", TextInputStyle.SHORT).setRequired(true).build())
                            .addActionRow(TextInput.create("nick", "Игровой ник", TextInputStyle.SHORT).setRequired(true).build())
                            .addActionRow(TextInput.create("know", "Откуда узнали про сервер", TextInputStyle.PARAGRAPH).setRequired(true).build()).build()
            ).queue();
        } else if (event.getButton().getId().contains("whitelist") && event.getMember().getRoles().contains(event.getJDA().getRoleById("1132744468106313758"))) {
            String nick = event.getButton().getId().split("-")[1];
            if (Bukkit.getWhitelistedPlayers().contains(Bukkit.getOfflinePlayer(nick))) {
                event.reply("Игрок " + nick + " уже в вайтлисте!").setEphemeral(true).queue();
            } else {
                Bukkit.getOfflinePlayer(nick).setWhitelisted(true);


                MessageEmbed embed = new EmbedBuilder()
                        .setTitle(nick)
                        .setDescription("Имя: " + event.getButton().getId().split("-")[2] + "\n" +
                                "Возраст: " + event.getButton().getId().split("-")[3])
                        .build();

                String uid = event.getButton().getId().split("-")[4];
                event.getGuild().removeRoleFromMember(event.getGuild().getMemberById(uid), event.getGuild().getRoleById("1132743398609129614")).queue();
                event.getGuild().addRoleToMember(event.getGuild().getMemberById(uid), event.getGuild().getRoleById("1132744232847814698")).queue();

                event.getGuild().getTextChannelById("1133365631551557723").sendMessageEmbeds(embed).queue();
                event.reply("Игрок " + nick + " добавлен в вайтлист!").setEphemeral(true).queue();
            }
        } else if (event.getButton().getId().contains("set-nick") && event.getMember().getRoles().contains(event.getJDA().getRoleById("1132744468106313758"))) {
            String nick = event.getButton().getId().split("-")[2];
            String uid = event.getButton().getId().split("-")[3];

            event.getGuild().getMemberById(uid).modifyNickname(nick).queue();
            event.reply("Ник установлен!").setEphemeral(true).queue();
        } else if (event.getButton().getId().equals("close-ticket")) {
            event.getChannel().delete().queue();
        }
    }
}
