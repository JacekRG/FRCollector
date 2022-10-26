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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name) && Objects.equals(oldAndNewCategories, category.oldAndNewCategories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, oldAndNewCategories);
    }
}
