package pl.jrdev.handlers;

import pl.jrdev.dao.CategoryDAO;
import pl.jrdev.dao.RecipeDAO;
import pl.jrdev.input.UserInputCommand;
import pl.jrdev.model.Category;
import pl.jrdev.model.Recipe;

import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class RecipeCommandHandler extends BaseCommandHandler {

    private static Logger LOG = Logger.getLogger(RecipeCommandHandler.class.getName());

    private static final String COMMAND_NAME = "recipe";
    private boolean isRecipeRepeated = false;

    private RecipeDAO recipeDAO;
    private CategoryDAO categoryDAO;

    public RecipeCommandHandler() {
        recipeDAO = new RecipeDAO();
        categoryDAO = new CategoryDAO();
    }

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void handle(UserInputCommand command) {
        if (command.getAction() == null) {
            throw new IllegalArgumentException("action can't be null");
        }
        switch (command.getAction()) {
            case LIST:
                LOG.info("---List of recipes---");
                if (!command.getParam().isEmpty()) {
                    throw new IllegalArgumentException("recipe list doesn't support any additional params");
                }
                List<Recipe> recipes = recipeDAO.findAllRecipes();
                recipes.forEach(System.out::println);
                break;

            case ADD:
                LOG.info("---Add recipe---");
                if (command.getParam().size() != 2) {
                    throw new IllegalArgumentException("wrong command format. Check help for more info");
                }
                String categoryName = command.getParam().get(0);
                String recipeName = command.getParam().get(1);
                Category category = categoryDAO.findOneCategory(categoryName)
                        .orElseThrow(() -> new IllegalArgumentException("Category not found: " + categoryName));
                recipeDAO.addRecipe(new Recipe(category, recipeName));
                break;

            case UPT:
                LOG.info("Update recipe");
                if (command.getParam().size() != 3) {
                    throw new IllegalArgumentException("wrong command format. Check help for more info");
                }
                categoryName = command.getParam().get(0);
                String oldRecipeName = command.getParam().get(1);
                String newRecipeName = command.getParam().get(2);
                category = categoryDAO.findOneCategory(categoryName)
                        .orElseThrow(() -> new IllegalArgumentException("Category not found: " + categoryName));
                recipeDAO.updateRecipe(new Recipe(category, oldRecipeName), new Recipe(category, newRecipeName));
                break;

            case DEL:
                LOG.info("Delete recipe");
                if (command.getParam().size() != 2) {
                    throw new IllegalArgumentException("wrong command format. Check help for more info");
                }
                categoryName = command.getParam().get(0);
                recipeName = command.getParam().get(1);
                System.out.println("categoryDAO.findOneCategory(categoryName): " + categoryDAO.findOneCategory(categoryName));
                category = categoryDAO.findOneCategory(categoryName)
                        .orElseThrow(() -> new IllegalArgumentException("Category not found: " + categoryName));
                recipeDAO.deleteRecipe(new Recipe(category, recipeName));
                break;

            default:
                throw new IllegalArgumentException(String.format("Unknown action: %s from command: %s", command.getAction(), command.getCommand()));
        }
    }
}
