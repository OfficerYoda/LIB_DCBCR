package de.officeryoda.dcbcr.Managment;

import de.officeryoda.dcbcr.CommandData.BotCommand;
import de.officeryoda.dcbcr.CommandData.PrivateBotCommand;
import de.officeryoda.dcbcr.CommandData.PublicBotCommand;
import net.dv8tion.jda.api.entities.channel.concrete.PrivateChannel;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Locale;

class CommandListener extends ListenerAdapter {

    private final String PREFIX;

    public CommandListener(String prefix) {
        this.PREFIX = prefix;
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if(!event.getMessage().getContentRaw().startsWith(PREFIX) || event.getAuthor().isBot())
            return;

        if(!event.isFromGuild())
            onPrivateMessageReceived(event);
        else
            onGuildMessageReceived(event);
    }

    private void onPrivateMessageReceived(MessageReceivedEvent event) {
        PrivateBotCommand botCommand = createPrivateBotCommand(event);
        boolean succeeded = CommandManager.executePrivateCommand(botCommand);
        if(!succeeded)
            event.getChannel().sendMessage("This command does not exist").queue();
    }

    private void onGuildMessageReceived(MessageReceivedEvent event) {
        PublicBotCommand botCommand = createPublicBotCommand(event);
        boolean succeeded = CommandManager.executePublicCommand(botCommand);
        if(!succeeded)
            event.getChannel().sendMessage("This command does not exist").queue();
    }

    private BotCommand createBotCommand(MessageReceivedEvent event) {
        String[] msgArgs = event.getMessage().getContentRaw().split(" ");

        // command
        String command = msgArgs[0].substring(PREFIX.length()).toLowerCase(Locale.ROOT);

        // args
        String[] cmdArgs = new String[0];
        if(msgArgs.length > 1)
            cmdArgs = Arrays.copyOfRange(msgArgs, PREFIX.length(), msgArgs.length);

        return new BotCommand(command, cmdArgs, event);
    }

    private PrivateBotCommand createPrivateBotCommand(MessageReceivedEvent event) {
        BotCommand botCommand = createBotCommand(event);
        PrivateChannel channel = event.getChannel().asPrivateChannel();

        return new PrivateBotCommand(botCommand, channel);
    }

    private PublicBotCommand createPublicBotCommand(MessageReceivedEvent event) {
        BotCommand botCommand = createBotCommand(event);
        TextChannel channel = event.getChannel().asTextChannel();

        return new PublicBotCommand(botCommand, channel);
    }
}
