package com.jikansoftware.adapterviewflipper.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Heroes {

    @SerializedName("heroes")
    private ArrayList<Hero> heroes;

    public Heroes() {
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }
}
