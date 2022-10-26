package pl.jrdev.handlers;

import pl.jrdev.input.UserInputCommand;

public class HelpCommandHandler extends BaseCommandHandler {


    public static final String COMMAND_NAME = "help";

    @Override
    public void handle(UserInputCommand command) {
        System.out.println("---Help---");
        System.out.println("Options: help, list, add, delete, update, quit ");
        System.out.println("Command pattern: <command>_<action>_<param1>_<param2>\nBy update <param1> is the current value and <param2> is the new value");
        System.out.println("Example: recipe_add_recipeName | category_list | category_add_categoryName | recipe_update_Category_currentRecipeName_newRecipeName");
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
