
package com.example.yummlyteam.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NutritionRestrictions {

    @SerializedName("FAT")
    @Expose
    private FAT fAT;

    public FAT getFAT() {
        return fAT;
    }

    public void setFAT(FAT fAT) {
        this.fAT = fAT;
    }

}
