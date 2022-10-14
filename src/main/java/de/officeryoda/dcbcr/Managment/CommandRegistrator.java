package de.officeryoda.dcbcr.Managment;

import de.officeryoda.dcbcr.DevCommands.PingCommands;

import java.util.function.Consumer;

public abstract class CommandRegistrator {
    public abstract void registerCommands();

    protected static void addPrivateCommand(Consumer<PrivateBotCommand> cmdExecuter, String command, String... aliases) {
        CommandManager.addPrivateCommand(cmdExecuter, command, aliases);
    }

    protected static void addPublicCommand(Consumer<PublicBotCommand> cmdExecuter, String command, String... aliases) {
        CommandManager.addPublicCommand(cmdExecuter, command, aliases);
    }

    public static void registerPingCommand() {
        registerClass(new PingCommands());
    }

    public static void registerClass(CommandRegistrator commandRegistrator) {
        commandRegistrator.registerCommands();
    }
}
