package pl.jrdev.model;

import java.util.List;
import java.util.Objects;

public class Category {

    private String name;

    private List<Category> oldAndNewCategories;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }
    public Category(String name, String newCategoryName) {
        this.name = name;
        oldAndNewCategories.add(new Category(name));
        oldAndNewCategories.add(new Category(newCategoryName));
        returnCategory();
    }
    private Category returnCategory() {
        return oldAndNewCategories.get(oldAndNewCategories.size()-1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                '}';
    }
}
