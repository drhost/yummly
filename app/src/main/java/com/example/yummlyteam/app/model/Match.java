
package com.example.yummlyteam.app.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Match {

    @SerializedName("attributes")
    @Expose
    private Attributes attributes;
    @SerializedName("flavors")
    @Expose
    private Flavors flavors;
    @SerializedName("rating")
    @Expose
    private Integer rating;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("smallImageUrls")
    @Expose
    private List<String> smallImageUrls = null;
    @SerializedName("sourceDisplayName")
    @Expose
    private String sourceDisplayName;
    @SerializedName("totalTimeInSeconds")
    @Expose
    private Integer totalTimeInSeconds;
    @SerializedName("ingredients")
    @Expose
    private List<String> ingredients = null;
    @SerializedName("recipeName")
    @Expose
    private String recipeName;

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public Flavors getFlavors() {
        return flavors;
    }

    public void setFlavors(Flavors flavors) {
        this.flavors = flavors;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getSmallImageUrls() {
        return smallImageUrls;
    }

    public void setSmallImageUrls(List<String> smallImageUrls) {
        this.smallImageUrls = smallImageUrls;
    }

    public String getSourceDisplayName() {
        return sourceDisplayName;
    }

    public void setSourceDisplayName(String sourceDisplayName) {
        this.sourceDisplayName = sourceDisplayName;
    }

    public Integer getTotalTimeInSeconds() {
        return totalTimeInSeconds;
    }

    public void setTotalTimeInSeconds(Integer totalTimeInSeconds) {
        this.totalTimeInSeconds = totalTimeInSeconds;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

}
