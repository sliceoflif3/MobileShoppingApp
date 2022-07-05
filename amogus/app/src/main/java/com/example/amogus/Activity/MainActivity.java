package com.example.amogus.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.amogus.Adapter.CategoryAdapter;
import com.example.amogus.Adapter.RecommendedAdapter;
import com.example.amogus.Domain.CategoryDomain;
import com.example.amogus.Domain.ElectronicDomain;
import com.example.amogus.R;

import java.util.ArrayList;

//

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recyclerViewPopular();
        bottomNavigation();
    }

    private void bottomNavigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout mapBtn = findViewById(R.id.mapBtn);
        LinearLayout cartBtn = findViewById(R.id.cartBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });

        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MapActivity.class));
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CartActivity.class));
            }
        });
    }

    //delete if unneeded
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }
    //

    private void recyclerViewPopular() {
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        //recyclerViewPopularList = findViewById(R.id.view2);
        //recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        recyclerViewPopularList = findViewById(R.id.view2);
        RecyclerView.LayoutManager mLayoutManager  = new GridLayoutManager(this, 2);
        recyclerViewPopularList.setLayoutManager(mLayoutManager);
        int spanCount = 2; // 3 columns
        int spacing = 50; // 50px
        boolean includeEdge = false;
        recyclerViewPopularList.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));

        ArrayList<ElectronicDomain> electronicList = new ArrayList<>();
        electronicList.add(new ElectronicDomain("Akko Tokyo","pizza1",
                "A pink mechanical keyboard, suitable for all ages and genders",
                50.0,5,11,50));
        electronicList.add(new ElectronicDomain("Macbook Pro","burger",
                "An affordable laptop for high school students",
                2000.0,5,12,1000));
        electronicList.add(new ElectronicDomain("Sony XM5","pizza3",
                "A budget headphone for low-income people",
                450.0,5,14,1000));
        electronicList.add(new ElectronicDomain("Secret Lab","chair",
                "Better than your average plastic chair",
                650.0, 5, 1, 100));
        electronicList.add(new ElectronicDomain("Logitech G903",
                "mouse",
                "Office mouse",130.0, 5, 2, 50));
        electronicList.add(new ElectronicDomain("White PC","pc",
                "Is able to play Minecraft with shader on",
                700.0,5,50,100));

        adapter2 = new RecommendedAdapter(electronicList);
        recyclerViewPopularList.setAdapter(adapter2);

    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.view1);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("Laptop","cat_1"));
        categoryList.add(new CategoryDomain("PC","cat_2"));
        categoryList.add(new CategoryDomain("Keyboard","cat_3"));
        categoryList.add(new CategoryDomain("Mouse","cat_4"));
        categoryList.add(new CategoryDomain("Headphone","cat_5"));

        adapter = new CategoryAdapter(categoryList);
        recyclerViewCategoryList.setAdapter(adapter);


    }
}