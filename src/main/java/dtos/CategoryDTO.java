package dtos;

import org.springframework.beans.BeanUtils;

import java.util.List;

public class CategoryDTO {

    private int id;
    private String name;
    private List<ModelDTO> models;

    public CategoryDTO(int id, String name, List<ModelDTO> models){
        this.id= id;
        this.name = name;
        this.models = models;
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
