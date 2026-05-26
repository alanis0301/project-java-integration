package dtos;

import org.springframework.beans.BeanUtils;

import java.util.List;

public class LineDTO {
    private int id;
    private String name;
    private List<CategoryDTO> categories;

    public LineDTO(int id, String name, List<CategoryDTO> categories) {
        this.id = id;
        this.name = name;
        this.categories = categories;
    }

    public LineDTO(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return name;
    }
}
