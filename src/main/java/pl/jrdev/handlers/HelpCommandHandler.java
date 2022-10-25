package pl.jrdev.handlers;

import pl.jrdev.input.UserInputCommand;

public class HelpCommandHandler extends BaseCommandHandler {


    public static final String COMMAND_NAME = "help";

    @Override
    public void handle(UserInputCommand command) {
        System.out.println("---Help---");
        System.out.println("Options: help, quit, category, addRecipe, deleteRecipe ");
        System.out.println("Command pattern: <command>_<action>_<param1>_<param2> ");
        System.out.println("Example: recipe add recipeName");
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
