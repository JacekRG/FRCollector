package pl.jrdev.handlers;

import pl.jrdev.input.UserInputCommand;

abstract class BaseCommandHandler implements CommandHandler {

    @Override
    public boolean canHandle(String name) {
        return getCommandName().equals(name);
    }

    protected abstract String getCommandName();
}
