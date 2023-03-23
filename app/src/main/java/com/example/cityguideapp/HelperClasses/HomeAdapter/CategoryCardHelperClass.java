package com.example.cityguideapp.HelperClasses.HomeAdapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryCardHelperClass  {
    int image;
    String title;

    public CategoryCardHelperClass(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }
}
