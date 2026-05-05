package dtos;

import models.Model;
import org.springframework.beans.BeanUtils;

public class ModelDTO {
    private int id;
    private String name;

    public ModelDTO(Model model){
        BeanUtils.copyProperties(model, this);
    }

    public ModelDTO(){

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
}
