package pl.jrdev.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.jrdev.model.Category;
import pl.jrdev.model.Recipe;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RecipeDAO {

    private static Logger LOG = Logger.getLogger(Recipe.class.getName());
    private static final String PATH = "./recipes.txt";

    private ObjectMapper objectMapper;

    public RecipeDAO() {
        this.objectMapper = new ObjectMapper();
    }

    public List<Recipe> findAllRecipes() {
        return getRecipes();
    }

    private List<Recipe> getRecipes() {
        try {
            return objectMapper.readValue(Files.readString(Paths.get(PATH)), new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            LOG.log(Level.WARNING, "Error on getRecipes", e);
            return new ArrayList<>();
        }
    }
    public Optional<Recipe> findOneRecipe(String recipeName) {
        return getRecipes().stream()
                .filter(c -> c.getName().equals(recipeName))
                .findAny();
    }

    public void addRecipe(Recipe recipe) {

        List<Recipe> recipes = getRecipes();
        recipes.add(recipe);

        saveRecipes(recipes);
    }
    public void deleteRecipe(Recipe recipe) {

        List<Recipe> recipes = getRecipes();
        recipes.remove(recipe);

        saveRecipes(recipes);
    }

    private void saveRecipes(List<Recipe> recipes) {
        try {
            Files.writeString(Paths.get(PATH), objectMapper.writeValueAsString(recipes));
        } catch (IOException e) {
            LOG.log(Level.WARNING, "Error on saveRecipe", e);
        }
    }
}
