package dtos;

import models.Category;

import org.springframework.beans.BeanUtils;

import java.util.List;

public class CategoryDTO {

    private int id;
    private String name;
    private List<ModelDTO> models;

    public CategoryDTO(Category category){
        BeanUtils.copyProperties(category, this);
    }

    public CategoryDTO(){

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

    public List<ModelDTO> getModels() {
        return models;
    }

    public void setModels(List<ModelDTO> models) {
        this.models = models;
    }

}
