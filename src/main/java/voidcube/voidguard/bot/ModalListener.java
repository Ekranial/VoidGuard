package voidcube.voidguard.bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;

public class ModalListener extends ListenerAdapter {
    @Override
    public void onModalInteraction(@NotNull ModalInteractionEvent event) {
        if (event.getModalId().equals("pass-form")) {
            TextChannel channel;


            channel = event.getGuild().createTextChannel("❰\uD83D\uDD13❱⊳проходка", event.getGuild().getCategoryById("1132748592294133791"))
                    .addMemberPermissionOverride(event.getMember().getIdLong(), Collections.singleton(Permission.VIEW_CHANNEL), null)
                    .addRolePermissionOverride(1132743322281201694L, null, Collections.singleton(Permission.VIEW_CHANNEL))
                    .addRolePermissionOverride(1132744468106313758L, Collections.singleton(Permission.VIEW_CHANNEL), null)
                    .complete();


            MessageEmbed messageEmbed = new EmbedBuilder()
                    .setTitle("Заявка на получение проходки")
                    .setDescription("\n\n" +
                            "Заявку подал: " + event.getMember().getAsMention() + "\n" +
                            "Возраст: " + event.getValue("age").getAsString() + "\n" +
                            "Настоящее имя: " + event.getValue("real-name").getAsString() + "\n" +
                            "Игровой ник: " + event.getValue("nick").getAsString() + "\n" +
                            "Откуда узнал про сервер: " + event.getValue("know").getAsString())
                    .build();

            Button button_whitelist = Button.success("whitelist-" +  event.getValue("nick").getAsString() + "-" + event.getValue("real-name").getAsString() + "-" + event.getValue("age").getAsString() + "-" + event.getMember().getId(), "Добавить " + event.getValue("nick").getAsString() + " в вайтлист");
            Button button_set_nick = Button.success("set-nick-" + event.getValue("nick").getAsString() + "-" + event.getMember().getId(), "Установить ник " + event.getValue("nick").getAsString());
            Button button_close_ticket = Button.danger("close-ticket", "Закрыть тикет");

            channel.sendMessageEmbeds(messageEmbed).setActionRow(button_whitelist, button_set_nick, button_close_ticket).queue();

            channel.sendMessage(event.getGuild().getRoleById("1132744468106313758").getAsMention()).queue();

            event.reply("Данные отправлены!").setEphemeral(true).queue();
        } else if (event.getModalId().equals("support-form")) {
            TextChannel channel;


            channel = event.getGuild().createTextChannel("❰\uD83D\uDCE8❱⊳поддержка", event.getGuild().getCategoryById("1132748592294133791"))
                    .addMemberPermissionOverride(event.getMember().getIdLong(), Collections.singleton(Permission.VIEW_CHANNEL), null)
                    .addRolePermissionOverride(1132743322281201694L, null, Collections.singleton(Permission.VIEW_CHANNEL))
                    .addRolePermissionOverride(1132744468106313758L, Collections.singleton(Permission.VIEW_CHANNEL), null)
                    .complete();


            MessageEmbed messageEmbed = new EmbedBuilder()
                    .setTitle("Обращение в техподдержку")
                    .setDescription("\n\n" +
                            "Заявку подал: " + event.getMember().getAsMention() + "\n" +
                            "Игровой ник: " + event.getValue("nick").getAsString() + "\n" +
                            "Причина: " + event.getValue("reason").getAsString())
                    .build();

            Button button_close_ticket = Button.danger("close-ticket", "Закрыть тикет");

            channel.sendMessageEmbeds(messageEmbed).setActionRow(button_close_ticket).queue();

            channel.sendMessage(event.getGuild().getRoleById("1132744468106313758").getAsMention()).queue();

            event.reply("Заявка отправлена!").setEphemeral(true).queue();
        }
    }
}
