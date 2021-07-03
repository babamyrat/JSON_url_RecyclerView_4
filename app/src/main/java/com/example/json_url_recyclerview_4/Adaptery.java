package com.example.json_url_recyclerview_4;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adaptery extends RecyclerView.Adapter<Adaptery.MyViewHolder> {

    private Context mContext;
    private List<MovieModelClass> mData;

    public Adaptery(Context mContext, List<MovieModelClass> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        v = inflater.inflate(R.layout.movie_item, parent, false);

        return  new MyViewHolder(v);


    }





    @Override
    public void onBindViewHolder(@NonNull  Adaptery.MyViewHolder holder, int position) {


        holder.name.setText(mData.get(position).getName());
        holder.species.setText(mData.get(position).getSpecies());
        holder.gender.setText(mData.get(position).getHogwartsStudent());

        // using Glide
        Glide.with(mContext)
                .load(mData.get(position).getImg())
                .into(holder.img);

        holder.wood.setText(mData.get(position).getWood());
        holder.length.setText(mData.get(position).getLength());

    }

    @Override
    public int getItemCount() {
        return mData.size();

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{


        TextView name;
        TextView species;
        TextView gender;
        ImageView img;
        TextView wood;
        TextView length;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name_txt);
            species = itemView.findViewById(R.id.id_txt);
            gender = itemView.findViewById(R.id.test_txt);
            img = itemView.findViewById(R.id.imageView);
            wood = itemView.findViewById(R.id.wood_txt);
            length = itemView.findViewById(R.id.length_txt);

        }
    }
}
