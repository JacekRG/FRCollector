package pl.jrdev.handlers;

import pl.jrdev.model.Category;
import pl.jrdev.dao.CategoryDAO;
import pl.jrdev.input.UserInputCommand;

import java.util.List;

public class CategoryCommandHandler extends BaseCommandHandler {

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

        switch (command.getAction()) {
            case "list":
                System.out.println("---List of categories---");
                List<Category> categories = categoryDAO.findAllCategories();
                categories.forEach(System.out::println);
                break;

            case "add":
                System.out.println("---Add category---");
                String categoryName = command.getParam().get(0);
                categoryDAO.addCategory(new Category(categoryName));
                break;

            default:
                throw new IllegalArgumentException(String.format("Unknown action: %s from command: %s", command.getAction(), command.getCommand()));
        }
    }
}
