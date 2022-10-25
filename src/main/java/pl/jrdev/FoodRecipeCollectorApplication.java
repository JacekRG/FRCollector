package pl.jrdev;

import pl.jrdev.handlers.CategoryCommandHandler;
import pl.jrdev.handlers.CommandHandler;
import pl.jrdev.handlers.HelpCommandHandler;
import pl.jrdev.handlers.QuitCommandHandler;
import pl.jrdev.input.UserInputCommand;
import pl.jrdev.input.UserInputManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FoodRecipeCollectorApplication {

    public static void main(String[] args) {
        new FoodRecipeCollectorApplication().start();
    }

    private void start() {
        System.out.println("Your Recipe Collector is ready to use!\n");
        System.out.println("If you need help just write: help \n\nPlease insert a command below: ");
        boolean applicationLoop = true;

        List<CommandHandler> handlers = new ArrayList<>();
        handlers.add(new HelpCommandHandler());
        handlers.add(new QuitCommandHandler());
        handlers.add(new CategoryCommandHandler());

        UserInputManager userInputManager = new UserInputManager();

        while (applicationLoop) {
            try {
                UserInputCommand userInputCommand = userInputManager.nextCommand();
                System.out.println(userInputCommand);

                Optional<CommandHandler> currentHandler = Optional.empty();
                for (CommandHandler handler : handlers) {
                    if (handler.canHandle(userInputCommand.getCommand().toLowerCase())) {
                        currentHandler = Optional.of(handler);
                        break;
                    }
                }
                currentHandler
                        .orElseThrow(() -> new IllegalArgumentException("Unknown handler: " + userInputCommand.getCommand()))
                        .handle(userInputCommand);

            } catch (QuitFoodRecipeCollectorException e) {
                System.out.println("---Quit---");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
