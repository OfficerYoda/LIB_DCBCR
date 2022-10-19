package de.officeryoda.dcbcr.CommandData;

import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.channel.concrete.PrivateChannel;
import net.dv8tion.jda.api.utils.messages.MessageCreateData;

import javax.annotation.Nonnull;
import java.util.Collection;

public class PrivateBotCommand extends BotCommand {

    private final PrivateChannel channel;

    public PrivateBotCommand(BotCommand botCommand, PrivateChannel channel) {
        super(botCommand);
        this.channel = channel;
    }

    public void sendMessage(@Nonnull CharSequence text) {
        channel.sendMessage(text).queue();
    }

    public void sendMessage(@Nonnull MessageCreateData msg) {
        channel.sendMessage(msg).queue();
    }

    public void sendEmbeds(@Nonnull MessageEmbed embed, @Nonnull MessageEmbed... other) {
        channel.sendMessageEmbeds(embed, other).queue();
    }

    public void sendEmbeds(@Nonnull Collection<? extends MessageEmbed> embeds) {
        channel.sendMessageEmbeds(embeds).queue();
    }
    public PrivateChannel getChannel() {
        return channel;
    }
}
