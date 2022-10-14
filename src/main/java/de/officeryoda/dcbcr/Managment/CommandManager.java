package de.officeryoda.dcbcr.Managment;

import de.officeryoda.dcbcr.commandData.PrivateBotCommand;
import de.officeryoda.dcbcr.commandData.PublicBotCommand;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Consumer;

public class CommandManager {

    private static final Map<String, Consumer<PrivateBotCommand>> privateCommands = new HashMap<>();
    private static final Map<String, String> privateAliases = new HashMap<>();

    private static final Map<String, Consumer<PublicBotCommand>> publicCommands = new HashMap<>();
    private static final Map<String, String> publicAliases = new HashMap<>();

    public static boolean executePrivateCommand(PrivateBotCommand botCommand) {
        String command = botCommand.getCommand();
        Consumer<PrivateBotCommand> cmdExecuter;

        if(privateCommands.containsKey(command)) { // if cmd exists get executer
            cmdExecuter = privateCommands.get(botCommand.getCommand());
        } else if(privateCommands.containsKey(command = privateAliases.get(botCommand.getCommand()))) { // if alias exist get executer
            cmdExecuter = privateCommands.get(command);
        } else { // cmd doesn't exist
            return false;
        }

        // execute command
        cmdExecuter.accept(botCommand);
        return true;
    }

    public static boolean executePublicCommand(PublicBotCommand botCommand) {
        String command = botCommand.getCommand();
        Consumer<PublicBotCommand> cmdExecuter;

        if(publicCommands.containsKey(command)) { // if cmd exists get executer
            cmdExecuter = publicCommands.get(botCommand.getCommand());
        } else if(publicCommands.containsKey(command = publicAliases.get(botCommand.getCommand()))) { // if alias exist get executer
            cmdExecuter = publicCommands.get(command);
        } else { // cmd doesn't exist
            return false;
        }

        // execute command
        cmdExecuter.accept(botCommand);
        return true;
    }

    protected static void addPrivateCommand(Consumer<PrivateBotCommand> cmdExecuter, String command, String... aliases) {
        privateCommands.put(command.toLowerCase(), cmdExecuter);
        for(String alias : aliases) {
            privateAliases.put(alias, command.toLowerCase(Locale.ROOT));
        }
    }

    protected static void addPublicCommand(Consumer<PublicBotCommand> cmdExecuter, String command, String... aliases) {
        publicCommands.put(command.toLowerCase(), cmdExecuter);
        for(String alias : aliases) {
            publicAliases.put(alias, command.toLowerCase(Locale.ROOT));
        }
    }
}