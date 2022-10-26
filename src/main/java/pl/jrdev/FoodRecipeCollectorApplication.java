package pl.jrdev;

import pl.jrdev.handlers.*;
import pl.jrdev.input.UserInputCommand;
import pl.jrdev.input.UserInputManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FoodRecipeCollectorApplication {

    private static Logger LOG = Logger.getLogger(FoodRecipeCollectorApplication.class.getName());

    public static void main(String[] args) {
        new FoodRecipeCollectorApplication().start();
    }

    private void start() {
        LOG.info("Your Recipe Collector is ready to use!\n");
        System.out.println("If you need help just write: help \n\nPlease insert a command below: ");
        boolean applicationLoop = true;

        List<CommandHandler> handlers = new ArrayList<>();
        handlers.add(new HelpCommandHandler());
        handlers.add(new QuitCommandHandler());
        handlers.add(new CategoryCommandHandler());
        handlers.add(new RecipeCommandHandler());

        UserInputManager userInputManager = new UserInputManager();

        while (applicationLoop) {
            try {
                UserInputCommand userInputCommand = userInputManager.nextCommand();
                LOG.info(userInputCommand.toString());

                Optional<CommandHandler> currentHandler = Optional.empty();
                for (CommandHandler handler : handlers) {
                    if (handler.canHandle(userInputCommand.getCommand())) {
                        currentHandler = Optional.of(handler);
                        break;
                    }
                }
                currentHandler
                        .orElseThrow(() -> new IllegalArgumentException("Unknown handler: " + userInputCommand.getCommand()))
                        .handle(userInputCommand);

            } catch (QuitFoodRecipeCollectorException e) {
                LOG.info("---Quit---");
            } catch (IllegalArgumentException e) {
                LOG.log(Level.WARNING, "Validation Exception", e.getMessage());
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "Unknown error", e);
            }
        }
    }
}
