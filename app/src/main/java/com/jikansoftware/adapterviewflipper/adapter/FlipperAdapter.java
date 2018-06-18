package com.jikansoftware.adapterviewflipper.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jikansoftware.adapterviewflipper.R;
import com.jikansoftware.adapterviewflipper.model.Hero;

import java.util.ArrayList;

public class FlipperAdapter extends BaseAdapter {

    private Context mCtx;
    private ArrayList<Hero> heroes;

    public FlipperAdapter(Context mCtx, ArrayList<Hero> heroes) {
        this.mCtx = mCtx;
        this.heroes = heroes;
    }

    @Override
    public int getCount() {
        return heroes.size();
    }

    @Override
    public Object getItem(int position) {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Hero hero = heroes.get(position);

        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.flipper_items, null);
        TextView textView = view.findViewById(R.id.textView);
        ImageView imageView = view.findViewById(R.id.imageView);

        Glide.with(mCtx).load(hero.getUrl()).into(imageView);

        return view;
    }
}
