package de.officeryoda.dcbcr.commandData;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class BotCommand {

    private final String command;
    private final String[] args;
    private final User author;
    private final Member member;

    private final Message message;
    private final MessageReceivedEvent event;

    public BotCommand(BotCommand other) {
        this.command = other.command;
        this.args = other.args;
        this.author = other.author;
        this.member = other.member;

        this.message = other.message;
        this.event = other.event;
    }

    public BotCommand(String command, String[] args, MessageReceivedEvent event) {
        this.command = command;
        this.args = args;
        this.author = event.getAuthor();
        this.member = event.getMember();

        this.message = event.getMessage();
        this.event = event;
    }

    public String getCommand() {
        return command;
    }

    public String[] getArgs() {
        return args;
    }

    public User getAuthor() {
        return author;
    }

    public Member getMember() {
        return member;
    }

    public Message getMessage() {
        return message;
    }

    public MessageReceivedEvent getEvent() {
        return event;
    }
}
