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
    protected String getCommandName() {
        return COMMAND_NAME;
    }
}
