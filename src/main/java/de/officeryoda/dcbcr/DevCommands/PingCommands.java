package de.officeryoda.dcbcr.DevCommands;

import de.officeryoda.dcbcr.Managment.CommandRegistrator;
import de.officeryoda.dcbcr.Managment.PrivateBotCommand;
import de.officeryoda.dcbcr.Managment.PublicBotCommand;

public class PingCommands extends CommandRegistrator {
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
