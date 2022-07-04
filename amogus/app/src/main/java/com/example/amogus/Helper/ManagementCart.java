package com.example.amogus.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.amogus.Domain.ElectronicDomain;
import com.example.amogus.Interface.ChangeNumberItemsListener;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }
    public void insertFood (ElectronicDomain item) {
        ArrayList<ElectronicDomain> listElectronic=getListCart();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i < listElectronic.size(); i++) {
            if (listElectronic.get(i).getTitle().equals(item.getTitle())) {
                existAlready = true;
                n = i;
                break;
            }
        }

        if (existAlready) {
            listElectronic.get(n).setNumberInCart(item.getNumberInCart());
        } else {
            listElectronic.add(item);
        }

        tinyDB.putListObject("CardList", listElectronic);
        Toast.makeText(context, "Added to your Cart", Toast.LENGTH_SHORT).show();

    }

    public ArrayList<ElectronicDomain> getListCart() {
        return tinyDB.getListObject("CardList");
    }

    public void minusNumberFood(ArrayList<ElectronicDomain> listFood, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        if (listFood.get(position).getNumberInCart() == 1) {
            listFood.remove(position);
        } else {
            listFood.get(position).setNumberInCart(listFood.get(position).getNumberInCart() - 1);
        }
        tinyDB.putListObject("CardList", listFood);
        changeNumberItemsListener.changed();
    }

    public void plusNumberFood(ArrayList<ElectronicDomain> listFood, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        listFood.get(position).setNumberInCart(listFood.get(position).getNumberInCart() + 1);
        tinyDB.putListObject("CardList", listFood);
        changeNumberItemsListener.changed();
    }

    public Double getTotalFee() {
        ArrayList<ElectronicDomain> listElectronic2 = getListCart();
        double fee = 0;
        for (int i = 0; i < listElectronic2.size(); i++)
            fee = fee + (listElectronic2.get(i).getFee() + listElectronic2.get(i).getNumberInCart());
        return fee;
    }
}
