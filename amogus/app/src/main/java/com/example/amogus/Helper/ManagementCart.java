package com.example.amogus.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.amogus.Domain.FoodDomain;
import com.example.amogus.Interface.ChangeNumberItemsListener;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context, TinyDB tinyDB) {
        this.context = context;
        this.tinyDB = tinyDB;
    }
    public void insertFood (FoodDomain item) {
        ArrayList<FoodDomain> listFood=getListCart();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i < listFood.size(); i++) {
            if (listFood.get(i).getTitle().equals(item.getTitle())) {
                existAlready = true;
                n = i;
                break;
            }
        }

        if (existAlready) {
            listFood.get(n).setNumberInCart(item.getNumberInCart());
        } else {
            listFood.add(item);
        }

        tinyDB.putListObject("CardList", listFood);
        Toast.makeText(context, "Added to your Cart", Toast.LENGTH_SHORT).show();

    }

    private ArrayList<FoodDomain> getListCart() {
        return tinyDB.getListObject("CardList");
    }

    public void minusNumberFood(ArrayList<FoodDomain> listFood, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        if (listFood.get(position).getNumberInCart() == 1) {
            listFood.remove(position);
        } else {
            listFood.get(position).setNumberInCart(listFood.get(position).getNumberInCart() - 1);
        }
        tinyDB.putListObject("CardList", listFood);
        changeNumberItemsListener.changed();
    }

    public void plusNumberFood(ArrayList<FoodDomain> listFood, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        listFood.get(position).setNumberInCart(listFood.get(position).getNumberInCart() + 1);
        tinyDB.putListObject("CardList", listFood);
        changeNumberItemsListener.changed();
    }

    public Double getTotalFee() {
        ArrayList<FoodDomain> listFood2 = getListCart();
        double fee = 0;
        for (int i = 0; i < listFood2.size(); i++)
            fee = fee + (listFood2.get(i).getFee() + listFood2.get(i).getNumberInCart());
        return fee;
    }
}
