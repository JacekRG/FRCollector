package pl.jrdev.dao;

import pl.jrdev.model.Category;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RecipeDAO {
    private static final String PATH = "./categories.txt";

    public List<Category> findAllCategories() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(PATH));
            List<Category> categories = new ArrayList<>();
            for (String line : lines) {
                categories.add(new Category(line));
            }
            return categories;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addCategory(Category category) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(PATH));
            lines.add(category.getName());

            Files.writeString(Paths.get(PATH), String.join("\n", lines));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
