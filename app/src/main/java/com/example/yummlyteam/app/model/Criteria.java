
package com.example.yummlyteam.app.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Criteria {

    @SerializedName("maxResults")
    @Expose
    private Integer maxResults;
    @SerializedName("excludedIngredients")
    @Expose
    private List<String> excludedIngredients = null;
    @SerializedName("excludedAttributes")
    @Expose
    private List<Object> excludedAttributes = null;
    @SerializedName("allowedIngredients")
    @Expose
    private List<String> allowedIngredients = null;
    @SerializedName("attributeRanges")
    @Expose
    private AttributeRanges attributeRanges;
    @SerializedName("nutritionRestrictions")
    @Expose
    private NutritionRestrictions nutritionRestrictions;
    @SerializedName("allowedDiets")
    @Expose
    private List<String> allowedDiets = null;
    @SerializedName("resultsToSkip")
    @Expose
    private Integer resultsToSkip;
    @SerializedName("requirePictures")
    @Expose
    private Boolean requirePictures;
    @SerializedName("facetFields")
    @Expose
    private List<Object> facetFields = null;
    @SerializedName("terms")
    @Expose
    private List<String> terms = null;
    @SerializedName("allowedAttributes")
    @Expose
    private List<String> allowedAttributes = null;

    public Integer getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    }

    public List<String> getExcludedIngredients() {
        return excludedIngredients;
    }

    public void setExcludedIngredients(List<String> excludedIngredients) {
        this.excludedIngredients = excludedIngredients;
    }

    public List<Object> getExcludedAttributes() {
        return excludedAttributes;
    }

    public void setExcludedAttributes(List<Object> excludedAttributes) {
        this.excludedAttributes = excludedAttributes;
    }

    public List<String> getAllowedIngredients() {
        return allowedIngredients;
    }

    public void setAllowedIngredients(List<String> allowedIngredients) {
        this.allowedIngredients = allowedIngredients;
    }

    public AttributeRanges getAttributeRanges() {
        return attributeRanges;
    }

    public void setAttributeRanges(AttributeRanges attributeRanges) {
        this.attributeRanges = attributeRanges;
    }

    public NutritionRestrictions getNutritionRestrictions() {
        return nutritionRestrictions;
    }

    public void setNutritionRestrictions(NutritionRestrictions nutritionRestrictions) {
        this.nutritionRestrictions = nutritionRestrictions;
    }

    public List<String> getAllowedDiets() {
        return allowedDiets;
    }

    public void setAllowedDiets(List<String> allowedDiets) {
        this.allowedDiets = allowedDiets;
    }

    public Integer getResultsToSkip() {
        return resultsToSkip;
    }

    public void setResultsToSkip(Integer resultsToSkip) {
        this.resultsToSkip = resultsToSkip;
    }

    public Boolean getRequirePictures() {
        return requirePictures;
    }

    public void setRequirePictures(Boolean requirePictures) {
        this.requirePictures = requirePictures;
    }

    public List<Object> getFacetFields() {
        return facetFields;
    }

    public void setFacetFields(List<Object> facetFields) {
        this.facetFields = facetFields;
    }

    public List<String> getTerms() {
        return terms;
    }

    public void setTerms(List<String> terms) {
        this.terms = terms;
    }

    public List<String> getAllowedAttributes() {
        return allowedAttributes;
    }

    public void setAllowedAttributes(List<String> allowedAttributes) {
        this.allowedAttributes = allowedAttributes;
    }

}
