package com.miguel.gestorincidenciaapp.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entity {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("is_recursive")
    @Expose
    private Integer isRecursive;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIsRecursive() {
        return isRecursive;
    }

    public void setIsRecursive(Integer isRecursive) {
        this.isRecursive = isRecursive;
    }

}