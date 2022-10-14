package de.officeryoda.dcbcr.CommandData;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.utils.messages.MessageCreateData;

import javax.annotation.Nonnull;

public class PublicBotCommand extends BotCommand {

    private final Guild guild;
    private final TextChannel channel;

    public PublicBotCommand(BotCommand botCommand, TextChannel channel) {
        super(botCommand);
        this.guild = super.getEvent().getGuild();
        this.channel = channel;
    }

    public void sendMessage(@Nonnull CharSequence text) {
        channel.sendMessage(text).queue();
    }

    public void sendMessage(@Nonnull MessageCreateData msg) {
        channel.sendMessage(msg).queue();
    }
    
    public Guild getGuild() {
        return guild;
    }

    public TextChannel getChannel() {
        return channel;
    }
}
