package com.example.cityguideapp.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cityguideapp.R;

import java.util.ArrayList;

public class CategoryCardAdapter extends RecyclerView.Adapter<CategoryCardAdapter.ViewHolder>
{
    ArrayList<CategoryCardHelperClass> categoryCardAdapterArrayList;

    public CategoryCardAdapter(ArrayList<CategoryCardHelperClass> categoryCardAdapterArrayList) {
        this.categoryCardAdapterArrayList = categoryCardAdapterArrayList;
    }

    @NonNull
    @Override
    public CategoryCardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_card_design, parent, false);

        return  new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull CategoryCardAdapter.ViewHolder holder, int position)
    {
        holder.image.setImageResource(categoryCardAdapterArrayList.get(position).getImage());
        holder.title.setText(categoryCardAdapterArrayList.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return categoryCardAdapterArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image_cl);
            title=itemView.findViewById(R.id.text_cl);
        }
    }
}
