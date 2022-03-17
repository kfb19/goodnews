package com.example.goodnews.model;

import com.google.gson.annotations.SerializedName;
/**
 * The Source model class.
 * @author Kate Belson
 */
class SourceModel {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    //getters and setters for each variable
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}