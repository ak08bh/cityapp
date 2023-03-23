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

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    Context context;
    ArrayList<CategoriesHelperClass> categoryAdapterArrayList;

    public CategoryAdapter(ArrayList<CategoriesHelperClass> categoryAdapterArrayList) {
        this.categoryAdapterArrayList = categoryAdapterArrayList;
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.most_view_card_design,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position)
    {

        holder.image.setImageResource(categoryAdapterArrayList.get(position).getImage());
        holder.title.setText(categoryAdapterArrayList.get(position).getTitle());
        holder.desc.setText(categoryAdapterArrayList.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return categoryAdapterArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView image;
        TextView title,desc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image=itemView.findViewById(R.id.mv_image);
            title=itemView.findViewById(R.id.mv_title);
            desc=itemView.findViewById(R.id.mv_desc);
        }
    }
}
