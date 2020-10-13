
package com.example.yummlyteam.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AttributeRanges {

    @SerializedName("flavor-piquant")
    @Expose
    private FlavorPiquant flavorPiquant;

    public FlavorPiquant getFlavorPiquant() {
        return flavorPiquant;
    }

    public void setFlavorPiquant(FlavorPiquant flavorPiquant) {
        this.flavorPiquant = flavorPiquant;
    }

}
