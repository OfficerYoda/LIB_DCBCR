package de.officeryoda.dcbcr.Commands;

import de.officeryoda.dcbcr.Managment.CommandExecuter;
import de.officeryoda.dcbcr.CommandData.PrivateBotCommand;
import de.officeryoda.dcbcr.CommandData.PublicBotCommand;

public class PingCommands implements CommandExecuter {
    @Override
    public void registerCommands() {
        addPrivateCommand(this::privatePing, "ping");
        addPublicCommand(this::publicPing, "ping");
    }

    private void privatePing(PrivateBotCommand botCommand) {
        botCommand.getChannel().sendMessage("pong :ping_pong:").queue();
    }

    private void publicPing(PublicBotCommand botCommand) {
        botCommand.getChannel().sendMessage("pong :ping_pong:").queue();
    }
}
