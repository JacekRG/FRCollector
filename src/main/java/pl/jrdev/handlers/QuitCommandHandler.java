package pl.jrdev.handlers;

import pl.jrdev.QuitFoodRecipeCollectorException;
import pl.jrdev.input.UserInputCommand;

public class QuitCommandHandler extends BaseCommandHandler {


    public static final String COMMAND_NAME = "quit";

    @Override
    public void handle(UserInputCommand command) {
        throw new QuitFoodRecipeCollectorException();
    }

    @Override
    public boolean canHandle(String name) {
        return COMMAND_NAME.equals(name);
    }

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }
}
