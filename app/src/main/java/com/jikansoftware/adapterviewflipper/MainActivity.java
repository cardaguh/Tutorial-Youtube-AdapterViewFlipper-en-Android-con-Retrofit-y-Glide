package com.jikansoftware.adapterviewflipper;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterViewFlipper;
import android.widget.Toast;

import com.jikansoftware.adapterviewflipper.adapter.FlipperAdapter;
import com.jikansoftware.adapterviewflipper.api.APIService;
import com.jikansoftware.adapterviewflipper.model.Hero;
import com.jikansoftware.adapterviewflipper.model.Heroes;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String BASE_URL = "https://www.simplifiedcoding.net/demos/view-flipper/";

    private AdapterViewFlipper adapterViewFlipper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapterViewFlipper = findViewById(R.id.adapterViewFlipper);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);

        Call<Heroes> call = service.getHeroes();

        call.enqueue(new Callback<Heroes>() {
            @Override
            public void onResponse(Call<Heroes> call, Response<Heroes> response) {

                ArrayList<Hero> heroes = response.body().getHeroes();

                FlipperAdapter adapter = new FlipperAdapter(getApplicationContext(), heroes);

                adapterViewFlipper.setAdapter(adapter);
                adapterViewFlipper.setFlipInterval(1000);
                adapterViewFlipper.startFlipping();
            }

            @Override
            public void onFailure(Call<Heroes> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });




    }
}
