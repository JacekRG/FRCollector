package pl.jrdev.handlers;

import pl.jrdev.input.UserInputCommand;

public interface CommandHandler {

    void handle(UserInputCommand command);

    boolean canHandle(String name);

}
