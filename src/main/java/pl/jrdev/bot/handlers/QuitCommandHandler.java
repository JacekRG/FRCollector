package pl.jrdev.bot.handlers;

import pl.jrdev.bot.QuitFoodRecipeCollectorException;
import pl.jrdev.bot.input.UserInputCommand;

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
