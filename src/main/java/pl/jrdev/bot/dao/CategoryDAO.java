package pl.jrdev.bot.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.jrdev.bot.model.Category;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoryDAO {

    private static Logger LOG = Logger.getLogger(CategoryDAO.class.getName());
    private static final String PATH = "./categories.txt";
    private ObjectMapper objectMapper;

    public CategoryDAO() {
        this.objectMapper = new ObjectMapper();
    }

    private List<Category> getCategories() {
        try {
            return objectMapper.readValue(Files.readString(Paths.get(PATH)), new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            LOG.log(Level.WARNING, "Error on getCategories", e);
            return new ArrayList<>();
        }
    }

    public List<Category> findAllCategories() {
        return getCategories();
    }

    public void addCategory(Category category) {
        try {
            List<Category> categories = getCategories();
            categories.add(category);
            saveCategories(categories);

        } catch (IOException e) {
            e.printStackTrace();
            LOG.log(Level.WARNING, "Error on addCategory", e);
        }
    }

    private void saveCategories(List<Category> categories) throws IOException {
        Files.writeString(Paths.get(PATH), objectMapper.writeValueAsString(categories));
    }

    public void updateCategory(Category oldCategoryName, Category newCategoryName) {

        try {
            List<Category> categories = getCategories();
            int indexOfCurrentCategory = categories.indexOf(oldCategoryName);
            categories.set(indexOfCurrentCategory, newCategoryName);
            saveCategories(categories);

        } catch (IOException e) {
            e.printStackTrace();
            LOG.log(Level.WARNING, "Error on updateCategory", e);
        }
    }

    public void deleteCategory(Category category) {
        try {

            List<Category> categories = getCategories();
            categories.remove(category);
            saveCategories(categories);

        } catch (IOException e) {
            LOG.log(Level.WARNING, "Error combined with Category deletion", e);
        }
    }

    public Optional<Category> findOneCategory(String categoryName) {
        return getCategories().stream()
                .filter(c -> c.getName().equals(categoryName))
                .findAny();
    }
}
