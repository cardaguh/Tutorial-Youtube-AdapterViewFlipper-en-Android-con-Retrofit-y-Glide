package com.jikansoftware.adapterviewflipper.api;

import com.jikansoftware.adapterviewflipper.model.Heroes;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("heroes.php")
    Call<Heroes> getHeroes();
}
