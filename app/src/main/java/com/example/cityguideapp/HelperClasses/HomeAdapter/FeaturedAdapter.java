package com.example.cityguideapp.HelperClasses.HomeAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cityguideapp.R;

import java.util.ArrayList;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.ViewHolder>

{

    Context context;
    ArrayList<FeaturedHelperClass> featuredHelperClasses;

    public FeaturedAdapter(ArrayList<FeaturedHelperClass> featuredHelperClasses)
    {
        this.featuredHelperClasses = featuredHelperClasses;
    }

    @NonNull
    @Override
    public FeaturedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View viev= LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_card_design,parent,false);

        return new ViewHolder(viev);
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedAdapter.ViewHolder holder, int position)
    {
        holder.image.setImageResource(featuredHelperClasses.get(position).getImage());
       holder.title.setText(featuredHelperClasses.get(position).getTitle());
       holder.desc.setText(featuredHelperClasses.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return featuredHelperClasses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView image;
        TextView title, desc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image=itemView.findViewById(R.id.featured_image);
            title=itemView.findViewById(R.id.featured_title);
            desc=itemView.findViewById(R.id.featured_desc);
        }
    }
}
