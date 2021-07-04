package com.example.json_url_recyclerview_4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.MyViewHolder> {

    private Context mContext;
    private List<ExampleItem> mExampleItem;
    private RecyclerViewClickListener listener;

    public ExampleAdapter(Context mContext, List<ExampleItem> mExampleItem, RecyclerViewClickListener listener) {
        this.mContext = mContext;
        this.mExampleItem = mExampleItem;
        this.listener = listener;
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
    public void onBindViewHolder(@NonNull  ExampleAdapter.MyViewHolder holder, int position) {


        holder.name.setText(mExampleItem.get(position).getName());
        holder.species.setText(mExampleItem.get(position).getSpecies());
        holder.gender.setText(mExampleItem.get(position).getHogwartsStudent());

        // using Glide
        Glide.with(mContext)
                .load(mExampleItem.get(position).getImg())
                .into(holder.img);

        holder.wood.setText(mExampleItem.get(position).getWood());
        holder.length.setText(mExampleItem.get(position).getLength());

    }

    @Override
    public int getItemCount() {
        return mExampleItem.size();

    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


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
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            listener.onClick(itemView, getAdapterPosition());

        }
    }
}
