package pl.jrdev.handlers;

import pl.jrdev.model.Category;
import pl.jrdev.dao.CategoryDAO;
import pl.jrdev.input.UserInputCommand;
import pl.jrdev.model.Recipe;

import java.util.List;
import java.util.logging.Logger;

public class CategoryCommandHandler extends BaseCommandHandler {

    private static Logger LOG = Logger.getLogger(CategoryCommandHandler.class.getName());

    private static final String COMMAND_NAME = "category";

    private CategoryDAO categoryDAO;

    public CategoryCommandHandler() {
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
                LOG.info("---List of categories---");

                if (!command.getParam().isEmpty()) {
                    throw new IllegalArgumentException("category list doesn't support any additional params");
                }

                List<Category> categories = categoryDAO.findAllCategories();
                categories.forEach(System.out::println);
                break;

            case ADD:
                LOG.info("---Add category---");

                if (command.getParam().size() != 1) {
                    throw new IllegalArgumentException("wrong command format. Check help for more info");
                }
                String categoryName = command.getParam().get(0);
                categoryDAO.addCategory(new Category(categoryName));
                break;

            case DEL:
                LOG.info("Delete category");
                if (command.getParam().size() != 1) {
                    throw new IllegalArgumentException("wrong command format. Check help for more info");
                }
                categoryName = command.getParam().get(0);
                categoryDAO.deleteCategory(new Category(categoryName));
                break;

            default:
                throw new IllegalArgumentException(String.format("Unknown action: %s from command: %s", command.getAction(), command.getCommand()));
        }
    }
}
