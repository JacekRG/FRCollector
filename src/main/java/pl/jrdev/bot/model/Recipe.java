package pl.jrdev.bot.model;

import java.util.Objects;

public class Recipe {
    private String name;
    private Category category;

    public Recipe() {
    }
    public Recipe(String name) {
        this.name = name;
    }

    public Recipe(Category category, String name) {
        this.name = name;
        this.category = category;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(name, recipe.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", category=" + category +
                '}';
    }
}
