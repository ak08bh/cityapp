package com.example.cityguideapp.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.cityguideapp.HelperClasses.HomeAdapter.CategoriesHelperClass;
import com.example.cityguideapp.HelperClasses.HomeAdapter.CategoryAdapter;
import com.example.cityguideapp.HelperClasses.HomeAdapter.CategoryCardAdapter;
import com.example.cityguideapp.HelperClasses.HomeAdapter.CategoryCardHelperClass;
import com.example.cityguideapp.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.example.cityguideapp.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.example.cityguideapp.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener {

    static final float END_SCALE = 0.7f;
    RecyclerView featured_recycler, mostViewedRecycler, addCategoryRecycler;

    RecyclerView.Adapter adapter;
    LinearLayout contentView;

    ImageView IconMenu;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    private boolean isDrawerFixed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAGS_CHANGED, WindowManager.LayoutParams.FLAGS_CHANGED);

        setContentView(R.layout.activity_user_dashboard);

        featured_recycler = findViewById(R.id.featured_recycler);
        mostViewedRecycler = findViewById(R.id.mostViewedRecycler);
        contentView = findViewById(R.id.content);
        addCategoryRecycler = findViewById(R.id.addCategoryRecycler);
        IconMenu = findViewById(R.id.icon_menu);

        isDrawerFixed = getResources().getBoolean(R.bool.isDrawerFixed);


        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

if(!isDrawerFixed)
{
    navigationView.bringToFront();
    navigationView.setNavigationItemSelectedListener(this);
    navigationView.setCheckedItem(R.id.nav_home);
    navigationDrawer();

}

        featuredRecycler();
        mostViewRecycle();
        addCategory();
    }

    private void navigationDrawer() {


        IconMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        animateNavigationDrawer();
    }

    private void animateNavigationDrawer() {

        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {

                                           public void onDrawerSlide(View drawerView, float slideOffset) {
                                               final float diffScaleOffset = slideOffset * (1 - END_SCALE);
                                               final float offsetScale = 1 - diffScaleOffset;
                                               contentView.setScaleX(offsetScale);
                                               contentView.setScaleY(offsetScale);


                                               final float xOffset = drawerView.getWidth() * slideOffset;
                                               final float xOffsetDiff = contentView.getWidth() * diffScaleOffset / 2;
                                               final float xTranslation = xOffset - xOffsetDiff;
                                               contentView.setTranslationX(xTranslation);
                                           }
                                       }
        );
    }

    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        return true;
    }

    private void addCategory() {
        addCategoryRecycler.setHasFixedSize(true);
        addCategoryRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


        ArrayList<CategoryCardHelperClass> categoryCardHelperClassArrayList = new ArrayList<>();
        categoryCardHelperClassArrayList.add(new CategoryCardHelperClass(R.drawable.restaurant, "Restaurants"));
        categoryCardHelperClassArrayList.add(new CategoryCardHelperClass(R.drawable.restaurant, "Cafe"));
        categoryCardHelperClassArrayList.add(new CategoryCardHelperClass(R.drawable.restaurant, "Dining"));
        categoryCardHelperClassArrayList.add(new CategoryCardHelperClass(R.drawable.restaurant, "Hotel"));


        adapter = new CategoryCardAdapter(categoryCardHelperClassArrayList);
        addCategoryRecycler.setAdapter(adapter);

    }

    private void mostViewRecycle() {
        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


        ArrayList<CategoriesHelperClass> categoryAdapterArrayList = new ArrayList<>();
        categoryAdapterArrayList.add(new CategoriesHelperClass(R.drawable.mcdonalds, "McDonald's", "The food that taste so good to fill all your hunger desires"));
        categoryAdapterArrayList.add(new CategoriesHelperClass(R.drawable.coffee, "Coffee", "The food that taste so good to fill all your hunger desires"));
        categoryAdapterArrayList.add(new CategoriesHelperClass(R.drawable.sweetsnbakers, "Sweets", "The food that taste so good to fill all your hunger desires"));
        categoryAdapterArrayList.add(new CategoriesHelperClass(R.drawable.shakes, "Shakes", "The food that taste so good to fill all your hunger desires"));


        adapter = new CategoryAdapter(categoryAdapterArrayList);
        mostViewedRecycler.setAdapter(adapter);


    }

    private void featuredRecycler() {
        featured_recycler.setHasFixedSize(true);
        featured_recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


        ArrayList<FeaturedHelperClass> featuredLocation = new ArrayList<>();
        featuredLocation.add(new FeaturedHelperClass(R.drawable.mcdonalds, "McDonald's", "The food that taste so good to fill all your hunger desires"));
        featuredLocation.add(new FeaturedHelperClass(R.drawable.coffee, "Coffee", "The food that taste so good to fill all your hunger desires"));
        featuredLocation.add(new FeaturedHelperClass(R.drawable.sweetsnbakers, "Sweets", "The food that taste so good to fill all your hunger desires"));
        featuredLocation.add(new FeaturedHelperClass(R.drawable.shakes, "Shakes", "The food that taste so good to fill all your hunger desires"));


        adapter = new FeaturedAdapter(featuredLocation);
        featured_recycler.setAdapter(adapter);

    }

}