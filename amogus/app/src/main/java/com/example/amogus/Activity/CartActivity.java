package com.example.amogus.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.amogus.Adapter.CardListAdapter;
import com.example.amogus.Helper.ManagementCart;
import com.example.amogus.Interface.ChangeNumberItemsListener;
import com.example.amogus.R;

public class CartActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagementCart managementCart;
    private TextView totalFeeTxt, taxTxt, deliveryTxt, totalTxt, emptyTxt;
    private double tax;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        managementCart = new ManagementCart(this);

        initView();
        initList();
    }

    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter = new CardListAdapter(managementCart.getListCart(), this, new ChangeNumberItemsListener() {
            @Override
            public void changed() {
                calculateCard();
            }
        });

        recyclerViewList.setAdapter(adapter);
        if (managementCart.getListCart().isEmpty()) {
            emptyTxt.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        } else {
            emptyTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
    }

    private void calculateCard() {
        double percentTax = 0.02; // can change
        double delivery = 10; // can change

        tax = Math.round((managementCart.getTotalFee() * percentTax) * 100.0) / 100.0;
        double total = Math.round((managementCart.getTotalFee() + tax + delivery) * 100.0) / 100.0;
        double itemTotal = Math.round(managementCart.getTotalFee() * 100.0) / 100.0;

        totalFeeTxt.setText("$" + itemTotal);
        taxTxt.setText("$" + tax);
        deliveryTxt.setText("$" + delivery);
        totalTxt.setText("$" + total);
    }

    private void initView() {
        totalFeeTxt = findViewById(R.id.totalFeeTxt);
        taxTxt = findViewById(R.id.taxTxt);
        deliveryTxt = findViewById(R.id.deliveryTxt);
        totalTxt = findViewById(R.id.totalTxt);
        recyclerViewList = findViewById(R.id.view);
        scrollView = findViewById(R.id.scrollView);
        emptyTxt = findViewById(R.id.emptyTxt);
    }
}