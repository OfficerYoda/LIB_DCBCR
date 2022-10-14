package de.officeryoda.dcbcr.Managment;

import de.officeryoda.dcbcr.CommandData.PrivateBotCommand;
import de.officeryoda.dcbcr.CommandData.PublicBotCommand;

import java.util.function.Consumer;

public interface CommandExecuter {
    public void registerCommands();

    default void addPrivateCommand(Consumer<PrivateBotCommand> cmdExecuter, String command, String... aliases) {
        CommandManager.addPrivateCommand(cmdExecuter, command, aliases);
    }

    default void addPublicCommand(Consumer<PublicBotCommand> cmdExecuter, String command, String... aliases) {
        CommandManager.addPublicCommand(cmdExecuter, command, aliases);
    }
}
