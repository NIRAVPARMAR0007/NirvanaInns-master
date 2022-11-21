package com.example.newn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyAdapterg extends RecyclerView.Adapter<MyAdapterg.ViewHolder> {
    private static final String Tag = "RecyclerView";
    private Context mContext;
    private ArrayList<image> imageArrayList;

    public MyAdapterg(Context mContext, ArrayList<image> imageArrayList) {
        this.mContext = mContext;
        this.imageArrayList = imageArrayList;
    }

    @NonNull
    @Override
    public MyAdapterg.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_card, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(mContext).load(imageArrayList.get(position).getImage()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return imageArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imagegallery);
        }
    }

}
