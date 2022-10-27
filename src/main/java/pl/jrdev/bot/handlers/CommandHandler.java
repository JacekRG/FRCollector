package pl.jrdev.bot.handlers;

import pl.jrdev.bot.input.UserInputCommand;

public interface CommandHandler {

    void handle(UserInputCommand command);

    boolean canHandle(String name);

}
