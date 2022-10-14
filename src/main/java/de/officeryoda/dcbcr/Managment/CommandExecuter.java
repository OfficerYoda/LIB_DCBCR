package de.officeryoda.dcbcr.Managment;

import de.officeryoda.dcbcr.commandData.PrivateBotCommand;
import de.officeryoda.dcbcr.commandData.PublicBotCommand;

import java.util.function.Consumer;

public abstract class CommandExecuter {
    public abstract void registerCommands();

    protected void addPrivateCommand(Consumer<PrivateBotCommand> cmdExecuter, String command, String... aliases) {
        CommandManager.addPrivateCommand(cmdExecuter, command, aliases);
    }

    protected void addPublicCommand(Consumer<PublicBotCommand> cmdExecuter, String command, String... aliases) {
        CommandManager.addPublicCommand(cmdExecuter, command, aliases);
    }
}
