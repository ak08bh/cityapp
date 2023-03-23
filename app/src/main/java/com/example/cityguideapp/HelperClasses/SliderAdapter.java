package com.example.cityguideapp.HelperClasses;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.cityguideapp.R;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.ViewHolder>
{
    Context context;

    public SliderAdapter(Context context)
    {
        this.context = context;
    }

    int images[]=  {R.drawable.location_search,
            R.drawable.make_call,
            R.drawable.search_your_location,
            R.drawable.sit_back};

    int headings[]={R.string.first_slide_title,
    R.string.second_slide_title,
    R.string.third_slide_title,
    R.string.fourth_slide_title};

    int descriptions[]={R.string.first_slide_desc,
            R.string.second_slide_desc,
            R.string.third_slide_desc,
            R.string.fourth_slide_desc};

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.slides_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(images[position]);
        holder.heading.setText(headings[position]);
        holder.desc.setText(descriptions[position]);

    }

    @Override
    public int getItemCount() {
        return headings.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView heading,desc;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
             imageView= itemView.findViewById(R.id.slider_image);
             heading= itemView.findViewById(R.id.slider_heading);
             desc= itemView.findViewById(R.id.slider_desc);
        }
    }
}
