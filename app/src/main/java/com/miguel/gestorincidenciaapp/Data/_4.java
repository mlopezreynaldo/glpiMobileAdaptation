package com.miguel.gestorincidenciaapp.Data;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class _4 {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("entities")
    @Expose
    private List<Entity> entities = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

}