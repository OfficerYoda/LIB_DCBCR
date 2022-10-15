package de.officeryoda.dcbcr.Managment;

import de.officeryoda.dcbcr.Commands.PingCommands;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class CommandRegistrator {

    public CommandRegistrator(JDABuilder builder, String prefix) {
        builder.addEventListeners(new CommandListener(prefix));
    }

    public CommandRegistrator(JDA jda, String prefix) {
        jda.addEventListener(new CommandListener(prefix));
    }

    public void registerPingCommand() {
        registerClass(new PingCommands());
    }

    public void registerClass(CommandExecuter cmdExecuter) {
        cmdExecuter.registerCommands();
    }
}
