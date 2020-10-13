
package com.example.yummlyteam.app.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecipeSearchList {

    @SerializedName("attribution")
    @Expose
    private Attribution attribution;
    @SerializedName("totalMatchCount")
    @Expose
    private Integer totalMatchCount;
    @SerializedName("facetCounts")
    @Expose
    private FacetCounts facetCounts;
    @SerializedName("matches")
    @Expose
    private List<Match> matches = null;
    @SerializedName("criteria")
    @Expose
    private Criteria criteria;

    public Attribution getAttribution() {
        return attribution;
    }

    public void setAttribution(Attribution attribution) {
        this.attribution = attribution;
    }

    public Integer getTotalMatchCount() {
        return totalMatchCount;
    }

    public void setTotalMatchCount(Integer totalMatchCount) {
        this.totalMatchCount = totalMatchCount;
    }

    public FacetCounts getFacetCounts() {
        return facetCounts;
    }

    public void setFacetCounts(FacetCounts facetCounts) {
        this.facetCounts = facetCounts;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public Criteria getCriteria() {
        return criteria;
    }

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

}
